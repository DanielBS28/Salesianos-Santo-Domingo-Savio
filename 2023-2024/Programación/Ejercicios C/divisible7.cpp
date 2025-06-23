#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int numero;

    do{
    printf("Dime un numero, acabaremos cuando sea divisible entre 7\n");
    scanf("%i",&numero);
    }while(numero % 7 !=0);

     printf("Fin\n");

    return EXIT_SUCCESS;
}
