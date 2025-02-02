package Mecanografía;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class PanelEliminarUsuarios extends JPanel{
	
		
		private FrameMecanografía frameMecanografía;
		private Usuario user;
		private static String fondoPanelLogin = "src/Mecanografía/ImágenesAPP/FondoAzulado.jpg";
		
		static ArrayList <Usuario> USUARIOS = DatosTXT.getUSUARIOS();
		
		public PanelEliminarUsuarios(FrameMecanografía frameMecanografía, Usuario user) {
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
						
			JButton EliminarUsuario = new JButton("Eliminar usuario");
			EliminarUsuario.setBounds(108, 392, 276, 38);
			EliminarUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
			EliminarUsuario.setForeground(new Color(255, 255, 255));
			EliminarUsuario.setBackground(new Color(187, 37, 30));
			add(EliminarUsuario);
			
			JLabel Pregunta = new JLabel("¿Qué usuario desea eliminar?");
			Pregunta.setHorizontalAlignment(SwingConstants.CENTER);
			Pregunta.setForeground(Color.WHITE);
			Pregunta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
			Pregunta.setBounds(73, 60, 352, 65);
			add(Pregunta);
			

			JList list = new JList();
			list.setBounds(70, 153, 356, 184);
			add(list);
			
			add(Imágenes.ponerFondo(fondoPanelLogin, frameMecanografía));
			

		}
	}

