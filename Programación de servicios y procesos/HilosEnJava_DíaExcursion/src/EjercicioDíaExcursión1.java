
import java.io.IOException;

public class EjercicioDíaExcursión1 {

    public static void main(String[] args) {
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        String comando = "";
        if (sistemaOperativo.contains("win")) {
          
            comando = "notepad";
        } else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux")) {
    
            comando = "gedit";
        } else {
            System.out.println("Sistema operativo no soportado.");
            return;
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.start();
            System.out.println("Proceso iniciado: " + comando);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar abrir el programa.");
            e.printStackTrace();
        }
    }
}