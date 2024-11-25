package Mecanografía;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class FrameMecanografía extends JFrame{
	
	public FrameMecanografía() {
		setUndecorated(true); // Esto es para quitar los botones de arriba.
		setResizable(false); // Esto es para que no se pueda redimensionar.
		setBounds(100, 100, 450, 300); // Posición x, y | Ancho y alto del frame.
		setLocationRelativeTo(null); // Para posicionar el frame en medio.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Para cerrar la aplicación con la X
		getContentPane().setLayout(null);
		setTitle("Aplicación de mecanografía de Daniel"); //Agrego el titulo a mi aplicación
		PanelCargaInicial cargaInicial = new PanelCargaInicial(this);
		getContentPane().add(cargaInicial);
	}
}
