/*Angular会注册模块,如果找不到模块会报错,ngRoute和ngAnimate是Angular自带的,animate是动画效果*/
/*bookStoreApp依赖于后面[]中的模块(类似spring中的依赖注入)*/
var bookStoreApp = angular.module("bookStoreApp", [ "ngRoute", "ngAnimate","bookStoreCtrls" ]);
/*Angular的路由功能,根据url的后缀来选择页面和控制器*/
bookStoreApp.config(function($routeProvider) {
    $routeProvider.when('/hello', {
        templateUrl: 'tpls/hello.html',
        controller: 'HelloCtrl'
    }).when('/list',{
    	templateUrl:'tpls/bookList.html',
    	controller:'BookListCtrl'
    }).otherwise({
        redirectTo: '/hello'
    })
});
/*Angular的模块的概念
 * Module
 * Config , Filter Directive,(Factory,Service,Provider,Value),Controller
 * Config下面有Routes
 */
