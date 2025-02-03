package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventoAgregarUsuario extends JPanel implements ActionListener {

	private JTextField campoID;
	private JTextField campoContraseña;
	private JTextField campoNombre;
	private JTextField campoCorreo;
	private ArrayList<Usuario> USUARIOS = null;

	public EventoAgregarUsuario(JTextField campoID, JTextField campoContraseña, JTextField campoNombre,
			JTextField campoCorreo, ArrayList<Usuario> USUARIOS) {

		this.campoContraseña = campoContraseña;
		this.campoCorreo = campoCorreo;
		this.campoID = campoID;
		this.campoNombre = campoNombre;
		this.USUARIOS = USUARIOS;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean ErrorEncontrado = false;

		String contraseña = campoContraseña.getText();
		String Correo = campoCorreo.getText();
		String ID = campoID.getText();
		String Nombre = campoNombre.getText();

		if (contraseña.isBlank() || Correo.isBlank() || ID.isBlank() || Nombre.isBlank()) {
			JOptionPane.showMessageDialog(this,
					"Debes de llenar todos los campos, no puedes dejar campos en el formulario vacíos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			ErrorEncontrado = true;

		} else if (USUARIOS.size() >= 6) {
			JOptionPane.showMessageDialog(this,
					"No se pudo agregar el usuario, el máximo de usuarios permitidos en la aplicación es 5.", "Error",
					JOptionPane.ERROR_MESSAGE);
			ErrorEncontrado = true;

		} else {
			for (int i = 0; i < USUARIOS.size() && !ErrorEncontrado; i++) {
				if (USUARIOS.get(i).getAlias().equals(ID) && USUARIOS.get(i).getCorreo().equals(Correo)) {
					JOptionPane.showMessageDialog(this,
							"No se puede agregar este usuario, ya existe otro usuario con el ID y correo que has introducido.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
				} else if (USUARIOS.get(i).getAlias().equals(ID)) {
					JOptionPane.showMessageDialog(this,
							"No se puede agregar este usuario, ya existe otro usuario con el ID que has introducido.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
				} else if (USUARIOS.get(i).getCorreo().equals(Correo)) {
					JOptionPane.showMessageDialog(this,
							"No se puede agregar este usuario, ya existe otro usuario con el correo que has introducido.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
				} else if (!esCorreoValido(Correo)) {
					JOptionPane.showMessageDialog(this,
							"El correo electrónico que has introducido no es un correo válido, vuelve a intentarlo por favor.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
				} else if (!esContraseñaValida(contraseña)) {
					JOptionPane.showMessageDialog(this,
							"La contraseña que has introducido no es válida, debe de tener 6 caracteres con mayúsculas, mínusculas y números, vuelve a intentarlo por favor.",
							"Error", JOptionPane.ERROR_MESSAGE);
					ErrorEncontrado = true;
				}
			}
		}

		if (!ErrorEncontrado) {
			JOptionPane.showMessageDialog(this, "El usuario se ha agregado correctamente.", "Usuario agregado",
					JOptionPane.NO_OPTION);
			USUARIOS.add(new Usuario(ID, Nombre, contraseña, Correo));
			EscribirTXT.EscribirUsuarios(USUARIOS);
			campoContraseña.setText("");
			campoCorreo.setText("");
			campoID.setText("");
			campoNombre.setText("");

		}
	}

	public static boolean esCorreoValido(String correo) {

		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

		Pattern expresión = Pattern.compile(regex);
		Matcher coincide = expresión.matcher(correo);

		return coincide.matches();
	}

	public static boolean esContraseñaValida(String contraseña) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$";

		Pattern expresión = Pattern.compile(regex);
		Matcher coincide = expresión.matcher(contraseña);

		return coincide.matches();
	}

}
