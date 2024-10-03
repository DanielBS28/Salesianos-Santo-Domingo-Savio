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
	printf("\nHola, soy el proceso padre con PID: %d, y PPID: %d. He creado un proceso con PID: %d",getpid(), getppid(),pid);
	

	}
	
	return EXIT_SUCCESS;

	

}

