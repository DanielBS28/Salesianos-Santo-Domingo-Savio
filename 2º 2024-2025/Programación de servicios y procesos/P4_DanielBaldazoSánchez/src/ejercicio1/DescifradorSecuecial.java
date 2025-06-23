package ejercicio1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DescifradorSecuecial {
	
	/**
     * Obtiene el hash SHA-256 de un texto dado.
     *
     * @param text Texto del cual se calculará el hash.
     * @return Array de bytes que representa el hash calculado.
     */

public static byte[] getHash(String text) {
		
		byte[] encodedhash = null;
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			//
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
		System.out.println(HashPalabraPasada);

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
     * Generamos combinaciones de caracteres recursivamente para verificar si alguna coincide con un hash dado.
     *
     * @param prefijo Prefijo inicial utilizado para generar combinaciones.
     * @param longitud Longitud máxima de las combinaciones (palabra a obtener).
     * @param hashADescifrar Hash que queremos descifrar.
     * @return true si se encuentra una coincidencia, false en caso contrario.
     */

	public static boolean recursiva(String prefijo, int longitud, String hashADescifrar) {

		if (prefijo.length() == longitud) {
			if (comprobarHash(getHash(prefijo))) {
				System.out.println(prefijo);
				return true;
			}
			return false;
		} else {
			for (char letra = 'a'; letra <= 'z'; letra++) {
				String nuevaPalabra = prefijo + letra;
				if (recursiva(nuevaPalabra, longitud, hashADescifrar))
					return true;
			}
		}
		return false;
	}
	
    /**
     * Generador de palabras de longitud 4 utilizando combinaciones de letras minúsculas de la a hasta la z,
     * y comprueba si alguna de ellas coincide con el hash a descifrar.
     *
     * @return La palabra que coincide con el hash a descifrar en caso de que se encuentre
     *  o una String vacía si no se encuentra.
     */


	public static String generarPalabras() {

		String palabra = "";
		boolean palabraEncontrada = false;

		for (char letra1 = 'a'; letra1 <= 'z' && !palabraEncontrada; letra1++) {
			for (char letra2 = 'a'; letra2 <= 'z' && !palabraEncontrada; letra2++)
				for (char letra3 = 'a'; letra3 <= 'z' && !palabraEncontrada; letra3++)
					for (char letra4 = 'a'; letra4 <= 'z' && !palabraEncontrada; letra4++) {

						palabra = "" + letra1 + letra2 + letra3 + letra4;
						palabraEncontrada = comprobarHash(getHash(palabra));
					}
		}
		return palabra;
	}
	

}
