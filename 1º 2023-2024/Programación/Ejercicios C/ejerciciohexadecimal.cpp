#include <stdlib.h>
#include <stdio.h>
#include <strings.h>

#define MAX 0x100

int main(int argc, char const *argv[])
{
    char nombre[MAX];
    bzero(nombre, sizeof (nombre));
    printf("Dime un número hexadecimal: \n");
    scanf("%3[0-9a-fA-F]", nombre);
    printf("El número es: %s\n", nombre);
    printf("%2i\n", 73);
    printf("%3i\n", 73);
    printf("%4i\n", 73);
    printf("%5i\n", 73);
    printf("%03i\n", 73);
    printf("%04i\n", 73);



    return EXIT_SUCCESS;
}
