app.service('provinceServer',function($q,$http){
//	查询所有省份信息
	this.getProvinces = function(){
		var deferred = $q.defer();
		$http.get('/dkvan-wuliu/province/getprovinces.do').success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		})

		return deferred.promise;
	}

//	根据条件查询省份信息
	this.getProvincesOfInfo = function(info){
		var deferred = $q.defer();
		$http({
			method:'post',
			url:'/province/findall',
			data:info,
			dataType:'json'
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});

		return deferred.promise;
	}

//	根据国家code查询省份信息
	this.getProvinceByCountryCode = function(code){
		var deferred = $q.defer();
		$http.get('/province/findbycountrycode?countryCode='+code).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});

		return deferred.promise;
	}

//	添加省份信息
	this.addProvince = function(province){
		var deferred = $q.defer();
		$http({
			method:'post',
			url:'/dkvan-wuliu/province/addprovince.do',
			data:province,
			dataType:'json'
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});

		return deferred.promise;
	}

//	根据code修改省份信息
	this.updateProvinceByCode = function(province){
		var deferred = $q.defer();
		$http({
			method:"post",
			url:"/dkvan-wuliu/province/updateprovincebycode.do",
			data:province,
			dataType:"json"
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("修改失败")
		});

		return deferred.promise;;
	}

//	根据code删除省份信息
	this.deleteProvinceByCode = function(code){
		var deferred = $q.defer();
		$http.get("/dkvan-wuliu/province/deleteprovincebycode.do?code="+code).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("删除失败")
		});

		return deferred.promise;
	}
})