#include <stdio.h>
#include <stdlib.h>

#define MAX 0x100
#define PREGUNTA(ntipo, sform, var)                    \
    printf("Mete un %s: ", ntipo);                      \
    scanf(sform, &var);                                  \
    printf("El %s contiene: %i\n", ntipo, (int) var);


// Cargar cosas en memoria 

int main(int argc, char const *argv[])
{
    
    double real;    
    int entero;
    unsigned sinsigno;
    unsigned long int ess;
    char byte[MAX];
    char un_byte;
    int aent [MAX];

    // Caracter

    PREGUNTA("carácter", "%c", un_byte)


    // Leer un caracter
    /*
    printf("Mete un %s: ", "caracter");
    scanf("%c", &un_byte);
    printf("El %s contiene: %i\n", "caracter", (int) un_byte);*/

    // Leer un número
    
    printf("Mete un %s: ", "entero");
    scanf("%i", &entero);
    printf("El %s contiene: %i\n", "caracter", entero);

    printf("Mete un %c: ", "sinsigno");
    scanf("%u", &sinsigno);
    printf("El %s contiene: %i\n", "caracter", entero);

    scanf("%s", &byte)

    return EXIT_SUCCESS;
}

