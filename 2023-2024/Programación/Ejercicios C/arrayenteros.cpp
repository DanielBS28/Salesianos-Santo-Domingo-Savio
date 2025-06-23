#include <stdio.h>
#include <stdlib.h>

#define MAX 10

int main(int argc, char const *argv[])
{
    int numeros [MAX];

    for (int i=0; i<MAX; i++){
    printf("Dime un número en la posición del array: %02i\n",i+1);
    scanf("%i", &numeros[i]);
    }
    for (int i=0; i<MAX; i++){
    printf("El número en la posición %02i es: %i\n",i+1,numeros[i]);
    }
    return EXIT_SUCCESS;
}                                                              