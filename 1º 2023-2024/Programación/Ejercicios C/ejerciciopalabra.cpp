#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    char *palabra =NULL;

    printf("Palabra: ");
    scanf("%ms", &palabra);
    printf("[%p]: %s!!!\n", palabra,palabra);

    free(palabra);

    return EXIT_SUCCESS;
}
