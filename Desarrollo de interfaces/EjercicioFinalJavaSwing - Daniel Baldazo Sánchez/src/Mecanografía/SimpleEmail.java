package Mecanografía;

import java.util.Properties;

import javax.mail.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleEmail {

	/*
	 * Outgoing mail smtp server requires tls or ssl smtp.gmail.com (ssl) use
	 * autentificacion ssl port 465
	 */

	public static boolean EnviarEmail(JTextField campoAsunto, JTextField campoCorreo, JTextArea mensaje) {
		final String fromEmail = DatosTXT.getUSUARIOS().getFirst().getCorreo(); // email de salida
		final String password = "fdlu qbno ztxt uknw";// contraseña del email de salida

		System.out.println("Configurando datos conexión SSL");

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // smtp de gmail en este caso
		props.put("mail.smtp.socketFactory.class", "465"); // puerto SSL
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true");// activar smtp autentificación
		props.put("mail.smtp.port", "465");// smtp port

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);

		/*
		 * Llamada al metodo send email con todos los datos configurados session toemail
		 * subject body
		 */
		
		return EmailUtil.sendEmail(session,  campoCorreo, campoAsunto, mensaje);
		
	}

}
