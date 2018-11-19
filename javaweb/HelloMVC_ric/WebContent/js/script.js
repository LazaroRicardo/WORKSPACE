console.log("Hola!");

if(document.getElementById('volverBtn')) document.getElementById('volverBtn').onclick=function(){
	window.history.back();
}

$('#enviarBtn').click(function(e){
	e.preventDefault();
	console.log("Validando!!");

	document.querySelectorAll('.error').forEach(elem => {
		elem.classList.add('esconder');
	});

	if(document.getElementById('nuevousuarioform').checkValidity()){
		//enviar;
		document.getElementById('nuevousuarioform').submit();
	}else{
		if(!document.getElementById('email').checkValidity()){
			document.getElementById('emailerr').classList.remove('esconder');
		}

		//verificar el resto campos...incuido password coincidente
	}

	

});