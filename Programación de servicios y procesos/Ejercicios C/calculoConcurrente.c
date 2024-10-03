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

unsigned long long int productoImpares(int max){
unsigned long long int producto = 1;

for(unsigned long long int i =1; i <= max; i++){
	if(i%2)
	producto *= i;
}

return producto;
}


int main(){

const int CANTIDAD_MAXIMA_PRIMOS = 1000000; //1.000.000
const int CANTIDAD_MAXIMA_IMPARES = 500000; //500.000
unsigned long long int numeros = sumaPrimos(CANTIDAD_MAXIMA_PRIMOS);


pid_t pidh1, pidh2;
int status;

pidh1 =fork();


if(pidh1 == 0){

unsigned long long int numeros = sumaPrimos(CANTIDAD_MAXIMA_PRIMOS);
printf("La suma es de los numeros primos hasta %i es: %llu\n",CANTIDAD_MAXIMA_PRIMOS, numeros);
return(1);
}

pidh2 = fork();

if(pidh2 == 0){

unsigned long long int producto = productoImpares(CANTIDAD_MAXIMA_IMPARES);
printf("El producto de los números impares hasta %i es: %llu\n",CANTIDAD_MAXIMA_IMPARES, producto);
return(2);

}
// Proceso padre
	
	for(int i = 0; i<2; i++){
		wait(&status);
		if (WIFEXITED(status)) 
           	 printf("Ha terminado el proceso del hijo: %d.\n", WEXITSTATUS(status));
	
	}
return EXIT_SUCCESS;

}




