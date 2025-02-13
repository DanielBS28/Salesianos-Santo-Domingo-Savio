package Utilidades;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnviarEmail{
	
	/*
	 * Esta clase es la encargada de enviar el email a un destinatario, tanto de preparar el envío como
	 * de procesar el envío a un destinatario. Se necesita el correo de quien manda el correo
	 * la contraseña para poder enviarlo, el correo de destino, un asunto y el mensaje.
	 */

	private static String emailFrom = "practicasdanielbs@gmail.com";
	private static String passwordFrom = "fdlu qbno ztxt uknw";
	private static String emailTo;
	private static String subject;
	private static String content;

	private static Properties mProperties;
	private static Session mSession;
	private static MimeMessage mCorreo;

	public static boolean crearEmail(String Correo, String Asunto, String Mensaje) {
		
		/*
		 * Esta función es la que se encarga de preparar el correo electrónico, la puse de tipo booleano y 
		 * dará true si el mensaje se ha enviado bien, y false si hubo algún problema durante el envío.
		 */
		mProperties = new Properties();

		emailTo = Correo;
		subject = Asunto;
		content = Mensaje;

		// Simple mail transfer protocol
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", emailFrom);
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");

		mSession = Session.getDefaultInstance(mProperties);

		try {
			mCorreo = new MimeMessage(mSession);
			mCorreo.setFrom(new InternetAddress(emailFrom));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mCorreo.setSubject(subject);
			mCorreo.setText(content, "ISO-8859-1", "html");

		} catch (AddressException ex) {
			Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MessagingException ex) {
			Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
		}

		return sendEmail();
	}

	private static boolean sendEmail() {
		
		/*
		 * Esta es la función que se encarga de enviar el correo mediante smtp. Si hay algún problema
		 * la función devolverá false y hay una ventana emergente que avisa de que no se ha enviado bien,
		 * si se ha enviado bien, devolverá true pero no hay ventana emergente aquí, la hay en la función donde
		 * se invoca a enviar correo para tener un mensaje más "personalizado" cuando devuelva true. Pero cuando devuelva
		 * false me interesa que la ventana emergente se cree aquí.
		 */
		try {
			Transport mTransport = mSession.getTransport("smtp");
			mTransport.connect(emailFrom, passwordFrom);
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();
			return true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Ha ocurrido un error durante el envío, no se ha enviado el mensaje.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
