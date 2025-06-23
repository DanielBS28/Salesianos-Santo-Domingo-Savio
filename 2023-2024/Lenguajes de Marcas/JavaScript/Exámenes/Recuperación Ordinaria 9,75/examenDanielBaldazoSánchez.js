
function ejercicio1(){

    var comprobar = /^[0-9]{9}$/;
    var telefono = prompt("Dime un número de teléfono");
    resultadotelefono = document.getElementById("resultadotelefono");
    var contador =0;


    for (var i=0; i<telefono.length ; i++){

        if (telefono.charAt(i) == 3){
            contador++;
        }
    }

    telefono.match(comprobar) ? resultadotelefono.innerHTML = "El numero de 3 en el teléfono que pusiste es " + contador : alert("El teléfono está mal");


}

var contadorfondo =0;

function cambiarfondo(){

        contadorfondo++;
    if(contadorfondo==1){
        document.body.style.backgroundColor = "green";
    }else if(contadorfondo==2){
        document.body.style.backgroundColor = "red";
    }else if(contadorfondo==3){
        document.body.style.backgroundColor = "blue";
    }else if(contadorfondo==4){
        document.body.style.backgroundColor = "yellow";
    }else{
        document.body.style.backgroundColor = "green";
    contadorfondo =1;
    }
   
    
}

function ejercicio3(){

    var palabras = prompt("Dime un número de palabras que quieres poner en la tabla");

    array =[];

    for (var i =0;i<palabras;i++){
       array[i] = prompt("Dime la palabra " + parseInt(i+1));
    }

    tabla = "<table border 1px>"
    for (var j=0; j<array.length; j++){
        tabla = tabla + "<tr><td>"+array[j]+"</td></tr>";
    }

    tabla = tabla + "</table>"

    document.getElementById("tabla").innerHTML = tabla;

}

function ejercicio4(){
    var nombre = document.getElementById("nombre").value;
    var edad = document.getElementById("edad").value;
    var dni = document.getElementById("dni").value;
  
        
    if (!comprobarnombre(nombre))
        alert("Nombre mal puesto")

    if(!comprobardni(dni))
        alert("DNI mal puesto")

    if(!comprobaresultado(edad))
    alert("Edad mal puesta")

   
    if (comprobardni(dni)&& comprobaresultado(edad) && comprobarnombre(nombre)){
    var res = edad % 2 * nombre.length;
    resultado = document.getElementById("resultadoform").value = res;
    }
}

function comprobarnombre(check){

    var nombre = /^[a-zA-Z]+$/

    if (check.match(nombre)){
        return true;
    }else 
    return false;

}

function comprobardni(check){

    var nombre = /^[0-9]{8}[a-zA-Z]$/

    if (check.match(nombre)){
        return true;
    }else 
    return false;


}

function comprobaresultado(edad){

    if (edad >0 && edad <60){
        return true;
    }else
    return false;

}


function carga(){


    document.getElementById("ComprobarTelefono").addEventListener("click", ejercicio1);
    document.getElementById("fondo").addEventListener("click", cambiarfondo);
    ejercicio3();
    document.getElementById("formulario").addEventListener("click", ejercicio4);
    


}



window.addEventListener("DOMContentLoaded",carga);