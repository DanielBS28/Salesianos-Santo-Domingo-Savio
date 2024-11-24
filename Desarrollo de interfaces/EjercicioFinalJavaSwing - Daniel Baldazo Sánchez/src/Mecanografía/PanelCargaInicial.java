package Mecanografía;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class PanelCargaInicial extends JPanel {

	Timer Crono;
	int tiempoCarga = 0;
	final static String FondoPanel1 = "src/Mecanografía/FondoPanel1.jpg";

	public PanelCargaInicial() {

		setLayout(null);

		JProgressBar BarraDeCarga = new JProgressBar();
		BarraDeCarga.setBounds(97, 223, 239, 20);
		add(BarraDeCarga);
		BarraDeCarga.setValue(0);
		add(Imágenes.ponerFondo(FondoPanel1));

		Crono = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tiempoCarga++;
				BarraDeCarga.setValue(BarraDeCarga.getValue() + (100 / 6) + 1);

				if (tiempoCarga == 4) {
					if (!Archivos.escanearArchivos()) {
						JOptionPane.showInternalMessageDialog(null,
								"No se han encontrado los archivos para inicializar el programa, la aplicación se cerrará.",
								"Error: ", 0);
						System.exit(0);
					}

				}

				if (tiempoCarga == 6) {
					Crono.stop();
					setVisible(false);
					Main.mecanografía.dispose(); // Esto es para hacer cambios en el frame es obligatorio
					// cuando voy a cambiar propiedades el frame, luego al final lo vuelvo a poner
					// en visible.
					Main.mecanografía.setUndecorated(false);
					// Las dos líneas de abajo permiten redimensionar el frame.
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					Main.mecanografía.setSize(screenSize.width, screenSize.height);
					// Esta opción de abajo no me reescala el frame y me lo deja pequeño
					// Main.mecanografía.setExtendedState(JFrame.MAXIMIZED_BOTH);
					Main.mecanografía.setVisible(true);
					PanelLogin login = new PanelLogin();
				}
			}
		});
		Crono.start();

	}

}
