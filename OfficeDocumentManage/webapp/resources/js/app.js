'use strict';

var AngularSpringmvcMybatis = {};

var App = angular.module('AngularSpringmvcMybatis', ['AngularSpringmvcMybatis.filters', 'AngularSpringmvcMybatis.services', 'AngularSpringmvcMybatis.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
	
//    $routeProvider.when('/users', {
//        templateUrl: 'users/layout',
//        controller: UserController
//    });
    
    $routeProvider.when('/pageview/getPageView', {
        template: '<h1>test</h1>'
    });

    $routeProvider.otherwise({redirectTo: '/pageview/getPageView'});
}]);
