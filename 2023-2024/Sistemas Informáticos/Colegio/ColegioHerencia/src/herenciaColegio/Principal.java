package herenciaColegio;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
  
	static ArrayList<Persona> personas=new ArrayList<Persona>();
	static int opcion;
	static Scanner leerTeclado= new Scanner (System.in);	

	public static void main(String[] args) {	  
	
		boolean salir=false;		
		menuInicial();
		
		do {
			
			
			switch  (opcion) {
				case 1:
					gestEstudiante(leerTeclado);
					menuInicial();
				break;
					
				case 2:
					gestPAS(leerTeclado);
					menuInicial();	
				break;
					
				case 3:
					gestProfes(leerTeclado);
					menuInicial();
					
				break;
				
				case 4:
					
					mostrarUsuarios();
					menuInicial();
					
				break;	
					
				case 5:
					salir();
					salir=true;
		    	break;							
			default:
				System.out.println( "Opción no reconocida");
				break;
			}
		
		}while(!salir);		
		
		leerTeclado.close();
	}
	
	
	private static void menuInicial() {
		
		System.out.println( "\n#####COLEGIO####");
		System.out.println( "#####MENÚ 1####");
		System.out.println( "OPCIONES: 1.ESTUDIANTE 2.PAS 3.PROFES. 4. MOSTRAR USUARIOS 5.SALIR");
		opcion=leerTeclado.nextInt();				
	}

	private static void gestEstudiante(Scanner leerTeclado) {
		
		boolean volver=false;
		
		do {
			System.out.println( "OPCIONES: 1.ALTAS 2.EDITAR 3.BAJAS. 4. VOLVER");			
			int opcionE=leerTeclado.nextInt();
			
			switch (opcionE) {
				case 1:
					
					crearAlta(leerTeclado);
					
					break;
					
				case 2:
				
					editarEst(leerTeclado);
				
				break;
	
				case 3:
					
					bajaEst(leerTeclado);
					
				break;
				
				
				case 4:
					
					volver=true;
					
				break;	
			}
			
		} while (!volver);
		System.out.println( "Volviendo al menú\n");	
	}
		
	private static void mostrarUsuarios() {

		for( Persona per:personas) {
			System.out.println( per);
		}
		
	}


	private static void gestPAS(Scanner leerTeclado) {
		// TODO Auto-generated method stub
		
	}
	
	private static void gestProfes(Scanner leerTeclado) {
		// TODO Auto-generated method stub
		
	}
	
	private static void salir() {
		System.out.println( "GRACIAS");
		
		
	}
		
	private static void crearAlta(Scanner leerTeclado) {
		
		
		System.out.println( "1 Nuevo Estudiante. 2. Volver");
		int opcionEnuevo=leerTeclado.nextInt();
		boolean atras=false;
		do {
			leerTeclado.nextLine();
			switch (opcionEnuevo) {
			case 1:
				
				datosNuevoEstudiante(leerTeclado);												
				System.out.println( "1 Nuevo Estudiante. 2. Volver");
				opcionEnuevo=leerTeclado.nextInt();
				
				break;
				
			case 2:
				atras=true;				
				break;
			}
			
		}	while (!atras) ;
					
	}
	
	private static void datosNuevoEstudiante(Scanner leerTeclado) {
		String nombre, direccion, nia, curso;
		double nota;
		System.out.println( "Introduce nombre");				
		nombre=leerTeclado.nextLine();
		
									
		System.out.println( "Introduce dirección");				
		direccion=leerTeclado.nextLine();
		
		
		System.out.println( "Introduce NIA");				
		nia=leerTeclado.nextLine();
	
						
		System.out.println( "Introduce curso");				
		curso=leerTeclado.nextLine();
		
						
		System.out.println( "Introduce nota media (separa con coma)");								
		nota=leerTeclado.nextDouble();
		
		personas.add(new Estudiante(nombre, direccion, nia, curso, nota));
		
		System.out.println( "\nAlta guardada");		
	}


	private static void bajaEst(Scanner leerTeclado) {
		// TODO Auto-generated method stub
		
	}

	private static void editarEst(Scanner leerTeclado) {
		// TODO Auto-generated method stub
		
	}


}
