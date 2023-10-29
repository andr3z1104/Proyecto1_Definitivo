/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UIs;

import clases.GraficarGrafo;
import clases.GrafoDefinitivo;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CargarArchivo extends javax.swing.JFrame {
    private GrafoDefinitivo g;
    private String path;
    /**
     * Creates new form negawatt
     */
    public CargarArchivo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TituloCargarArchivo = new javax.swing.JLabel();
        VerGrafoBut = new javax.swing.JButton();
        ModificarGrafoBut = new javax.swing.JButton();
        KosajaruBut = new javax.swing.JButton();
        FondoCargarArchivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        TituloCargarArchivo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TituloCargarArchivo.setForeground(new java.awt.Color(255, 255, 255));
        TituloCargarArchivo.setText("Seleccione una opción");
        getContentPane().add(TituloCargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 510, 90));

        VerGrafoBut.setBackground(new java.awt.Color(0, 0, 0));
        VerGrafoBut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        VerGrafoBut.setForeground(new java.awt.Color(255, 255, 255));
        VerGrafoBut.setText("Ver Grafo");
        VerGrafoBut.setBorderPainted(false);
        VerGrafoBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerGrafoButActionPerformed(evt);
            }
        });
        getContentPane().add(VerGrafoBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 170, 80));

        ModificarGrafoBut.setBackground(new java.awt.Color(0, 0, 0));
        ModificarGrafoBut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ModificarGrafoBut.setForeground(new java.awt.Color(255, 255, 255));
        ModificarGrafoBut.setText("Modificar Grafo");
        ModificarGrafoBut.setBorderPainted(false);
        ModificarGrafoBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarGrafoButActionPerformed(evt);
            }
        });
        getContentPane().add(ModificarGrafoBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 170, 80));

        KosajaruBut.setBackground(new java.awt.Color(0, 0, 0));
        KosajaruBut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        KosajaruBut.setForeground(new java.awt.Color(255, 255, 255));
        KosajaruBut.setText("Ver Componentes Fuertemente Concectados");
        KosajaruBut.setBorderPainted(false);
        KosajaruBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KosajaruButActionPerformed(evt);
            }
        });
        getContentPane().add(KosajaruBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 300, 80));

        FondoCargarArchivo.setBackground(new java.awt.Color(0, 0, 0));
        FondoCargarArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIs/Fondo CargarImagen.jpeg"))); // NOI18N
        getContentPane().add(FondoCargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarGrafoButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarGrafoButActionPerformed
        this.setVisible(false);
        ModificarGrafo ventana = new ModificarGrafo();
        ventana.setPath(getPath());
        ventana.setG(getG());
        ventana.setVisible(true);
            
    }//GEN-LAST:event_ModificarGrafoButActionPerformed

    private void VerGrafoButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerGrafoButActionPerformed
        setG(getG().completarGrafo());
        
        GraficarGrafo gPrint = new GraficarGrafo(g.getListaUsuarios(),g.getGrafo());
        gPrint.mostrar();
    }//GEN-LAST:event_VerGrafoButActionPerformed

    private void KosajaruButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KosajaruButActionPerformed
        setG(getG().completarGrafo());
        GraficarGrafo gPrint = new GraficarGrafo(g.getListaUsuarios(),g.getGrafo());
        gPrint.printSubGraph();
        
    }//GEN-LAST:event_KosajaruButActionPerformed

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
            java.util.logging.Logger.getLogger(CargarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoCargarArchivo;
    private javax.swing.JButton KosajaruBut;
    private javax.swing.JButton ModificarGrafoBut;
    private javax.swing.JLabel TituloCargarArchivo;
    private javax.swing.JButton VerGrafoBut;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the g
     */
    public GrafoDefinitivo getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(GrafoDefinitivo g) {
        this.g = g;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
}
