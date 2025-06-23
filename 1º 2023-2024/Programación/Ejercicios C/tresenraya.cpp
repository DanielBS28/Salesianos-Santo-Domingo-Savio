 #include <stdlib.h>
 #include <stdio.h>
#define MAX 100
void titulo (const char){
    printf("##     ######   #######   #####            #######  ##   ##           ######     ##     ##  ##     ##\n"            
           "##      ##  ##   ##   #  ##   ##            ##   #  ###  ##            ##  ##   ####    #    #    ####\n"
           "#####   ##  ##   ## #    #                  ## #    #### ##            ##  ##  ##  ##     ##     ##  ##\n "
           "##      #####    ####     #####             ####    ## ####            #####   ##  ##     ##    ##  ##\n"
           "##      ## ##    ## #         ##            ## #    ##  ###            ## ##   ######     ##     ######\n"
           "## ##   ##  ##   ##   #  ##   ##            ##   #  ##   ##            ##  ##  ##  ##     ##     ##  ##\n"
           "###   #### ##  #######   #####            #######  ##   ##            #### ##  ##  ##    ####    ##  ##\n");
}
void dibujar_tablero(char tablero[3][3]) {
    printf("\n");
    printf(" %c | %c | %c \n", tablero[0][0], tablero[0][1], tablero[0][2]);
    printf("---|---|---\n");
    printf(" %c | %c | %c \n", tablero[1][0], tablero[1][1], tablero[1][2]);
    printf("---|---|---\n");
    printf(" %c | %c | %c \n", tablero[2][0], tablero[2][1], tablero[2][2]);
    printf("\n");
}
int main(int argc, char const *argv[])
{
    char titulo1;
    char nombre1 [MAX];
    char nombre2 [MAX];
    titulo(titulo1);
    
    printf("Dime el nombre del jugador 1\n");
    scanf("%s", nombre1);
    fflush( stdin );
    printf("Dime el nombre del jugador 2\n");
    scanf("%s", nombre2);
    fflush( stdin );
     char tablero[3][3] = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    dibujar_tablero(tablero);
    return EXIT_SUCCESS;
}
