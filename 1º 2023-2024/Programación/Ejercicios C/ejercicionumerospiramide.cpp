#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int altura;

    printf("Dime un numero una piramide de numeros\n");
    scanf("%i",&altura);

    for (int i=1; i<=altura; i++){
        for (int j=1; j<=altura - i; j++) // Estos son los espacios
        printf(" ");
        for (int triuno=1; triuno<i; triuno++) // Este es el primer triangulo
        printf("%i",triuno);
        for (int principal=1; principal<=1; principal++) // Esta es la columna principal
        printf("%i",i);
        for (int tritres=i-1; tritres>=1; tritres--) // Este es el tercer triangulo
        printf("%i",tritres);
        printf("\n");

    }

    return EXIT_SUCCESS;
}
