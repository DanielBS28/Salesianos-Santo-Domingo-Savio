function ejercicio1(){

    document.body.style.backgroundColor="hotpink"
    document.getElementById("ejercicio1").innerHTML="<h1>Daniel</h1>";

}
function ejercicio4(){

    var precio = document.getElementById("numero").value;
    var des = document.getElementById("des").value;
    var res = document.getElementById("res").value;
    var total = precio*des;

    res.innerHTML=total;
    

}

function ejercicio5(){

    var contador = 1;
    var tiempo = 1;

    document.getElementById("tiempo").innerHTML=tiempo;

}

function ejercicio2(){
    var vehiculos = ["coche", "ventana", "edificio"];

    var coche = 0;
    var ventana = 0;
    var edificio = 0;

    for (var i = 0; i<vehiculos[i].length; i++){
        for (var j=0; j<vehiculos[j].length; j++) {
        if (vehiculos[i].charAt(j)== /^[a-z]+$/)
        coche++;
        ventana++;
        edificio++;
    }
    }
    document.getElementById("pc").innerHTML=coche;
    document.getElementById("pv").innerHTML=ventana;
    document.getElementById("pe").innerHTML=edificio;
}

function ejercicio3(){

    var dni = prompt("Dime tu DNI");
}
function carga(){

   ejercicio1();
   ejercicio2();
   ejercicio3();
   document.getElementById("Enviar").addEventListener("click",ejercicio4);
   document.getElementById("iniciar").addEventListener("click", ejercicio5);

}



window.addEventListener("DOMContentLoaded", carga);