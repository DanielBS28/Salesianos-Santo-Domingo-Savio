// Al cargar la ventana

function escribir() {
  var cantidad = document.getElementById("cantidad").value;
  var total = document.getElementById("total");
  total.value = parseInt(cantidad, 10) + 5;

  var resultado = "";
  for (var i = 0; i < cantidad.length; i++) {
    console.log(cantidad.charAt(i));
    resultado = resultado + cantidad.charAt(i);
  }
  document.getElementById("resultado").innerHTML = resultado;
}

function carga() {
  var boton = document.getElementById("enviar");
  boton.addEventListener("click", escribir);
}

window.addEventListener("DOMContentLoaded", carga);


