App.controller('keeptrack3Controller',['$scope','keeptrack2Factory', function ($scope, keeptrack2Factory){
		var url="keeptrack3" ;
		$scope.kt3employees = [
				
				];                                                      
			 
			  keeptrack2Factory.get('/keeptrack3').then(function(data){
					$scope.kt3employees=data;
					console.log($scope.kt3employees);
				},function(data)
				{
					console.log("Error!!");
				}); 
					
			      $scope.save=function(){
				    keeptrack2Factory.post('/keeptrack3',{
				    resource_name:$scope.newEmployee.resource_name,
				    sow:$scope.newEmployee.sow,
				    comments:$scope.newEmployee.comments,
					start_date:$scope.newEmployee.start_date,
					end_date:$scope.newEmployee.end_date,
					rate_set:$scope.newEmployee.rate_set,
					sap_id:$scope.newEmployee.sap_id,
					employee_id:$scope.newEmployee.employee_id,
					rate:$scope.newEmployee.rate,
					location:$scope.newEmployee.location,
					desig:$scope.newEmployee.desig,
					cat:$scope.newEmployee.cat,
					amount:$scope.newEmployee.amount,
					workingdays:$scope.newEmployee.workingdays,
					leaves:$scope.newEmployee.leaves,
					leave_dates:$scope.newEmployee.leave_dates,
					w1:$scope.newEmployee.w1,
					w2:$scope.newEmployee.w2,
					w3:$scope.newEmployee.w3,
					w4:$scope.newEmployee.w4,
					w5:$scope.newEmployee.w5,
					flag:$scope.newEmployee.flag,
					totalworkingdays:$scope.newEmployee.totalworkingdays
				 
				 }).then(function(res){
					alert('Success');
				},function(err)
				{
					alert('Error');
				});
				}; // end
				$scope.kt3removeEmployee= function(emp){
				    keeptrack2Factory.delete('keeptrack3',emp.ID
					 
					 ).then(function(res){
						 alert('Success');
					},function(err)
					{
						alert('Error');
					});
					};
			
			}]);