#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(){
	pid_t pidh1, pidh2, pidn1, pidn2;
	
	// Creamos el Hijo 1
	pidh1 = fork();
	
	
	if(pidh1 == 0){ 
	printf("Soy el hijo 1, mi PID es: %d y mi PPID es: %d\n",getpid(), getppid());
	exit(1);
	
	} 
	
	// Creamos el Hijo 2
	pidh2 = fork();
	if (pidh2==0){
	
	printf("Soy el hijo 2, mi PID es: %d y mi PPID es: %d\n",getpid(), getppid());
	
		// Creamos el Nieto 1
		pidn1 = fork();

		if(pidn1 == 0){
		printf("Soy el nieto 1, mi PID es: %d y mi PPID es: %d\n",getpid(), getppid());
		exit(2); // Nieto 1 ha terminado
		}
		// Creamos el Nieto 2
		pidn2 = fork();
		
		if(pidn2 == 0){ 
		printf("Soy el nieto 2, mi PID es: %d y mi PPID es: %d\n",getpid(), getppid());
		exit(2); // Nieto 2 ha terminado
		}
	
	wait(NULL);
	wait(NULL);
	
	exit(1);
	}
	
	wait(NULL);
	wait(NULL);
	printf("Soy el proceso padre, mi PID es: %d y mi PPID es: %d\n",getpid(), getppid());
	
	
	return EXIT_SUCCESS;
	
	
	}

