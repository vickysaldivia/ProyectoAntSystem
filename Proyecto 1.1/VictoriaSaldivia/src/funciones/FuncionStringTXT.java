/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import edd.Grafo;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vickysaldivia
 */
public class FuncionStringTXT {
    
    public void StringTXT(Grafo GrafoSimulacion, String FileName) throws IOException{
        String Grafo = GrafoSimulacion.toString();
        
        if(FileName.contains(".txt")){
            FileName = FileName.replace(".txt", "");
            FileName = FileName + ".txt";    
        }
        else{
           FileName = FileName + ".txt"; 
        }
        FileWriter writer = new FileWriter(FileName);
        writer.write(Grafo);
        writer.close();
    }
    
}
