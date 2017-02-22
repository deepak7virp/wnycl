'use strict';
 
var App = angular.module('myApp',['ngRoute']);

App.config(function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/listTeams', {
            templateUrl : '/wnycl/teamsList',
            controller  : 'TeamController'
        })
        
        .when('/teamInfo/:teamid', {
        	templateUrl:'/wnycl/playersList',
        	controller : 'PlayerController',
        	teamid: ':teamid'
        })

        .when('/team/AddTeam', {        
            templateUrl : '/wnycl/addTeam',
            controller  : 'TeamController'            
        })
        
        .when('/listTours', {
            templateUrl : '/wnycl/toursList',
            controller  : 'TourController'
        })
        
        .when('/tourInfo/:tourid', {
        	templateUrl:'/wnycl/tourInfo',
        	controller : 'TourController',
        	teamid: ':tourid'
        })

        .when('/team/AddTour', {        
            templateUrl : '/wnycl/addTour',
            controller  : 'TourController'            
        })
        
        // route for the about page
        .when('/about', {
            templateUrl : 'pages/about.html',
            controller  : 'aboutController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl : 'pages/contact.html',
            controller  : 'contactController'
        });
});


