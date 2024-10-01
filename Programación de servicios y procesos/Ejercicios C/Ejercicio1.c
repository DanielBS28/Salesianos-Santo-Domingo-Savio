#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(){

pid_t pid,pid2, Hijo_pid;

pid = fork(); // Crea un subproceso

pid2 = fork(); // Crea un subproceso

if(pid == 0){
printf("Soy el hijo: \n\tMi PID es %d\n \n\tPPID: %d\n", getpid(), getppid());
// El proceso hijo
}else{

printf("Soy el padre: \n\tMi PID es %d\n\t \n\tPPID: %d\n", getpid(), getppid());
printf("\tVariable PID: %d\n",pid);

// proceso padre
}

printf("Hola\n");
printf("Hola\n");

return 0;


}
