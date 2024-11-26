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
import javax.swing.JPasswordField;

public class PanelLogin extends JPanel {

	private JTextField CampoUsuario;
	private FrameMecanografía frameMecanografía;

	private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";
	private JPasswordField CampoContraseña;

	public PanelLogin(FrameMecanografía frameMecanografía) {

		this.frameMecanografía = frameMecanografía;
		
		frameMecanografía.dispose(); // Esto es para hacer cambios en el frame es obligatorio
		// cuando voy a cambiar propiedades el frame, luego al final lo vuelvo a poner
		// en visible.
		frameMecanografía.setUndecorated(false);
		frameMecanografía.setBounds(100, 100, 500, 570);
		frameMecanografía.setLocationRelativeTo(null);
		frameMecanografía.setVisible(true);

		setLayout(null);
		setBounds(0, 0, 500, 700);

		CampoUsuario = new JTextField();
		CampoUsuario.setText("");
		CampoUsuario.setBounds(207, 197, 137, 20);
		add(CampoUsuario);
		CampoUsuario.setColumns(10);

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


		JCheckBox MostrarPass = new JCheckBox("Mostrar");
		MostrarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MostrarPass.isSelected())
					CampoContraseña.setEchoChar((char) 0);
				else
					CampoContraseña.setEchoChar('\u2022');
			}

		});

		MostrarPass.setForeground(new Color(255, 255, 255));
		MostrarPass.setContentAreaFilled(false);
		MostrarPass.setBounds(362, 292, 93, 21);
		add(MostrarPass);

		CampoContraseña = new JPasswordField();
		CampoContraseña.setBounds(207, 292, 137, 20);
		add(CampoContraseña);
		
		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.addActionListener(new EventoIniciarSesión(CampoUsuario, CampoContraseña, this, frameMecanografía));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 102));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
		btnNewButton.setBounds(148, 396, 198, 46);
		add(btnNewButton);
		add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));

	}
}
