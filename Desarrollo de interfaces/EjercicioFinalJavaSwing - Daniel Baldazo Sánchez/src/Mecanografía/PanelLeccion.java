package Mecanografía;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLeccion extends JPanel{
	
	final static char FÁCIL = '1';
	final static char DIFÍCIL = '2';
	
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
		
	
		JLabel Nombre = new JLabel(user.getNombre().toUpperCase());
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setForeground(new Color(255, 153, 102));
		Nombre.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 33));
		Nombre.setBounds(103, 111, 269, 39);
		add(Nombre);
		
		JButton BotónFácil = new JButton("Lección fácil");
		BotónFácil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelMecanografía panel = new PanelMecanografía(frameMecanografía,FÁCIL,PanelLeccion.this);
				frameMecanografía.getContentPane().add(panel);	
				}
		});
		BotónFácil.setBackground(new Color(255, 153, 102));
		BotónFácil.setForeground(new Color(255, 255, 255));
		BotónFácil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		BotónFácil.setBounds(131, 294, 219, 52);
		add(BotónFácil);
		
		JLabel Pregunta = new JLabel("¿Qué lección deseas practicar?");
		Pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		Pregunta.setForeground(Color.WHITE);
		Pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		Pregunta.setBounds(61, 196, 352, 65);
		add(Pregunta);
		
		JButton BotónDifícil = new JButton("Lección difícil");
		BotónDifícil.setForeground(Color.WHITE);
		BotónDifícil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		BotónDifícil.setBackground(new Color(255, 153, 102));
		BotónDifícil.setBounds(131, 389, 219, 52);
		add(BotónDifícil);
		
		add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));



	}
}
