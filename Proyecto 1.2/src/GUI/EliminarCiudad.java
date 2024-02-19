/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static GUI.Menu.GrafoSimulacion;
import edd.ListaSimple;
import funciones.FuncionRellenarCombos;


/**
 *
 * @author vickysaldivia
 */
public class EliminarCiudad extends javax.swing.JFrame {

    /**
     * Creates new form EliminarCiudad
     */
    FuncionRellenarCombos re = new FuncionRellenarCombos();
    String NumCiudades = GrafoSimulacion.CiudadesToLista();
    
    public EliminarCiudad() {
        initComponents();
        re.RellenarCombos(NumCiudades, CiudadesDisponibles);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CiudadesDisponibles = new javax.swing.JComboBox<>();
        Volver = new javax.swing.JButton();
        EliminarCiudad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Maku", 1, 36)); // NOI18N
        jLabel2.setText("ELIMINAR CIUDAD");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Maku", 1, 18)); // NOI18N
        jLabel3.setText("NOMBRE: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 101, -1, 40));

        CiudadesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadesDisponiblesActionPerformed(evt);
            }
        });
        jPanel1.add(CiudadesDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        EliminarCiudad.setText("Eliminar");
        EliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(EliminarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCiudadActionPerformed
        // TODO add your handling code here:
        if(GrafoSimulacion.getCiudades().Search((int) this.CiudadesDisponibles.getSelectedItem())){
            GrafoSimulacion.eliminarCiudad((int) this.CiudadesDisponibles.getSelectedItem());
            re.RellenarCombos(NumCiudades, this.CiudadesDisponibles);
            
        }
    }//GEN-LAST:event_EliminarCiudadActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // TODO add your handling code here:
        Menu VentanaMenu = new Menu(); 
        this.setVisible(false);
        VentanaMenu.setLocationRelativeTo(null);
        VentanaMenu.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void CiudadesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadesDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiudadesDisponiblesActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarCiudad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CiudadesDisponibles;
    private javax.swing.JButton EliminarCiudad;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}