package TraductorSeparado;

import javax.swing.JFrame;

public class Traductor extends JFrame{
	
	public Traductor() {
		
		setSize(800,400);
		setLocationRelativeTo(null);
		setTitle("Ejemplo Traductor");
		MiPanel panelLienzo = new MiPanel();
		add(panelLienzo);
	}

}
