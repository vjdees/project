App.factory("keeptrack2Factory",['$rootScope','$http','$q',function($rootScope,$http,$q){
				var base_url= 'http://localhost:8080/FAT';
				return{
					post: function(url,user_data){
						var deferred =$q.defer();
						$http({
								method: "POST",
								url: base_url + url,
								data: user_data
								
							}).success(function(res){
								deferred.resolve(res);
							}).error(function(err){
								deferred.reject(err);
							});
							return deferred.promise;
						},
						get: function(url){
							var deferred =$q.defer();
							$http({
									method: "GET",
									url: base_url + url,
								}).success(function(res){
									deferred.resolve(res);
									
								}).error(function(err){
									deferred.reject(err);
								});
								return deferred.promise;
						},
						delete: function(url,emp){
							var deferred =$q.defer();
							$http({
									method: "DELETE",
									url: base_url+ url,
									data: ({ID:emp})
								}).success(function(res){
									deferred.resolve(res);
									
								}).error(function(err){
									deferred.reject(err);
								});
								return deferred.promise;
						}
						}
					}]);		
		