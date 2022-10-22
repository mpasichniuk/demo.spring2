angular.module('spring2', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8189/spring2/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
            });
    };

    $scope.deleteProduct = function (id) {
        $http.delete('http://localhost:8189/spring2/api/v1/products/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8189/spring2/api/v1/products', $scope.newProductDTO)
            .then(function (response) {
                $scope.newProductDTO = null;
                $scope.fillTable();
            });
    }

    $scope.fillTable();
});