#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <sys/types.h>


unsigned long long int esPrimo(unsigned long long int num){

 if(num == 1) 
	 return 0;

for(unsigned long long int i =2; i<= num/2; i++){

 if(num % i ==0)
 	return 0;
 
 }

 return 1;

}

unsigned long long int sumaPrimos(int max){

unsigned long long int suma=0;

for(unsigned long long int i= 0; i < max; i++){
	
	if(esPrimo(i))
	suma += i;
}
return suma;
}

unsigned long long int sumaImpares(int max){
unsigned long long int suma = 0;

for(unsigned long long int i =0; i <= max; i++){
	if(i%2)
	suma += i;
}

return suma;
}


int main(){

const int CANTIDAD_MAXIMA_PRIMOS = 1000000; //1.000.000
const int CANTIDAD_MAXIMA_IMPARES = 5000000; //5.000.000

/*
unsigned long long int numeros = sumaPrimos(CANTIDAD_MAXIMA_PRIMOS);
printf("La suma es de los numeros primos hasta %i es: %llu\n",CANTIDAD_MAXIMA_PRIMOS, numeros);

*/
unsigned long long int suma = sumaImpares(CANTIDAD_MAXIMA_IMPARES);
printf("El suma de los números impares hasta %i es: %llu\n",CANTIDAD_MAXIMA_IMPARES,suma);

return EXIT_SUCCESS;

}




