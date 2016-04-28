var formulario; //Formulario a validar
var clase; //clase de la que sacaremos los inputs
$(formulario).on('submit',function(e) { //cuando el formulario sea enviado 
	$(clase).each(function() { //por cada input 
		if($.trim($(this).val()) === ''){ //verificamos si esta vacio
			alert("Campo '"+ $(this).attr("placeholder") +"' vacio!!"); //alertamos
			e.preventDefault(); //prevenimos que se envie 
			return false; //hay campo vacio
		} 
		return true; //todo correcto
	});
	
})