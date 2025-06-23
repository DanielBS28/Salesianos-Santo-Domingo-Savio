#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{

const char *nombre = "Jorge";
char const *p = nombre;

printf("%s\n", nombre);

while (*p !='\0')
{
    printf("%c", *p);
    p++;
}
printf("\n");
    return EXIT_SUCCESS;
}
