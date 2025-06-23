package cenadelosfilosofos;
import java.util.concurrent.locks.*;

public class CenaDeLosFilosofos {

    // Definimos los 5 tenedores, cada uno con un lock
    static final int NUM_FILOSOFOS = 5;
    static Tenedor[] tenedores = new Tenedor[NUM_FILOSOFOS];
    
    public static void main(String[] args) {
        // Inicializamos los tenedores
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            tenedores[i] = new Tenedor();
        }

        // Creamos los filósofos
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % NUM_FILOSOFOS]);
            filosofos[i].start();
        }
    }

    // Clase Tenedor (utilizando ReentrantLock para sincronización)
    static class Tenedor {
        private final Lock lock = new ReentrantLock();
        
        public void tomar() {
            lock.lock();  // Bloquea el tenedor
        }

        public void soltar() {
            lock.unlock();  // Libera el tenedor
        }
    }

    // Clase Filosofo (representa a cada filósofo como un hilo)
    static class Filosofo extends Thread {
        private final int id;
        private final Tenedor tenedorIzquierdo;
        private final Tenedor tenedorDerecho;
        private enum Estado {PENSANDO, HAMBRIENTO, COMIENDO};
        private Estado estado;

        public Filosofo(int id, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
            this.id = id;
            this.tenedorIzquierdo = tenedorIzquierdo;
            this.tenedorDerecho = tenedorDerecho;
            this.estado = Estado.PENSANDO;
        }

        @Override
        public void run() {
            while (true) {
                pensar();
                hambriento();
                comer();
            }
        }

        private void pensar() {
            estado = Estado.PENSANDO;
            System.out.println("Filósofo " + id + " está pensando.");
            try {
                Thread.sleep((long) (Math.random() * 1000)); // Pensando aleatoriamente
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void hambriento() {
            estado = Estado.HAMBRIENTO;
            System.out.println("Filósofo " + id + " está hambriento y quiere comer.");
            
            // Intentar tomar ambos tenedores
            while (true) {
                // Primero toma el tenedor de la izquierda
                tenedorIzquierdo.tomar();
                if (tenedorDerecho.lock.tryLock()) {
                    // Si puede tomar ambos tenedores, comienza a comer
                    estado = Estado.COMIENDO;
                    System.out.println("Filósofo " + id + " ha tomado el tenedor izquierdo y derecho y está comiendo.");
                    break; 
                } else {
                    // Si no puede tomar el segundo tenedor, suelta el primero y espera
                    tenedorIzquierdo.soltar();
                }
            }
        }

        private void comer() {
            try {
                Thread.sleep((long) (Math.random() * 1000)); // Comiendo aleatoriamente
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            // Después de comer, el filósofo suelta los tenedores
            estado = Estado.PENSANDO;
            System.out.println("Filósofo " + id + " ha terminado de comer y ha soltado los tenedores.");
            tenedorIzquierdo.soltar();
            tenedorDerecho.soltar();
        }
    }
}
