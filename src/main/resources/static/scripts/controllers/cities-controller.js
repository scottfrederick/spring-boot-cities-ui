'use strict';

angular.module('citiesUiApp', ['ngResource', 'ui.bootstrap']).
    factory('PostalCodes', function ($resource) {
        return $resource('cities');
    }).
    factory('PostalCode', function ($resource) {
        return $resource('cities/:id', {id: '@id'});
    }).
    controller('CitiesController', function ($scope, PostalCodes, PostalCode) {
        function list() {
            console.log('loading page number: ' + $scope.pageNumber);
            PostalCodes.get({page: $scope.pageNumber - 1, size: $scope.itemsPerPage}).$promise.then(function(pagedCities) {
                $scope.pagedCities = pagedCities;
            })
        }

        $scope.pageChanged = function() {
            list();
        };

        $scope.init = function() {
            $scope.pageNumber = 1;
            $scope.itemsPerPage = 20;
            $scope.maxPageLinks = 15;
            list();
        };
    });
