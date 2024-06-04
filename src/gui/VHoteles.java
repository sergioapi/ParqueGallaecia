/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import pojos.Hotel;

/**
 *
 * @author alumnogreibd
 */
public class VHoteles extends javax.swing.JFrame {
    private VPrincipal padre;
    private aplicacion.FachadaAplicacion fa;
    /**
     * Creates new form VHoteles
     */
    public VHoteles(VPrincipal vp, aplicacion.FachadaAplicacion fa) {
        this.padre = vp;
        this.fa = fa;
        initComponents();
        // Desactiva el botón de inserción por defecto
        tablaBusqueda.setModel(new ModeloTablaHoteles());
        btnInsertar.setEnabled(false);
        addCamposCompletosListener();
        jLabel1Estrella.setVisible(false);
        jLabel2Estrellas.setVisible(false);
        jLabel3Estrellas.setVisible(false);
        jLabel4Estrellas.setVisible(false);
        jLabel5Estrellas.setVisible(false);
        jLabel1EstrellasBuscar.setVisible(false);
        jLabel2EstrellasBuscar.setVisible(false);
        jLabel3EstrellasBuscar.setVisible(false);
        jLabel4EstrellasBuscar.setVisible(false);
        jLabel5EstrellasBuscar.setVisible(false);
        
    }
    
