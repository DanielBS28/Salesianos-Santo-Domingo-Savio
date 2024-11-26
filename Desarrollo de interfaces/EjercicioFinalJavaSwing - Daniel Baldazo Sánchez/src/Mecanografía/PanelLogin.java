package Mecanografía;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel{
	
	private JTextField CampoUsuario;
	private JTextField CampoContraseña;
	private FrameMecanografía frameMecanografía;
	
	private static String fondoPanelLogin = "src/Mecanografía/FondoAzulado.jpg";
	
	public PanelLogin(FrameMecanografía frameMecanografía) {
		
		this.frameMecanografía = frameMecanografía;
		
		setLayout(null);
		setBounds(0, 0, 500, 700);

		CampoUsuario = new JTextField();
		CampoUsuario.setText("");
		CampoUsuario.setBounds(207, 197, 137, 20);
		add(CampoUsuario);
		CampoUsuario.setColumns(10);
		
		CampoContraseña = new JTextField();
		CampoContraseña.setBounds(207, 293, 137, 20);
		add(CampoContraseña);
		CampoContraseña.setColumns(10);
		
		JLabel LabelUsuario = new JLabel("Usuario");
		LabelUsuario.setForeground(new Color(255, 255, 255));
		LabelUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		LabelUsuario.setBounds(71, 197, 190, 14);
		add(LabelUsuario);
		
		JLabel LabelContraseña = new JLabel("Contraseña");
		LabelContraseña.setForeground(new Color(255, 255, 255));
		LabelContraseña.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		LabelContraseña.setBounds(71, 293, 190, 14);
		add(LabelContraseña);	
		
		JLabel Login = new JLabel("LOG IN");
		Login.setForeground(new Color(255, 255, 255));
		Login.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 50));
		Login.setBounds(163, 60, 307, 68);
		add(Login);
		
		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
		btnNewButton.setBounds(148, 396, 198, 46);
		add(btnNewButton);
		
		JCheckBox MostrarPass = new JCheckBox("Mostrar");
		MostrarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MostrarPass.isSelected())
					CampoContraseña.setText("Hola");
			}
		});

		MostrarPass.setForeground(new Color(255, 255, 255));
		MostrarPass.setContentAreaFilled(false);
		MostrarPass.setBounds(362, 292, 93, 21);
		add(MostrarPass);
		
		add(Imágenes.ponerFondo(fondoPanelLogin,frameMecanografía));

	}
}
