'use strict';

angular.module('citiesUiApp', ['ngResource']).
    factory('PostalCodes', function ($resource) {
        return $resource('cities');
    }).
    factory('PostalCode', function ($resource) {
        return $resource('cities/:id', {id: '@id'});
    }).
    controller('CitiesController', function ($scope, PostalCodes, PostalCode) {
        function list() {
            PostalCodes.get().$promise.then(function(pagedCities) {
                $scope.pagedCities = pagedCities;
            })
        }

        list();
    });
