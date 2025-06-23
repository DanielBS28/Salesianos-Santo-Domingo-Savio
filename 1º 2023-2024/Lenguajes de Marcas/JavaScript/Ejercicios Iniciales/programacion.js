function ejercicio1(){
	var numero1=3;
	var numero2=5;
	var resultado=numero1+numero2;
	document.write("El resultado es: "+resultado);
}
function ejercicio2(){
	var nombre=prompt("¿Cuál es tu nombre?","Escribe el nombre");
	document.write("El nombre es: "+nombre+"<br>");
}
function ejercicio3(){
	var numero1=prompt("Escribe un número");
	var numero2=prompt("Escribe un segundo número");
	var resultado=parseInt(numero1)+parseInt(numero2);
	document.write("El resultado es:"+resultado)
}
function ejercicio4(){
	var numero1=prompt("Escribe un número");
	var numero2=prompt("Escribe un segundo número");

	if(parseInt(numero1)>parseInt(numero2))
		document.write("El numero mayor es: "+numero1+"<br>");
	else if(parseInt(numero1)<parseInt(numero2))
			document.write("El numero mayor es: "+numero2+"<br>");
		else
			document.write("Son iguales");

	// == compara el contenido
    // === Mismo contenido y mismo tipo de datos
}
function ejercicio5(){
	var mayor=0;

	var numero =[];
	for(var i=0;i<3;i++){
		numero[i]=parseInt(prompt("Escribe un número"+i+""));
	}
	
	mayor=numero[0];
	for(i=1;i<3;i++){
		if(mayor<numero[i])
			mayor=numero[i];
	}
	
	document.write("El mayor del array "+numero+" es: "+mayor);
}
function ejercicio6(){
	 var numero=parseInt(prompt("Escribe un número"));
	 if(numero%2==0)
	 	document.write("Divisible entre dos");
	else
		document.write("NO Divisible entre dos");
}
function ejercicio7(){
	var frase=prompt("Escribe una frase");
	var vocalA=0;
	for(var i=0;i<frase.length;i++){
		if(frase.charAt(i)==='a'||frase.charAt(i)==='A'){
			vocalA++;
		}
	}
	document.write("El numero de veces que aparece la A: "+vocalA)

}
function ejercicio8(){
	var vocalA=0;
	var vocalE=0;
	var vocalI=0;
	var vocalO=0;
	var vocalU=0;
	var consonante=0;
	var frase=prompt("Escribe una frase");
	var fraseMayusculas=frase.toUpperCase(); //toLowerCase()

	for(var i=0;i<fraseMayusculas.length;i++){
		if(fraseMayusculas.charAt(i)==='A')
			vocalA++;
		else if(fraseMayusculas.charAt(i)==='E')
				vocalE++;
			 else if(fraseMayusculas.charAt(i)==='I')
						vocalI++;
				else if(fraseMayusculas.charAt(i)==='O')
						vocalO++;
					else if(fraseMayusculas.charAt(i)==='U')
						vocalU++;	
						 else
						 	consonante++;	
	}
	document.writeln("<h1>Resultado</h1>");
	document.writeln("<table border='1px'>");
	document.writeln("<tr>");
	document.writeln("<td> vocales de A</td>");
	document.writeln("<td>"+vocalA+"</td>");
	document.writeln("</tr>");
	document.writeln("<tr>");
	document.writeln("<td> vocales de E</td>");
	document.writeln("<td>"+vocalE+"</td>");
	document.writeln("</tr>");
	document.writeln("<tr>");
	document.writeln("<td> vocales de I</td>");
	document.writeln("<td>"+vocalI+"</td>");
	document.writeln("</tr>");
	document.writeln("<tr>");
	document.writeln("<td> vocales de O</td>");
	document.writeln("<td>"+vocalO+"</td>");
	document.writeln("</tr>");
	document.writeln("<tr>");
	document.writeln("<td> vocales de U</td>");
	document.writeln("<td>"+vocalU+"</td>");
	document.writeln("</tr>");
	document.writeln("</table>");
}
function ejercicio9(){
	var frase=prompt("Escribe una frase");
	var vocal=0;
	for(var i=0;i<frase.length;i++){
		if(frase.charAt(i)==='a'||frase.charAt(i)==='A'||frase.charAt(i)==='e'||frase.charAt(i)==='E'||frase.charAt(i)==='i'||frase.charAt(i)==='I'||frase.charAt(i)==='o'||frase.charAt(i)==='O'||frase.charAt(i)==='u'||frase.charAt(i)==='U'){
			vocal++;
		}
	}
	document.write("El numero de veces que aparece las vocales: "+vocal)

}
function ejercicio13(){
	var numero=parseInt(prompt("Escribe un numero"));
	var divisores=false;

	for(var i=2;i<numero;i++){
		if(numero % i===0){
			document.write(i+",");
			divisores=true;
		}
	}
	if(!divisores)
		document.write("No tiene divisores");
}
function carga(){
	/*ejercicio1();
	ejercicio2();
	ejercicio3();
	ejercicio4();
	ejercicio5();*/
	//ejercicio6()
	ejercicio13()

}
window.addEventListener("DOMContentLoaded",carga);