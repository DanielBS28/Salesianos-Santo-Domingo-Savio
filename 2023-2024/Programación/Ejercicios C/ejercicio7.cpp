#include <stdio.h>
#include <stdlib.h>

#define N 5

int main(int argc, char const *argv[])
{
    unsigned A [N][N];
   
    /* for (int i= 0; i<N; i++){
        printf("\n");
    for (int j=0; j<N; j++)
    printf("0");
    }
   printf("\n"); */

   for (int i=0; i<N; i++)
   for (int j=0; j<N; j++)
    A[i][j]=0;

     for (int i=0; i<N; i++){
   for (int j=0; j<N; j++)
    printf ("%u", A[i] [j]);
     printf("\n");
     }

    return EXIT_SUCCESS;
}
