import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import java.awt.event.MouseEvent;

public class Mariposas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	Random r = new Random();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mariposas window = new Mariposas();
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
	public Mariposas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 724, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Mariposa = new JLabel();
		
		ImageIcon miniMosca = new ImageIcon("src/Mariposa.png");
		
		Image miniMoscaRed = miniMosca.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			
		Mariposa.setIcon(new ImageIcon(miniMoscaRed));
		Mariposa.setBounds(0, 0, 50, 50);
		frame.getContentPane().add(Mariposa);
		
		JLabel PosMariposa = new JLabel("Posición de la mariposa:");
		PosMariposa.setBounds(10, 443, 170, 14);
		frame.getContentPane().add(PosMariposa);
		
		JLabel PosRatón = new JLabel("Posición del ratón:");
		PosRatón.setBounds(496, 443, 139, 14);
		frame.getContentPane().add(PosRatón);
		
		JLabel CoorRatón = new JLabel("");
		CoorRatón.setBounds(604, 443, 94, 14);
		frame.getContentPane().add(CoorRatón);
		
		JLabel CoorMariposa = new JLabel("");
		CoorMariposa.setBounds(153, 443, 102, 14);
		frame.getContentPane().add(CoorMariposa);
		
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				int Xpuntero = e.getX();
				int Ypuntero = e.getY();
				
				int XMariposa = Mariposa.getX();
				int YMariposa = Mariposa.getY();
				
				CoorMariposa.setText("[X:"+XMariposa + ", " + "Y:"+YMariposa+"]");
				CoorRatón.setText("[X:"+Xpuntero + ", " +"Y:"+Ypuntero+"]");
				
				int distanX = Math.abs(YMariposa - Xpuntero);
				int distanY = Math.abs(YMariposa - Ypuntero);
				
				int tamX = Mariposa.getWidth();
				int tamY = Mariposa.getHeight();
				
				int radio = 75;
				
				if(distanX < radio || distanY < radio) {
					
					int moverX = r.nextInt(101) -50;
					int moverY = r.nextInt(101) -50;
					
					int nuevaX= Math.max(0, Math.min(XMariposa + moverX, frame.getWidth()- 2* tamX));
					int nuevaY= Math.max(0, Math.min(YMariposa + moverY, frame.getHeight()- 2* tamY));

					Mariposa.setLocation(nuevaX, nuevaY);

				}


			}
		});
		
	
	}
}
