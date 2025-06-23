#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
char a;
char *b = &a;

printf("Dime un caracter\n");
scanf("%c", &a);

printf("%p\n", &a);
printf("%p\n", b);
printf("%c\n",*b);

    return 0;
}   