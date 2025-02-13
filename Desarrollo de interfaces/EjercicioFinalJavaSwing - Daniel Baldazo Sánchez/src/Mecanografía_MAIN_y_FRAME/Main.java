package Mecanografía_MAIN_y_FRAME;
import java.awt.EventQueue;


public class Main {
	
	//Este es el método main unicamente en él, se crea el frame.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMecanografía mecanografía = new FrameMecanografía();	
					mecanografía.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
