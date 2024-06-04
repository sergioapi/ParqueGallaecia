/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author alumnogreibd
 */
public class CamposCompletosListener implements DocumentListener {
    
    private JButton btnInsertar;
    private List<JTextField> campos;
    
    public CamposCompletosListener(JButton btnInsertar,
            List<JTextField> campos) {
        this.btnInsertar = btnInsertar;
        this.campos = campos;
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        habilitarBotonInsertar();
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        habilitarBotonInsertar();
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        habilitarBotonInsertar();
    }
    
    private void habilitarBotonInsertar() {
        // Verifica si todos los campos están completos
        boolean camposCompletos = true;
        for (int i = 0; i < campos.size(); i++) {
            if (campos.get(i).getText().isEmpty()) {
                camposCompletos = false;
            }
        }
        btnInsertar.setEnabled(camposCompletos);
    }
}
