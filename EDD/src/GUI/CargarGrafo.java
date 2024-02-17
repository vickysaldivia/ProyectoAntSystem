/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import funciones.Funcion_StringAGrafo;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vickysaldivia
 */
public class CargarGrafo extends javax.swing.JFrame {
    
    private final Funcion_StringAGrafo StringAGrafo = new Funcion_StringAGrafo();

    /**
     * Creates new form CargarGrafo
     */
    public CargarGrafo() {
        initComponents();
        setResizable(false);
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
        jLabel1 = new javax.swing.JLabel();
        Fichero = new javax.swing.JTextField();
        BuscarArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TXT_String = new javax.swing.JTextArea();
        Volver = new javax.swing.JButton();
        CargarTXT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Maku", 1, 36)); // NOI18N
        jLabel2.setText("CARGAR GRAFO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 50));

        jLabel1.setFont(new java.awt.Font("Maku", 1, 18)); // NOI18N
        jLabel1.setText("BUSCAR ARCHIVO TXT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        Fichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FicheroActionPerformed(evt);
            }
        });
        jPanel1.add(Fichero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 230, -1));

        BuscarArchivo.setText("Buscar");
        BuscarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        TXT_String.setColumns(20);
        TXT_String.setRows(5);
        TXT_String.setFocusable(false);
        jScrollPane1.setViewportView(TXT_String);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 110));

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        CargarTXT.setText("Cargar");
        CargarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarTXTActionPerformed(evt);
            }
        });
        jPanel1.add(CargarTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // TODO add your handling code here:
        Menu VentanaMenu = new Menu(); 
        this.setVisible(false);
        VentanaMenu.setLocationRelativeTo(null);
        VentanaMenu.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void BuscarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser FileChooser = new JFileChooser();
        FileNameExtensionFilter Filter = new FileNameExtensionFilter("*.TXT", "txt");
        FileChooser.setFileFilter(Filter);
        int seleccion = FileChooser.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = FileChooser.getSelectedFile();
            this.Fichero.setText(fichero.getAbsolutePath());
            
            try(FileReader FileReader = new FileReader(fichero)){
                String string = "";
                int value = FileReader.read();
                while(value != -1){
                    string = string + (char) value;
                    value = FileReader.read();
                }
                this.TXT_String.setText(string);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Archivo no seleccionado.");
        }
    }//GEN-LAST:event_BuscarArchivoActionPerformed

    private void FicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FicheroActionPerformed
        // TODO add your handling code here:
        this.StringAGrafo.convertString(TXT_String.getText());
    }//GEN-LAST:event_FicheroActionPerformed

    private void CargarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarTXTActionPerformed

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
            java.util.logging.Logger.getLogger(CargarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarGrafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarArchivo;
    private javax.swing.JButton CargarTXT;
    private javax.swing.JTextField Fichero;
    private javax.swing.JTextArea TXT_String;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
