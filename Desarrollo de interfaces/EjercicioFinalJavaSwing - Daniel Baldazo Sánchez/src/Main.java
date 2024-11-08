import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JProgressBar;

public class Main {

	private JFrame frame;
	Timer Crono;
	int tiempoCarga = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JProgressBar BarraDeCarga = new JProgressBar();
		BarraDeCarga.setBounds(100, 223, 239, 20);
		frame.getContentPane().add(BarraDeCarga);
		BarraDeCarga.setValue(0);

		Crono = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tiempoCarga++;
				BarraDeCarga.setValue(BarraDeCarga.getValue() + (100 / 6)+1);

				if (tiempoCarga == 4) {
					
				}

			}
		});
		
		Crono.start();


	}

}
