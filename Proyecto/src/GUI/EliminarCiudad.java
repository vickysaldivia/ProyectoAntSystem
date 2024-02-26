/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static GUI.Menu.GrafoSimulacion;
import funciones.FuncionRellenarCombos;
import javax.swing.JOptionPane;


/**
 *
 * @author vickysaldivia
 */
public class EliminarCiudad extends javax.swing.JFrame {

    /**
     * Creates new form EliminarCiudad
     */
    FuncionRellenarCombos re = new FuncionRellenarCombos();
    
    
    public EliminarCiudad() {
        initComponents();
        String NumCiudades = GrafoSimulacion.CiudadesToLista();
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
        jLabel5 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        EliminarCiudad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CiudadesDisponibles = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 246, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(83, 26, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccione la ciudad a eliminar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 390, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(83, 26, 11));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ELIMINAR CIUDAD");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 390, 80));

        Volver.setBackground(new java.awt.Color(83, 26, 11));
        Volver.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        EliminarCiudad.setBackground(new java.awt.Color(83, 26, 11));
        EliminarCiudad.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        EliminarCiudad.setText("Eliminar");
        EliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(EliminarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 170, -1));

        jPanel2.setBackground(new java.awt.Color(241, 246, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 26, 11), 2, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(83, 26, 11), java.awt.Color.white)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(83, 26, 11));
        jLabel3.setText("CIUDAD:");

        CiudadesDisponibles.setBackground(new java.awt.Color(83, 26, 11));
        CiudadesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadesDisponiblesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CiudadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CiudadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 290, 100));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IMG_3263.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IMG_3263.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 360, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCiudadActionPerformed
        // TODO add your handling code here:
        if(GrafoSimulacion.getCiudades().getSize() >= 4){
            if(GrafoSimulacion.getCiudad((int) CiudadesDisponibles.getSelectedItem()) !=  null){
                int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar la ciudad seleccionada?\n" + GrafoSimulacion.stringCiudad((int) this.CiudadesDisponibles.getSelectedItem()), "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    String NumCiudades = GrafoSimulacion.CiudadesToLista();
                    GrafoSimulacion.eliminarCiudad((int) this.CiudadesDisponibles.getSelectedItem());
                    
                    CiudadesDisponibles.removeAllItems();
                    re.RellenarCombos(NumCiudades, this.CiudadesDisponibles);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "La simulación debe permanecer con al menos 4 ciudades.");
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
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
