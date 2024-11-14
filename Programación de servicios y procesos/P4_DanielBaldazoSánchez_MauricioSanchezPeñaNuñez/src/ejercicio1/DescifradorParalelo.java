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

	

	public DescifradorParalelo(String palabra, int longitud, String hash, AtomicBoolean encontrado,
			ExecutorService executor) {
		super();
		this.palabra = palabra;
		this.longitud = longitud;
		this.hash = hash;
		this.encontrado = encontrado;
		this.executor = executor;
	}

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
		//System.out.println(HashPalabraPasada);

		String hashInicial = "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79";

		return HashPalabraPasada.equals(hashInicial);
	}

	public static String ArrayDeBytesHexadecimal(byte[] bytes) {
		String palabra = "";

		for (byte b : bytes)

			palabra += String.format("%02x", b);

		return palabra;
	}

	public boolean recursiva(String prefijo, int longitud, String hashADescifrar) {
		
		if (encontrado.get()) 
            return false;

		if (prefijo.length() == longitud) {
			if (comprobarHash(getHash(prefijo))) {
				System.out.println(prefijo);
				encontrado.set(true);
				if(encontrado.get())
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

	@Override
	public void run() {

		recursiva(palabra, longitud, hash);
	}

}
