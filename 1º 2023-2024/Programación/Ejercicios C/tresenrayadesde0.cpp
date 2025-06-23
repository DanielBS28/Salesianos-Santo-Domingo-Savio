 #include <stdlib.h>
 #include <stdio.h>
 #include <strings.h>
 // #include "doctest.h"


enum Ejugador {j0, j1, JUGADORES}; // Limita los numeros enteros
enum Efichas {f0, f1, f2, FICHAS};
enum Edimens{filas, columnas, DIMENSIONES};
#define MAX_STR 8

enum Ejugador alternar (enum Ejugador turno){
    return (enum Ejugador) (((int) turno + 1) %2);
}

bool no_haya_ganado(enum Ejugador victoria){
    return victoria == JUGADORES;
}

void pedir_nombre(enum Ejugador jugador, char *pos_nombre){
    // Nombre jugador 1;
    // Guardar la entrada donde apunta pos_nombre.
    printf ("Nombre del jugador %i: ", (int)jugador +1);
    scanf (" %s", pos_nombre);
}
void gestor_partida(){
     // TITULO


     enum Ejugador turno, victoria;
     victoria =JUGADORES;
     turno = j0;

     int fichas [JUGADORES][FICHAS][DIMENSIONES];
    bzero(fichas,sizeof(fichas));
    

    char nombre[JUGADORES][MAX_STR];

    for (int j=j0; j<JUGADORES; j++)
        pedir_nombre((enum Ejugador) j, &nombre[j][0]);

        do {

           turno = alternar(turno);
        }while(no_haya_ganado (victoria));
}


void titulo(){
system ("clear");
system ("toilet -f pagga '3 en Raya'");
}
int main(int argc, char const *argv[])
{

enum Ejugador jugador;
titulo();
   
    return EXIT_SUCCESS;
}

 //    GESTOR PARTIDA
    //      Resetear Marcador
    //      Mover fichas a casa
            
    //      Nombres de los jugadores
    //              GAME LOOP
    //                      Alternar Jugador
    //                      ELEGIR FICHA
    //                          ¿Ficha en casa?
    //                              Seleccionar la primera ficha
    //                          Sino
    //                              Preguntar cual mover
    //                      PREGUNTAR DONDE MOVER
    //                      ¿Valido?


// Crear archivo .cpp y luego añadir al programa principal ese archivo con un include entre comillas.