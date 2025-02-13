package Utilidades;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Mecanografía_MAIN_y_FRAME.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Imágenes{
	
	//Esta clase se utiliza en todos los paneles, es para poner el fondo de pantalla azul


	//Le tengo que pasar la ruta de la imagen y el frame
	public static Component ponerFondo(String ruta, FrameMecanografía frameMecanografía) {

		//Obtengo un objeto Image con la ruta que le he pasado
		final Image imagenFondo = requestImage(ruta);
		
		//Creo un JPanel con la imagen que le he pasado, la altura y anchura será la del frame que 
		// le hemos pasado
		JPanel miPanel = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				int W = frameMecanografía.getWidth();
				int H = frameMecanografía.getHeight();

				g.drawImage(imagenFondo, 0, 0, W, H, null);
			}

		};
		
		//El panel será de la misma altura y anchura que el frame
		miPanel.setSize(frameMecanografía.getWidth(), frameMecanografía.getHeight());

		return miPanel;
	}

	private static Image requestImage(String ruta) {

		//Devuelvo la fotografía con la ruta que le he pasado
		BufferedImage imagenFondo = null;
		try {
			imagenFondo = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return imagenFondo;
	}

}
