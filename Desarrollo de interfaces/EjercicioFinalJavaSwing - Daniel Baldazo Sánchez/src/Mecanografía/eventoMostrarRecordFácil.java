package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class eventoMostrarRecordFácil implements ActionListener {

	private Usuario user;

	public eventoMostrarRecordFácil(Usuario user) {

		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Estadísticas estadística = DatosTXT.obtenerEstadística(user);
		JOptionPane.showMessageDialog(null, "El récord que tienes en la lección fácil: " + "\n\nTeclas acertadas: "
				+ estadística.getAciertosTeclasF() + "\nTeclas erróneas: " + estadística.getErroresTeclasF() + "\nPPM: "
				+ estadística.getPPMF() + " pulsaciones\n" + "Tiempo usado: "
				+ (estadística.getTiempoTotalF() - estadística.getSegundosRestantesF() + " segundos\nTiempo restante: "
						+ estadística.getSegundosRestantesF() + " segundos\n\nNota: " + estadística.getNotaFácil()),
				"Récord en la lección fácil", JOptionPane.INFORMATION_MESSAGE);

	}

}
