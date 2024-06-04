package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojos.Restaurante;

public class ModeloTablaRestaurantes extends AbstractTableModel {

    private List<Restaurante> restaurantes = new ArrayList<>();

    private String[] columnNames = {"Nombre", "Ubicación", "Aforo", "Hora apertura", "Hora cierre"};

    public ModeloTablaRestaurantes() {
        this.restaurantes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return restaurantes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Restaurante restaurante = restaurantes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return restaurante.getNombreEstablecimiento();
            case 1:
                return restaurante.getUbicacion();
            case 2:
                return restaurante.getAforo();
            case 3:
                return restaurante.getHoraInicio();
            case 4:
                return restaurante.getHoraFin();
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
            case 1: // Columna "Ubicacion"
                return String.class;
            case 2: // Columna "Aforo"
                return Integer.class;
            default:
                return Object.class;
        }
    }

    public void setFilas(java.util.List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
        fireTableDataChanged();
    }

    public Restaurante obtenerRestaurante(int i) {
        return this.restaurantes.get(i);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }
    
    
}
