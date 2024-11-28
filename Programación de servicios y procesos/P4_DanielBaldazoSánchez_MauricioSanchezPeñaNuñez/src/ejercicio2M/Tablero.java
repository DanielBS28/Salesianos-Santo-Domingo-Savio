package ejercicio2M;


import java.util.HashMap;


public class Tablero {

	private String[][] tableroPartida = new String[15][15];
	public static HashMap<Coordenadas, Tipo> tableroFijo = new HashMap<>();

	public Tablero() {

		inicializarTablero(new HashMap<>(), new HashMap<>());
	}

	public void inicializarTablero(HashMap<Coordenadas, Tipo> tableroFijo, HashMap<Coordenadas, Jugador> jugadores) {
	    for (int i = 0; i < tableroPartida.length; i++) {
	        for (int j = 0; j < tableroPartida[i].length; j++) {
	            Coordenadas coord = new Coordenadas(i, j);

	            if (tableroFijo.containsKey(coord)) {
	                Tipo tipo = tableroFijo.get(coord);
	                if (tipo == Tipo.MINA) {
	                    tableroPartida[i][j] = "M"; // Es una mina
	                } else if (tipo == Tipo.PEPITA) {
	                    tableroPartida[i][j] = "p"; // Es una pepita
	                }
	            } else if (jugadores.containsKey(coord)) {
	                tableroPartida[i][j] = "T"; // Jugador
	            } else {
	                tableroPartida[i][j] = "*"; // Celda vacía
	            }
	        }
	    }
	}


	public void imprimirTablero() {

		for (String[] fila : tableroPartida) {
			for (String columna : fila) {
				System.out.print(columna + " ");
			}
			System.out.println();
		}
	}

	public String[][] getTablero() {
		return tableroPartida;
	}

	public void setTablero(String[][] tablero) {
		this.tableroPartida = tablero;
	}

}
