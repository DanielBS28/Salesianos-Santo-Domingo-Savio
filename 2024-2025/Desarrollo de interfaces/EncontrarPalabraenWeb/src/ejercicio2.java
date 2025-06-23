import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ejercicio2 {

	public static void main(String[] args) throws IOException {

		URL direccion = new URL("https://www.ingles.com/traductor/perro");

		// String html = obtenerHTML(direccion);
		
		
		System.out.println(traducirJsoup("Perro"));
		
	}

	private static String traducirJsoup(String palabra) {
		
		String cadena = null;
		Document document = null;
		
		String webPage = "https://www.ingles.com/traductor/"+palabra;
		
		try {
			document= Jsoup.connect(webPage).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		cadena = document.getElementById("quickdef1-es").getElementsByClass("MhZ0VHvJ").html().toUpperCase();
		
		return cadena;
		
		
	}

}
