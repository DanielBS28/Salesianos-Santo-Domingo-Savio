#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int nivel;
    int numero;

    printf("Dime el numero de altura de la piramide\n");
    scanf("%i",&nivel);

    for(int i = 1; i<=nivel; i++){
    for (int j=1; j<=nivel-i; j++)
    printf(" ");
    for (int j=1; j<=2*i-1; j++){
    numero = i%10;
     printf("%i", numero);
    }
    printf("\n");
    }

    return EXIT_SUCCESS;
}
