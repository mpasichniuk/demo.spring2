angular.module('spring2', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8189/spring2/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
            });
    };

    if ($localStorage.marchMarketUser) {
            try {
                let jwt = $localStorage.marchMarketUser.token;
                let payload = JSON.parse(tob(jwt.split('.')[1]));
                let currentTime = parseInt(new Date().getTime() / 1000);
                if (currentTime > payload.exp) {
                    console.log("Token is expired!!!");
                    delete $localStorage.marchMarketUser;
                    $http.defaults.headers.common.Authorization = '';
                }
            } catch (e) {
            }

            if ($localStorage.marchMarketUser) {
                $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.marchMarketUser.token;
            }
        }

        $scope.tryToAuth = function () {
            $http.post('http://localhost:8189/market-core/auth', $scope.user)
                .then(function successCallback(response) {
                    if (response.data.token) {
                        $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                        $localStorage.marchMarketUser = {username: $scope.user.username, token: response.data.token};

                        $scope.user.username = null;
                        $scope.user.password = null;
                    }
                }, function errorCallback(response) {
                });
        };

        $scope.tryToLogout = function () {
            $scope.clearUser();
        };

        $scope.clearUser = function () {
            delete $localStorage.marchMarketUser;
            $http.defaults.headers.common.Authorization = '';
        };

        $scope.isUserLoggedIn = function () {
            if ($localStorage.marchMarketUser) {
                return true;
            } else {
                return false;
            }
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