/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UIs;

import clases.GrafoDefinitivo;

/**
 *
 * @author ACER
 */
public class ModificarGrafo extends javax.swing.JFrame {

    private GrafoDefinitivo g;
    private String path;
    /**
     * Creates new form ModificarGrafo
     */
    public ModificarGrafo() {
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
        TituloModificar = new javax.swing.JLabel();
        ElminiarUsuarioBut = new javax.swing.JButton();
        AñadirUsuarioBut = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        FondoModificar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 146, -1, -1));

        TituloModificar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TituloModificar.setText("Seleccione una opción");
        getContentPane().add(TituloModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        ElminiarUsuarioBut.setBackground(new java.awt.Color(0, 0, 0));
        ElminiarUsuarioBut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ElminiarUsuarioBut.setForeground(new java.awt.Color(255, 255, 255));
        ElminiarUsuarioBut.setText("Eliminar usuario");
        ElminiarUsuarioBut.setBorderPainted(false);
        ElminiarUsuarioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElminiarUsuarioButActionPerformed(evt);
            }
        });
        getContentPane().add(ElminiarUsuarioBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 160, 90));

        AñadirUsuarioBut.setBackground(new java.awt.Color(0, 0, 0));
        AñadirUsuarioBut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AñadirUsuarioBut.setForeground(new java.awt.Color(255, 255, 255));
        AñadirUsuarioBut.setText("Añadir usuario");
        AñadirUsuarioBut.setBorderPainted(false);
        AñadirUsuarioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirUsuarioButActionPerformed(evt);
            }
        });
        getContentPane().add(AñadirUsuarioBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 160, 90));

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        FondoModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIs/Fondo Modificar.jpeg"))); // NOI18N
        getContentPane().add(FondoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ElminiarUsuarioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElminiarUsuarioButActionPerformed
        this.setVisible(false);
        EliminarUsuario ventanaeliminar = new EliminarUsuario();
        ventanaeliminar.setG(getG());
        ventanaeliminar.setPath(getPath());
        ventanaeliminar.setVisible(true);
    }//GEN-LAST:event_ElminiarUsuarioButActionPerformed

    private void AñadirUsuarioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirUsuarioButActionPerformed
        this.setVisible(false);
        AñadirUsuario ventanaañadir = new AñadirUsuario();
        ventanaañadir.setPath(getPath());
        ventanaañadir.setG(getG());
        ventanaañadir.setVisible(true);
    }//GEN-LAST:event_AñadirUsuarioButActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        CargarArchivo v = new CargarArchivo();
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
            java.util.logging.Logger.getLogger(ModificarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarGrafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirUsuarioBut;
    private javax.swing.JButton ElminiarUsuarioBut;
    private javax.swing.JLabel FondoModificar;
    private javax.swing.JLabel TituloModificar;
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
