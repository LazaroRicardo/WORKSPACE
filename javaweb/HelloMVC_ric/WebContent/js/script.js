console.log("Hola!");
 //si existe el boton de volver atras (volverBtn) en el documnento que al darle vuelvas a la pantalla anterior:
if(document.getElementById('volverBtn')) document.getElementById('volverBtn').onclick=function(){
	window.history.back();
}

$('#enviarBtn').click(function(e){
	e.preventDefault();   //el preventdefault sirve para evitar envios inecesarios si se han puesto los datos erroneamente
	console.log("Validando!!");

	document.querySelectorAll('.error').forEach(elem => {  //querySelectorAll selecciona todos los elementos con class error
		elem.classList.add('esconder');
	});

	if(document.getElementById('nuevousuarioform').checkValidity()){  //checkvalidity quiere decir si es verdad:
		//enviar;
		document.getElementById('nuevousuarioform').submit(); //submit es para enviar, similar a send
	}else{
		if(!document.getElementById('email').checkValidity()){
			document.getElementById('emailerr').classList.remove('esconder');
		}

		//verificar el resto campos...incuido password coincidente
	}

	

});