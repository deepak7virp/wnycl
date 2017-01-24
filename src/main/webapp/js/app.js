'use strict';

var App = angular.module('myApp', ['ngRoute', 'ui.bootstrap']);

App.config(function($routeProvider) {
	$routeProvider
	.when('/listTeams', {
		templateUrl : 'TeamList',
		controller : 'TeamController'
	})
	.when('/home', {
		templateUrl : 'home',
		controller : 'BlogController'
	})
	.when('/about', {
		templateUrl : 'about',
		controller : 'AboutController'
	})
	.otherwise({
		redirectTo : '/'
	});
});
