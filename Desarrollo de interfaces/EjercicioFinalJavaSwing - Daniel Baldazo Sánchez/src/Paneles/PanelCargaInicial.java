package Paneles;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import Mecanografía_MAIN_y_FRAME.*;
import Utilidades.Archivos;
import Utilidades.Imágenes;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class PanelCargaInicial extends JPanel {

	//En este panel se van a comprobar los 3 archivos si están o no, tiene una barra de carga de 3 segundos.
	Timer Crono;
	int tiempoCarga = 0;
	final static String FondoPanelInicio = "src/Mecanografía/ImágenesAPP/FondoPanel1.jpg";

	public PanelCargaInicial(FrameMecanografía frameMecanografía) {

		setLayout(null);
		setBounds(0, 0, 450, 300);
		JProgressBar BarraDeCarga = new JProgressBar();
		BarraDeCarga.setBounds(97, 219, 239, 20);
		add(BarraDeCarga);
		BarraDeCarga.setValue(0);
		
		JLabel LabelArchivos = new JLabel("Comprobando archivos...");
		LabelArchivos.setForeground(new Color(255, 255, 255));
		LabelArchivos.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		LabelArchivos.setBounds(126, 263, 253, 14);
		add(LabelArchivos);
		
		add(Imágenes.ponerFondo(FondoPanelInicio,frameMecanografía));
		
		Crono = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tiempoCarga++;
				BarraDeCarga.setValue(BarraDeCarga.getValue() + (100 / 6) + 1);
				// A los 4 segundos verifica si los archivos están o no, si no están la aplicación se cierra
				// Si están el crono sigue avanzando hasta que llega a 6 segundos.
				if (tiempoCarga == 4) {
					if (!Archivos.escanearArchivos()) {
						JOptionPane.showInternalMessageDialog(null,
								"No se han encontrado los archivos para inicializar el programa, la aplicación se cerrará.",
								"Error: ", 0);
						System.exit(0);
					}else
						LabelArchivos.setText("Cargando el panel Login...");

				}
				// A los 6 segundos se cambia el panel al panel de Login
				if (tiempoCarga == 6) {
					Crono.stop();
					setVisible(false);
					PanelLogin login = new PanelLogin(frameMecanografía);
					frameMecanografía.getContentPane().add(login);
				}
			}
		});
		Crono.start();

	}
}


