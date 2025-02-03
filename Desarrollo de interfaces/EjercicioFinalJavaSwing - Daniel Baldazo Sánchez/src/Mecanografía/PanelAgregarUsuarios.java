package Mecanografía;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PanelAgregarUsuarios extends JPanel {

	private FrameMecanografía frameMecanografía;
	private Usuario user;
	private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";

	static ArrayList<Usuario> USUARIOS = DatosTXT.getUSUARIOS();
	private JTextField CampoID;
	private JTextField CampoNombre;
	private JTextField CampoCorreo;
	private JTextField CampoContraseña;

	public PanelAgregarUsuarios(FrameMecanografía frameMecanografía, Usuario user) {
		this.frameMecanografía = frameMecanografía;
		this.user = user;

		setLayout(null);
		setBounds(0, 0, 500, 700);
		JButton volverAtrás = new JButton("Volver atrás");
		volverAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelAdmin panelAdmin = new PanelAdmin(frameMecanografía, user);
				frameMecanografía.getContentPane().add(panelAdmin);
			}
		});
		volverAtrás.setBackground(new Color(255, 153, 102));
		volverAtrás.setForeground(new Color(255, 255, 255));
		volverAtrás.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		volverAtrás.setBounds(123, 469, 241, 27);
		add(volverAtrás);

		JLabel pregunta = new JLabel("Introduce los datos del usuario");
		pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		pregunta.setForeground(new Color(255, 255, 255));
		pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		pregunta.setBounds(38, 60, 401, 65);
		add(pregunta);

		JLabel ID = new JLabel("ID");
		ID.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 17));
		ID.setForeground(new Color(255, 153, 102));
		ID.setBounds(67, 183, 96, 27);
		add(ID);

		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 17));
		Nombre.setForeground(new Color(255, 153, 102));
		Nombre.setBounds(226, 177, 139, 38);
		add(Nombre);

		JLabel correo = new JLabel("Correo");
		correo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 17));
		correo.setForeground(new Color(255, 153, 102));
		correo.setBounds(67, 245, 114, 27);
		add(correo);

		JLabel Contraseña = new JLabel("Contraseña");
		Contraseña.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 17));
		Contraseña.setForeground(new Color(255, 153, 102));
		Contraseña.setBounds(67, 304, 126, 27);
		add(Contraseña);
		
		CampoID = new JTextField();
		CampoID.setBounds(108, 186, 96, 19);
		add(CampoID);
		CampoID.setColumns(10);
		
		CampoNombre = new JTextField();
		CampoNombre.setBounds(311, 187, 96, 19);
		add(CampoNombre);
		CampoNombre.setColumns(10);
		
		CampoCorreo = new JTextField();
		CampoCorreo.setBounds(144, 249, 265, 19);
		add(CampoCorreo);
		CampoCorreo.setColumns(10);
		
		CampoContraseña = new JTextField();
		CampoContraseña.setBounds(182, 306, 96, 19);
		add(CampoContraseña);
		CampoContraseña.setColumns(10);
		
		JButton agregarUsuario = new JButton("Agregar usuario");
		agregarUsuario.addActionListener(new EventoAgregarUsuario(CampoID, CampoContraseña, CampoNombre, CampoCorreo, DatosTXT.getUSUARIOS()));
		agregarUsuario.setBounds(106, 392, 276, 38);
		agregarUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		agregarUsuario.setForeground(Color.WHITE);
		agregarUsuario.setBackground(new Color(0, 128, 0));
		add(agregarUsuario);
		
		add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));


	}
}
