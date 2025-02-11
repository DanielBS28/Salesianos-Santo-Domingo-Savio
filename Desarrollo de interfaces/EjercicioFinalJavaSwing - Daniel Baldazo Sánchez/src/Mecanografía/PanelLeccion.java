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
	
	final public static char FÁCIL = '1';
	final public static char DIFÍCIL = '2';
	
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
		Bienvenida.setBounds(103, 30, 269, 39);
		add(Bienvenida);
		
		JLabel Nombre = new JLabel(user.getNombre().toUpperCase());
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setForeground(new Color(255, 153, 102));
		Nombre.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 33));
		Nombre.setBounds(103, 79, 269, 39);
		add(Nombre);
		
		JButton BotónFácil = new JButton("Lección fácil");
		BotónFácil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelMecanografía panel = new PanelMecanografía(frameMecanografía,FÁCIL,PanelLeccion.this, user);
				frameMecanografía.getContentPane().add(panel);	
				}
		});
		BotónFácil.setBackground(new Color(255, 153, 102));
		BotónFácil.setForeground(new Color(255, 255, 255));
		BotónFácil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		BotónFácil.setBounds(131, 211, 219, 52);
		add(BotónFácil);
		
		JLabel Pregunta = new JLabel("¿Qué lección deseas practicar?");
		Pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		Pregunta.setForeground(Color.WHITE);
		Pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		Pregunta.setBounds(61, 127, 352, 65);
		add(Pregunta);
		
		JButton RecordFácil = new JButton("Mostrar record lección fácil");
		RecordFácil.addActionListener(new eventoMostrarRecordFácil(user));
		RecordFácil.setBackground(new Color(255, 255, 255));
		RecordFácil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		RecordFácil.setBounds(131, 273, 219, 21);
		add(RecordFácil);
		
		JButton BotónDifícil = new JButton("Lección difícil");
		BotónDifícil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelMecanografía panel = new PanelMecanografía(frameMecanografía,DIFÍCIL,PanelLeccion.this, user);
				frameMecanografía.getContentPane().add(panel);	
			}
		});
		BotónDifícil.setForeground(Color.WHITE);
		BotónDifícil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		BotónDifícil.setBackground(new Color(255, 153, 102));
		BotónDifícil.setBounds(131, 332, 219, 52);
		add(BotónDifícil);
		
		JButton RecordDifícil = new JButton("Mostrar record lección difícil");
		RecordDifícil.addActionListener(new eventoMostrarRecordDifícil(user));
		RecordDifícil.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		RecordDifícil.setBackground(Color.WHITE);
		RecordDifícil.setBounds(131, 394, 219, 21);
		add(RecordDifícil);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelLogin panelLogin = new PanelLogin(frameMecanografía);
				frameMecanografía.getContentPane().add(panelLogin);
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		btnCerrarSesion.setBackground(new Color(187, 37, 30));
		btnCerrarSesion.setBounds(120, 459, 241, 27);
		add(btnCerrarSesion);
		
		add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));
		
	
		
		
		

	}
}
