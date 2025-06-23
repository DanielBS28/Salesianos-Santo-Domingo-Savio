#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int numero;
    int resultado = 1;

    printf("Dime un numero y realizaremos su sumatorio\n");
    scanf("%i",&numero);

    for (int i=1; i<=numero; i++)
    resultado = resultado * i;

    printf("El resultado es: %i", resultado);

    return EXIT_SUCCESS;
}
