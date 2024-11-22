package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class PanelCargaInicial extends JPanel{
	
	Timer Crono;
	int tiempoCarga = 0;
	
	public PanelCargaInicial() {
		
		setLayout(null);
		
		JProgressBar BarraDeCarga = new JProgressBar();
		BarraDeCarga.setBounds(97, 223, 239, 20);
		add(BarraDeCarga);
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
