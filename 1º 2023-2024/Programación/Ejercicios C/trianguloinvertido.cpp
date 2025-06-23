#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int nivel;

    printf("Dime el numero de altura de la piramide\n");
    scanf("%i",&nivel);

    for(int i = 1; i<=nivel; i++){
    for (int j=0; j<(i-1); j++)
    printf(" ");
    for (int j=0; j<=(nivel-i)*2; j++)
    printf("*");

    printf("\n");
    }

    return EXIT_SUCCESS;
}
