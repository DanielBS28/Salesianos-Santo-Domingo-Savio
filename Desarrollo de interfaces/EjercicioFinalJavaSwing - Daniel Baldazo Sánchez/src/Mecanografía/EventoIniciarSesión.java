package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EventoIniciarSesión implements ActionListener {

	private JTextField campoUsuario;
	private JTextField campoContraseña;
	private PanelLogin panelLogin;
	private FrameMecanografía frameMecanografía;

	public EventoIniciarSesión(JTextField campoUsuario, JPasswordField campoContraseña, PanelLogin panelLogin, FrameMecanografía frameMecanografía) {

		this.campoUsuario = campoUsuario;
		this.campoContraseña = campoContraseña;
		this.panelLogin = panelLogin;
		this.frameMecanografía = frameMecanografía;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String alias = campoUsuario.getText();
		String contraseña = campoContraseña.getText();

		ArrayList<Usuario> USUARIOS = DatosTXT.getUSUARIOS();

		for (int i = 0; i < USUARIOS.size(); i++) {

			Usuario user = USUARIOS.get(i);
			if (user.getAlias().equals(alias) && user.getContrasena().equals(contraseña)) {
				panelLogin.setVisible(false);
				PanelLeccion panelLeccion = new PanelLeccion(frameMecanografía, user);
				frameMecanografía.getContentPane().add(panelLeccion);
				return;
			} else
				System.out.println("Error");
		}
	}

}
