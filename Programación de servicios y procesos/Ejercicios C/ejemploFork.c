#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(){

	pid_t pid;
	pid = fork(); // Creo un susproceso
	int status;
		
	if(pid == 0){
	printf("Hola, soy el proceso hijo con PID: %d, y PPID:%d",getpid(), getppid());
	}
	else {
	
	wait(&status);
	printf("\nHola, soy el proceso padre con PID: %d, y PPID: %d.\nHe creado un proceso con PID: %d",getpid(), getppid(),pid);
	
	/* Coinciden el PPID del hijo con el PID del padre, ya que el PPID es el ID de proceso 
	por tanto el PPID del hijo debe de coindicir con el PID del proceso padre*/

	}
	
	return EXIT_SUCCESS;

	

}

