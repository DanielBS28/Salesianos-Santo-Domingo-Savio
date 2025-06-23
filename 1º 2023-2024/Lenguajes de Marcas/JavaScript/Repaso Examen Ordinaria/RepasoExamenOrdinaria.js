function ejercicio2(){



}
function comprobarn(nombre){

    var cadenar = /^[a-zA-Z]+$/

    if (nombre.match(cadenar))
        return true;
    else 
    return false;
}

function comprobarc(correo){

    var cadenar = /^[a-zA-Z0-9]+@[a-z]+\.[es]+$/

    if (cadenar.test(correo))
        return true;
    else 
    return false;

    // return cadenar.test(correo);
}

function comprobarcon(contrasena){

    var cadenar = /^[a-z]+[A-Z]+[0-9]$/

    if (contrasena.match(cadenar)&& (contrasena.lenght>=6))
        return true;
    else 
    return false;

    // return cadenar.test(correo);
}

function formulario(){

    var nombre = document.getElementById("nombre").value;
    var email = document.getElementById("email").value;
    var com = document.getElementById("comentarios").value;
    
    var pass = document.getElementById("password").value;

    if((nombre.length>0) && (email.length>0)&& (com.length>0)){
        if(comprobarn(nombre))
            alert("nombre correcto")
        if(comprobarc(email))
            alert("correo correcto")
        if (comprobarcon(pass))
        alert("contraseña correcta")
        document.getElementById("resultado").innerHTML=nombre+email+com+pass;

    }else
    alert("Datos invalidos")
}

function carga(){

document.getElementById("envio").addEventListener("click",formulario);
    
}

window.addEventListener("DOMContentLoaded", carga);