package Mecanografía;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelAdmin extends JPanel {

	private FrameMecanografía frameMecanografía;
	private Usuario user;
	private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";

	public PanelAdmin(FrameMecanografía frameMecanografía, Usuario user) {
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
		btnCerrarSesion.setBounds(123, 469, 241, 27);
		add(btnCerrarSesion);
		
		JLabel Pregunta = new JLabel("¿Qué acción deseas realizar?");
		Pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		Pregunta.setForeground(Color.WHITE);
		Pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		Pregunta.setBounds(61, 161, 352, 65);
		add(Pregunta);
		
		JButton AltaUsuarios = new JButton("Agregar Usuarios");
		AltaUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelAgregarUsuarios panelAgregarUsuarios = new PanelAgregarUsuarios(frameMecanografía, user);
				frameMecanografía.getContentPane().add(panelAgregarUsuarios);
			}
		});
		AltaUsuarios.setBackground(new Color(0, 128, 0));
		AltaUsuarios.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		AltaUsuarios.setForeground(new Color(255, 255, 255));
		AltaUsuarios.setBounds(38, 259, 193, 56);
		add(AltaUsuarios);
		
		JButton BajaUsuarios = new JButton("Eliminar Usuarios");
		BajaUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelEliminarUsuarios panelEliminarUsuarios = new PanelEliminarUsuarios(frameMecanografía, user);
				frameMecanografía.getContentPane().add(panelEliminarUsuarios);
			}
		});
		BajaUsuarios.setBackground(new Color(255, 128, 64));
		BajaUsuarios.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		BajaUsuarios.setForeground(new Color(255, 255, 255));
		BajaUsuarios.setBounds(260, 259, 193, 56);
		add(BajaUsuarios);
		
		
		JButton btnProbarCorreoenvo = new JButton("Enviar correos");
		btnProbarCorreoenvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelCorreos panelCorreos = new PanelCorreos(frameMecanografía, user);
				frameMecanografía.getContentPane().add(panelCorreos);
			}
		});
		btnProbarCorreoenvo.setForeground(Color.WHITE);
		btnProbarCorreoenvo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		btnProbarCorreoenvo.setBackground(new Color(11, 181, 200));
		btnProbarCorreoenvo.setBounds(38, 352, 193, 56);
		add(btnProbarCorreoenvo);
		
		JButton btnModificarTextos = new JButton("Modificar textos");
		btnModificarTextos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelTextos panelTextos = new PanelTextos(frameMecanografía, user);
				frameMecanografía.getContentPane().add(panelTextos);
			}
		});
		btnModificarTextos.setForeground(Color.WHITE);
		btnModificarTextos.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
		btnModificarTextos.setBackground(new Color(235, 223, 5));
		btnModificarTextos.setBounds(260, 352, 193, 56);
		add(btnModificarTextos);
		
		add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));

	}
}
