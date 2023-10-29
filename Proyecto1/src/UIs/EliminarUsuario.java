/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UIs;

import clases.GrafoDefinitivo;
import clases.Txt;

/**
 *
 * @author ACER
 */
public class EliminarUsuario extends javax.swing.JFrame {

    private GrafoDefinitivo g;
    private String path;
    /**
     * Creates new form Eliminar
     */
    public EliminarUsuario() {
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
        TituloEliminar = new javax.swing.JLabel();
        TextEliminar = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        confirmacion = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        TituloEliminar.setBackground(new java.awt.Color(255, 255, 255));
        TituloEliminar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TituloEliminar.setForeground(new java.awt.Color(255, 255, 255));
        TituloEliminar.setText("A quien va a eliminar");
        getContentPane().add(TituloEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        TextEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(TextEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 180, 30));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));
        getContentPane().add(confirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 180, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIs/FondoELiminar.jpeg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEliminarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String name=TextEliminar.getText();
        setG(getG().deleteVerticeGrafo(name));
        Txt t = new Txt();
        t.modificarTxt(getPath(), t.modificarStringd(t.leer_txt(getPath()),name));
        setG(getG().completarGrafo());
        confirmacion.setText("El usuario fue eliminado");
    }//GEN-LAST:event_eliminarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        ModificarGrafo v = new ModificarGrafo();
        v.setG(getG());
        v.setPath(getPath());
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField TextEliminar;
    private javax.swing.JLabel TituloEliminar;
    private javax.swing.JTextField confirmacion;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton regresar;
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
