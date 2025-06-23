#include <stdio.h>
#include <stdlib.h>

#define OP1 2
#define OP2 3

void usage(FILE *where, const char *error_mssg){
    fprintf(where, "ERROR: %s!!!!\n", error_mssg);
    if (where == stderr)
    exit (1);
}

int main (int argc, char*argv[]){

    int op1, op2;
    int resultado = 0;

if (argc < 2)
usage (stderr, "Se necesita un argumento.");
    printf("N. Argumentos = %i\n", argc);
    op1 =atoi(argv[1]);
    op2 =atoi(argv[2]);

    for (int i = 1; i<argc; i++)
    resultado += atoi(argv[i]);

    printf("%i\n", resultado);
    return EXIT_SUCCESS;

}