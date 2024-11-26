package Mecanografía;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameMecanografía extends JFrame {

	public FrameMecanografía() {

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrameMecanografía.class.getResource("/Mecanografía/ImágenesAPP/Teclado.png")));
		setUndecorated(true); // Esto es para quitar los botones de arriba.
		setResizable(false); // Esto es para que no se pueda redimensionar.
		setBounds(100, 100, 450, 300); // Posición x, y | Ancho y alto del frame.
		setLocationRelativeTo(null); // Para posicionar el frame en medio.
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// Para que al cerrar la aplicación con la X no haga nada
		// y que sea el evento de cerrar aplicación el que decida que hacer.
		getContentPane().setLayout(null);
		setTitle("Aplicación de mecanografía de Daniel"); // Agrego el titulo a mi aplicación
		PanelCargaInicial cargaInicial = new PanelCargaInicial(this);
		getContentPane().add(cargaInicial);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Mostrar un mensaje de confirmación para cerrar la aplicación
				int opcion = JOptionPane.showConfirmDialog(null, "¿Desea confirmar el cierre de la aplicación?",
						"Cerrando aplicación...", JOptionPane.YES_NO_OPTION, JOptionPane.CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
	}
}
