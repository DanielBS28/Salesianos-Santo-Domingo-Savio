package Mecanografía;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelLeccion extends JPanel{
	
	private FrameMecanografía frameMecanografía;
	private Usuario user;
	private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";


	public PanelLeccion(FrameMecanografía frameMecanografía, Usuario user) {
		
		this.frameMecanografía = frameMecanografía;
		this.user = user;
		
		setLayout(null);
		setBounds(0, 0, 500, 700);
		
		JLabel Bienvenida = new JLabel("¡Bienvenido!");
		Bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		Bienvenida.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 33));
		Bienvenida.setForeground(new Color(255, 255, 255));
		Bienvenida.setBounds(103, 51, 269, 39);
		add(Bienvenida);
		
	
		JLabel Nombre = new JLabel(user.getNombre());
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setForeground(Color.WHITE);
		Nombre.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 33));
		Nombre.setBounds(103, 111, 269, 39);
		add(Nombre);
		
		add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));


	}
}
