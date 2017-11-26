angular.module('app', []).controller('Controller', function($scope, $http , $window , $location ) {
	var BASE_URL = ""+location.protocol+"//" + $location.$$host + ':' + $location.$$port + '/';
	$scope.message = {
		"content" : "" 
	};
	$scope.send = function(){
		var request = $scope.message;
		$http.post(BASE_URL+'/save', request).
	    then(function(response){
	    	console.log(response);
	    	setTimeout(function(){
	    		$scope.clear();
	    	},100);
	    });
	};
	$scope.clear = function(){
		$scope.message = {
				"content" : "" 
			};
		console.log('Clear it!');
	}
	$scope.list = function(){
		var request = {};
		$http.get(BASE_URL+'/list', request).
		then(function(response){
			console.log(JSON.stringify(response.data));
		});
	};
});