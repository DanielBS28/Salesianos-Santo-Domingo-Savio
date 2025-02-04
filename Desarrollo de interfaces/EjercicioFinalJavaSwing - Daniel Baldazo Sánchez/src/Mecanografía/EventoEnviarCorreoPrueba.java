package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventoEnviarCorreoPrueba extends JPanel implements ActionListener {
	
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
		
		if(campoAsunto.getText().trim().isBlank()||Mensaje.getText().trim().isBlank()||campoCorreo.getText().isBlank())
			JOptionPane.showMessageDialog(this,
					"Debes de llenar todos los campos del formulario: asunto, mensaje y destinatario.", "Error",
					JOptionPane.ERROR_MESSAGE);
		else
			SimpleEmail.EnviarEmail(campoAsunto, campoCorreo, Mensaje);
		
	}

}
