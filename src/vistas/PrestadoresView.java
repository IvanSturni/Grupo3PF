/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.*;
import java.util.ArrayList;
import modelos.*;
/**
 *
 * @author Eourist
 */
public class PrestadoresView extends javax.swing.JInternalFrame implements View {
    private boolean prestadorSeleccionado = false;
    /**
     * Creates new form PrestadoresView
     */
    public PrestadoresView() {
        initComponents();
        llenarDesplegableEspecialidades();
        llenarDesplegablePrestadores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxPrestadores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTipo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDNIFormulario = new javax.swing.JTextField();
        jComboBoxEspecialidades = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabelMensaje = new javax.swing.JLabel();
        jButtonHorarios = new javax.swing.JButton();
        jButtonDeshabilitar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jTextFieldDNIBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Administracion de prestadores");
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

        jComboBoxPrestadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPrestadoresItemStateChanged(evt);
            }
        });

        jLabel1.setText("Buscar por DNI:");

        jLabelTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTipo.setText("Creación/Edición");

        jLabel3.setText("Nombre:");

        jLabel4.setText("DNI:");

        jTextFieldDNIFormulario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDNIFormularioKeyTyped(evt);
            }
        });

        jLabel5.setText("Especialidad:");

        jLabelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonHorarios.setText("Gestionar horarios");

        jButtonDeshabilitar.setText("Deshabilitar");
        jButtonDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeshabilitarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jTextFieldDNIBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDNIBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDNIBusquedaKeyTyped(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccionar prestador a modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabelMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonHorarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeshabilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardar))
                    .addComponent(jLabelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDNIFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDNIBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPrestadores, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPrestadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDNIBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTipo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDNIFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHorarios)
                    .addComponent(jButtonDeshabilitar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPrestadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPrestadoresItemStateChanged
        if ((Prestador)jComboBoxPrestadores.getSelectedItem() == null)
            return;
        
        Prestador p = ((Prestador)jComboBoxPrestadores.getSelectedItem());
        if (p.getId() != -1){
            prestadorSeleccionado = true;
            llenarDatosPrestador(p);
            jLabelTipo.setText("Edición del prestador: " + p.getNombre());
        } else {
            prestadorSeleccionado = false;
            vaciarDatosPrestador();
            jLabelTipo.setText("Creación de prestador");
        }
    }//GEN-LAST:event_jComboBoxPrestadoresItemStateChanged

    private void jTextFieldDNIBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDNIBusquedaKeyTyped
        String dni = jTextFieldDNIBusqueda.getText() + evt.getKeyChar();
        boolean dniInvalido = false;
        
        if (!Character.isDigit(evt.getKeyChar()) || dni.length() > 8){
            evt.consume();
        }
        else if (dni.length() == 8){
            PrestadorData pd = new PrestadorData();
            Prestador p = pd.obtenerPrestadorDNI(Integer.parseInt(dni));
            if (p != null){
                llenarDatosPrestador(p);
                evt.consume();
            } else {
                dniInvalido = true;
            }
        } else {
            dniInvalido = true;
        }
        
        if (dniInvalido && jComboBoxPrestadores.getSelectedIndex() != 0){
            String texto = jTextFieldDNIBusqueda.getText();
            jComboBoxPrestadores.setSelectedIndex(0);
            jTextFieldDNIBusqueda.setText(texto);
        }
    }//GEN-LAST:event_jTextFieldDNIBusquedaKeyTyped

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        PrestadorData pd = new PrestadorData();
        Prestador p;
        if (prestadorSeleccionado){
            if (jTextFieldDNIFormulario.getText().length() == 8 && !jTextFieldNombre.getText().equals("") && jComboBoxEspecialidades.getSelectedIndex() != 0){
                p = (Prestador)jComboBoxPrestadores.getSelectedItem();
                p.setDni(Integer.valueOf(jTextFieldDNIFormulario.getText()));
                p.setNombre(jTextFieldNombre.getText());
                p.setEspecialidad((Especialidad)jComboBoxEspecialidades.getSelectedItem());
                
                pd.actualizarPrestador(p.getId(), p);
                jLabelMensaje.setText("Prestador editado correctamente");
                jLabelTipo.setText("Edición del prestador: " + p.getNombre());
            } else {
                jLabelMensaje.setText("Error al editar: datos del formulario incompletos");
            }
        } else {
            if (jTextFieldDNIFormulario.getText().length() == 8 && !jTextFieldNombre.getText().equals("") && jComboBoxEspecialidades.getSelectedIndex() != 0){
                p = new Prestador(
                    Integer.valueOf(jTextFieldDNIFormulario.getText()), 
                    jTextFieldNombre.getText(), 
                    (Especialidad)jComboBoxEspecialidades.getSelectedItem(), true);
                
                pd.altaPrestador(p);
                jLabelMensaje.setText("Prestador creado correctamente");
                jComboBoxPrestadores.addItem(p);
                llenarDatosPrestador(p);
            } else {
                jLabelMensaje.setText("Error al guardar: datos del formulario incompletos");
            }
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        if (prestadorSeleccionado){
            PrestadorData pd = new PrestadorData();
            Prestador p = (Prestador)jComboBoxPrestadores.getSelectedItem();
            pd.bajaPrestador(p.getId());
            jComboBoxPrestadores.removeItem(p);
            jLabelMensaje.setText("Prestador eliminado correctamente");
            vaciarDatosPrestador();
        } else {
            jLabelMensaje.setText("Error al eliminar: no se encontro un prestador");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeshabilitarActionPerformed
        if (prestadorSeleccionado){
            PrestadorData pd = new PrestadorData();
            Prestador p = (Prestador)jComboBoxPrestadores.getSelectedItem();
            p.setActivo(!p.isActivo());
            pd.actualizarPrestador(p.getId(), p);
            
            if (p.isActivo()){
                jLabelMensaje.setText("Prestador habilitado correctamente");
                jButtonDeshabilitar.setText("Deshabilitar");
            }
            else{
                jLabelMensaje.setText("Prestador deshabilitado correctamente");
                jButtonDeshabilitar.setText("Habilitar");
            }
        } else {
            jLabelMensaje.setText("Error al deshabilitar: no se encontro un prestador");
        }
    }//GEN-LAST:event_jButtonDeshabilitarActionPerformed

    private void jTextFieldDNIFormularioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDNIFormularioKeyTyped
        String dni = jTextFieldDNIFormulario.getText() + evt.getKeyChar();
        
        if (!Character.isDigit(evt.getKeyChar()) || dni.length() > 8)
            evt.consume();
    }//GEN-LAST:event_jTextFieldDNIFormularioKeyTyped

    private void jTextFieldDNIBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDNIBusquedaKeyReleased
        if (evt.getKeyCode() == 8 && jComboBoxPrestadores.getSelectedIndex() != 0){
            String texto = jTextFieldDNIBusqueda.getText();
            jComboBoxPrestadores.setSelectedIndex(0);
            jTextFieldDNIBusqueda.setText(texto);
        }
    }//GEN-LAST:event_jTextFieldDNIBusquedaKeyReleased

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        /*int indEsp = jComboBoxEspecialidades.getSelectedIndex();
        Especialidad objEsp = (Especialidad)jComboBoxEspecialidades.getSelectedItem();
        llenarDesplegableEspecialidades();
        if (jComboBoxEspecialidades.getItemAt(indEsp).equals(objEsp))
            jComboBoxEspecialidades.setSelectedIndex(indEsp);
        
        int indPre = jComboBoxPrestadores.getSelectedIndex();
        Prestador objPre = (Prestador)jComboBoxPrestadores.getSelectedItem();
        llenarDesplegablePrestadores();
        if (jComboBoxPrestadores.getItemAt(indPre).equals(objPre))
            jComboBoxPrestadores.setSelectedIndex(indPre);*/
    }//GEN-LAST:event_formInternalFrameActivated
    
    
    private void llenarDatosPrestador(Prestador p){
        jTextFieldDNIBusqueda.setText(String.valueOf(p.getDni()));
        jTextFieldDNIFormulario.setText(String.valueOf(p.getDni()));
        jTextFieldNombre.setText(p.getNombre());
        if (p.isActivo())
            jButtonDeshabilitar.setText("Deshabilitar");
        else
            jButtonDeshabilitar.setText("Habilitar");
        
        if (((Prestador)jComboBoxPrestadores.getSelectedItem()).getId() != p.getId()){
            for (int i = 0; i < jComboBoxPrestadores.getItemCount(); i++){
                if (jComboBoxPrestadores.getItemAt(i).getId() == p.getId()){
                    jComboBoxPrestadores.setSelectedIndex(i);
                    break;
                }
            }
        }
        
        if (p.getEspecialidad() != null && ((Especialidad)jComboBoxEspecialidades.getSelectedItem()).getId() != p.getEspecialidad().getId()){
            for (int i = 0; i < jComboBoxEspecialidades.getItemCount(); i++){
                if (jComboBoxEspecialidades.getItemAt(i).getId() == p.getEspecialidad().getId()){
                    jComboBoxEspecialidades.setSelectedIndex(i);
                    break;
                }
            } 
        }
    }
    
    private void vaciarDatosPrestador(){
        jTextFieldDNIBusqueda.setText("");
        jTextFieldDNIFormulario.setText("");
        jTextFieldNombre.setText("");
        jButtonDeshabilitar.setText("Deshabilitar");
        
        if (((Prestador)jComboBoxPrestadores.getSelectedItem()).getId() != -1){
            for (int i = 0; i < jComboBoxPrestadores.getItemCount(); i++){
                if (jComboBoxPrestadores.getItemAt(i).getId() == -1){
                    jComboBoxPrestadores.setSelectedIndex(i);
                    break;
                }
            }
        }
        
        if (((Especialidad)jComboBoxEspecialidades.getSelectedItem()).getId() != -1){
            for (int i = 0; i < jComboBoxEspecialidades.getItemCount(); i++){
                if (jComboBoxEspecialidades.getItemAt(i).getId() == -1){
                    jComboBoxEspecialidades.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    private void llenarDesplegablePrestadores(){
        ArrayList<Prestador> prestadores = new ArrayList<>();
        PrestadorData pd = new PrestadorData();
        prestadores = pd.obtenerPrestadores(true);
        
        jComboBoxPrestadores.removeAllItems();
        Prestador placeholder = new Prestador(0000000, "Ninguno seleccionado", new Especialidad("NULL"), true);
        jComboBoxPrestadores.addItem(placeholder);
        jComboBoxPrestadores.setSelectedItem(placeholder);
        for (Prestador p : prestadores){
            jComboBoxPrestadores.addItem(p);
        }
    }
    
    private void llenarDesplegableEspecialidades(){
        ArrayList<Especialidad> especialidades = new ArrayList<>();
        EspecialidadData ed = new EspecialidadData();
        especialidades = ed.obtenerEspecialidades();
        
        jComboBoxEspecialidades.removeAllItems();
        Especialidad placeholder = new Especialidad("Seleccionar especialidad");
        jComboBoxEspecialidades.addItem(placeholder);
        jComboBoxEspecialidades.setSelectedItem(placeholder);
        for (Especialidad e : especialidades){
            jComboBoxEspecialidades.addItem(e);
        }
    }
    
    @Override
    public void actualizarValores(){
        System.out.println("Se actualizo la vista de Prestadores");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeshabilitar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonHorarios;
    private javax.swing.JComboBox<Especialidad> jComboBoxEspecialidades;
    private javax.swing.JComboBox<Prestador> jComboBoxPrestadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldDNIBusqueda;
    private javax.swing.JTextField jTextFieldDNIFormulario;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
