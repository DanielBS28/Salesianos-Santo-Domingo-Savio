#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int numero, numeroanterior;

    do
    {
        printf("Dime un numero, luego te pedire otro si son iguales el programa parara\n");
        scanf("%i", &numeroanterior);
        printf("Dime el otro numero\n");
        scanf("%i", &numero);

        if (numero==numeroanterior)
        printf("Son iguales");
        else
        printf("Son diferentes, repite el proceso\n");

    } while (numeroanterior!=numero);
    

    return EXIT_SUCCESS;
}
