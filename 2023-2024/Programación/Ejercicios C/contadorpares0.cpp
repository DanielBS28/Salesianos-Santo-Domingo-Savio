#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int numero, contador =0;

    do
    {
        printf("Dime un numero, si el numero es 0 el programa parara\n");
        scanf("%i", &numero);
        if (numero % 2==0)
        contador++;

    } while (numero!=0);
    
    printf("El numero de pares que has introducido es: %i", contador);

    return EXIT_SUCCESS;
}
