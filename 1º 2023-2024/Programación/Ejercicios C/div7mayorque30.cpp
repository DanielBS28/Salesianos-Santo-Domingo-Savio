#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int numero;

    do{
    printf("Dime un numero, acabaremos cuando sea divisible entre 7 y mayor que 30\n");
    scanf("%i",&numero);
    }while(numero % 7 !=0 || numero<30);

     printf("Fin\n");

    return EXIT_SUCCESS;
}
