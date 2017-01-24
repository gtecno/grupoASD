(function () {
    'use strict';
    angular.module('app').service('appConstant', ['growl', function (growl) {
            this.MSG_GROWL_OK = function (text) {
                growl.success("<div><table><tr><td><i class='glyphicon glyphicon-ok' style='padding-left: 15px;font-size: 20px;'></i></td>&nbsp;&nbsp;<td  style='padding-left: 16px;'><span><strong>BIEN HECHO</strong><BR><span>" + text + "</span></span></td></tr><table></div>");
            };
            this.MSG_GROWL_ADVERTENCIA = function (text) {
                growl.warning("<div><table><tr><td><i class='glyphicon glyphicon-warning-sign' style='padding-left: 15px;font-size: 20px;'></i></td>&nbsp;&nbsp;<td  style='padding-left: 16px;'><span><strong>ALTO AHÍ</strong><BR><span>" + text + "</span></span></td></tr><table></div>");
            };

            this.MSG_GROWL_ERROR = function (text) {
                growl.error("<div><table><tr><td><i class='glyphicon glyphicon-remove-circle' style='padding-left: 15px;font-size: 20px;'></i></td>&nbsp;&nbsp;<td  style='padding-left: 16px;'><span><strong>OOPS!!</strong><BR><span>" + text+ "</span></span></td></tr><table></div>");
            };
        }]);
})();