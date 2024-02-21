/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;


import javax.swing.JComboBox;

/**
 *
 * @author vickysaldivia
 */
public class FuncionRellenarCombos {
    public void RellenarCombos(String ciudades, JComboBox combo){
        if(ciudades != null){
            String parts[] = ciudades.split(",");

            for (String ciudad : parts) {
                combo.addItem(ciudad);
            }
        }
    }
}
