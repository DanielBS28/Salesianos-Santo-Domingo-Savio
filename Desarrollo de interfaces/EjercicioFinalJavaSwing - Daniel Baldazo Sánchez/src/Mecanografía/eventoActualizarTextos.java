package Mecanografía;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class eventoActualizarTextos extends JPanel implements ActionListener {
    
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
        
        if (TextoFácil.isBlank() || TextoDifícil.isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Debes de llenar los dos textos, no pueden dejar ninguno vacío."
                    + " Vuelve a intentarlo de nuevo por favor", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            EscribirTXT.escribirTextos(TextoFácil, TextoDifícil);
            eliminarDatosAntiguos(DatosTXT.getTEXTOS());
            DatosTXT.getTEXTOS().add(TextoFácil);
            DatosTXT.getTEXTOS().add(TextoDifícil);
            JOptionPane.showMessageDialog(this, "Los textos se han agregado correctamente.", "Textos agregados",
                    JOptionPane.NO_OPTION);
        }
    }

    public static void eliminarDatosAntiguos(ArrayList<String> textos) {
        for (int i = textos.size() - 1; i >= 0; i--) {
            textos.remove(i);
        }
    }

    
}
