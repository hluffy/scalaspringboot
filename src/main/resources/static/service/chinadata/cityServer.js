app.service('cityServer',function($q,$http){
//	查询所有市信息
	this.getCities = function(){
		var deferred = $q.defer();
		$http.get('/dkvan-wuliu/city/getcities.do').success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败");
		})

		return deferred.promise;
	}

//	根据条件查询市信息
	this.getCitiesOfCity = function(city){
		var deferred = $q.defer();
		$http({
			method:'post',
			url:'/city/findall',
			data:city,
			dataType:'json'
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});

		return deferred.promise;
	}

//	根据省份code查询城市信息
	this.getCitiesByProvinceCode = function(code){
		var deferred = $q.defer();
		$http.get('/dkvan-wuliu/city/getcitiesbyprovincecode.do?code='+code).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("查询失败")
		});

		return deferred.promise;
	}

//	添加城市信息
	this.addCity = function(city){
		var deferred = $q.defer();
		$http({
			method:'post',
			url:'/dkvan-wuliu/city/addcity.do',
			data:city,
			dataType:'json'
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("添加失败")
		});

		return deferred.promise;
	}

//	根据code修改城市信息
	this.updateCityByCode = function(city){
		var deferred = $q.defer();
		$http({
			method:'post',
			url:'/dkvan-wuliu/city/updatecitybycode.do',
			data:city,
			dataType:'json'
		}).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("修改失败")
		});

		return deferred.promise;
	}

//	根据code删除城市信息
	this.deleteCityByCode = function(code){
		var deferred = $q.defer();
		$http.get("/dkvan-wuliu/city/deletecitybycode.do?code="+code).success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("删除失败")
		});

		return deferred.promise;
	}


})