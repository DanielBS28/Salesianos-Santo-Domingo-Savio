package Mecanografía;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class EscribirTXT {
	
	public static void EscribirUsuarios(ArrayList <Usuario> USUARIOS) {
		
		
		Path fichero = Paths.get(Archivos.Usuarios);

		try {
			Files.writeString(fichero, "");
			for (int i = 0; i < USUARIOS.size(); i++) {

				Files.writeString(fichero, USUARIOS.get(i).getAlias()+",", StandardOpenOption.APPEND);
				Files.writeString(fichero, USUARIOS.get(i).getNombre()+",", StandardOpenOption.APPEND);
				Files.writeString(fichero, USUARIOS.get(i).getContrasena()+",", StandardOpenOption.APPEND);
				Files.writeString(fichero, USUARIOS.get(i).getCorreo()+"\n", StandardOpenOption.APPEND);				
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

