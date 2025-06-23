import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.concurrent.RecursiveAction;

public class EjercicioHackeo {

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

	public static boolean comprobarHash(byte[] hashPasado) {

		String HashPalabraPasada = ArrayDeBytesHexadecimal(hashPasado);
		System.out.println(HashPalabraPasada);

		String hashInicial = "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79";

		return HashPalabraPasada.equals(hashInicial);
	}

	public static String ArrayDeBytesHexadecimal(byte[] bytes) {
		String palabra = "";

		for (byte b : bytes)

			palabra += String.format("%02x", b);

		return palabra;
	}

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

	public static void main(String[] args) {
		//System.out.println(generarPalabras());
		recursiva("", 4, "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79");
	}

}
