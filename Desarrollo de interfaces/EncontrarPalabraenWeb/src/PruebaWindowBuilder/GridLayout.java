package PruebaWindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GridLayout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridLayout window = new GridLayout();
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
	public GridLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));
		
		JPanel panel_azul = new JPanel();
		panel_azul.setBackground(new Color(0, 128, 255));
		frame.getContentPane().add(panel_azul);
		panel_azul.setLayout(null);
		
		JButton btnNewButton = new JButton("Mostrar el panel 1");
		
		btnNewButton.setBounds(69, 162, 169, 23);
		panel_azul.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(147, 52, 30, 70);
		panel_azul.add(lblNewLabel);
		
		JPanel panel_rosa = new JPanel();
		panel_rosa.setVisible(false);
		panel_rosa.setBackground(new Color(255, 128, 192));
		frame.getContentPane().add(panel_rosa);
		panel_rosa.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Mostrar el panel 2");
		
		btnNewButton_1.setBounds(84, 162, 173, 23);
		panel_rosa.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(166, 51, 30, 70);
		panel_rosa.add(lblNewLabel_1);
		
		JPanel panel_naranja = new JPanel();
		panel_naranja.setVisible(false);
		panel_naranja.setBackground(new Color(255, 128, 64));
		frame.getContentPane().add(panel_naranja);
		panel_naranja.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Mostrar el panel 3");
		
		btnNewButton_2.setBounds(69, 169, 178, 23);
		panel_naranja.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(152, 51, 30, 70);
		panel_naranja.add(lblNewLabel_2);
		
		JPanel panel_amarillo = new JPanel();
		panel_amarillo.setVisible(false);
		panel_amarillo.setBackground(new Color(255, 255, 128));
		frame.getContentPane().add(panel_amarillo);
		panel_amarillo.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Ocultar todos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_rosa.setVisible(false);
				panel_naranja.setVisible(false);
				panel_amarillo.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(110, 170, 131, 23);
		panel_amarillo.add(btnNewButton_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("3");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2_1.setBounds(164, 47, 30, 70);
		panel_amarillo.add(lblNewLabel_2_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_rosa.setVisible(true);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_naranja.setVisible(true);
				
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_amarillo.setVisible(true);
			}
		});
	}
}
