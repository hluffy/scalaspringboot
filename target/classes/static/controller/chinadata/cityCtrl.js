app.controller('cityCtrl',function($scope,$rootScope,cityServer,contryServer,provinceServer){
//	设置高度
	$rootScope.divheight = window.innerHeight-51+"px";
	$scope.citytableheight = window.innerHeight-205+"px";

	$scope.cityinfos = {};

	$scope.city = {};
	$scope.indexPage = 0;

//	添加城市信息对象
	$scope.addCity = {};

//	获取所有国家信息
	contryServer.getCountries().then(function(data){
		$scope.counties = data;
//		默认选择第一个国家
		$scope.selectedCountry = data[0];

//		查询选择框
		$scope.queryCountrys = data;
		$scope.selectedQueryCountry = data[0];
	});

//	根据国家code查询省份信息
	provinceServer.getProvinceByCountryCode(1).then(function(data){
		if(data.status){
			$scope.provinces = data.data;
//			默认选择第一个省份
			$scope.selectedProvince = data.data[0];

//			查询选择框
			$scope.queryProvinces = data.data;
			$scope.selectedQueryProvince = data.data[0];
		}else{

		}
	})

	//分页
	function pageselectCallback(page_index, jq){
		$scope.city.page = page_index;
		cityServer.getCitiesOfCity($scope.city).then(function(data){
			$scope.cityinfos = data.data.content;
			$scope.indexPage = page_index;
		});
	    return false;
	}

	function getOptionsFromForm(){
	    var opt = {callback: pageselectCallback};
	    opt.prev_text = "<<";
	    opt.next_text = ">>";
	    opt.items_per_page=20;
	    opt.num_display_entries=4;
	    opt.num_edge_entries=2;
	    return opt;
	}
//	查询所有市信息
//	cityServer.getCities().then(function(data){
//		if(data.state){
//			$scope.cityinfos = data.data;
//		}else{
//			$scope.cityinfos = {};
//		}
//	});

	//根据条件查询市信息
	$scope.getCitiesOfCity = function(param){
		cityServer.getCitiesOfCity(param).then(function(data){
			if(data.status){
				$scope.cityinfos = data.data.content;
				$scope.count = data.data.totalElements;
				var optInit = getOptionsFromForm();
		        $("#Pagination").pagination($scope.count, optInit);

				$("#Pagination").click(function(){
		            var opt = getOptionsFromForm();
		            $("#Pagination").pagination($scope.count, opt);
		        });
			}else{
				$scope.cityinfos = {};
				$scope.count = 0;
			}
		});
	}

	//页面初始化数据
	$scope.city.countryCode = 1;
	$scope.city.provinceCode = 11;
	$scope.getCitiesOfCity($scope.city);

	//点击按钮查询数据
	$scope.getCityInfo = function(){
		if($scope.selectedQueryCountry){
			$scope.city.countryCode = $scope.selectedQueryCountry.code;
		}
		if($scope.selectedQueryProvince){
			$scope.city.provinceCode = $scope.selectedQueryProvince.code;
		}
		$scope.city.page = 0;
		$scope.getCitiesOfCity($scope.city);
		$scope.indexPage = 0;
	}

//	打开添加城市信息页面
	$scope.openAddCityView = function(){
		$("#addcitybutton").click();
	}

//	添加城市页面保存
	$scope.saveAddCity = function(){
		if(!$scope.addCity.code){
			alert("城市编码不允许为空");
			return;
		}
		if(!Number($scope.addCity.code)){
			alert("城市编码只能是数字");
			return;
		}
		if(!$scope.addCity.name){
			alert("城市名称不允许为空");
			return;
		}
		if(!$scope.selectedCountry){
			alert("国家名称不允许为空");
			return;
		}
		if(!$scope.selectedProvince){
			alert("省份名称不允许为空");
			return;
		}

		$scope.addCity.countryCode = $scope.selectedCountry.code;
		$scope.addCity.provinceCode = $scope.selectedProvince.code;

		cityServer.addCity($scope.addCity).then(function(data){
			if(data.state){
				alert(data.message);
				$scope.addCity = {};
				$("#closeAddCityButton").click();
				$scope.city.page = 0;
				$scope.getCitiesOfCity($scope.city);
				$scope.indexPage = 0;
			}else{
				alert(data.message)
			}
		});
	}

//	编辑页面保存
	$scope.saveEditCity = function(){
		if(!$rootScope.editcityinfo.name){
			alert("城市名称不可以为空");
			return;
		}
		if($rootScope.editcityinfo.editName == $rootScope.editcityinfo.name){
			alert("保存成功");
			$("#closeEditCityButton").click();
			$rootScope.editcityinfo = {};
			$scope.city.page = 0;
			$scope.getCitiesOfCity($scope.city);
			$scope.indexPage = 0;
			return;
		}

		cityServer.updateCityByCode($rootScope.editcityinfo).then(function(data){
			if(data.state){
				alert(data.message);
				$("#closeEditCityButton").click();
				$rootScope.editcityinfo = {};
				$scope.city.page = 0;
				$scope.getCitiesOfCity($scope.city);
				$scope.indexPage = 0;
			}else{
				alert(data.message);
			}
		})
	}

//	删除页面确认
	$scope.deleteCity = function(){
		cityServer.deleteCityByCode($rootScope.cityCode).then(function(data){
			$("#closeDeleteCityButton").click();
			alert(data.message);
			if(data.state){
				$scope.city.page = 0;
				$scope.getCitiesOfCity($scope.city);
				$scope.indexPage = 0;
			}
		});
	}

//	查询框中国家选择下拉框值改变时
	$scope.selectQueryCountry = function(){

	}

//	查询框中省份选择下拉框值改变时
	$scope.selectQueryProvince = function(){
		$scope.getCityInfo();
	}

});

//编辑按钮
//app.directive("cityedit",function($rootScope,$document,townServer){
//	return{
//		restrict:"E",
//		require:"ngModel",
//		link:function(scope,element,attrs,ngModel){
//			element.bind("click",function(){
//					var code = ngModel.$modelValue.code;
//					scope.$apply(function(){
//						for(var i=0;i<scope.cityinfos.length;i++){
//							if(scope.cityinfos[i].code == code){
////								console.log(ngModel.$modelValue);
//								$("#editcitybutton").click();
//								var result = ngModel.$modelValue;
////								console.log(result);
//								$rootScope.editcityinfo = {};
//								$rootScope.editcityinfo.code = result.code;
//								$rootScope.editcityinfo.countryCode = result.countryCode;
//								$rootScope.editcityinfo.countryName = result.countryName;
//								$rootScope.editcityinfo.name = result.name;
//								$rootScope.editcityinfo.provinceCode = result.provinceCode;
//								$rootScope.editcityinfo.provinceName = result.provinceName;
//
//								$rootScope.editcityinfo.editName = $rootScope.editcityinfo.name;
//							}
//						}
//					});
//			});
//		}
//	}
//});

//删除按钮
//app.directive("citydelete",function($rootScope,$document,townServer){
//	return{
//		restrict:"E",
//		require:"ngModel",
//		link:function(scope,element,attrs,ngModel){
//			element.bind("click",function(){
////				if(confirm("您确定要删除吗？")){
//					var code = ngModel.$modelValue.code;
//					scope.$apply(function(){
//						for(var i=0;i<scope.cityinfos.length;i++){
//							if(scope.cityinfos[i].code == code){
//								$rootScope.cityCode = code;
//								$("#deletecitybutton").click();
//							}
//						}
//					});
////				}
//			});
//		}
//	}
//});