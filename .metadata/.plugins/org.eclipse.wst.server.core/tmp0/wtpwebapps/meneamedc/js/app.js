angular.module('meneameApp', ["ngRoute"])
.config(function($routeProvider){
	$routeProvider
	.when("/", {
		controller: "noticiasCtrl",
		controllerAs: "vm",
		templateUrl: "listar-noticias.html",
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
	.when("/categoria/:CAT", {
        controller: "categoriasCtrl",
        controllerAs: "vm",
        templateUrl: "listar-noticias.html"
    })
	.when("/noticia/:ID", {
        controller: "mostrarNoticiaCtrl",
        controllerAs: "vm",
        templateUrl: "info-noticia.html"
    });
})
.factory("noticiasFactory", function($http){
   var url = 'http://localhost:8080/meneamedc/rest/noticias/';

    var interfaz = {
    		
    		 leerNoticias: function(){
    			 return $http.get(url)
    			 .then(function(response){
    				 return response.data;
    				 });
    			 },
    			
    			 leerNoticiasCategoria: function(categoria){
    				 var geturl = url + categoria;
	    			 return $http.get(geturl)
	    			 .then(function(response){
	    				 return response.data;
	    				 });
    			 }, 
    			 
    			 leerNoticia: function(id){
    				 var geturl = url+id;
        			 return $http.get(geturl)
        			 .then(function(response){
        				 return response.data;
        				 });
        			 },
    					  
		
    }
    return interfaz;
})
.factory("usersFactory", function($http){
   var url = 'http://localhost:8080/meneamedc/rest/usuarios/';

    var interfaz = {
    		   		
    	     leerUser : function(id){
                  var geturl = url + id ;
                      return $http.get(geturl)
                      .then(function(response){
         				 return response.data;
     				 });
                 },
             
             karma : function(id){
            	 var geturl = url + "karma/" + id ;
                 return $http.get(geturl)
                 .then(function(response){
    				 return response.data;
				 });
             },
             
             login : function(){
            	 var geturl = url + "sesion";
                 return $http.get(geturl)
                 .then(function(response){
                	 console.log("desde fac bello");
    				 return response;
				 },function(response){
					 console.log("desde fac error");
					 return response;
				 });
             }
		
    }
    return interfaz;
})
.factory("commentsFactory", function($http){
   var url = 'http://localhost:8080/meneamedc/rest/comentarios/';

    var interfaz = {
    		   		
    		leerComentarios : function(id){
                  var geturl = url + "noticia/" + id ;
                      return $http.get(geturl)
                      .then(function(response){
         				 return response.data;
     				 });
                 }			  
		
    }
    return interfaz;
})
.controller("noticiasCtrl", function(noticiasFactory,usersFactory,commentsFactory){
    var vm = this;
    vm.noticias=[];
       
    vm.funciones = {
			
			obtenerNoticias : function() {
		        noticiasFactory.leerNoticias()
					.then(function(respuesta){
		    			console.log("Trayendo todas las noticias: ", respuesta);
		    			angular.forEach(respuesta, function(value) {
		    				value = getUserNew(value,usersFactory);
		    				value = getNumberComments(value,commentsFactory);
		    				value = getKarmaUser(value,usersFactory);
		    			});
		    			vm.noticias = respuesta;
		    			vm.categoria = "Nuevas";
	    			}, function(respuesta){
	    			console.log("Error obteniendo noticias");
	    			})
		}
    
    
    
	}
	vm.funciones.obtenerNoticias();
   
})
.controller("categoriasCtrl", function(noticiasFactory,usersFactory,commentsFactory,$routeParams){
    var vm = this;
    vm.noticias=[];
       
    vm.funciones = {
			
			obtenerNoticiasCategoria : function() {
		        noticiasFactory.leerNoticiasCategoria($routeParams.CAT)
					.then(function(respuesta){
		    			console.log("Trayendo todas las noticias: ", respuesta);
		    			angular.forEach(respuesta, function(value) {
		    				value = getUserNew(value,usersFactory);
		    				value = getNumberComments(value,commentsFactory);
		    				value = getKarmaUser(value,usersFactory);
		    			});
		    			vm.noticias = respuesta;
		    			vm.categoria = $routeParams.CAT;
	    			}, function(respuesta){
	    			console.log("Error obteniendo noticias");
	    			})
		}
    
    
    
	}
	vm.funciones.obtenerNoticiasCategoria();
   
})
.controller("mostrarNoticiaCtrl", function(noticiasFactory,usersFactory,commentsFactory,$routeParams){
    var vm = this;
    vm.comentarios=[];
    vm.noticia={};
    vm.funciones = {
			
			obtenerDetalleNoticia : function(id) {
		        noticiasFactory.leerNoticia(id)
					.then(function(respuesta){
		    			console.log("Trayendo todas la noticia: ", respuesta);
		    			respuesta = getUserNew(respuesta,usersFactory);
		    			respuesta = getNumberComments(respuesta,commentsFactory);
		    			respuesta = getKarmaUser(respuesta,usersFactory);
		    			vm.noticia = respuesta;
	    			}, function(respuesta){
	    			console.log("Error obteniendo noticias");
	    			});
		        
		        commentsFactory.leerComentarios(id).then(function(respuesta){
		        	angular.forEach(respuesta, function(value) {
	    				value = getUserNew(value,usersFactory);
	    			});
		        	vm.comentarios=respuesta;
		        },function(respuesta){
		        	console.log("Errror consultando comentarios");
		        });
		}
    
    
    
	}
	vm.funciones.obtenerDetalleNoticia($routeParams.ID);
   
})
.controller("mainAppCtrl", function($location){
    var vm = this;
    vm.funciones = {
			estoy : function(ruta){
	            return $location.path() == ruta;
	        }, 
    };
})
.controller("loginAppCtrl", function(usersFactory){
    var vm = this;
    vm.funciones = {
			login : function(){
				usersFactory.login().then(function(usuario){
					if(usuario.status==404){
						console.log("No hay nadie en sesion");
					}else{
						console.log("Bienvenido usuario");
						vm.user=usuario.data;
					}
				});
			}
    };
    
    vm.funciones.login();
})
;

//Funciones utiles
//Consultar usuario noticia
function getUserNew(value,usersFactory){
	usersFactory.leerUser(value.owner).then(function(usuario){
		console.log("Usuario obtenido",usuario);
		value.user=usuario;
	},function(usuario){
		console.log("Error en la consulta al usuario");
	});
	return value;
};

//Consultar cantidad comments noticia
function getNumberComments(value,commentsFactory){
	commentsFactory.leerComentarios(value.id).then(function(cantidad){
		console.log("Cantidad de comentarios",cantidad);
		value.comments = cantidad.length;
	},function(cantidad){
		console.log("Error consultando cantidad");
	});
	return value;
};
//Consultar karma de usuario para noticia
function getKarmaUser(value,usersFactory){
	usersFactory.karma(value.owner).then(function(karma){
		console.log("Karma obtenido",karma);
		value.karma = karma;
	},function(karma){
		console.log("Consulta de karma erronea");
	});
	return value;
};