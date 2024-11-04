package TraductorSeparado;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiPanel extends JPanel{
	
	private JTextField textField;
	private JTextField textField_1;
	
	public MiPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Traductor ");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(174, 23, 187, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce palabra");
		lblNewLabel_1.setBounds(88, 96, 116, 23);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("RESULTADO");
		lblNewLabel_1_1.setBounds(88, 159, 116, 23);
		add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(241, 97, 136, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 160, 136, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Traducir");
		btnNewButton.addActionListener(new EventoTraducir(textField,textField_1));
		btnNewButton.setBounds(174, 244, 89, 23);
		add(btnNewButton);
		
		
		// JMENU sin organizar en clases a diferentes
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 22);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Abrir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "DAM 24_25", "INFO", 1);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Guardar");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Desplegable");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Salir");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenu mnNewMenu_2 = new JMenu("Fondo");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cambiar Fondo");
		mnNewMenu_2.add(mntmNewMenuItem_2);
	}
}
