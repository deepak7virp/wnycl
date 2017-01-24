'use strict';

angular.module('myApp').controller('AddController', ['$scope', '$modalInstance', function($scope, $modalInstance) {
    
	$scope.addForm = {};

	$scope.ok = function () {
		$modalInstance.close($scope.addForm);
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
}]);
