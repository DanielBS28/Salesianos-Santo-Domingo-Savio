function ejercicio1(){

    document.body.style.backgroundColor="hotpink";
    document.getElementById("ejercicio1").innerHTML="<h1>Daniel</h1>";


}

function ejercicio2(){

    var array=["coche","ventana","edificio"];
    var tabla="<table border ='1px'>"   

    for(var i =0; i<array.length; i++){
        // alert(array[i]+" "+array[i].length)
        tabla=tabla+"<tr><td>"+array[i]+"</td><td>"
        +array[i].length+"</td></tr>";
    }
    tabla=tabla+"</table>";
    document.getElementById("ejercicio2").innerHTML=tabla
}

function ejercicio3(){

    var cadena = /^[0-9]{8}[A-Z]$/
    var DNI = prompt("Escribe el DNI");
    
    DNI.match(cadena) ? document.getElementById("ejercicio3").innerHTML=DNI : document.getElementById("ejercicio3").innerHTML="Error";
}
var contador =0;
function ejercicio51(){

contador++;
document.getElementById("resultado2").value=contador;
}
function ejercicio52(){

    contador = 0;
    document.getElementById("resultado2").value=contador;
    }



function ejercicio4(){


var precio = document.getElementById("precio").value;
var descuento = document.getElementById("descuento").value;
var resultado =0;

descuento < 0 || descuento > 100 ? alert("Descuento no válido") : resultado = precio - (precio*descuento/100),document.getElementById("resultado").value=resultado


}
function carga(){

ejercicio1();
ejercicio2();
// ejercicio3();
document.getElementById("calcular").addEventListener("click",ejercicio4)
document.getElementById("iniciar").addEventListener("click", ejercicio51)
document.getElementById("reset").addEventListener("click", ejercicio52)

}


window.addEventListener("DOMContentLoaded", carga);
