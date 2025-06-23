#include <stdlib.h>
#include <stdio.h>

#define L 5

int main(int argc, char const *argv[]){

printf("\n");
    for (int i=0; i<L; i++){
        for (int col=0; col<=i; col++)
        printf("*");
        printf("\n");        
    }
    return EXIT_SUCCESS;
}
