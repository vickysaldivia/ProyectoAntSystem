package funciones;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vickysaldivia
 */
public class Validaciones {
    
    // Validar si un String es decimal
    public double isDecimal(String cadena){
        if(!isNumeric(cadena)){
            try{
                Integer.valueOf(cadena);
                return -1; //no es decimal
            }
            catch (NumberFormatException e){
                double value = Double.valueOf(cadena);
                return value; // es decimal
            }
        }
        return -1;
    }
    
    //Validar si un String es numerico
    public boolean isNumeric(String cadena) {
        
        for (int i = 0; i < cadena.length(); i++) {
            char valorNumerico = cadena.charAt(i); //para transformar el caracter
            if ((valorNumerico >= 'a' && valorNumerico <= 'z') || (valorNumerico >= 'A' && valorNumerico <= 'Z')) { //  para comparar valor numerico
                return true; // Se encontró al menos una letra
            }
        }
        return false; // No se encontraron letras
    }
    
    
    public boolean ValidTitle(String titulo) {
         // Permite letras, números, espacios y algunos caracteres especiales
        // pero excluir <, >, :, ", |, ?, *, /, y .
        return titulo.matches("[a-zA-Z0-9\\s\\.,;!()'\\[\\]{}_-]+");
    }

}

    

