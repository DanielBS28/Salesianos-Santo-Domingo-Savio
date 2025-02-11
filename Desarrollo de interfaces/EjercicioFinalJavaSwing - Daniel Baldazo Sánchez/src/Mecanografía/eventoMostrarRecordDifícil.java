package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class eventoMostrarRecordDifícil implements ActionListener {

	private Usuario user;

	public eventoMostrarRecordDifícil(Usuario user) {

		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Estadísticas estadística = DatosTXT.obtenerEstadística(user);
		JOptionPane.showMessageDialog(null, "El récord que tienes en la lección difícil: " + "\n\nTeclas acertadas: "
				+ estadística.getAciertosTeclasD() + "\nTeclas erróneas: " + estadística.getErroresTeclasD() + "\nPPM: "
				+ estadística.getPPMD() + " pulsaciones\n" + "Tiempo usado: "
				+ (estadística.getTiempoTotalD() - estadística.getSegundosRestantesD() + " segundos\nTiempo restante: "
						+ estadística.getSegundosRestantesD() + " segundos\n\nNota: " + estadística.getNotaDifícil()),
				"Récord en la lección difícil", JOptionPane.INFORMATION_MESSAGE);

	}
}