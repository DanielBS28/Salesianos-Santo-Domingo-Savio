#include <stdlib.h>
#include <stdio.h>
int main(int argc, char const *argv[])
{
const char *nombre = "Jorge";
char const *p = nombre;
char const *r = nombre;

printf("%s\n", nombre);

while (*p !='\0')
{
    printf("%c", *p);
    p++;
}
printf("\n");
// Avanzar el puntero hasta el final
// Ir hacia atrás una posición
// Imprimir una letra 
// Mientras no llegue al principio
while (*r !='\0') r++;
do{
r--;
printf("%c", *r);
}while(r != nombre); // Mientras no llegue al principio
printf("\n");
    return EXIT_SUCCESS;
}