    private void addCamposCompletosListener() {
        List<JTextField> listaTextField = new ArrayList();
        listaTextField.add(jTextFieldNombreNuevo);
        listaTextField.add(jTextFieldUbicacionNuevo);
        listaTextField.add(jTextFieldAforoNuevo);
        // Agrega un DocumentListener a cada uno de los campos de texto
        jTextFieldNombreNuevo.getDocument().addDocumentListener(new CamposCompletosListener(btnInsertar, listaTextField));
        jTextFieldUbicacionNuevo.getDocument().addDocumentListener(new CamposCompletosListener(btnInsertar, listaTextField));
        jTextFieldAforoNuevo.getDocument().addDocumentListener(new CamposCompletosListener(btnInsertar, listaTextField));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTabla = new javax.swing.JPopupMenu();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jMenuItemInsertarVisitante = new javax.swing.JMenuItem();
        jTabbedPaneNuevo = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1Nombre = new javax.swing.JLabel();
        jTextFieldNombreNuevo = new javax.swing.JTextField();
        jLabelUbicacionNuevo = new javax.swing.JLabel();
        jTextFieldUbicacionNuevo = new javax.swing.JTextField();
        jLabelAforoNuevo = new javax.swing.JLabel();
        jTextFieldAforoNuevo = new javax.swing.JTextField();
        jSliderEstrellas = new javax.swing.JSlider();
        jLabelEstrellasNuevo = new javax.swing.JLabel();
        jLabel1Estrella = new javax.swing.JLabel();
        jLabel2Estrellas = new javax.swing.JLabel();
        jLabel3Estrellas = new javax.swing.JLabel();
        jLabel4Estrellas = new javax.swing.JLabel();
        jLabel5Estrellas = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombreBuscar = new javax.swing.JTextField();
        jLabelAforo = new javax.swing.JLabel();
        jTextFieldAforoBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jSliderEstrellasBuscar = new javax.swing.JSlider();
        jLabelEstrellasBuscar = new javax.swing.JLabel();
        jLabel1EstrellasBuscar = new javax.swing.JLabel();
        jLabel3EstrellasBuscar = new javax.swing.JLabel();
        jLabel4EstrellasBuscar = new javax.swing.JLabel();
        jLabel5EstrellasBuscar = new javax.swing.JLabel();
        jLabel2EstrellasBuscar = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        jMenuItemEliminar.setText("Eliminar hotel");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jPopupMenuTabla.add(jMenuItemEliminar);

        jMenuItemInsertarVisitante.setText("Insertar huésped");
        jMenuItemInsertarVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsertarVisitanteActionPerformed(evt);
            }
        });
        jPopupMenuTabla.add(jMenuItemInsertarVisitante);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1Nombre.setText("Nombre");

        jLabelUbicacionNuevo.setText("Ubicación ");

        jLabelAforoNuevo.setText("Aforo");

        jSliderEstrellas.setMaximum(5);
        jSliderEstrellas.setMinimum(1);
        jSliderEstrellas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderEstrellasStateChanged(evt);
            }
        });

        jLabelEstrellasNuevo.setText("Estrellas");

        jLabel1Estrella.setText("1");

        jLabel2Estrellas.setText("2");

        jLabel3Estrellas.setText("3");

        jLabel4Estrellas.setText("4");
        jLabel4Estrellas.setToolTipText("");

        jLabel5Estrellas.setText("5");

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabelEstrellasNuevo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInsertar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelUbicacionNuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldUbicacionNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabelAforoNuevo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel1Estrella)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2Estrellas)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel3Estrellas)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel4Estrellas)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel5Estrellas)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAforoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1Nombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNombreNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSliderEstrellas, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1Nombre)
                    .addComponent(jTextFieldNombreNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUbicacionNuevo)
                    .addComponent(jTextFieldUbicacionNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAforoNuevo)
                    .addComponent(jTextFieldAforoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabelEstrellasNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderEstrellas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4Estrellas)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1Estrella)
                        .addComponent(jLabel2Estrellas)
                        .addComponent(jLabel3Estrellas)
                        .addComponent(jLabel5Estrellas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnInsertar)
                .addGap(28, 28, 28))
        );

        jTabbedPaneNuevo.addTab("Nuevo", jPanel1);

        jLabelNombre.setText("Nombre");

        jLabelAforo.setText("Aforo");

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Ubicación", "Aforo", "Estrellas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaBusquedaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBusqueda);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jSliderEstrellasBuscar.setMaximum(5);
        jSliderEstrellasBuscar.setMinimum(1);
        jSliderEstrellasBuscar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderEstrellasBuscarStateChanged(evt);
            }
        });

        jLabelEstrellasBuscar.setText("Estrellas");

        jLabel1EstrellasBuscar.setText("1");

        jLabel3EstrellasBuscar.setText("3");

        jLabel4EstrellasBuscar.setText("4");

        jLabel5EstrellasBuscar.setText("5");

        jLabel2EstrellasBuscar.setText("2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelAforo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAforoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSliderEstrellasBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1EstrellasBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2EstrellasBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3EstrellasBuscar)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel4EstrellasBuscar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel5EstrellasBuscar)
                                        .addGap(12, 12, 12))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEstrellasBuscar)
                                .addGap(59, 59, 59))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre)
                            .addComponent(jTextFieldNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAforo)
                            .addComponent(jTextFieldAforoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabelEstrellasBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderEstrellasBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4EstrellasBuscar)
                            .addComponent(jLabel5EstrellasBuscar)
                            .addComponent(jLabel1EstrellasBuscar)
                            .addComponent(jLabel3EstrellasBuscar)
                            .addComponent(jLabel2EstrellasBuscar))))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPaneNuevo.addTab("Buscar", jPanel2);

        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Se mostrarán los hoteles con aforo superior al introducido");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        padre.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jSliderEstrellasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderEstrellasStateChanged
        int value = jSliderEstrellas.getValue();
        if(value==1){
            jLabel1Estrella.setVisible(true);
        }
        else{
            jLabel1Estrella.setVisible(false);
        }
        if(value==2){
            jLabel2Estrellas.setVisible(true);
        }
        else{
            jLabel2Estrellas.setVisible(false);
        }
        if(value==3){
            jLabel3Estrellas.setVisible(true);
        }
        else{
            jLabel3Estrellas.setVisible(false);
        }
        if(value==4){
            jLabel4Estrellas.setVisible(true);
        }
        else{
            jLabel4Estrellas.setVisible(false);
        }
        if(value==5){
            jLabel5Estrellas.setVisible(true);
        }
        else{
            jLabel5Estrellas.setVisible(false);
        }
        
    }//GEN-LAST:event_jSliderEstrellasStateChanged

    private void jSliderEstrellasBuscarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderEstrellasBuscarStateChanged
        int value = jSliderEstrellasBuscar.getValue();
        if(value==1){
            jLabel1EstrellasBuscar.setVisible(true);
        }
        else{
            jLabel1EstrellasBuscar.setVisible(false);
        }
        if(value==2){
            jLabel2EstrellasBuscar.setVisible(true);
        }
        else{
            jLabel2EstrellasBuscar.setVisible(false);
        }
        if(value==3){
            jLabel3EstrellasBuscar.setVisible(true);
        }
        else{
            jLabel3EstrellasBuscar.setVisible(false);
        }
        if(value==4){
            jLabel4EstrellasBuscar.setVisible(true);
        }
        else{
            jLabel4EstrellasBuscar.setVisible(false);
        }
        if(value==5){
            jLabel5EstrellasBuscar.setVisible(true);
        }
        else{
            jLabel5EstrellasBuscar.setVisible(false);
        }
    }//GEN-LAST:event_jSliderEstrellasBuscarStateChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarHoteles();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        Hotel hotel = new Hotel(jTextFieldNombreNuevo.getText(), jTextFieldUbicacionNuevo.getText(), Integer.parseInt(jTextFieldAforoNuevo.getText()), jSliderEstrellas.getValue());
        fa.insertarHotel(hotel);
        jTextFieldNombreNuevo.setText("");
        jTextFieldUbicacionNuevo.setText("");
        jTextFieldAforoNuevo.setText("");
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void tablaBusquedaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMousePressed
        if(SwingUtilities.isRightMouseButton(evt)){
            int row = tablaBusqueda.rowAtPoint(evt.getPoint());
            if(row>=0 && row< tablaBusqueda.getRowCount()){
                tablaBusqueda.setRowSelectionInterval(row, row);
                jPopupMenuTabla.show(evt.getComponent(), evt.getX(), evt.getY());
            
            }
        }
    }//GEN-LAST:event_tablaBusquedaMousePressed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        int row = tablaBusqueda.getSelectedRow();
        if(row>0 && row < tablaBusqueda.getRowCount()){
            String nombreHotel = (String) tablaBusqueda.getValueAt(row, 0);
            fa.borrarHotel(nombreHotel);
            buscarHoteles();
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jMenuItemInsertarVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInsertarVisitanteActionPerformed
        int row = tablaBusqueda.getSelectedRow();
        if(row>=0 && row < tablaBusqueda.getRowCount()){
            String nombreHotel = (String) tablaBusqueda.getValueAt(row, 0);
            fa.iniciarInterfazInsertarHuesped(this, nombreHotel);
            setVisible(false);
        }
    }//GEN-LAST:event_jMenuItemInsertarVisitanteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1Estrella;
    private javax.swing.JLabel jLabel1EstrellasBuscar;
    private javax.swing.JLabel jLabel1Nombre;
    private javax.swing.JLabel jLabel2Estrellas;
    private javax.swing.JLabel jLabel2EstrellasBuscar;
    private javax.swing.JLabel jLabel3Estrellas;
    private javax.swing.JLabel jLabel3EstrellasBuscar;
    private javax.swing.JLabel jLabel4Estrellas;
    private javax.swing.JLabel jLabel4EstrellasBuscar;
    private javax.swing.JLabel jLabel5Estrellas;
    private javax.swing.JLabel jLabel5EstrellasBuscar;
    private javax.swing.JLabel jLabelAforo;
    private javax.swing.JLabel jLabelAforoNuevo;
    private javax.swing.JLabel jLabelEstrellasBuscar;
    private javax.swing.JLabel jLabelEstrellasNuevo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelUbicacionNuevo;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemInsertarVisitante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenuTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderEstrellas;
    private javax.swing.JSlider jSliderEstrellasBuscar;
    private javax.swing.JTabbedPane jTabbedPaneNuevo;
    private javax.swing.JTextField jTextFieldAforoBuscar;
    private javax.swing.JTextField jTextFieldAforoNuevo;
    private javax.swing.JTextField jTextFieldNombreBuscar;
    private javax.swing.JTextField jTextFieldNombreNuevo;
    private javax.swing.JTextField jTextFieldUbicacionNuevo;
    private javax.swing.JTable tablaBusqueda;
    // End of variables declaration//GEN-END:variables
public void buscarHoteles(){
    ModeloTablaHoteles m ;

        m=(ModeloTablaHoteles) tablaBusqueda.getModel();
        //tomamos el aforo
        Integer aforo = null;
        String aforo_aux = jTextFieldAforoBuscar.getText();
        if(aforo_aux.length()>0){
            aforo = Integer.parseInt(aforo_aux);
        }
        m.setFilas(fa.obtenerHoteles(jTextFieldNombreBuscar.getText(), aforo, jSliderEstrellasBuscar.getValue()));
}

}