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
        gestionActivos.activos = activosFijosServices.activos;
        gestionActivos.activosFijos = activosFijosServices.activosFijos;
        gestionActivos.listaActivosFijos = [];


        function onBuscarTodosActivosFijos() {
            gestionActivos.listaActivosFijos = [];
            activosFijosServices.buscarActivos().then(function (data) {
                gestionActivos.listaActivosFijos = data.responseList;
            });
        }

        gestionActivos.onBuscarActivosFijosPorParametro = function (columna, parametro) {
            gestionActivos.listaActivosFijos = [];
            activosFijosServices.buscarActivosByParametros(columna, parametro).then(function (data) {
                gestionActivos.listaActivosFijos = data.responseList;
            });
        };

        function onLimpiar() {
            gestionActivos.activosFijos = {};
            gestionActivos.activosFijos.id = null;
            gestionActivos.activosFijos.tipo = null;
            gestionActivos.activosFijos.nombre = null;
            gestionActivos.activosFijos.descripcion = null;
            gestionActivos.activosFijos.serial = null;
            gestionActivos.activosFijos.serialInventario =null;
            gestionActivos.activosFijos.peso = null;
            gestionActivos.activosFijos.altura = null;
            gestionActivos.activosFijos.largo = null;
            gestionActivos.activosFijos.valorCompra = null;
            gestionActivos.activosFijos.fechaCompra = null;
            gestionActivos.activosFijos.fechaBaja = null;
            gestionActivos.activosFijos.estado = null;
            gestionActivos.activosFijos.color = null;
        }

        gestionActivos.onClickToEditarActivo = function (item) {
            gestionActivos.activosFijos.id = item.id;
            gestionActivos.activosFijos.tipo = item.tipo;
            gestionActivos.activosFijos.nombre = item.nombre;
            gestionActivos.activosFijos.descripcion = item.descripcion;
            gestionActivos.activosFijos.serial = item.serial;
            gestionActivos.activosFijos.serialInventario = item.serialInventario;
            gestionActivos.activosFijos.peso = item.peso;
            gestionActivos.activosFijos.altura = item.alto;
            gestionActivos.activosFijos.largo = item.largo;
            gestionActivos.activosFijos.valorCompra = item.valorCompra;
            gestionActivos.activosFijos.fechaCompra = item.fechaCompra;
            gestionActivos.activosFijos.fechaBaja = item.fechaBaja;
            gestionActivos.activosFijos.estado = item.estado;
            gestionActivos.activosFijos.color = item.color;
            $location.path('/gestionar-activos');
        };



        gestionActivos.onGuardarActivo = function () {
            if (gestionActivos.activosFijos.id !== null || gestionActivos.activosFijos.id !== undefined) {
                var activoFijo = {
                    "tipo": gestionActivos.activosFijos.tipo,
                    "nombre": gestionActivos.activosFijos.nombre,
                    "descripcion": gestionActivos.activosFijos.descripcion,
                    "serial": gestionActivos.activosFijos.serial,
                    "serialInventario": gestionActivos.activosFijos.serialInventario,
                    "peso": gestionActivos.activosFijos.peso,
                    "alto": gestionActivos.activosFijos.altura,
                    "largo": gestionActivos.activosFijos.largo,
                    "valorCompra": gestionActivos.activosFijos.valorCompra,
                    "fechaCompra": gestionActivos.activosFijos.fechaCompra,
                    "fechaBaja": gestionActivos.activosFijos.fechaBaja,
                    "estado": gestionActivos.activosFijos.estado,
                    "color": gestionActivos.activosFijos.color
                };
                activosFijosServices.registrarActivo(activoFijo).then(function (data) {
                    onLimpiar();
                    
//                    gestionActivos.listaActivosFijos = data.responseList;
                });
            } else {
                var activoFijo = {
                    "id": gestionActivos.activosFijos.id,
                    "tipo": gestionActivos.activosFijos.tipo,
                    "nombre": gestionActivos.activosFijos.nombre,
                    "descripcion": gestionActivos.activosFijos.descripcion,
                    "serial": gestionActivos.activosFijos.serial,
                    "serialInventario": gestionActivos.activosFijos.serialInventario,
                    "peso": gestionActivos.activosFijos.peso,
                    "alto": gestionActivos.activosFijos.altura,
                    "largo": gestionActivos.activosFijos.largo,
                    "valorCompra": gestionActivos.activosFijos.valorCompra,
                    "fechaCompra": gestionActivos.activosFijos.fechaCompra,
                    "fechaBaja": gestionActivos.activosFijos.fechaBaja,
                    "estado": gestionActivos.activosFijos.estado,
                    "color": gestionActivos.activosFijos.color
                };
                activosFijosServices.actulizarActivo(activoFijo).then(function (data) {
                    gestionActivos.listaActivosFijos = data.responseList;
                });

            }

        }
        ;


        function formatDate(date) {
            var d = new Date(date),
                    month = '' + (d.getMonth() + 1),
                    day = '' + d.getDate(),
                    year = d.getFullYear();

            if (month.length < 2)
                month = '0' + month;
            if (day.length < 2)
                day = '0' + day;

            return [year, month, day].join('-');
        }

        gestionActivos.onClickToGoListaActivos = function () {
            $location.path('/activos');
        };
        gestionActivos.onClickToGoGestionActivos = function () {
            $location.path('/gestionar-activos');
        };
        onBuscarTodosActivosFijos();

    }
})();


