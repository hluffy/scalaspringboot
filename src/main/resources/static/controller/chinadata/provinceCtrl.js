app.controller('provinceCtrl',function($scope,$rootScope,provinceServer,contryServer){
//	设置高度
	$rootScope.divheight = window.innerHeight-51+"px";
	$scope.provincetableheight = window.innerHeight-205+"px";
	//省份对象
	$scope.provinceinfos = {};

	$scope.province = {};
	$scope.indexPage = 0;

//	添加省份对象
	$scope.addProvince = {};

//	获取所有国家信息
	contryServer.getCountries().then(function(data){
		$scope.counties = data;
//		默认选择第一个国家
		$scope.selectedCountry = data[0];

//		查询选择框
		$scope.queryCountrys = data;
		$scope.selectedQueryCountry = data[0];
	});

	//分页
	function pageselectCallback(page_index, jq){
		$scope.province.page = page_index;
		provinceServer.getProvincesOfInfo($scope.province).then(function(data){
			$scope.provinceinfos = data.data.content;
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
//	查询所有省份信息
//	provinceServer.getProvinces().then(function(data){
//		console.log(data);
//		if(data.state){
//			$scope.provinceinfos = data.data;
//		}else{
//			$scope.provinceinfos = {};
//		}
//	});

	//根据条件查询省份信息
	$scope.getProvincesOfInfo = function(param){
		provinceServer.getProvincesOfInfo(param).then(function(data){
			if(data.status){
				$scope.provinceinfos = data.data.content;
				$scope.count = data.data.totalElements;
				var optInit = getOptionsFromForm();
		        $("#Pagination").pagination($scope.count, optInit);

				$("#Pagination").click(function(){
		            var opt = getOptionsFromForm();
		            $("#Pagination").pagination($scope.count, opt);
		        });
			}else{
				$scope.provinceinfos = {};
				$scope.count = 0;
			}
		});
	}

//	进入页面初始化数据数据
	$scope.getProvincesOfInfo($scope.province);

	//点击查询按钮查询数据
	$scope.getProvinceInfo = function(){
		$scope.getProvincesOfInfo($scope.province);
	}

//	打开添加省份页面
	$scope.openAddProvinceView = function(){
		$("#addprovincebutton").click();
	}

//	添加页面保存
	$scope.saveAddProvince = function(){
		if(!$scope.addProvince.code){
			alert("省份编码不允许为空");
			return;
		}
		if(!Number($scope.addProvince.code)){
			alert("省份编码只能是数字");
			return;
		}
		if(!$scope.addProvince.name){
			alert("省份名称不允许为空");
			return;
		}
		if(!$scope.selectedCountry){
			alert("国家名称不允许为空");
			return;
		}
		$scope.addProvince.countryCode = $scope.selectedCountry.code;
		provinceServer.addProvince($scope.addProvince).then(function(data){
			if(data.state){
				alert(data.message);
				$("#closeAddProvinceButton").click();
				$scope.addProvince= {};
				$scope.province.page = 0;
				$scope.getProvincesOfInfo($scope.province);
				$scope.indexPage = 0;
			}else{
				alert(data.message);
			}
		});
	}

//	编辑页面保存
	$scope.saveEditProvince = function(){
		if(!$rootScope.editprovinceinfo.name){
			alert("省份名称不能为空");
			return;
		}
		if($rootScope.editprovinceinfo.editName == $rootScope.editprovinceinfo.name){
			alert("保存成功");
			$("#closeEditProvinceButton").click();
			$rootScope.editprovinceinfo = {};
			$scope.province.page = 0;
			$scope.getProvincesOfInfo($scope.province);
			$scope.indexPage = 0;
			return;
		}

		provinceServer.updateProvinceByCode($rootScope.editprovinceinfo).then(function(data){
			if(data.state){
				alert(data.message);
				$("#closeEditProvinceButton").click();
				$rootScope.editprovinceinfo = {};
				$scope.province.page = 0;
				$scope.getProvincesOfInfo($scope.province);
				$scope.indexPage = 0;
			}else{
				alert(data.message);
			}
		});
	}

//	删除页面确认
	$scope.deleteProvince = function(){
		provinceServer.deleteProvinceByCode($rootScope.provinceCode).then(function(data){
			alert(data.message);
			$("#closeDeleteProvinceButton").click();
			if(data.state){
				$scope.province.page = 0;
				$scope.getProvincesOfInfo($scope.province);
				$scope.indexPage = 0;
			}
		});
	}




});

//编辑按钮
//app.directive("provinceedit",function($rootScope,$document,townServer){
//	return{
//		restrict:"E",
//		require:"ngModel",
//		link:function(scope,element,attrs,ngModel){
//			element.bind("click",function(){
//					var code = ngModel.$modelValue.code;
//					scope.$apply(function(){
//						for(var i=0;i<scope.provinceinfos.length;i++){
//							if(scope.provinceinfos[i].code == code){
//								console.log(ngModel.$modelValue);
//								$("#editprovincebutton").click();
//								var result = ngModel.$modelValue;
//								console.log(result);
//								$rootScope.editprovinceinfo = {};
//								$rootScope.editprovinceinfo.code = result.code;
//								$rootScope.editprovinceinfo.countryCode = result.countryCode;
//								$rootScope.editprovinceinfo.countryName = result.countryName;
//								$rootScope.editprovinceinfo.name = result.name;
//
//								$rootScope.editprovinceinfo.editName = $rootScope.editprovinceinfo.name;
//							}
//						}
//					});
//			});
//		}
//	}
//});

//删除按钮
//app.directive("provincedelete",function($rootScope,$document,townServer){
//	return{
//		restrict:"E",
//		require:"ngModel",
//		link:function(scope,element,attrs,ngModel){
//			element.bind("click",function(){
////				if(confirm("您确定要删除吗？")){
//					var code = ngModel.$modelValue.code;
//					scope.$apply(function(){
//						for(var i=0;i<scope.provinceinfos.length;i++){
//							if(scope.provinceinfos[i].code == code){
//								$rootScope.provinceCode = code;
//								$("#deleteprovincebutton").click();
//							}
//						}
//					});
////				}
//			});
//		}
//	}
//});