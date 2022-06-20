/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import controlador.Cuestionario;
import enums.Dificultad;


/**
 *
 * @author beni-
 */
public class PanelCuestionario extends javax.swing.JPanel {

    /**
     * Creates new form Cuestionario
     */
    public Cuestionario cuestionario;
    
    public PanelCuestionario( Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
        initComponents();
        this.refrescoPanel();
    }
    
    public PanelCuestionario(){
        this.cuestionario = new Cuestionario();
        initComponents();
    }
    
    public void cambiarDificultad( Dificultad dificultad ) {
        this.cuestionario.setDificultad(dificultad);
        this.cuestionario.resetTest();
        this.refrescoPanel();
    }

    private void refrescoPanel(){ 
        cuestionario.siguientePregunta();
                
        // <-- Preguntas y respuestas -->
        this.lblPregunta.setText(cuestionario.getPreguntaActiva().getCuestion());

        this.rbRespuesta1.setText(cuestionario.getPreguntaActiva().getRespuestas()[0]);
        this.rbRespuesta2.setText(cuestionario.getPreguntaActiva().getRespuestas()[1]);
        this.rbRespuesta3.setText(cuestionario.getPreguntaActiva().getRespuestas()[2]);
        this.rbRespuesta4.setText(cuestionario.getPreguntaActiva().getRespuestas()[3]);

        //<-- Numero de pregunta, aciertos, dificultad  -->
        this.lblDificultad.setText("Dificultad: " + this.cuestionario.getDificultad());
        this.lblNumeroPregunta.setText("\nPregunta: " + this.cuestionario.getIndicePregunta());
        this.lblAciertos.setText(" ");
        
        //<-- Muestro los radioButton -->
        this.setVisibleRB(true);
    }

    private int comprobarRadioButton(){
        int res = 0;
           
        if( rbRespuesta1.isSelected() ) res = 0;
            else if( rbRespuesta2.isSelected() ) res = 1;
                else if( rbRespuesta3.isSelected() ) res = 2;
                    else res = 3;
            
        return res;
    }
    
    private void mostrarResultado( boolean acierto ){
        
        this.lblAciertos.setText("Has acertado");
//        if(acierto) 
//           else this.lblAciertos.setText("Has fallado");
                      
    }
    
    private void finTest(){
         this.lblAciertos.setText("Aciertos: " + cuestionario.getAciertos()  + " de " + cuestionario.getListaPreguntas().size() );
         this.lblPregunta.setText("Pulse siguiente para repetir o cambie la dificultad");
         this.setVisibleRB( false );
         this.cuestionario.finTest();
    }
    
    private void setVisibleRB( boolean visible) {
        this.rbRespuesta1.setVisible(visible);
        this.rbRespuesta2.setVisible(visible);
        this.rbRespuesta3.setVisible(visible);
        this.rbRespuesta4.setVisible(visible);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupRespuestas = new javax.swing.ButtonGroup();
        rbRespuesta1 = new javax.swing.JRadioButton();
        rbRespuesta2 = new javax.swing.JRadioButton();
        rbRespuesta3 = new javax.swing.JRadioButton();
        rbRespuesta4 = new javax.swing.JRadioButton();
        lblPregunta = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        lblAciertos = new javax.swing.JLabel();
        lblNumeroPregunta = new javax.swing.JLabel();
        lblDificultad = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(755, 300));
        setMinimumSize(new java.awt.Dimension(755, 300));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(755, 300));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbRespuesta1.setBackground(new java.awt.Color(255, 255, 255));
        groupRespuestas.add(rbRespuesta1);
        rbRespuesta1.setText(cuestionario.getPreguntaActiva().getRespuestas()[0]);
        rbRespuesta1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(rbRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        rbRespuesta2.setBackground(new java.awt.Color(255, 255, 255));
        groupRespuestas.add(rbRespuesta2);
        rbRespuesta2.setText(cuestionario.getPreguntaActiva().getRespuestas()[1]);
        rbRespuesta2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(rbRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        rbRespuesta3.setBackground(new java.awt.Color(255, 255, 255));
        groupRespuestas.add(rbRespuesta3);
        rbRespuesta3.setText(cuestionario.getPreguntaActiva().getRespuestas()[2]);
        rbRespuesta3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(rbRespuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        rbRespuesta4.setBackground(new java.awt.Color(255, 255, 255));
        groupRespuestas.add(rbRespuesta4);
        rbRespuesta4.setText(cuestionario.getPreguntaActiva().getRespuestas()[3]);
        rbRespuesta4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(rbRespuesta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        lblPregunta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPregunta.setText(cuestionario.getPreguntaActiva().getCuestion());
        add(lblPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 700, 32));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, -1, -1));
        btnSiguiente.getAccessibleContext().setAccessibleName("btnSiguiente");

        add(lblAciertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 160, 10));

        lblNumeroPregunta.setText("Pregunta: " + this.cuestionario.getIndicePregunta());
        add(lblNumeroPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 330, 20));

        lblDificultad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDificultad.setForeground(new java.awt.Color(102, 102, 102));
        lblDificultad.setText("Dificultad "+ cuestionario.getDificultad().toString().toLowerCase());
        add(lblDificultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 330, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        
        int res;
        
        // <-- Si hay alguna respuesta seleccionada continua -->
        if( this.groupRespuestas.getSelection() != null ) {
            
            // <-- Comprobación RadioButton -->
            res = this.comprobarRadioButton();

            boolean acierto = cuestionario.verificarRespuesta(res);
            
            System.err.println(acierto);
            
            this.mostrarResultado(acierto);

            // <-- Quito la seleccion del grupo de radioButton -->
            groupRespuestas.clearSelection();

            // <-- Si hay mas preguntas continua de lo contrario muestra el resultado -->
            if( this.cuestionario.getIndicePregunta() < cuestionario.getListaPreguntas().size() ) 
                this.refrescoPanel();
            
            else 
                this.finTest();
        }
        else if ( cuestionario.getFinTest() ) {
            this.refrescoPanel();
        }
        
        
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup groupRespuestas;
    private javax.swing.JLabel lblAciertos;
    private javax.swing.JLabel lblDificultad;
    private javax.swing.JLabel lblNumeroPregunta;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JRadioButton rbRespuesta1;
    private javax.swing.JRadioButton rbRespuesta2;
    private javax.swing.JRadioButton rbRespuesta3;
    private javax.swing.JRadioButton rbRespuesta4;
    // End of variables declaration//GEN-END:variables
}
