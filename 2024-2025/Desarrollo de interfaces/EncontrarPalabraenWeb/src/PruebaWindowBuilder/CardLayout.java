package PruebaWindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardLayout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayout window = new CardLayout();
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
	public CardLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new java.awt.CardLayout(0, 0));
		frame.setLocationRelativeTo(null);

		JPanel panel_rosa = new JPanel();
		panel_rosa.setBackground(new Color(255, 128, 192));
		frame.getContentPane().add(panel_rosa, "name_2496439312300");
		panel_rosa.setLayout(null);

		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(196, 74, 46, 54);
		panel_rosa.add(lblNewLabel);

		JButton btnNewButton = new JButton("Siguiente");

		btnNewButton.setBounds(147, 168, 140, 23);
		panel_rosa.add(btnNewButton);

		JPanel panel_verde = new JPanel();
		panel_verde.setVisible(false);
		panel_verde.setBackground(new Color(0, 255, 128));
		frame.getContentPane().add(panel_verde, "name_2528513553200");
		panel_verde.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(191, 75, 62, 63);
		panel_verde.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Siguiente");

		btnNewButton_1.setBounds(132, 169, 159, 23);
		panel_verde.add(btnNewButton_1);

		JPanel panel_naranja = new JPanel();
		panel_naranja.setVisible(false);
		panel_naranja.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panel_naranja, "name_2545736720400");
		panel_naranja.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_2.setBounds(195, 48, 77, 74);
		panel_naranja.add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("Siguiente");

		btnNewButton_2.setBounds(132, 164, 157, 23);
		panel_naranja.add(btnNewButton_2);

		JPanel panel_verdeoscuro = new JPanel();
		panel_verdeoscuro.setVisible(false);
		panel_verdeoscuro.setBackground(new Color(0, 128, 64));
		frame.getContentPane().add(panel_verdeoscuro, "name_2591342094600");
		panel_verdeoscuro.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_3.setBounds(197, 63, 52, 55);
		panel_verdeoscuro.add(lblNewLabel_3);

		JButton btnNewButton_3 = new JButton("Inicio");

		btnNewButton_3.setBounds(126, 166, 160, 23);
		panel_verdeoscuro.add(btnNewButton_3);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_verde.setVisible(true);
				panel_rosa.setVisible(false);
			}

		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_naranja.setVisible(true);
				panel_verde.setVisible(false);
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_naranja.setVisible(false);
				panel_verdeoscuro.setVisible(true);
			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_verdeoscuro.setVisible(false);
				panel_rosa.setVisible(true);
			}
		});
	}

}
