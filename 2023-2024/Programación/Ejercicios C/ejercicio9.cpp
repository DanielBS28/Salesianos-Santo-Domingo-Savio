#include <stdio.h>
#include <stdlib.h>

#define N 5

int main(int argc, char const *argv[])
{
   unsigned A [N][N];

 for (int i=0; i<N; i++){
   for (int j=0; j<N; j++){
    
    A[i][j]= 0;

    if (i==0 && j==0)
    A[i][j]= 1;
    A[i][0]= 1;

    if (i>0&& j>0)
    A[i][j] = A[i-1][j] + A[i-1][j-1];
    printf("%u", A[i][j]);
   }
   printf("\n");
    }
   return EXIT_SUCCESS;
}

/*
memset(A,0, sizeof(A));
bzero(A, sizeof (A));


for (int i=0; i<N; i++){
   for (int j=0; j<N; j++){
    
    if (j==0)
     A[i][j]= 1;

     else 
     A[i][j] = A[i-1][j] + A[i-1][j-1];
     
     A[i][j] = (j==0) ? 1 : A[i-1][j] + A[i-1][j-1];
     
     */


