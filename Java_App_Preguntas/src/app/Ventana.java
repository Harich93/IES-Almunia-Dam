package app;


import controlador.Cuestionario;
import enums.Dificultad;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import paneles.PanelCRUD;
import paneles.PanelCuestionario;
import paneles.PanelModificarPregrunta;
import paneles.PanelNuevaPregunta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author beni-
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    
    Cuestionario cuestionario;
    PanelCRUD panelCrud;
    PanelNuevaPregunta panelNuevaPregunta;
    PanelModificarPregrunta panelModificar;
    JPanel panelActivo;
    
    
    
    public Ventana() throws SQLException {
        this.cuestionario = new Cuestionario();
        
        initComponents();
        
        this.panelActivo = this.panelCuestionario;
    }
    
    public JPanel getPanelActivo() {
        return this.panelActivo;
    }
    
    public void setPanelActivo( JPanel panel ) {
        this.panelActivo = panel;
    }

    public void setPanelModificar( PanelModificarPregrunta panel ){
        this.panelModificar = panel;
        this.panelActivo.setVisible(false);
        this.setContentPane(panelModificar); 
        
        this.panelActivo = this.panelModificar;
    }
    
    
    
    private void salir(){
        int opt = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if( opt == 0 ) {
            cuestionario.cerrarConexion();
            System.exit(0);
        }
    }
    
    public void volver(){
        this.setJMenuBar(this.menuBarCuestionario);
        this.setContentPane(this.panelCuestionario);
    }
    
    public Cuestionario getCuestionario() {
        return this.cuestionario;
    }
    
    public void volverCrud(){
        this.panelCrud = new PanelCRUD( this, cuestionario ); 
        
        this.panelActivo.setVisible(false);
         
        panelCrud.setVisible(true);
        this.setContentPane(this.panelCrud);
       
        
        panelActivo = panelCrud;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuestionario = new paneles.PanelCuestionario();
        menuBarCuestionario = new javax.swing.JMenuBar();
        btnMenuAjustes = new javax.swing.JMenu();
        menubBtnTest = new javax.swing.JMenuItem();
        menuBtnCrearPregunta = new javax.swing.JMenuItem();
        menuBtnCRUD = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuBtnSalir = new javax.swing.JMenuItem();
        menuBtnDificultad = new javax.swing.JMenu();
        menuFacil = new javax.swing.JMenuItem();
        menuIntermedio = new javax.swing.JMenuItem();
        menuAleatorio = new javax.swing.JMenuItem();
        btnMenuModificar = new javax.swing.JMenu();
        menuBtnModificarFacil = new javax.swing.JMenuItem();
        menuBtnModificarIntermedio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(736, 463));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panelCuestionario);

        menuBarCuestionario.setBackground(new java.awt.Color(255, 255, 255));
        menuBarCuestionario.setBorder(null);
        menuBarCuestionario.setForeground(new java.awt.Color(255, 255, 255));

        btnMenuAjustes.setBackground(new java.awt.Color(255, 255, 255));
        btnMenuAjustes.setBorder(null);
        btnMenuAjustes.setText("Ajustes");

        menubBtnTest.setText("Test");
        menubBtnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubBtnTestActionPerformed(evt);
            }
        });
        btnMenuAjustes.add(menubBtnTest);

        menuBtnCrearPregunta.setText("Crear pregunta");
        menuBtnCrearPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnCrearPreguntaActionPerformed(evt);
            }
        });
        btnMenuAjustes.add(menuBtnCrearPregunta);

        menuBtnCRUD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuBtnCRUD.setText("Modificar preguntas");
        menuBtnCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnCRUDActionPerformed(evt);
            }
        });
        btnMenuAjustes.add(menuBtnCRUD);
        btnMenuAjustes.add(jSeparator1);

        menuBtnSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuBtnSalir.setText("Salir");
        menuBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnSalirActionPerformed(evt);
            }
        });
        btnMenuAjustes.add(menuBtnSalir);

        menuBarCuestionario.add(btnMenuAjustes);

        menuBtnDificultad.setText("Dificultad");

        menuFacil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuFacil.setText("Facil");
        menuFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFacilActionPerformed(evt);
            }
        });
        menuBtnDificultad.add(menuFacil);

        menuIntermedio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuIntermedio.setText("Intermedio");
        menuIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIntermedioActionPerformed(evt);
            }
        });
        menuBtnDificultad.add(menuIntermedio);

        menuAleatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuAleatorio.setText("Aleatorio");
        menuAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAleatorioActionPerformed(evt);
            }
        });
        menuBtnDificultad.add(menuAleatorio);

        menuBarCuestionario.add(menuBtnDificultad);

        btnMenuModificar.setText("Modificar");
        btnMenuModificar.setEnabled(false);

        menuBtnModificarFacil.setText("Test facil");
        menuBtnModificarFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnModificarFacilActionPerformed(evt);
            }
        });
        btnMenuModificar.add(menuBtnModificarFacil);

        menuBtnModificarIntermedio.setText("Test Intermedio");
        menuBtnModificarIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnModificarIntermedioActionPerformed(evt);
            }
        });
        btnMenuModificar.add(menuBtnModificarIntermedio);

        menuBarCuestionario.add(btnMenuModificar);

        setJMenuBar(menuBarCuestionario);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIntermedioActionPerformed
        
        this.panelCuestionario.cambiarDificultad(Dificultad.INTERMEDIA);
        
    }//GEN-LAST:event_menuIntermedioActionPerformed

    private void menuFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFacilActionPerformed

        this.panelCuestionario.cambiarDificultad(Dificultad.FACIL);
    }//GEN-LAST:event_menuFacilActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.salir();
    }//GEN-LAST:event_formWindowClosing

    private void menuBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnSalirActionPerformed
        this.salir();
    }//GEN-LAST:event_menuBtnSalirActionPerformed

    private void menuAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAleatorioActionPerformed
        try {
            int opt = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero preguntas", "De 0 a 23 - Si no es correcto 23"));
            if( opt > 23 ) opt = 23;
            this.panelCuestionario.cuestionario.setNPreguntasAleatorias(opt);
            
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
        this.panelCuestionario.cambiarDificultad(Dificultad.ALEATORIA);
        this.btnMenuModificar.setEnabled(false);
    }//GEN-LAST:event_menuAleatorioActionPerformed

    private void menuBtnCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnCRUDActionPerformed
        cuestionario.setDificultad(Dificultad.FACIL);
        this.panelCrud = new PanelCRUD( this, cuestionario ); 
        
        this.panelActivo.setVisible(false);
        panelCrud.setVisible(true);
        this.setContentPane(this.panelCrud);
        this.btnMenuModificar.setEnabled(true);
        this.menuBtnDificultad.setEnabled(false);
        
        panelActivo = panelCrud;
    }//GEN-LAST:event_menuBtnCRUDActionPerformed

    private void menuBtnModificarFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnModificarFacilActionPerformed
        this.panelCrud.cambiarDificultad(Dificultad.FACIL);
    }//GEN-LAST:event_menuBtnModificarFacilActionPerformed

    private void menuBtnModificarIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnModificarIntermedioActionPerformed
        this.panelCrud.cambiarDificultad(Dificultad.INTERMEDIA);
    }//GEN-LAST:event_menuBtnModificarIntermedioActionPerformed

    private void menubBtnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubBtnTestActionPerformed
        this.abrirTest();
    }//GEN-LAST:event_menubBtnTestActionPerformed

    private void menuBtnCrearPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnCrearPreguntaActionPerformed
        this.panelNuevaPregunta = new PanelNuevaPregunta(cuestionario, this);
        
        this.panelActivo.setVisible(false);
        this.panelNuevaPregunta.setVisible(true);
        this.setContentPane(this.panelNuevaPregunta);
       
        this.btnMenuModificar.setEnabled(false);
        this.menuBtnDificultad.setEnabled(false);
        this.panelActivo = this.panelNuevaPregunta;
    }//GEN-LAST:event_menuBtnCrearPreguntaActionPerformed

    public void abrirTest(){
        
        this.cuestionario.resetTest();
        
        this.panelCuestionario = new PanelCuestionario( cuestionario );
        
        this.panelActivo.setVisible(false);
        this.panelCuestionario.setVisible(true);
        this.setContentPane(this.panelCuestionario);
        this.btnMenuModificar.setEnabled(false);
        this.menuBtnDificultad.setEnabled(true);
        panelActivo = this.panelCuestionario;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ventana().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnMenuAjustes;
    private javax.swing.JMenu btnMenuModificar;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuAleatorio;
    private javax.swing.JMenuBar menuBarCuestionario;
    private javax.swing.JMenuItem menuBtnCRUD;
    private javax.swing.JMenuItem menuBtnCrearPregunta;
    private javax.swing.JMenu menuBtnDificultad;
    private javax.swing.JMenuItem menuBtnModificarFacil;
    private javax.swing.JMenuItem menuBtnModificarIntermedio;
    private javax.swing.JMenuItem menuBtnSalir;
    private javax.swing.JMenuItem menuFacil;
    private javax.swing.JMenuItem menuIntermedio;
    private javax.swing.JMenuItem menubBtnTest;
    private paneles.PanelCuestionario panelCuestionario;
    // End of variables declaration//GEN-END:variables
}
