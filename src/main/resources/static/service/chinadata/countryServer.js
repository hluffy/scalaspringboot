app.service('contryServer',function($q,$http){
	this.getCountries = function(){
		var deferred = $q.defer();
		$http.get("/page/data/country.json").success(function(data){
			deferred.resolve(data);
		}).error(function(){
			deferred.reject("连接失败");
		});

		return deferred.promise;
	}
})