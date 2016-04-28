angular.module('pizzeriaApp', ["ngRoute"])
.config(function($routeProvider){
    $routeProvider
    	.when("/", {
    		controller: "listCtrl",
    		controllerAs: "vm",
    		templateUrl: "list.html",
    		resolve: {
    		      // provoca 100 milisegundos (0,1 segundos) de delay que deberían ser suficientes para que el servidor haga cualquier actualización que se le haya pedido antes de leer las órdenes.
    			  // extraído del script.js utilizado como ejemplo en https://docs.angularjs.org/api/ngRoute/service/$route
    		      delay: function($q, $timeout) {
    		        var delay = $q.defer();
    		        $timeout(delay.resolve, 100);
    		        return delay.promise;
    		      }
    		}
    	})
    	.when("/insertOrder", {
            controller: "editCtrl",
            controllerAs: "vm",
            templateUrl: "order.html"
        })
        .when("/editOrder/:ID", {
            controller: "editCtrl",
            controllerAs: "vm",
            templateUrl: "order.html"
        })
        .when("/deleteOrder/:ID", {
            controller: "editCtrl",
            controllerAs: "vm",
            templateUrl: "order.html"
        });
})
.factory("ordersFactory", function($http){
   var url = 'https://localhost:8080/pizzeria/rest/orders/';

    var interfaz = {
    		
    		
    		 leerOrdenes: function(){
    			 return $http.get(url)
    			 .then(function(response){
    				 return response.data;
    				 });
    			 },
    		
    		
    	     leerOrden : function(id){
                  var urlid = url + id;
                      return $http.get(urlid)
                      .then(function(response){
         				 return response.data;
         				 });
                 },
    		
    		actualizarOrden : function(order){
                var urlid = url+order.id;
                  return $http.put(urlid, order)
                  .then(function(response){
      				 return response.status;
  				 });                   
                },
    		
    		nuevaOrden:  function(order){
                    return $http.post(url,order)
                    .then(function(response){
         				 return response.status;
     				 });
                    }, 
              
              eliminarOrden : function(id){
					var urlid = url+id;
                    return $http.delete(urlid)
                    .then(function(response){
         				 return response.status;
     				 });
                  }				  
		
    }
    return interfaz;
})
.factory("usersFactory", function($http){
   var url = 'https://localhost:8080/pizzeria/rest/users/';

    var interfaz = {
    		   		
    	     leerUser : function(){
                  url = url ;
                      return $http.get(url)
                      .then(function(response){
         				 return response.data;
     				 });
                 }			  
		
    }
    return interfaz;
})
.controller("mainAppCtrl", function(usersFactory,$route,$templateCache){
    var vm = this;
    vm.user={};
    vm.funciones = {
		obtenerUsuario : function() {
	        usersFactory.leerUser()
				.then(function(respuesta){
    			vm.user = respuesta
    			console.log("Trayendo user con id: ", vm.user.id," Respuesta: ", respuesta);
    			}, function(respuesta){
    			// acciones a realizar cuando se recibe una respuesta de error
    			console.log("Error:", respuesta.status);
    			})
	}
    
    	
	}
		
	vm.funciones.obtenerUsuario();
    }
)
.controller("listCtrl", function(ordersFactory){
    var vm = this;
    vm.ordenes=[];
       
    vm.funciones = {
			
			obtenerOrdenes : function() {
		        ordersFactory.leerOrdenes()
					.then(function(respuesta){
	    			console.log("Trayendo todas las ordenes: ", respuesta);
	    			vm.ordenes = respuesta;
	    			}, function(respuesta){
	    			console.log("Error obteniendo ordenes");
	    			})
		}
    
    
    
	}
	vm.funciones.obtenerOrdenes();
   
}
)
.controller("editCtrl", function(ordersFactory,usersFactory,$routeParams,$location,$scope){
    var vm = this;
    vm.order={};
    vm.user={};
    vm.order.tel="";
    vm.order.comments="";
   
	vm.funciones = {
			estoy : function(ruta){
	            return $location.path() == ruta;
	        },
						
	
	obtenerDatosUsuario : function() {
	        usersFactory.leerUser()
				.then(function(respuesta){
    			vm.order.name= respuesta.name;
    			vm.order.email= respuesta.email;
    			console.log("Trayendo user con id: ",respuesta.id," Respuesta: ", respuesta);
    			
    			}, function(respuesta){
    			// acciones a realizar cuando se recibe una respuesta de error
    			console.log("Error: datos de usuario no obtenidos");
    			})
	},
	


	obtenerOrden : function(id) {
        ordersFactory.leerOrden(id)
			.then(function(respuesta){
			console.log("Trayendo la orden con id: ", id," Respuesta: ", respuesta);
			vm.order = respuesta;
			}, function(respuesta){
			// acciones a realizar cuando se recibe una respuesta de error
			console.log("Error: datos de orden no obtenidos");
			})
},
	cambiarOrden : function() {
	        ordersFactory.actualizarOrden(vm.order)
				.then(function(respuesta){
    			console.log("Actualizando orden con id:",vm.order.id," Respuesta recibida:", respuesta);
    			
    			}, function(respuesta){
    			// acciones a realizar cuando se recibe una respuesta de error
    			console.log("Error: cambio de orden no realizado");
    			
    			})
	},	agregarOrden : function() {
	        ordersFactory.nuevaOrden(vm.order)
				.then(function(respuesta){
    			console.log("Insertando orden . Respuesta recibida:", respuesta);
    			
    			}, function(respuesta){
    			// acciones a realizar cuando se recibe una respuesta de error
    			console.log("Error: inserción de orden no realizado");
    			
    			})
	},
	borrarOrden : function(id) {
        ordersFactory.eliminarOrden(id)
			.then(function(respuesta){
			console.log("Eliminando orden con id:",id," Respuesta recibida:", respuesta);
			
			}, function(respuesta){
			// acciones a realizar cuando se recibe una respuesta de error
			console.log("Error: eliminación de orden no realizado");
			
			})
},
	
	editarOrden : function(){
		if (vm.funciones.estoy('/insertOrder'))
			{
			console.log($location.path());
			vm.funciones.agregarOrden();
			}
		else if (vm.funciones.estoy('/editOrder/'+vm.order.id)){
			console.log($location.path());
			vm.funciones.cambiarOrden();
		}
		else if (vm.funciones.estoy('/deleteOrder/'+vm.order.id)){
			console.log($location.path());
			vm.funciones.borrarOrden(vm.order.id);
		}
		else {
			console.log($location.path());
		}
		
		$location.path('/');
		}
	}
	
	vm.funciones.obtenerDatosUsuario();
	console.log("$routeParams.ID=",$routeParams.ID);
	if (!($routeParams.ID==undefined)) vm.funciones.obtenerOrden($routeParams.ID);
	
	
}
	)
;
