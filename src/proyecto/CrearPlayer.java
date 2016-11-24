/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge A. Santos
 */

public class CrearPlayer extends javax.swing.JFrame {
    public String usuario;
    public String pass;
    /**
     * Creates new form CrearPlayer
     */
    public CrearPlayer() {
        initComponents();
        this.setLocationRelativeTo(null);
        usuario=jTextField1.getText();
        pass=jPasswordField1.getText();
        
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(216, 287));
        setMinimumSize(new java.awt.Dimension(216, 287));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(230, 217, 17));
        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 240, 70, 28);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 12)); // NOI18N
        jLabel2.setText("New User");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 140, 70, 17);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 3, 12)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 180, 60, 17);

        jTextField1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(70, 140, 130, 30);

        jPasswordField1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jPasswordField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(70, 180, 130, 30);

        jButton2.setBackground(new java.awt.Color(230, 217, 17));
        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(110, 240, 67, 28);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.1.2.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 30, 70, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.3.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(225, 287));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 230, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MenuInicial m = new MenuInicial();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Usuarios us=new Usuarios();
     try{
         us.addPlayer();
     }catch(NullPointerException e) {
         JOptionPane.showMessageDialog(null,"Se ha generado un error al intentar crear el usuario");
     }
      MenuPrincipal pl= new MenuPrincipal();
      MenuInicial mi= new MenuInicial();
      this.dispose();
      mi.dispose();
      pl.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
