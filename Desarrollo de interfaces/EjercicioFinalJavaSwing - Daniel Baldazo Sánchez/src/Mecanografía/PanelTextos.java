package Mecanografía;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTextos extends JPanel{
	
	private FrameMecanografía frameMecanografía;
	private Usuario user;
	private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";
	
	static ArrayList <String> TEXTOS = DatosTXT.getTEXTOS();
	
	public PanelTextos(FrameMecanografía frameMecanografía, Usuario user) {
		this.frameMecanografía = frameMecanografía;
		this.user = user;
		
		setLayout(null);
		setBounds(0, 0, 500, 700);
		JButton volverAtrás = new JButton("Volver atrás");
		volverAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PanelAdmin panelAdmin = new PanelAdmin(frameMecanografía, user);
				frameMecanografía.getContentPane().add(panelAdmin);
			}
		});
		volverAtrás.setBackground(new Color(255, 153, 102));
		volverAtrás.setForeground(new Color(255, 255, 255));
		volverAtrás.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		volverAtrás.setBounds(123, 469, 241, 27);
		add(volverAtrás);
		
		add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));

	}
	
}