package Eventos;

import java.awt.event.ActionEvent;
import Utilidades.*;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventoEnviarCorreoPrueba extends JPanel implements ActionListener {
	
	/**
	 * Esta clase es un evento que permite enviar correos.
	 */

	private JTextField campoAsunto;
	private JTextField campoCorreo;
	private JTextArea Mensaje;

	public EventoEnviarCorreoPrueba(JTextField campoAsunto, JTextField campoCorreo, JTextArea Mensaje) {
		this.campoAsunto = campoAsunto;
		this.campoCorreo = campoCorreo;
		this.Mensaje = Mensaje;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Si hay algún campo que está vacio no voy a enviar el correo y voy a avisar al usuario
		if (campoAsunto.getText().trim().isBlank() || Mensaje.getText().trim().isBlank()
				|| campoCorreo.getText().isBlank())
			JOptionPane.showMessageDialog(this,
					"Debes de llenar todos los campos del formulario: asunto, mensaje y destinatario.", "Error",
					JOptionPane.ERROR_MESSAGE);
		//Si están los 3 campos llenos voy a enviar el correo, pero puede ser que lo reciba o no,
		//En ese caso la función crearEmail es de tipo booleano, si el correo se ha enviado recibo true
		//y se muestra que se ha enviado el correo, si no se ha enviado la función crearEmail, da el aviso de que 
		// no se ha enviado.
		else if (EnviarEmail.crearEmail(campoCorreo.getText(),campoAsunto.getText(), Mensaje.getText())) {
			JOptionPane.showMessageDialog(this, "El correo electrónico se ha enviado correctamente", "Mensaje enviado",
					JOptionPane.NO_OPTION);
			campoAsunto.setText("");
			campoCorreo.setText("");
			Mensaje.setText("");
			//Aquí reseteo los Jlabels para quitarles el texto si el correo se envió
		}
			
	}

}
