package PruebaWindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

public class CuentaAtrás {

	private JFrame frame;
	Timer crono; // Java Swing
	int i = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuentaAtrás window = new CuentaAtrás();
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
	public CuentaAtrás() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("CUENTA ATRÁS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(97, 11, 382, 82);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("START");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));

		btnNewButton.setBounds(63, 147, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("-------");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(282, 141, 119, 40);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fin");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_2.setBounds(187, 203, 71, 35);
		frame.getContentPane().add(lblNewLabel_2);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 10;
				lblNewLabel_1.setText(String.valueOf(i));

				lblNewLabel_2.setVisible(false);

				crono.start();

			}
		});

		crono = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				i--;
				lblNewLabel_1.setText(String.valueOf(i));
				if (i == 0) {
					crono.stop();
					lblNewLabel_2.setVisible(true);
					frame.getContentPane().add(createContenPanelConFondo()); 

				}

			}

			private Component createContenPanelConFondo() {

				final Image imagenFondo = requestImage();

				JPanel miPanel = new JPanel() {

					@Override
					protected void paintComponent(Graphics g) {
						// TODO Auto-generated method stub
						super.paintComponent(g);

						int W = frame.getWidth();
						int H = frame.getHeight();

						g.drawImage(imagenFondo, 0, 0, W, H, null);

					}

				};

				 miPanel.setSize(500, 333);

				return miPanel;
			}
			
			private Image requestImage() {

				BufferedImage imagenFondo = null;
				try {
					imagenFondo = ImageIO.read(new File("src/PruebaWindowBuilder/imagen.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return imagenFondo;
			}
				
		
			
		});
		
		
	}

}
