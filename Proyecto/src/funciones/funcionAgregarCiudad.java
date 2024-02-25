/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import edd.Ciudad;
import edd.ListaSimple;

/**
 *
 * @author vickysaldivia
 */
public class funcionAgregarCiudad {

    /**
     * Verifica si hay ciudades sin aristas en la lista de ciudades agregadas.
     *
     * @param ciudadesAgregadas Lista de ciudades agregadas.
     * @return String con las ciudades sin aristas, o null si no hay ciudades
     * sin aristas.
     */
    public String verificarAristas(ListaSimple<Ciudad> ciudadesAgregadas){
        String string = "";
        for (int i = 0; i < ciudadesAgregadas.getSize(); i++) {
            if(ciudadesAgregadas.GetData(i).getAristas().getSize() == 0){
                string += String.valueOf(i+1) + ") Ciudad: " + ciudadesAgregadas.GetData(i).getValue() + "\n";
            }
        }
        if(!"".equals(string)){
            return string;
        }
        else{
            return null;
        }
    }
}
