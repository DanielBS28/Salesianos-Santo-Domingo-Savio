package Mecanografía;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailUtil {

	public static boolean sendEmail(Session session, String asunto, String correo, String mensaje) {
		try {

			// configurar cabeceras
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress(DatosTXT.getUSUARIOS().getFirst().getCorreo(), correo));// Datos de ejemplo
			msg.setReplyTo(InternetAddress.parse(DatosTXT.getUSUARIOS().getFirst().getCorreo(), false));
			msg.setSubject(correo, "UTF-8");
			msg.setText(mensaje, "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(asunto, false));
			System.out.println("MENSAJE CREADO");
			Transport.send(msg);
			System.out.println("¡EMAIL ENVIADO!");// si no da error
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;		

		}
	}

}
