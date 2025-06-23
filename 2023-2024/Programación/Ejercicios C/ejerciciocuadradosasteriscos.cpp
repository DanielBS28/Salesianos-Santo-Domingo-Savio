#include <stdlib.h>
#include <stdio.h>


#define L 3

int main(int argc, char *argv[]) {

    for (int filaCuad=0; filaCuad < L; filaCuad++)
        for (int fila=0; fila < L; fila++ ){
            for (int colCuad=0; colCuad < L; colCuad ++)
                for(int col=0; col < L; col++)
                    if ( (filaCuad + colCuad) % 2 )
                        printf("*");
                    else
                        printf("-");
            printf("\n");
        }

    return EXIT_SUCCESS;
}


