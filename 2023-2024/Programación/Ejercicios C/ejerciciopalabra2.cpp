#include <stdio.h>
#include  <stdlib.h>

#define MAX 0x100

int main(int argc, char const *argv[])
{
    char palabra [MAX];

    printf("Dime una palabra: ");
    scanf(" %[^\n]", palabra);
    printf("Tu palabra es: %s\n", palabra);
    
    return EXIT_SUCCESS;
}
