/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.*;

/**
 *
 * @author Eourist
 */
public class ListadoPrestadoresView extends javax.swing.JInternalFrame implements View{
    DefaultTableModel tableModel;
    ArrayList<Prestador> tablaMostrada;
    /**
     * Creates new form ListadoPrestadoresView
     */
    public ListadoPrestadoresView() {
        initComponents();
        tableModel = new DefaultTableModel();
        armarEncabezados();
        llenarDesplegableEspecialidades();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxEspecialidades = new javax.swing.JComboBox<>();
        jCheckBoxDeshabilitados = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrestadores = new javax.swing.JTable();

        setClosable(true);
        setTitle("Listado de prestadores");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Filtrar por especialidad:");

        jComboBoxEspecialidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEspecialidadesItemStateChanged(evt);
            }
        });

        jCheckBoxDeshabilitados.setText("Mostrar inactivos");
        jCheckBoxDeshabilitados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxDeshabilitadosItemStateChanged(evt);
            }
        });

        jTablePrestadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablePrestadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEspecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxDeshabilitados))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxDeshabilitados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEspecialidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEspecialidadesItemStateChanged
        if (jComboBoxEspecialidades.getSelectedItem() != null)
            llenarTabla();
    }//GEN-LAST:event_jComboBoxEspecialidadesItemStateChanged

    private void jCheckBoxDeshabilitadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxDeshabilitadosItemStateChanged
        llenarTabla();
    }//GEN-LAST:event_jCheckBoxDeshabilitadosItemStateChanged

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        int indEsp = jComboBoxEspecialidades.getSelectedIndex();
        Especialidad objEsp = (Especialidad)jComboBoxEspecialidades.getSelectedItem();
        llenarDesplegableEspecialidades();
        if (jComboBoxEspecialidades.getItemAt(indEsp).equals(objEsp))
            jComboBoxEspecialidades.setSelectedIndex(indEsp);
        
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameActivated
    
    private void llenarTabla(){
        Especialidad esp = (Especialidad)jComboBoxEspecialidades.getSelectedItem();
        boolean mostrarDeshabilitados = jCheckBoxDeshabilitados.isSelected();
        
        for (int i = tableModel.getRowCount(); i > 0; i--){
            tableModel.removeRow(i-1);
        }
        
        PrestadorData pd = new PrestadorData();
        
        if (esp.getId() == -1){
            System.out.println("Se muestran todas");
            tablaMostrada = pd.obtenerPrestadores(mostrarDeshabilitados);
        } else {
            System.out.println("Se muestran solo las de la especialidad " + esp.getNombre());
            tablaMostrada = pd.obtenerPrestadoresEspecialidad(esp, mostrarDeshabilitados);
        }
        
        for (Prestador p : tablaMostrada){
            tableModel.addRow(new Object[]{p.getDni(), p.getNombre(), p.getEspecialidad() != null ? p.getEspecialidad().getNombre() : "", (p.isActivo() ? "Si" : "No")});
        }
    }
    
    private void armarEncabezados(){
        ArrayList<Object> ob = new ArrayList<Object>();
        ob.add("DNI");
        ob.add("Nombre");
        ob.add("Especialidad");
        ob.add("Activo");
        
        for(Object o : ob){
            tableModel.addColumn(o);
        }
        jTablePrestadores.setModel(tableModel);
    }
    
    private void llenarDesplegableEspecialidades(){
        ArrayList<Especialidad> especialidades = new ArrayList<>();
        EspecialidadData ed = new EspecialidadData();
        especialidades = ed.obtenerEspecialidades();
        
        jComboBoxEspecialidades.removeAllItems();
        Especialidad placeholder = new Especialidad("Todas seleccionadas");
        jComboBoxEspecialidades.addItem(placeholder);
        jComboBoxEspecialidades.setSelectedItem(placeholder);
        for (Especialidad e : especialidades){
            jComboBoxEspecialidades.addItem(e);
        }
    }
    
    @Override
    public void actualizarValores(){
        System.out.println("Se actualizo la vista de Listado de prestadores");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxDeshabilitados;
    private javax.swing.JComboBox<Especialidad> jComboBoxEspecialidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrestadores;
    // End of variables declaration//GEN-END:variables
}
