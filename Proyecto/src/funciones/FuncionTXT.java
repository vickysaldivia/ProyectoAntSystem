/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import edd.Grafo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author vickysaldivia
 */
public class FuncionTXT {
    
    FuncionStringGrafo func = new FuncionStringGrafo();
    
    
    public void eliminarArchivo() {
        File archivo = new File("test//GrafoSimulacion.txt");

        if (archivo.exists()) {
            archivo.delete();
        }      
    }
    
    public Grafo cargaTXTAutomatica() throws IOException{
        if(new File("test//GrafoSimulacion.txt").exists() && new File("test//GrafoSimulacion.txt").isFile()){
            File fichero = new File("test//GrafoSimulacion.txt");
            try(FileReader FileReader = new FileReader(fichero)){
                String string = "";
                int value = FileReader.read();
                while(value != -1){
                    string = string + (char) value;
                    value = FileReader.read();
                }
                Grafo newGrafo = func.convertString(string);
                return newGrafo; 
            }
        }       
        return null;
    }
    
    public void String_TXT2(String Grafo) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("test//GrafoSimulacion.txt");
        pw.print(Grafo);
        pw.close();
    }
}
