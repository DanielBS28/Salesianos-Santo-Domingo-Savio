#include <stdlib.h>
#include <stdio.h>

#define L 3

int main(int argc, char const *argv[]){
    for (int filacuad=0; filacuad<L; filacuad++) 

        for (int fila=0; fila<L; fila++){

        for (int colcuad=0; colcuad<L; colcuad++)
        for (int col=0; col<L; col++)

        if ((filacuad + colcuad)%2)
        printf("*");
        else
        printf("-");
        printf("\n");
    }

    return EXIT_SUCCESS;
}

