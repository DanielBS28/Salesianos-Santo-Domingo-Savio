#include <stdlib.h>
#include <stdio.h>

int sumar (int op1, int op2){
    int resultado = op1 + op2;
    printf("El resultado de la suma es: %i\n", resultado);
    return resultado;
}
int restar (int op1, int op2){
    int resultado = op1 - op2;
    printf("El resultado de la resta es: %i\n", resultado);
    return resultado;
}
int dividir (int op1, int op2){
    int resultado = op1 / op2;
    printf("El resultado de la división es: %i\n", resultado);
    return resultado;
}
int multiplicar (int op1, int op2){
    int resultado = op1 * op2;
    printf("El resultado de multiplicación es: %i\n", resultado);
    return resultado;
}

int main(int argc, char const *argv[])
{
    int op1, op2, eleccion;
    printf("Este ejercicio es una calculadora que permite sumar, restar, dividir y multiplicar\n");
    do{
    printf("Dime que operacion quieres hacer\n");
    printf("1. Sumar\n");
    printf("2. Restar\n");
    printf("3. Dividir\n");
    printf("4. Multiplicar\n");
    scanf("%i",&eleccion);
    if (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4)
    printf("El número introducido no está en la lista de operaciones, repite el proceso\n");
    }while(eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4 );

    printf("Dime el operando 1\n");
    scanf("%i",&op1);
    printf("Dime el operando 2\n");
    scanf("%i",&op2);

    if (eleccion == 1)
    sumar(op1, op2);
    
    else if (eleccion==2)
    restar(op1, op2);

    else if (eleccion==3)
    dividir(op1, op2);

    else if (eleccion==4)
    multiplicar(op1, op2);

    return EXIT_SUCCESS;
}
