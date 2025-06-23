#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    int pid;
    // Crear un proceso hijo
    pid = fork();
    
    
    if (pid == 0) {
        // Este bloque se ejecuta en el proceso hijo
        printf("\tSoy el proceso hijo, mi PID es %d\n", getpid());
        printf("Estoy bien, gracias por preguntar.\n");
    } else {
        // Este bloque se ejecuta en el proceso padre
        printf("Hola, ¿qué tal? Todo bien, gracias.\n");
        printf("Soy el proceso padre, mi PID es %d\n", getpid());
    }

    return 0;
}