package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojos.Hotel;

public class ModeloTablaHoteles extends AbstractTableModel {

    private List<Hotel> hoteles = new ArrayList<>();

    private String[] columnNames = {"Nombre", "Ubicación", "Aforo", "Estrellas"};

    public ModeloTablaHoteles() {
        this.hoteles = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return hoteles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hotel hotel = hoteles.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return hotel.getNombreEstablecimiento();
            case 1:
                return hotel.getUbicacion();
            case 2:
                return hotel.getAforo();
            case 3:
                return hotel.getEstrellas();
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
            case 3: // Columna estrellas
                return Integer.class;
            default:
                return Object.class;
        }
    }

    public void setFilas(java.util.List<Hotel> hoteles) {
        this.hoteles = hoteles;
        fireTableDataChanged();
    }

    public Hotel obtenerRestaurante(int i) {
        return this.hoteles.get(i);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }
    
    
}
