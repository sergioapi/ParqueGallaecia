/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojos.Empleado;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaEmpleado extends AbstractTableModel {
    private List<Empleado> empleados = new ArrayList<>();
    private String[] columnNames = {"DNI", "Nombre", "Teléfono", "Sector"};
    
    public ModeloTablaEmpleado() {
        this.empleados = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado empleado = empleados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return empleado.getDNI();
            case 1:
                return empleado.getNombre();
            case 2:
                return empleado.getTelefono();
            case 3:
                return empleado.getSector();
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
        return String.class;
    }
    
    public void setFilas(java.util.List<Empleado> empleados) {
        this.empleados = empleados;
        fireTableDataChanged();
    }

    public Empleado obtenerEmpleado(int i) {
        return this.empleados.get(i);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }
    
}
