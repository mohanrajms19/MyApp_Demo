sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "com/myapp/model/URLConstants",
    "sap/ui/model/json/JSONModel",

],
    /**
     * @param {typeof sap.ui.core.mvc.Controller} Controller
     */
    function (Controller, URLConstants, JSONModel) {
        "use strict";

        return Controller.extend("com.myapp.controller.Employee", {
            onInit: function () {
                this.getemployees();
              
            },
            getemployees: async function () {
                try {
                    var path = URLConstants.URL.Employeeall
                    let obj = await this.restMethodGet(path);
                    this.getView().setModel(new JSONModel(obj), "Employees");
                }
                catch (e) {
                    return e
                }
            },
            restMethodGet:function(url){
                url = URLConstants.URL.app_endPoint + url;
                var deferred = $.Deferred();

                $.ajax({
                    type:"GET",
                    url:url,
                    contentType:"application/json",
                    success:function(response){
                        deferred.resolve(response);
                    },
                    error:function(xhr){
                        deferred.reject(xhr);
                    }
                });
                return deferred.promise();
            }
        });


    });