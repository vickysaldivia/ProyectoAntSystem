/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;


import javax.swing.JComboBox;

/**
* Clase para rellenar los combos de ciudades en la interfaz gráfica.
*
* @author vickysaldivia
*/

public class FuncionRellenarCombos {
    
    /**
    * Método para rellenar un JComboBox con los valores de las ciudades.
    *
    * @param ciudades Una cadena de texto separada por comas que contiene los valores
    *                de las ciudades.
    * @param combo   El JComboBox a rellenar.
    */
    public void RellenarCombos(String ciudades, JComboBox combo){
        if(ciudades != null){
            String parts[] = ciudades.split(",");

            for (String ciudad : parts) {
                combo.addItem(Integer.parseInt(ciudad));
            }
        }
    }
}
