/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import app.Ventana;
import clases.Pregunta;
import controlador.Cuestionario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author beni-
 */
public class PanelModificarPregrunta extends javax.swing.JPanel {

    Cuestionario cuestionario;
    int indice;
    Ventana ventana;
    Pregunta p;

    public PanelModificarPregrunta() throws SQLException {
        this.cuestionario = new Cuestionario();
        initComponents();
    }
    
    public PanelModificarPregrunta( Ventana ventana , int indice) {
        this.cuestionario = ventana.getCuestionario();
        this.ventana = ventana;
        this.indice = indice;
        initComponents();
        
        this.rellenarDatos();
    }
    
    private void rellenarDatos(){
        p = this.cuestionario.getListaPreguntas().get(indice);
        this.txtPregunta.setText(p.getCuestion());
        this.txtRespuesta1.setText(p.getRespuestas()[0]);
        this.txtrespuesta2.setText(p.getRespuestas()[1]);
        this.txtRespuesta3.setText(p.getRespuestas()[2]);
        this.txtRespuesta4.setText(p.getRespuestas()[3]);
        
        this.establecerCorrecta(p);
    }
    
    private boolean comprobarCamposRellenos() {
       
        if( this.rbGroupCorrecta.getSelection() != null )
                if( this.txtPregunta.toString().length() > 4 
                    && this.txtRespuesta1.toString().length() > 4
                    && this.txtrespuesta2.toString().length() > 4
                    && this.txtRespuesta3.toString().length() > 4
                    && this.txtRespuesta4.toString().length() > 4 
                ) return true;
        
        return false;
    }
   
    private int correctaSeleccionada(){
        if( this.rbCorrecta0.isSelected() ) return 0;
        if( this.rbCorrecta1.isSelected() ) return 1;
        if( this.rbCorrecta2.isSelected() ) return 2;
        if( this.rbCorrecta3.isSelected() ) return 3;
        return -1;
    }
    
    private String[] getNuevasRespuestas() {
        
        String[] respuestas = new String[]{
            this.txtRespuesta1.getText(),
            this.txtrespuesta2.getText(),
            this.txtRespuesta3.getText(),
            this.txtRespuesta4.getText()
        };
        
        return respuestas;
    }
    
    private void limpiarPanel(){
        this.rbGroupCorrecta.clearSelection();
        this.rbGroupDificultad.clearSelection();
        this.txtPregunta.setText("");
        this.txtRespuesta1.setText("");
        this.txtrespuesta2.setText("");
        this.txtRespuesta3.setText("");
        this.txtRespuesta4.setText("");
        this.btnGuardar.setEnabled(false);
    }
    
    private void establecerCorrecta( Pregunta p ){
        int correcta = p.getRespuestaCorrecta();
        
        switch (correcta) {
            case 0: this.rbGroupCorrecta.setSelected(rbCorrecta0.getModel(), true);
                break;
            case 1: this.rbGroupCorrecta.setSelected(rbCorrecta1.getModel(), true);
                break;
            case 2: this.rbGroupCorrecta.setSelected(rbCorrecta2.getModel(), true);
                break;
            case 3: this.rbGroupCorrecta.setSelected(rbCorrecta3.getModel(), true);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroupCorrecta = new javax.swing.ButtonGroup();
        rbGroupDificultad = new javax.swing.ButtonGroup();
        txtPregunta = new javax.swing.JTextField();
        txtRespuesta1 = new javax.swing.JTextField();
        txtrespuesta2 = new javax.swing.JTextField();
        txtRespuesta3 = new javax.swing.JTextField();
        txtRespuesta4 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        rbCorrecta0 = new javax.swing.JRadioButton();
        rbCorrecta1 = new javax.swing.JRadioButton();
        rbCorrecta2 = new javax.swing.JRadioButton();
        rbCorrecta3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        txtPregunta.setMaximumSize(new java.awt.Dimension(6, 20));

        txtRespuesta1.setMaximumSize(new java.awt.Dimension(6, 20));

        txtrespuesta2.setMaximumSize(new java.awt.Dimension(6, 20));

        txtRespuesta3.setMaximumSize(new java.awt.Dimension(6, 20));

        txtRespuesta4.setMaximumSize(new java.awt.Dimension(6, 20));

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        rbGroupCorrecta.add(rbCorrecta0);
        rbCorrecta0.setText("Respuesta 1:");

        rbGroupCorrecta.add(rbCorrecta1);
        rbCorrecta1.setText("Respuesta 4:");

        rbGroupCorrecta.add(rbCorrecta2);
        rbCorrecta2.setText("Respuesta 2:");

        rbGroupCorrecta.add(rbCorrecta3);
        rbCorrecta3.setText("Respuesta 3:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar Pregunta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbCorrecta2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbCorrecta3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbCorrecta1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbCorrecta0, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRespuesta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtrespuesta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRespuesta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRespuesta4, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(140, 140, 140)
                                .addComponent(btnGuardar)
                                .addGap(0, 79, Short.MAX_VALUE))
                            .addComponent(txtPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRespuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCorrecta0))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCorrecta2)
                    .addComponent(txtrespuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCorrecta3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRespuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCorrecta1)
                    .addComponent(txtRespuesta4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if( this.comprobarCamposRellenos() ) this.btnGuardar.setEnabled(true);
        else this.btnGuardar.setEnabled(false);    
    }//GEN-LAST:event_formMouseMoved

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
       
        p.setCuestion( txtPregunta.getText() );
        p.setRespuestas( getNuevasRespuestas() );
        p.setRespuestaCorrecta( correctaSeleccionada() );
        p.setDificultad( cuestionario.getDificultad().ordinal() + 1 );

        this.cuestionario.modificar(p);

        JOptionPane.showMessageDialog(null, p.getCuestion() , "Pregunta modificada", WIDTH);
        this.limpiarPanel();
        this.setVisible(false);
        this.ventana.volverCrud();
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbCorrecta0;
    private javax.swing.JRadioButton rbCorrecta1;
    private javax.swing.JRadioButton rbCorrecta2;
    private javax.swing.JRadioButton rbCorrecta3;
    private javax.swing.ButtonGroup rbGroupCorrecta;
    private javax.swing.ButtonGroup rbGroupDificultad;
    private javax.swing.JTextField txtPregunta;
    private javax.swing.JTextField txtRespuesta1;
    private javax.swing.JTextField txtRespuesta3;
    private javax.swing.JTextField txtRespuesta4;
    private javax.swing.JTextField txtrespuesta2;
    // End of variables declaration//GEN-END:variables

    
}

