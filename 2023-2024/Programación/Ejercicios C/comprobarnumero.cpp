#include <stdio.h>

int main(int argc, char const *argv[])
{
    int num1 = -5;
 if (num1 < 0) {
        num1 = -num1;
    }

    printf("%i",num1);

    return 0;
}
