package Paneles;

import java.awt.*;

import javax.swing.JPanel;

import Mecanografía_MAIN_y_FRAME.*;
import ClasesArchivos.*;
import Utilidades.Imágenes;

public class PanelMecanografía extends JPanel {
	
	//Este panel hace de puente entre el login y el panelteclado, su función es cambiar las propiedades
	// del frame ya que pasamos de un tamaño pequeño a pantalla completa.

	final static String FondoPanelMecanografía = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";

	private FrameMecanografía frameMecanografía;
	private PanelLeccion panelLeccion;
	private char dificultad;
	private Usuario user;

	public PanelMecanografía(FrameMecanografía frameMecanografía, char dificultad, PanelLeccion panelLeccion, Usuario user) {
		this.dificultad = dificultad;
		this.frameMecanografía = frameMecanografía;
		this.panelLeccion = panelLeccion;
		this.user = user;

		// Destruir el frame anterior para poder modificarlo
		frameMecanografía.dispose();

		// Eliminar la decoración de la ventana y hacerla redimensionable
		frameMecanografía.setUndecorated(false);

		// Configurar el tamaño de la ventana
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameMecanografía.setSize(screenSize.width, screenSize.height);
		frameMecanografía.setLocationRelativeTo(null);
		frameMecanografía.setVisible(true);
		
		//Creamos el panel teclado pasándole el frame, la dificultad y el usuario que inició sesión.
		frameMecanografía.getContentPane().add(new PanelTeclado(frameMecanografía, dificultad, user));

		setLayout(null);

		frameMecanografía.getContentPane().add(Imágenes.ponerFondo(FondoPanelMecanografía, frameMecanografía));

	}
}
