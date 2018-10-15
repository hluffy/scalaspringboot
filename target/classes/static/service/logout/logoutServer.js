app.service('logoutServer',function($q,$http){
    this.logout = function(){
        var deferred = $q.defer();
        $http.get('/logout').success(function(data){
            deferred.resolve(data);
        }).error(function(){
            deferred.reject("查询失败");
        })

        return deferred.promise;
    }
})