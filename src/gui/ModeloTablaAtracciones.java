package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojos.Atraccion;

public class ModeloTablaAtracciones extends AbstractTableModel {

    private List<Atraccion> atracciones;

    private String[] columnNames = {"Nombre", "Aforo", "Altura mínima", "Coste de mantenimiento", "Ubicacion", "Descripción"};

    public ModeloTablaAtracciones() {
        this.atracciones = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return atracciones.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Atraccion atraccion = atracciones.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return atraccion.getNombre();
            case 1:
                return atraccion.getAforo();
            case 2:
                return atraccion.getAlturaMin();
            case 3:
                return atraccion.getCosteMantenimiento();
            case 4:
                return atraccion.getUbicacion();
            case 5:
                return atraccion.getDescripcion();
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
            case 0: // Columna "Nombre"
            case 4: // Columna "Ubicacion"
            case 5: // Columna "Descripción"
                return String.class;
            case 1: // Columna "Aforo"
                return Integer.class;
            case 2: // Columna "Altura mínima"
            case 3: // Columna "Coste de mantenimiento"
                return Float.class;
            default:
                return Object.class;
        }
    }

    public void setFilas(java.util.List<Atraccion> atracciones) {
        this.atracciones = atracciones;
        fireTableDataChanged();
    }

    public Atraccion obtenerAtraccion(int i) {
        return this.atracciones.get(i);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }
}
