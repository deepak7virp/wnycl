'use strict';
 
var App = angular.module('myApp',['ngRoute']);

App.config(function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/listTeams', {
            templateUrl : '/wnycl/TeamsList',
            controller  : 'TeamController'
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


