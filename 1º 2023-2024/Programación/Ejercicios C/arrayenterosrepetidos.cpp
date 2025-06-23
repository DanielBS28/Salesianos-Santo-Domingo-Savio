#include <stdio.h>
#include <stdlib.h>

#define MAX 10

int main(int argc, char const *argv[])
{
    int numeros [MAX];

    for (int i=0; i<MAX;){
        // Recojo un número solo si no está en la lista, en ese caso lo incluyo.
        int num;
    printf("Dime un número en la posición del array: %02i\n",i+1);
    scanf("%i", &num);

    int repetido = 0;
    for (int j=0; j<i; j++)
    if (numeros[j]==num)
    repetido=1;

    if (!repetido){
        numeros[i] = num;
        i++;
    } 
    }
    
    for (int i=0; i<MAX; i++){
    printf("El número en la posición %02i es: %i\n",i+1,numeros[i]);
    }
    return EXIT_SUCCESS;
    
}
                                                             