App.controller('keeptrack2Controller',['$scope','keeptrack2Factory', function ($scope, keeptrack2Factory){	 
	$scope.test = '';
	$scope.employees = [
				
				];                                                      
			 
			  keeptrack2Factory.get('/keeptrack2').then(function(data){
					$scope.employees=data;
					console.log($scope.employees);
				},function(data)
				{
					console.log("Error!!");
				}); 
					
			      $scope.save=function(){
				    keeptrack2Factory.post('/keeptrack2',{
				    name:$scope.newEmployee.name,
				    ID:$scope.newEmployee.ID,
				    workdayid:$scope.newEmployee.workdayid,
					teammember:$scope.newEmployee.teammember,
					comments:$scope.newEmployee.comments,
					sow:$scope.newEmployee.sow,
					location:$scope.newEmployee.location,
					stream:$scope.newEmployee.stream,
					project:$scope.newEmployee.project,
					leaves:$scope.newEmployee.leaves,
					workingdays:$scope.newEmployee.workingdays,
					pdtosp:$scope.newEmployee.pdtosp,
					agreedsp:$scope.newEmployee.agreedsp,
					allocatedsp:$scope.newEmployee.allocatedsp,
					actualsp:$scope.newEmployee.actualsp,
					revenue:$scope.newEmployee.revenue,
				 
				 }).then(function(res){
					alert('Success');
				},function(err)
				{
					alert('Error');
				});
				}; // end
				$scope.removeEmployee= function(emp){
				    keeptrack2Factory.delete('/keeptrack2',emp.ID
					 
					 ).then(function(res){
						 alert('Success');
					},function(err)
					{
						alert('Error');
					});
					};
			
			}]);