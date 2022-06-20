/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import app.Ventana;
import clases.Pregunta;
import controlador.Cuestionario;
import enums.Dificultad;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

/**
 *
 * @author beni-
 */
public class PanelCRUD extends javax.swing.JPanel {

    Cuestionario cuestionario;
    PanelModificarPregrunta panelModificar;
    Ventana ventana;
    
    
    public PanelCRUD() throws SQLException {
        cuestionario = new Cuestionario();
        initComponents();
        this.refrescoLista();
    }
    
    public PanelCRUD( Ventana ventana, Cuestionario cuestionario ) { 
        this.cuestionario = cuestionario;
        this.ventana = ventana;
        initComponents();    
        this.refrescoLista();
    }
    
    public void cambiarDificultad( Dificultad dificultad ) {
        this.cuestionario.setDificultad(dificultad);
        this.refrescoLista();
    }
    
    private void refrescoLista(){ 
      
        // <-- Nombre lista -->
        
        this.lblTest.setText("Test "+ cuestionario.getDificultad());
        
        // <-- Generando lista -->
      
        DefaultListModel modelo = new DefaultListModel();
        
        cuestionario.getCuestiones().forEach((cuestion) -> {
            modelo.addElement(cuestion);
        });

        this.listPreguntas.setModel(modelo);        
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listPreguntas = new javax.swing.JList<>();
        btnVolver = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNueva = new javax.swing.JButton();
        lblTest = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(755, 300));
        setMinimumSize(new java.awt.Dimension(755, 300));
        setPreferredSize(new java.awt.Dimension(755, 300));

        listPreguntas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listPreguntas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPreguntasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPreguntas);

        btnVolver.setText("Volver");
        btnVolver.setMaximumSize(new java.awt.Dimension(75, 23));
        btnVolver.setMinimumSize(new java.awt.Dimension(75, 23));
        btnVolver.setPreferredSize(new java.awt.Dimension(75, 23));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.setEnabled(false);
        btnBorrar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnBorrar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnBorrar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnNueva.setText("Nueva");
        btnNueva.setMaximumSize(new java.awt.Dimension(75, 23));
        btnNueva.setMinimumSize(new java.awt.Dimension(75, 23));
        btnNueva.setPreferredSize(new java.awt.Dimension(75, 23));
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        lblTest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTest.setText("Test Facil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNueva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ventana.abrirTest();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int ind = this.listPreguntas.getSelectedIndex();
        this.panelModificar = new PanelModificarPregrunta( this.ventana , ind );
        this.ventana.setPanelModificar(panelModificar);
        this.ventana.setPanelActivo(this.panelModificar);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
       
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void listPreguntasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPreguntasValueChanged
        if( !this.listPreguntas.isSelectionEmpty() ) {
            this.btnBorrar.setEnabled(true);
            this.btnModificar.setEnabled(true);
        }
        else{
            this.btnBorrar.setEnabled(false);
            this.btnModificar.setEnabled(false);
        }
        

    }//GEN-LAST:event_listPreguntasValueChanged

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int indice = this.listPreguntas.getSelectedIndex();
        
        Pregunta p = this.cuestionario.getListaPreguntas().get(indice);
        
        this.cuestionario.borrar(p);
        this.refrescoLista();
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTest;
    private javax.swing.JList<String> listPreguntas;
    // End of variables declaration//GEN-END:variables

}
