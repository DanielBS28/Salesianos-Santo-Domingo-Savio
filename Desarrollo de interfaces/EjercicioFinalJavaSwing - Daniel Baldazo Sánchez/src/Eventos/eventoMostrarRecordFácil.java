package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Utilidades.*;
import ClasesArchivos.*;
import javax.swing.JOptionPane;

public class eventoMostrarRecordFácil implements ActionListener {

	/*
	 * Esta clase es un evento que permite mostrar las estadísticas del récord de un usuario en el panel de lección
	 * cuando se pulsa en el botón de mostrar récord lección fácil.
	 */
	private Usuario user;

	public eventoMostrarRecordFácil(Usuario user) {

		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Obtengo las estadísticas del usuario y las muestro en un mensaje expontanéo
		Estadísticas estadística = DatosTXT.obtenerEstadística(user);
		JOptionPane.showMessageDialog(null, "El récord que tienes en la lección fácil: " + "\n\nTeclas acertadas: "
				+ estadística.getAciertosTeclasF() + "\nTeclas erróneas: " + estadística.getErroresTeclasF() + "\nPPM: "
				+ estadística.getPPMF() + " pulsaciones\n" + "Tiempo usado: "
				+ (estadística.getTiempoTotalF() - estadística.getSegundosRestantesF() + " segundos\nTiempo restante: "
						+ estadística.getSegundosRestantesF() + " segundos\n\nNota: " + estadística.getNotaFácil()),
				"Récord en la lección fácil", JOptionPane.INFORMATION_MESSAGE);

	}

}
