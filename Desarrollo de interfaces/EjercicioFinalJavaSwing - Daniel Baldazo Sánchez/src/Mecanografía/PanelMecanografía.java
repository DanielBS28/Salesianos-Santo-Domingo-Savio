package Mecanografía;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelMecanografía extends JPanel{
	
	private FrameMecanografía frameMecanografía;
	private PanelLeccion panelLeccion;
	private char dificultad;

	public PanelMecanografía(FrameMecanografía frameMecanografía, char dificultad, PanelLeccion panelLeccion) {
		this.dificultad = dificultad;
		this.frameMecanografía = frameMecanografía;
		this.panelLeccion = panelLeccion;
		
		
		  Main.mecanografía.dispose(); // Esto es para hacer cambios en el frame es obligatorio
			// cuando voy a cambiar propiedades el frame, luego al final lo vuelvo a poner
							// en visible.
							Main.mecanografía.setUndecorated(false);
							// Las dos líneas de abajo permiten redimensionar el frame.
							Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
							Main.mecanografía.setSize(screenSize.width, screenSize.height);
							// Esta opción de abajo no me reescala el frame y me lo deja pequeño
							// Main.mecanografía.setExtendedState(JFrame.MAXIMIZED_BOTH);
							Main.mecanografía.setVisible(true);*/
		
	}


}
