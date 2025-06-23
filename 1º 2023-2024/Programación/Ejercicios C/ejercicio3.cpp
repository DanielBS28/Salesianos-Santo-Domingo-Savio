#include <stdlib.h>
#include <stdio.h>

#define L 5

int main(int argc, char const *argv[]){

printf("\n");
    for (int fila=0; fila<L; fila++){
        for (int col=0; col< L- fila; col++)
        printf("*");
        printf("\n");        
    }
    return EXIT_SUCCESS;

 }
