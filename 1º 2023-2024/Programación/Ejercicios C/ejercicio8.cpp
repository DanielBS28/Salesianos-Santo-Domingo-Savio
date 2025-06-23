#include <stdio.h>
#include <stdlib.h>

#define N 5

int main(int argc, char const *argv[])
{
   
    for (int i= 0; i<N; i++){
        printf("\n");
    for (int j=0; j<N; j++)
        if(j==i)
    printf("0");
    else 
    printf(" ");
    }
   printf("\n");

   printf("EJERCICIO 2");

   for (int i= 0; i<N; i++){
        printf("\n");
    for (int j=0; j<=N; j++)
        if(j+i-N==0)
    printf("0");
    else 
    printf(" ");
    }
    return EXIT_SUCCESS;
}
