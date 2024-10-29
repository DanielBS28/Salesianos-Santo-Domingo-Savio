package TraductorSeparado;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

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
	}
}
