/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
    'use strict';
    angular.module('app').controller('activosController', activosController);
    activosController.$inject = ['activosFijosServices', '$location', '$window', '$http'];
    function activosController(activosFijosServices, $location, $window, $http) {
        var gestionActivos = this;
        gestionActivos.listaActivosFijos = [];


        function onBuscarTodosActivosFijos() {
            gestionActivos.listaActivosFijos = [];
            activosFijosServices.buscarActivos().then(function (data) {
                gestionActivos.listaActivosFijos = data.responseList;
            });
        }


        gestionActivos.onBuscarActivosFijosPorParametro = function (columna, parametro) {
            gestionActivos.listaActivosFijos = [];
            activosFijosServices.buscarActivosByParametros().then(function (data) {
                gestionActivos.listaActivosFijos = data.responseList;
            });
        };

        gestionActivos.onGuardarActivo = function (activoFijo) {
            if (activoFijo.id !== null) {
                activosFijosServices.putActivos(activoFijo).then(function (data) {
                    gestionActivos.listaActivosFijos = data.responseList;
                });
            } else {
                activosFijosServices.registrarActivo(activoFijo).then(function (data) {
                    gestionActivos.listaActivosFijos = data.responseList;
                });

            }

        };


        gestionActivos.onClickToGoListaActivos = function () {
            $location.path('/activos');
        };
        gestionActivos.onClickToGoGestionActivos = function () {
            $location.path('/gestionar-activos');
        };


        onBuscarTodosActivosFijos();

    }
})();


