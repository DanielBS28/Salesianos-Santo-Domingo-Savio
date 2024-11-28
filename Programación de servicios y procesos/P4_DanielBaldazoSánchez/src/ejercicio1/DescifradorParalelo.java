package ejercicio1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class DescifradorParalelo implements Runnable {

    private String palabra;
    private int longitud;
    private String hash;
    AtomicBoolean encontrado;
    ExecutorService executor;

    /**
     * Constructor DescifradorParalelo.
     *
     * @param palabra  Palabra inicial desde donde comenzará el descifrado.
     * @param longitud  Longitud máxima de la palabra generada.
     * @param hash   Hash a descifrar que se quiere descifrar.
     * @param encontrado  Referencia a un AtomicBoolean que indica si el hash ya ha sido descifrado.
     * @param executor  ExecutorService para gestionar los hilos de ejecución.
     */
    public DescifradorParalelo(String palabra, int longitud, String hash, AtomicBoolean encontrado,
                               ExecutorService executor) {
        super();
        this.palabra = palabra;
        this.longitud = longitud;
        this.hash = hash;
        this.encontrado = encontrado;
        this.executor = executor;
    }

    /**
     * Obtiene el hash SHA-256 de un texto dado.
     *
     * @param text Texto del cual se calculará el hash.
     * @return Array de bytes que representa el hash calculado.
     */
    public static byte[] getHash(String text) {
        byte[] encodedhash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            encodedhash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodedhash;
    }

    /**
     * Comprueba si un hash dado coincide con el hash a descifrar.
     *
     * @param hashPasado Hash que será comparado.
     * @return true si el hash pasado coincide con el hash a descifrar, false en caso contrario.
     */
    public static boolean comprobarHash(byte[] hashPasado) {
        String HashPalabraPasada = ArrayDeBytesHexadecimal(hashPasado);
        String hashInicial = "f9744197f797d034670a6c096410f6f5a4aba30e733430ba91becfd211816b7e";
        return HashPalabraPasada.equals(hashInicial);
    }

    /**
     * Convierte un array de bytes a una String de números hexadecimales.
     *
     * @param bytes array de bytes a convertir.
     * @return String en formato hexadecimal.
     */
    public static String ArrayDeBytesHexadecimal(byte[] bytes) {
        String palabra = "";
        for (byte b : bytes)
            palabra += String.format("%02x", b);
        return palabra;
    }

    /**
     * Función recursiva que genera combinaciones de palabras y verifica si alguna
     * coincide con el hash objetivo.
     *
     * @param prefijo Prefijo inicial para generar combinaciones.
     * @param longitud Es la longitud de la palabra a descrifrar.
     * @param hashADescifrar Hash que se desea descifrar.
     * @return true si se encuentra una coincidencia, false en caso contrario.
     */
    public boolean recursiva(String prefijo, int longitud, String hashADescifrar) {
        if (encontrado.get())
            return false;

        if (prefijo.length() == longitud) {
            if (comprobarHash(getHash(prefijo))) {
                System.out.println(prefijo);
                encontrado.set(true);
                if (encontrado.get())
                    executor.shutdownNow();
                return true;
            }
            return false;
        } else {
            for (char letra = 'a'; letra <= 'z'; letra++) {
                if (encontrado.get())
                    return false;
                String nuevaPalabra = prefijo + letra;
                if (recursiva(nuevaPalabra, longitud, hashADescifrar))
                    return true;
            }
        }
        return false;
    }
    
    /**
     * Función que ejecuta el descifrado de manera recursiva.
     * Le pertenece a los hilos.
     */
 
    @Override
    public void run() {
        recursiva(palabra, longitud, hash);
    }
}