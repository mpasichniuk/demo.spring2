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
        $http.post('http://localhost:8189/spring2/api/v1/products', $scope.newProductDTO)
            .then(function (response) {
                $scope.newProductDTO = null;
                $scope.fillTable();
            });
    }
    $scope.addProductToCart = function(productId){
    $http.get('http://localhost:8189/spring2/api/v1/add' + productId).then(function(response))}{
    $scope.loadCart();
    });
    }
     $scope.deleteProductInCart = function(productId){
        $http.get('http://localhost:8189/spring2/api/v1/delete' + productId).then(function(response))}{
        $scope.loadCart();
        });
        }
$scope.loadCart = function () {
        $http.get('http://localhost:8189/spring2/api/v1/cart')
            .then(function (response) {
                $scope.cart() = response.data;
            });
    };
    $scope.fillTable();
    $scope.loadCart();
});