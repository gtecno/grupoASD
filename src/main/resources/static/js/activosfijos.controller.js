/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
    'use strict';
    angular.module('app').controller('activosController', activosController);
    activosController.$inject = ['activosFijosServices', '$location', 'localStorageService', '$window', '$http' ];
    function activosController(activosFijosServices, $location, localStorageService,  $window, $http) {
        var gestionActivos = this;

    }
})();


