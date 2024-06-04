/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojos.Visitante;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaVisitantes extends AbstractTableModel {

    private List<Visitante> visitantes;

    private String[] columnNames = {"DNI", "Nombre", "Nacionalidad", "Teléfono", "Fecha de nacimiento", "Altura"};

    public ModeloTablaVisitantes() {
        this.visitantes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return visitantes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Visitante visitante = visitantes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return visitante.getDNI();
            case 1:
                return visitante.getNombre();
            case 2:
                return visitante.getNacionalidad();
            case 3:
                return visitante.getTelefono();
            case 4:
                return visitante.getFechaNacimiento();
            case 5:
                return visitante.getAltura();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: // Columna "DNI"
            case 1: // Columna "Nombre"
            case 2: // Columna "Nacionalidad"
            case 3: // Columna "Teléfono"
                return String.class;
            case 4: // Columna "Fecha de nacimiento"
                return java.sql.Date.class;
            case 5: // Columna "Altura"
                return float.class;
            default:
                return Object.class;
        }
    }

    public void setFilas(java.util.List<Visitante> visitantes) {
        this.visitantes = visitantes;
        fireTableDataChanged();
    }

    public Visitante obtenerVisitante(int i) {
        return this.visitantes.get(i);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }

    public void removeRow(int rowIndex) {
        visitantes.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}