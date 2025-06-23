import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EjercicioDíaExcursión2 {

    public static void main(String[] args) {
        List<Process> procesos = new ArrayList<>();
        int numeroProcesos = 10;

        for (int i = 1; i <= numeroProcesos; i++) {
            try {
                ProcessBuilder pb = crearProceso(i);
                Process proceso = pb.start(); 
                procesos.add(proceso);
            } catch (IOException e) {
                System.out.println("Error al iniciar el proceso " + i);
                e.printStackTrace();
            }
        }

        for (Process proceso : procesos) {
            try {
                proceso.waitFor(); 
            } catch (InterruptedException e) {
                System.out.println("Error al esperar por el proceso.");
                e.printStackTrace();
            }
        }

        System.out.println("Todos los procesos han finalizado.");
    }

    private static ProcessBuilder crearProceso(int id) {
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();
        String comando = "";
        Random rand = new Random();
        int tiempoEspera = rand.nextInt(5) + 1; 

        if (sistemaOperativo.contains("win")) {
            comando = "cmd /c echo Proceso " + id + " iniciado && timeout /t " + tiempoEspera + " && echo Proceso " + id + " finalizado";
        } else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux")) {
            comando = "bash -c 'echo Proceso " + id + " iniciado && sleep " + tiempoEspera + " && echo Proceso " + id + " finalizado'";
        }

        return new ProcessBuilder(comando.split(" ")).inheritIO();
    }
}
