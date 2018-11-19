if(document.getElementById('enviarBtn')) document.getElementById('enviarBtn').onclick = (function () {
	window.history.back();
	
	$(`#enviarBtn`).click(function(e) {
		e.preventDefault();
		 console.log("Validando!!");
		 
		 if(!document.getElementById(`email`).checkValidity()){
			 document.getElementById(`emailerror`).checkValidity(`esconder`)
	}
		 
	})
	
	
    console.log(event);
    event.preventDefault();//previene envio form

    document.querySelectorAll('.error').forEach(element => { //querySelectorAll=getElementById=getElementByClassName
        element.classList.add('esconder');
    });

    let formValid = document.getElementById('formPerfil').checkValidity();
    
    if (formValid) {
        //Enviar
        $.ajax({
            method: "POST",
            url: "http://www.mocky.io/v2/5bd973312f00006f0006d126",//caso true
            // url: "http://www.mocky.io/v2/5bd977ac2f00003e0006d155",//caso false
            crossDomain: true,
            dataType: 'jsonp',
            data: {
                nick: document.getElementById('nombre').value,
                codigo_postal: document.getElementById('post').value,
                email: document.getElementById('email').value,
                contraseña: document.getElementById('contra').value,
                contraseña_repetida: document.getElementById('repeatcontra').value,
            }
        }).done(function (data) { //done=respuesta del servidor//
            console.log(data);
            if (data.result) {
                alert("Perfil Modificado!"); 
                window.location.href = 'pgprincipal.html';
            } else {
                document.getElementById('mensaje').classList.remove('esconder');
            }
        });
    } else {
        //mostrar mensaje y no enviar
        // document.getElementById('mensaje').innerHTML="Datos Incorrectos";

        if (!document.getElementById('nombre').checkValidity()) {
            document.getElementById('errornick').classList.remove('esconder');
        }

        if (!document.getElementById('post').checkValidity()) {
            document.getElementById('errorcp').classList.remove('esconder');
        }

        if (!document.getElementById('email').checkValidity()) {
            document.getElementById('errorcorreo').classList.remove('esconder');
        }

        if (!document.getElementById('contra').checkValidity()) {
            document.getElementById('errorcontraseña').classList.remove('esconder');
        }

        if (!document.getElementById('repeatcontra').checkValidity()) {
            document.getElementById('errorcontraseñanueva').classList.remove('esconder');
        }

    }
});