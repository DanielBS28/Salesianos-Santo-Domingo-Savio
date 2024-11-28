package Mecanografía;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Imágenes{
	
	public static Component ponerFondo(String ruta, FrameMecanografía frameMecanografía) {

		final Image imagenFondo = requestImage(ruta);

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

		miPanel.setSize(frameMecanografía.getWidth(), frameMecanografía.getHeight());

		return miPanel;
	}

	private static Image requestImage(String ruta) {

		BufferedImage imagenFondo = null;
		try {
			imagenFondo = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return imagenFondo;
	}

}
