package TraductorSeparado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class EventoTraducir implements ActionListener{
	
	JTextField palabraIN , palabraOUT;
	
	public EventoTraducir(JTextField textFieldIN, JTextField textFieldOUT) {
		
		this.palabraIN = textFieldIN;
		this.palabraOUT = textFieldOUT;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (palabraIN.getText().isBlank() != true) {
			String palabraESP = palabraIN.getText();
			palabraOUT.setText(traducirING(palabraESP));// Escribir el resultado en la caja de texto "gris"
		} else {
			JOptionPane.showInternalMessageDialog(null, "No hay palabra a traducir", "Error: ", 0);
		}
		
	}

	private String traducirING(String palabraESP) {
		
		String cadena = null;
		Document document = null;

		String webPage = "https://www.ingles.com/traductor/" + palabraESP;

		try {
			document = Jsoup.connect(webPage).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		cadena = document.getElementById("quickdef1-es").getElementsByClass("tCur1iYH").html();

		return cadena;
		
	}

}
