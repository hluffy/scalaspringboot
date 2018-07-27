angular.module("myApp",['ui.router']);
var app = angular.module("myApp");

app.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/index');
    $stateProvider
//    *
	    .state('index',{
	    	url:'/index',
	    	templateUrl:'html/index.html',
	    })
//	    .state('user.home',{
//	    	url:'/home',
//	    	templateUrl:'html/index.html',
//	    	controller:function(){
//	    		$('#myul').children().first().addClass("active");
//	    		$("#myul li").click(function(e){
//	    			console.log(111);
//	    			$("#myul li").removeClass("active");
//	    			var object = e.target;
//	    			console.log(object);
//	    			$(object).parent().addClass("active");
//	    		})
//	    	}
//	    })
	    .state('user',{
	    	url:'/user',
	    	templateUrl:'html/tree/user.html',
	    })
	    .state('province',{
	    	url:'/province',
	    	templateUrl:'html/chinadata/province.html',
	    	controller:'provinceCtrl'
	    })
	    .state('city',{
	    	url:'/city',
	    	templateUrl:'html/chinadata/city.html',
	    })
	    .state('area',{
	    	url:'/area',
	    	templateUrl:'html/chinadata/area.html',
	    })
	    .state('town',{
	    	url:'/town',
	    	templateUrl:'html/chinadata/town.html',
	    })
	    .state('bol',{
	    	url:'/bol',
	    	templateUrl:'html/bol/bol.html',
	    })
//	    线路流量月累计
	    .state('lineflow',{
	    	url:'/lineflow',
	    	templateUrl:'html/operation/lineflow.html',
	    })
//	    客户货量月累计
	    .state('clientvolume',{
	    	url:'/clientvolume',
	    	templateUrl:'html/operation/clientvolume.html',
	    })
//	    平台进仓排名
	    .state('platform',{
	    	url:'/platform',
	    	templateUrl:'html/operation/platform.html',
	    })
	    .state('liantongbol',{
	    	url:'/liantongbol',
	    	templateUrl:'html/bolmanager/liantongbol.html',
	    })
	    .state('ganxianshipment',{
	    	url:'/ganxianshipment',
	    	templateUrl:'html/bolmanager/ganxianshipment.html',
	    })
	    .state('chengpeishipment',{
	    	url:'/chengpeishipment',
	    	templateUrl:'html/bolmanager/chengpeishipment.html',
	    })
	    .state('appointment',{
	    	url:'/appointment',
	    	templateUrl:'html/bolmanager/appointment.html',
	    })
	    .state('delivery',{
	    	url:'/delivery',
	    	templateUrl:'html/bolmanager/delivery.html',
	    })
	    .state('boldetail',{
	    	url:'/boldetail',
	    	templateUrl:'html/detail/boldetail.html',
	    })
	    .state('deliverydetail',{
	    	url:'/deliverydetail',
	    	templateUrl:'html/detail/deliverydetail.html',
	    })
	    .state('shipmentdetail',{
	    	url:'/shipmentdetail',
	    	templateUrl:'html/detail/shipmentloading.html',
	    })
	    .state('liantonglocation',{
	    	url:'/liantonglocation',
	    	templateUrl:'html/location/liantonglocation.html',
	    })
	    .state('pingtailocation',{
	    	url:'/pingtailocation',
	    	templateUrl:'html/location/pingtailocation.html',
	    })
	    .state('kehulocation',{
	    	url:'/kehulocation',
	    	templateUrl:'html/location/kehulocation.html',
	    })
	    .state('location',{
	    	url:'/location',
	    	templateUrl:'html/location/location.html',
	    })
	    .state('events',{
	    	url:'/events',
	    	templateUrl:'html/events/events.html',
	    })
	    .state('siteinbound',{
	    	url:'/siteinbound',
	    	templateUrl:'html/route/siteinbound.html',
	    })
	    .state('siteoutbound',{
	    	url:'/siteoutbound',
	    	templateUrl:'html/route/siteoutbound.html',
	    })
	    .state('vehicleplan',{
	    	url:'/vehicleplan',
	    	templateUrl:'html/route/vehicleplan.html',
	    })
	    .state('vehicleplanlegs',{
	    	url:'/vehicleplanlegs',
	    	templateUrl:'html/route/vehicleplanlegs.html',
	    })
	    .state('cargoplan',{
	    	url:'/cargoplan',
	    	templateUrl:'html/route/cargoplan.html',
	    })
	    .state('wholeplan',{
	    	url:'/wholeplan',
	    	templateUrl:'html/plan/wholeplan.html',
	    })
	    .state('tcinboundplan',{
	    	url:'/tcinboundplan',
	    	templateUrl:'html/plan/tcinboundplan.html',
	    })
	    .state('tcoutboundplan',{
	    	url:'/tcoutboundplan',
	    	templateUrl:'html/plan/tcoutboundplan.html',
	    })
	    .state('tctranferplan',{
	    	url:'/tctranferplan',
	    	templateUrl:'html/plan/tctranferplan.html',
	    })
});