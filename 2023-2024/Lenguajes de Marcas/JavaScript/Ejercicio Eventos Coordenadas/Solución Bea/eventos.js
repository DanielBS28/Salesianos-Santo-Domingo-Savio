 function cambiarFondo1(){
	var caja2=document.getElementById("caja2");
	alert("voy a cambiar el fondo");
	caja2.style.backgroundColor='turquoise';
	caja2.innerHTML="HOLA";

}
function cambiarTexto(){

	document.getElementById("caja3").innerHTML="El ratón ha pasado por aquí"
}
function volverOriginal(){
	document.getElementById("caja3").innerHTML="A"
}
function calcular(){
	var precio=document.getElementById("precio").value;
	var cantidad=document.getElementById("cantidad").value;
	document.getElementById("total").value=precio*cantidad;
}
function aviso1(cadena){
	alert("has pulsado el botón número "+cadena);
}
function aviso2(){
	alert("has pulsado el botón número 2");
}
function ocultar(){
	var elemento=document.getElementById("ejercicio6");
	if(elemento.style.display==="none")
		elemento.style.display="block";
	else
		elemento.style.display="none";
}
function comprobar(){
	var cadenaRegular=/^[0-9]+$/;
	var numero=document.getElementById("numero").value;
	if(numero.match(cadenaRegular))
		alert("es un numero");
	else
		alert("no es un numero");
}
function visualizarCoordenadas(event){
	var texto="x: "+event.clientX+" y: "+event.clientY+";";
	document.getElementById("caja7").innerHTML=texto;
}
var colores=0;
function cambiarFondo(){
	if(colores===0){
		document.body.style.backgroundColor = "red";
		colores++;
	}else{
		if(colores===1){
			document.body.style.backgroundColor = "green";
			colores++;
		}
		else{
			document.body.style.backgroundColor = "blue";
			colores=0;
		}
	}

}
function carga(){
	//Esperamos evento
	document.getElementById("caja2").addEventListener('click',cambiarFondo1);
	document.getElementById("caja3").addEventListener('mouseover',cambiarTexto);
	document.getElementById("caja3").addEventListener('mouseout',volverOriginal)
	document.getElementById("enviar").addEventListener('click',calcular);
	//document.getElementById("boton1").addEventListener('click',aviso1);
	//document.getElementById("boton2").addEventListener('click',aviso2);
	document.getElementById("ejercicio6").addEventListener('mouseover',ocultar);
	document.getElementById("comprobar").addEventListener('click',comprobar);
	document.getElementById("colores").addEventListener('click',cambiarFondo);

}
window.addEventListener("DOMContentLoaded",carga)