#include <stdio.h>
#include <stdlib.h>
#include <stdio_ext.h>

#define MAX 10

bool esta_repetido(int num, int lista [MAX], int hasta){
    int repetido = false;
    for (int j=0; j<hasta; j++)
    if (lista[j]==num)
    repetido= true;

    return repetido;
}

int main(int argc, char const *argv[])
{
    int lista [MAX];

    for (int i=0; i<MAX;){
        // Recojo un número solo si no está en la lista, en ese caso lo incluyo.
        int num;
    printf("Dime un número en la posición del array: %02i\n",i+1);
    __fpurge(stdin);
    scanf("%i", &num);


    if (!esta_repetido(num, lista, i)){
        lista[i] = num;
        i++;
    } 
    }
    
    for (int i=0; i<MAX; i++){
    printf("El número en la posición %02i es: %i\n",i+1,lista[i]);
    }
    return EXIT_SUCCESS;
    
}
                                                             