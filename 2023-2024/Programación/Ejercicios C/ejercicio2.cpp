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

    int op1, op2, resultado;

if (argc < 3)
usage (stderr, "Se necesita dos argumentos.");
    printf("N. Argumentos = %i\n", argc);
    op1 =atoi(argv[1]);
    op2 =atoi(argv[2]);
    resultado = atoi(argv[1]) + atoi(argv[2]);
    printf("%s\n", argv[1]);
    printf("%i + %i = %i\n", op1, op2, resultado);
    return EXIT_SUCCESS;

}