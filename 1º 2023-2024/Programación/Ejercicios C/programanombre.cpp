#include <stdio.h>
#include <stdlib.h>
#include <strings.h>

#define MAX 0x100



int main(int argc, char const *argv[])
{

    char nombre[MAX];
    bzero(nombre, sizeof (nombre));


    printf("Dime tu nombre: \n");
    scanf(" %[^\n]", nombre);
    printf("Tu nombre: %s\n", nombre);

    return EXIT_SUCCESS;
}
