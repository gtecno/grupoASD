/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('app', ['ngRoute', 'ngResource']);
app.config(function ($routeProvider) {
    $routeProvider
            .when('/activos', {
                templateUrl: 'view/activosfijos.html'
            })
            .when('/gestionar-activos', {
                templateUrl: 'view/gestionar-activos-fijos.html'
            })
            .otherwise(
                    {redirectTo: '/'}
            );
});
