package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EventoIniciarSesión implements ActionListener {

	private JTextField campoUsuario;
	private JTextField campoContraseña;
	private PanelLogin panelLogin;
	private FrameMecanografía frameMecanografía;

	public EventoIniciarSesión(JTextField campoUsuario, JPasswordField campoContraseña, PanelLogin panelLogin,
			FrameMecanografía frameMecanografía) {

		this.campoUsuario = campoUsuario;
		this.campoContraseña = campoContraseña;
		this.panelLogin = panelLogin;
		this.frameMecanografía = frameMecanografía;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String alias = campoUsuario.getText();
		String contraseña = campoContraseña.getText();
		boolean usuarioEncontrado = false;

		ArrayList<Usuario> USUARIOS = DatosTXT.getUSUARIOS();

		if (alias.equals("a") && contraseña.equals("a")) {
			panelLogin.setVisible(false);
			PanelAdmin panelAdmin = new PanelAdmin(frameMecanografía, DatosTXT.getUSUARIOS().get(0));
			frameMecanografía.getContentPane().add(panelAdmin);
		} else if (USUARIOS.size() <= 3)
			JOptionPane.showInternalMessageDialog(null,
					"Hay menos de 3 usuarios para que la aplicación funcione, debes"
							+ "de añadir más usuarios como administrador para poder utilizar la aplicación",
					"Error: ", 0);
		else if(DatosTXT.getTEXTOS().size() != 2){
			JOptionPane.showInternalMessageDialog(null,
					"No hay textos cargados o los datos son insuficientes, inicia sesión como administrador"
					+ " para agregar los dos textos para poder jugar",
					"Error: ", 0);
		}else {
			for (int i = 0; i < USUARIOS.size(); i++) {

				Usuario user = USUARIOS.get(i);
				if (user.getAlias().equals(alias) && user.getContrasena().equals(contraseña)) {
					panelLogin.setVisible(false);
					PanelLeccion panelLeccion = new PanelLeccion(frameMecanografía, user);
					frameMecanografía.getContentPane().add(panelLeccion);
					usuarioEncontrado = true;
				}
			}
			if (!usuarioEncontrado)
				JOptionPane.showInternalMessageDialog(null,
						"No se han encontrado usuarios o la contraseña es incorrecta", "Error: ", 0);
		}

	}
}
