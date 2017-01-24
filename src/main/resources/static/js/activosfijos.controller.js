/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function () {
    'use strict';
    angular.module('app').controller('activosController', activosController);
    activosController.$inject = ['activosFijosServices', '$location', '$window', '$http', 'appConstant', 'growl'];
    function activosController(activosFijosServices, $location, $window, $http, appConstant, growl) {
        var gestionActivos = this;
        gestionActivos.activos = activosFijosServices.activos;
        gestionActivos.activosFijos = activosFijosServices.activosFijos;
        gestionActivos.listaActivosFijos = [];


        function onBuscarTodosActivosFijos() {
            gestionActivos.listaActivosFijos = [];
            activosFijosServices.buscarActivos().then(function (data) {
                switch (data.tipo) {
                    case 200:
                        gestionActivos.listaActivosFijos = data.responseList;
//                        $window.alert("<div><table><tr><td><i class='glyphicon glyphicon-ok' style='padding-left: 15px;font-size: 20px;'></i></td>&nbsp;&nbsp;<td  style='padding-left: 16px;'><span><strong>BIEN HECHO</strong><BR><span>" + data.message + "</span></span></td></tr><table></div>");
//                        appConstant.MSG_GROWL_OK(data.message);
                        break;
                    case 404:
                        $window.alert(data.message);
//                        appConstant.MSG_GROWL_ADVERTENCIA(data.message);
                        break;
                }
            });
        }

        gestionActivos.onBuscarActivosFijosPorParametro = function (parametro, valor) {
            gestionActivos.listaActivosFijos = [];
            activosFijosServices.buscarActivosByParametros(parametro, parametro === '1' ? formatDate(valor) : valor).then(function (data) {
                switch (data.tipo) {
                    case 200:
                        gestionActivos.listaActivosFijos = data.responseList;
//                       $window.alert("<div><table><tr><td><i class='glyphicon glyphicon-ok' style='padding-left: 15px;font-size: 20px;'></i></td>&nbsp;&nbsp;<td  style='padding-left: 16px;'><span><strong>BIEN HECHO</strong><BR><span>" + data.message + "</span></span></td></tr><table></div>");
//                        appConstant.MSG_GROWL_OK(data.message);
                        break;
                    case 404:
                        $window.alert(data.message);
//                        appConstant.MSG_GROWL_ADVERTENCIA(data.message);
                        break;
                }
            });
        };

        function onLimpiar() {
            gestionActivos.activosFijos = {};
            gestionActivos.activosFijos.id = null;
            gestionActivos.activosFijos.tipo = null;
            gestionActivos.activosFijos.nombre = null;
            gestionActivos.activosFijos.descripcion = null;
            gestionActivos.activosFijos.serial = null;
            gestionActivos.activosFijos.serialInventario = null;
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
            gestionActivos.activosFijos.fechaCompra = toDate(item.fechaCompra);
            gestionActivos.activosFijos.fechaBaja = toDate(item.fechaBaja);
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
                    switch (data.tipo) {
                        case 200:
                            onLimpiar();
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_OK(data.message);
                            break;
                        case 400:
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_ADVERTENCIA(data.message);
                            break;
                        case 404:
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_ADVERTENCIA(data.message);
                            break;
                        case 500:
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_ERROR(data.message);
                            break;

                    }
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
                    switch (data.tipo) {
                        case 200:
//                            onLimpiar();
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_OK(data.message);
                            break;
                        case 400:
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_ADVERTENCIA(data.message);
                            break;
                        case 404:
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_ADVERTENCIA(data.message);
                            break;
                        case 500:
                            $window.alert(data.message);
//                            appConstant.MSG_GROWL_ERROR(data.message);
                            break;
                    }
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

        function toDate(dateStr) {
            var dateStrLong;
            if (typeof dateStr === 'undefined' || typeof dateStr === null) {
                dateStr = null;
                return dateStr;
            } else {
                var parts = [];
                if (dateStr.match('/')) {
                    parts = dateStr.split('/');
                } else {
                    parts = dateStr.split('-');
                }
                dateStr = new Date(parts[2], parts[1] - 1, parts[0]);
                dateStrLong = Date.parse(dateStr);
                return dateStrLong;
            }
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


