package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Utilidades.DatosTXT;
import Utilidades.EscribirTXT;

public class eventoActualizarTextos extends JPanel implements ActionListener {
	
	/**
	 * Esta clase es un evento que se encarga de actualizar los textos de la aplicación
	 * **/

    
    private JTextArea JTPTextoFácil;
    private JTextArea JTPTextoDifícil;

    public eventoActualizarTextos(JTextArea jTPTextoFácil, JTextArea jTPTextoDifícil) {
    	
        JTPTextoFácil = jTPTextoFácil;
        JTPTextoDifícil = jTPTextoDifícil;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String TextoFácil = JTPTextoFácil.getText().trim();
        String TextoDifícil = JTPTextoDifícil.getText().trim();
        
        //Si alguno de los dos textos está vacio no se realizará la acción
        if (TextoFácil.isBlank() || TextoDifícil.isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Debes de llenar los dos textos, no pueden dejar ninguno vacío."
                    + " Vuelve a intentarlo de nuevo por favor", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
        	//Si no voy a reescribir los textos y se van a guardar
            EscribirTXT.escribirTextos(TextoFácil, TextoDifícil);
            eliminarDatosAntiguos(DatosTXT.getTEXTOS());
            //Una vez eliminados los textos los añado actualizados
            DatosTXT.getTEXTOS().add(TextoFácil);
            DatosTXT.getTEXTOS().add(TextoDifícil);
            JOptionPane.showMessageDialog(this, "Los textos se han agregado correctamente.", "Textos agregados",
                    JOptionPane.NO_OPTION);
        }
    }
    //Esto elimina los textos antiguos del ArrayList de textos
    public static void eliminarDatosAntiguos(ArrayList<String> textos) {
        for (int i = textos.size() - 1; i >= 0; i--) {
            textos.remove(i);
        }
    }

    
}
