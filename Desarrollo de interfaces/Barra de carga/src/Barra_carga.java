import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Barra_carga {

	private JFrame frame;
	Timer Crono;
	int variable = 10;
	
	int i  =variable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Barra_carga window = new Barra_carga();
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
	public Barra_carga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 641, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel tiempo = new JLabel(String.valueOf(i));
		tiempo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		tiempo.setBounds(403, 151, 105, 56);
		frame.getContentPane().add(tiempo);
		
		JLabel Mensaje = new JLabel("Cargando...");
		Mensaje.setBounds(199, 310, 105, 31);
		frame.getContentPane().add(Mensaje);
		
		JLabel porcentaje = new JLabel("0 %");
		porcentaje.setVisible(false);
		porcentaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		porcentaje.setBounds(297, 272, 46, 14);
		frame.getContentPane().add(porcentaje);
		
		JProgressBar BarraCarga = new JProgressBar();
		BarraCarga.setStringPainted(true);
		BarraCarga.setBounds(172, 260, 280, 39);
		frame.getContentPane().add(BarraCarga);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				i = variable;
				Crono.start();
				Mensaje.setBounds(199, 310, 105, 31);
				Mensaje.setText("Cargando...");
				BarraCarga.setValue(0);

			}
		});
		btnNewButton.setBounds(122, 151, 158, 56);
		frame.getContentPane().add(btnNewButton);
		
		
		
		Crono = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				i--;
				tiempo.setText(String.valueOf(i));
				if(i == 0) {
					Crono.stop();
				Mensaje.setText("¡Final!");
				}
				if(i>0) {
					porcentaje.setText(BarraCarga.getValue()+(100/variable) +"%");
					Mensaje.setLocation((int)Mensaje.getLocation().getX()+20, (int)Mensaje.getLocation().getY());
				}
				BarraCarga.setValue(BarraCarga.getValue()+(100/variable));
				if(BarraCarga.getValue() == 100) {
					
				}
			}
		});
	}
}

