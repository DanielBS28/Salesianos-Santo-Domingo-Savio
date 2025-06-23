
function espar(){

var numero = document.getElementById("numero").value;
var caja = document.getElementById("total");

numero % 2 == 0 ? caja.value="Es un número par" : caja.value="El número es impar";

}


function carga(){

document.getElementById("enviar").addEventListener("click",espar);

}


window.addEventListener("DOMContentLoaded", carga);