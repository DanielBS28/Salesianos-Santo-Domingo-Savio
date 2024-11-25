package Mecanografía;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelLogin extends JPanel{
	
	private JTextField CampoUsuario;
	private JTextField CampoContraseña;
	private static String fondoPanelLogin = "src/Mecanografía/FondoPanelLogin.jpg";
	
	public PanelLogin(FrameMecanografía frameMecanografía) {
		
		setLayout(null);
		setBounds(0, 0, 500, 700);

		CampoUsuario = new JTextField();
		CampoUsuario.setText("");
		CampoUsuario.setBounds(253, 208, 137, 20);
		add(CampoUsuario);
		CampoUsuario.setColumns(10);
		
		CampoContraseña = new JTextField();
		CampoContraseña.setBounds(253, 304, 137, 20);
		add(CampoContraseña);
		CampoContraseña.setColumns(10);
		
		JLabel LabelUsuario = new JLabel("Usuario");
		LabelUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		LabelUsuario.setBounds(95, 209, 190, 14);
		add(LabelUsuario);
		
		JLabel LabelContraseña = new JLabel("Contraseña");
		LabelContraseña.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		LabelContraseña.setBounds(95, 305, 190, 14);
		add(LabelContraseña);
		
		add(Imágenes.ponerFondo(fondoPanelLogin,frameMecanografía));
		
		
	}
}
