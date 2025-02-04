package Mecanografía;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailUtil {

	public static boolean sendEmail(Session session, JTextField campoCorreo, JTextField campoAsunto, JTextArea mensaje) {
		try {

			// configurar cabeceras
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@example.com", campoAsunto.getText()));// Datos de ejemplo
			msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));
			msg.setSubject(campoAsunto.getText(), "UTF-8");
			msg.setText(mensaje.getText(), "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(campoCorreo.getText(), false));
			System.out.println("MENSAJE CREADO");
			Transport.send(msg);
			System.out.println("¡EMAIL ENVIADO!");// si no da error

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}

}
