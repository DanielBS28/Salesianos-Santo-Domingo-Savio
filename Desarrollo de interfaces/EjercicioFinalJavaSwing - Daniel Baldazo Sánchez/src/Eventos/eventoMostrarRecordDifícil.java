package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Utilidades.*;
import ClasesArchivos.*;
import javax.swing.JOptionPane;

public class eventoMostrarRecordDifícil implements ActionListener {

	/*
	 * Esta clase es un evento que permite mostrar las estadísticas del récord de un usuario en el panel de lección
	 * cuando se pulsa en el botón de mostrar récord lección difícil.
	 */
	private Usuario user;

	public eventoMostrarRecordDifícil(Usuario user) {

		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Obtengo las estadísticas del usuario y las muestro en un mensaje expontanéo
		Estadísticas estadística = DatosTXT.obtenerEstadística(user);
		JOptionPane.showMessageDialog(null, "El récord que tienes en la lección difícil: " + "\n\nTeclas acertadas: "
				+ estadística.getAciertosTeclasD() + "\nTeclas erróneas: " + estadística.getErroresTeclasD() + "\nPPM: "
				+ estadística.getPPMD() + " pulsaciones\n" + "Tiempo usado: "
				+ (estadística.getTiempoTotalD() - estadística.getSegundosRestantesD() + " segundos\nTiempo restante: "
						+ estadística.getSegundosRestantesD() + " segundos\n\nNota: " + estadística.getNotaDifícil()),
				"Récord en la lección difícil", JOptionPane.INFORMATION_MESSAGE);

	}
}