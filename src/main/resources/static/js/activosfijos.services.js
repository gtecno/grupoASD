/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
    'use strict';
    angular.module('app').service('activosFijosServices', activosFijosServices);
    activosFijosServices.$inject = ['$http', '$q'];
    function activosFijosServices($http, $q) {
        var servicioActivos = this;
        servicioActivos.registrarActivo = postActivos;
        servicioActivos.actulizarActivo = putActivos;
        servicioActivos.buscarActivos = getActivos;
        servicioActivos.buscarActivosByParametros = getActivosByParametro;
        servicioActivos.activos = {};
        servicioActivos.activosFijos = {};
        var url = '/ActivoFijo/';
        function postActivos(activo) {
            var defered = $q.defer();
            var urlRequest = url;
            $http.post(urlRequest, activo).success(function (response) {
                defered.resolve(response);
            }).error(function (error) {
                defered.reject(error);
            });
            return defered.promise;
        }

        function putActivos(activo) {
            var defered = $q.defer();
            var urlRequest = url;
            $http.put(urlRequest, activo).success(function (response) {
                defered.resolve(response);
            }).error(function (error) {
                defered.reject(error);
            });
            return defered.promise;
        }

        function ejecutarServicesGet(urlRequest) {
            var defered = $q.defer();
            $http.get(urlRequest).success(function (response) {
                defered.resolve(response);
            }).error(function (error) {
                defered.reject(error);
            });
            return defered.promise;
        }

        function getActivos() {
            var urlRequest = url;
            return ejecutarServicesGet(urlRequest);
        }

        function getActivosByParametro(parametro, valor) {
            var urlRequest = url + 'findByParametro/' + parametro + '/' + valor;
            return ejecutarServicesGet(urlRequest);
        }
    }
})();
