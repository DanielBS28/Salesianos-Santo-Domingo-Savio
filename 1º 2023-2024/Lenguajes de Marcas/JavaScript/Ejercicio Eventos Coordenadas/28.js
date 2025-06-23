

function cambiarfondo(){

    var caja2 =  document.getElementById("caja2");
    alert("Voy a cambiar el fondo");
    document.getElementById("caja2").style.backgroundColor="turquoise";

    caja2.innerHTML="HOLA";
}

function cambiartexto() {

    document.getElementById("caja3").innerHTML="El ratón ha pasado por aquí";
  
}
function original(){
    document.getElementById("caja3").innerHTML="3";
}

function calcular(){

    var precio = document.getElementById("precio").value;
    var cantidad = document.getElementById("cantidad").value;

    document.getElementById("total").value=precio*cantidad;
}
function aviso1(cadena){
    alert("Has pulsado el botón número 1" + cadena);

}
function aviso2(){
    alert("Has pulsado el botón número 2");
}

function ocultar(){
    var elemento = document.getElementById("ejercicio6");
    if (elemento.style.display==="none")
        elemento.style.display="block";
    else
    elemento.style.display="none";

}

function comprobar(){

    var cadenaRegular = /^[0-9]+$/;
    var numero=document.getElementById("numero").value;

    if(numero.match(cadenaRegular))
        alert("Es un numero");
    else 
    alert("No es numero");

}

function visualizar(event){
    var texto = "x: "+event.clientX +" y: " +event.clientY+";";
    document.getElementById("caja7").innerHTML=texto;
}

function carga(){

    document.getElementById("caja2").addEventListener("click",cambiarfondo);
    document.getElementById("caja3").addEventListener("mouseover",cambiartexto);
    document.getElementById("caja3").addEventListener("mouseout",original);
    document.getElementById("enviar").addEventListener("click",calcular);
    document.getElementById("boton1").addEventListener("click",aviso1);
    document.getElementById("boton2").addEventListener("click",aviso2);
    document.getElementById("ejercicio6").addEventListener("mouseover",ocultar);
    document.getElementById("ejercicio6").addEventListener("mouseout",ocultar);
    document.getElementById("comprobar").addEventListener("click",comprobar);



}
window.addEventListener("DOMContentLoaded", carga);