/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import modelos.*;

/**
 *
 * @author Eourist
 */
public class ListadoOrdenesView extends javax.swing.JInternalFrame implements View{
    DefaultTableModel tableModel;
    /**
     * Creates new form ListadoOrdenesView
     */
    public ListadoOrdenesView() {
        tableModel = new DefaultTableModel();
        initComponents();
        llenarDesplegableAños();
        llenarDesplegableMeses();
        llenarDesplegableDias();
        llenarDesplegableAfiliados();
        llenarDesplegablePrestadores();
        armarEncabezados();
        llenarTabla();
        jCheckBoxFiltroFecha.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrdenes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxDia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxAño = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxAfiliado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxPrestador = new javax.swing.JComboBox<>();
        jCheckBoxFiltroFecha = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Listado de ordenes");

        jTableOrdenes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableOrdenes);

        jLabel1.setText("Dia:");

        jComboBoxDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actualizarTabla(evt);
            }
        });

        jLabel2.setText("Mes:");

        jComboBoxMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actualizarTabla(evt);
                actualizarDias(evt);
            }
        });

        jLabel3.setText("Año:");

        jComboBoxAño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actualizarTabla(evt);
                actualizarDias(evt);
            }
        });

        jLabel4.setText("Afiliado:");

        jComboBoxAfiliado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actualizarTabla(evt);
            }
        });

        jLabel5.setText("Prestador:");

        jComboBoxPrestador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actualizarTabla(evt);
            }
        });

        jCheckBoxFiltroFecha.setText("Filtrar por fecha");
        jCheckBoxFiltroFecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxFiltroFechaItemStateChanged(evt);
                actualizarTabla(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jCheckBoxFiltroFecha)
                            .addGap(98, 98, 98)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxAño, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxFiltroFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarTabla(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actualizarTabla
        llenarTabla();
    }//GEN-LAST:event_actualizarTabla

    private void jCheckBoxFiltroFechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxFiltroFechaItemStateChanged
        boolean activo = jCheckBoxFiltroFecha.isSelected();
        jComboBoxDia.setEnabled(activo);
        jComboBoxMes.setEnabled(activo);
        jComboBoxAño.setEnabled(activo);
    }//GEN-LAST:event_jCheckBoxFiltroFechaItemStateChanged

    private void actualizarDias(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actualizarDias
        llenarDesplegableDias();
    }//GEN-LAST:event_actualizarDias

    private void armarEncabezados(){
        ArrayList<Object> ob = new ArrayList<Object>();
        ob.add("Afiliado");
        ob.add("Prestador");
        ob.add("Fecha");
        ob.add("Hora");
        ob.add("Pago");
        
        for(Object o : ob){
            tableModel.addColumn(o);
        }
        jTableOrdenes.setModel(tableModel);
    }
    
    private void llenarTabla(){
        for (int i = tableModel.getRowCount(); i > 0; i--){
            tableModel.removeRow(i-1);
        }
        
        Afiliado afiliado = (Afiliado)jComboBoxAfiliado.getSelectedItem();
        Prestador prestador = (Prestador)jComboBoxPrestador.getSelectedItem();
        if (1+jComboBoxMes.getSelectedIndex() == 0 || 1+jComboBoxDia.getSelectedIndex() == 0 || afiliado == null || prestador == null)
            return;
        LocalDate fecha;
        try {
        fecha = LocalDate.of(Integer.parseInt((String)jComboBoxAño.getSelectedItem()), Month.of(1+jComboBoxMes.getSelectedIndex()), 1+jComboBoxDia.getSelectedIndex());
        } catch (DateTimeException e ){
            jComboBoxDia.setSelectedIndex(27);
            fecha = LocalDate.of(Integer.parseInt((String)jComboBoxAño.getSelectedItem()), Month.of(1+jComboBoxMes.getSelectedIndex()), 28);
        }
        OrdenData od = new OrdenData();
        ArrayList<Orden> tablaMostrada = new ArrayList<>();
        
        boolean filtroFecha = jCheckBoxFiltroFecha.isSelected();
        boolean filtroAfiliado = afiliado.getId() != -1;
        boolean filtroPrestador = prestador.getId() != -1;
        
        if (!filtroFecha && !filtroAfiliado && !filtroPrestador){
            // Sin filtro
            tablaMostrada = od.obtenerOrdenes();
        } else if (filtroFecha && filtroAfiliado && filtroPrestador){
            // Todos los filtros
            tablaMostrada = od.obtenerOrdenesAfiliadoPrestadorFecha(afiliado, prestador, fecha);
        } else if (!filtroFecha){
            if (filtroAfiliado && filtroPrestador){
                // Filtrar por afiliado y prestador
                tablaMostrada = od.obtenerOrdenesAfiliadoPrestador(afiliado, prestador);
            } else if (filtroAfiliado && !filtroPrestador){
                // Filtrar solo por afiliado
                tablaMostrada = od.obtenerOrdenesAfiliado(afiliado);
            } else {
                // Filtrar solo por prestador   
                tablaMostrada = od.obtenerOrdenesPrestador(prestador);
            }
        } else if (!filtroAfiliado){
            if (filtroFecha && filtroPrestador){
                // Filtrar por fecha y prestador
                tablaMostrada = od.obtenerOrdenesPrestadorFecha(prestador, fecha);
            } else if (filtroFecha && !filtroPrestador){
                // Filtrar solo por fecha
                tablaMostrada = od.obtenerOrdenesFecha(fecha);
            } else {
                // Filtrar solo por prestador
                tablaMostrada = od.obtenerOrdenesPrestador(prestador);
            }
        } else if (!filtroPrestador){
            if (filtroFecha && filtroAfiliado){
                // Filtrar por fecha y afiliado
                tablaMostrada = od.obtenerOrdenesAfiliadoFecha(afiliado, fecha);
            } else if (filtroFecha && !filtroAfiliado){
                // Filtrar solo por fecha
                tablaMostrada = od.obtenerOrdenesFecha(fecha);
            } else {
                // Filtrar solo por afiliado
                tablaMostrada = od.obtenerOrdenesAfiliado(afiliado);
            }
        } else {
            System.out.println("EEEEEEEEERRRRRROOOOOOOOORRRRRRRR");
        }
        
        for (Orden o : tablaMostrada)
            tableModel.addRow(new Object[]{o.getAfiliado().getNombre(), o.getHorario().getPrestador(), fecha.toString(), o.getHorario().toString(), o.isEfectivo() ? "Efectivo" : "Contado"});
    }
    
    private void llenarDesplegableAfiliados(){
        ArrayList<Afiliado> afiliados = AfiliadoData.obtenerAfiliados(false);
        
        jComboBoxAfiliado.removeAllItems();
        jComboBoxAfiliado.addItem(new Afiliado(-1, "Todos seleccionados", true));
        for (Afiliado a : afiliados){
            jComboBoxAfiliado.addItem(a);
        }
    }
    
    private void llenarDesplegablePrestadores(){
        ArrayList<Prestador> prestadores = new PrestadorData().obtenerPrestadores(false);
        
        jComboBoxPrestador.removeAllItems();
        jComboBoxPrestador.addItem(new Prestador(-1, "Todos seleccionados", new Especialidad("NULL"),true));
        for (Prestador p : prestadores){
            jComboBoxPrestador.addItem(p);
        }
    }
    
    private void llenarDesplegableDias(){
        int diaSeleccionado = jComboBoxDia.getSelectedIndex();
        int mesSeleccionado = jComboBoxMes.getSelectedIndex()+1;
        int dias = 0;
        switch(mesSeleccionado){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                dias = 31;
                break;
            case 2:
                dias = 28;
                if (Integer.parseInt((String)jComboBoxAño.getSelectedItem()) % 4 == 0)
                    dias = 29;
                break;
            default:
                dias = 30;
                break;
        }
        
        jComboBoxDia.removeAllItems();
        for (int i = 1; i <= dias; i++){
            jComboBoxDia.addItem(String.valueOf(i));
        }
        
        if (jComboBoxDia.getItemAt(diaSeleccionado) != null){
            jComboBoxDia.setSelectedIndex(diaSeleccionado);
        }
    }
    
    private void llenarDesplegableMeses(){
        jComboBoxMes.removeAllItems();
        for (int i = 1; i <= 12; i++){
            jComboBoxMes.addItem(String.valueOf(i));
        }
        
        /*jComboBoxMes.addItem("Enero");
        jComboBoxMes.addItem("Febrero");
        jComboBoxMes.addItem("Marzo");
        jComboBoxMes.addItem("Abril");
        jComboBoxMes.addItem("Mayo");
        jComboBoxMes.addItem("Junio");
        jComboBoxMes.addItem("Julio");
        jComboBoxMes.addItem("Agosto");
        jComboBoxMes.addItem("Septiembre");
        jComboBoxMes.addItem("Octubre");
        jComboBoxMes.addItem("Noviembre");
        jComboBoxMes.addItem("Diciembre");*/
    }
    
    private void llenarDesplegableAños(){
        int añoActual = LocalDate.now().getYear();
        
        jComboBoxAño.removeAllItems();
        for (int i = añoActual-2; i <= añoActual+2; i++){
            jComboBoxAño.addItem(String.valueOf(i));
        }
        jComboBoxAño.setSelectedIndex(2);
    }
    
    @Override
    public void actualizarValores(){
        System.out.println("Se actualizo la vista de Listado de ordenes");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxFiltroFecha;
    private javax.swing.JComboBox<Afiliado> jComboBoxAfiliado;
    private javax.swing.JComboBox<String> jComboBoxAño;
    private javax.swing.JComboBox<String> jComboBoxDia;
    private javax.swing.JComboBox<String> jComboBoxMes;
    private javax.swing.JComboBox<Prestador> jComboBoxPrestador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOrdenes;
    // End of variables declaration//GEN-END:variables
}
