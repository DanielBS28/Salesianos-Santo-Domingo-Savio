#include <stdlib.h>
#include <stdio.h>

#define L 3

int main(int argc, char const *argv[]){
    for (int i=0; i<L; i++){
       
        for (int j=L; j<=L; j++){
         printf("---");
         printf("***");
         printf("---");
        }
         printf("\n"); 
    }
    for (int i=0; i<L; i++){
       
        for (int j=L; j<=L; j++){
         printf("***");
         printf("---");
         printf("***");
        }
         printf("\n"); 
    }
   for (int i=0; i<L; i++){

        for (int j=L; j<=L; j++){
         printf("---");
         printf("***");
         printf("---");
        }
         printf("\n"); 
    }
   
    return EXIT_SUCCESS;
}

