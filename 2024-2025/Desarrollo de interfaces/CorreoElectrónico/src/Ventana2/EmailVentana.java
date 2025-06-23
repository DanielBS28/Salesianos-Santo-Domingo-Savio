package Ventana2;

import java.awt.EventQueue;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class EmailVentana {

	private JFrame frame;
	private JTextField enviarA;
	private JTextField asunto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailVentana window = new EmailVentana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmailVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enviar a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(56, 11, 177, 34);
		frame.getContentPane().add(lblNewLabel);
		
		enviarA = new JTextField();
		enviarA.setBounds(147, 21, 231, 20);
		frame.getContentPane().add(enviarA);
		enviarA.setColumns(10);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAsunto.setBounds(56, 56, 177, 34);
		frame.getContentPane().add(lblAsunto);
		
		asunto = new JTextField();
		asunto.setColumns(10);
		asunto.setBounds(147, 66, 231, 20);
		frame.getContentPane().add(asunto);
		
		JTextArea textArea = new JTextArea(Fichero.leerArchivo());
		textArea.setBounds(147, 116, 231, 70);
		frame.getContentPane().add(textArea);
		
		JLabel lblTexto = new JLabel("Texto:");
		lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTexto.setBounds(56, 108, 177, 34);
		frame.getContentPane().add(lblTexto);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String enviarAcorreo = "";
				String AsuntoCorreo = "";
				String body = "";
				
				if(enviarA.getText().isBlank() != true && asunto.getText().isBlank() != true && textArea.getText().isBlank() != true) {
					enviarAcorreo = enviarA.getText();
					AsuntoCorreo = asunto.getText();
					body = textArea.getText();
					SimpleEmail.EnviarEmail(enviarAcorreo, AsuntoCorreo, body);

				}else
					JOptionPane.showInternalMessageDialog(null, "Campos incompletos", "Error: ", 0);

			}
		});
		btnNewButton.setBounds(289, 215, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	

	
}
