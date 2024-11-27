package Mecanografía;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelMecanografía extends JPanel {

	private FrameMecanografía frameMecanografía;
	private PanelLeccion panelLeccion;
	private char dificultad;

	public PanelMecanografía(FrameMecanografía frameMecanografía, char dificultad, PanelLeccion panelLeccion) {
		this.dificultad = dificultad;
		this.frameMecanografía = frameMecanografía;
		this.panelLeccion = panelLeccion;

		frameMecanografía.dispose(); // Esto es para hacer cambios en el frame es obligatorio
		// cuando voy a cambiar propiedades el frame, luego al final lo vuelvo a poner
		// en visible.
		frameMecanografía.setUndecorated(false);
		// Las dos líneas de abajo permiten redimensionar el frame.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameMecanografía.setSize(screenSize.width, screenSize.height);
		frameMecanografía.setLocationRelativeTo(null);
		frameMecanografía.setVisible(true);
		
		

	}

}
