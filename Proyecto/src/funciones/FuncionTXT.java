/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import edd.Grafo;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vickysaldivia
 */
public class FuncionTXT {
    
    FuncionStringGrafo func = new FuncionStringGrafo();
    
    public void StringTXT(Grafo GrafoSimulacion, String FileName) throws IOException{
        String Grafo = GrafoSimulacion.toString();
        FileWriter writer = new FileWriter(FileName);
        writer.write(Grafo);
        writer.close();
    }
    
    public void eliminarArchivo(String FileName) {
        File archivo = new File(FileName);

        if (archivo.exists()) {
            archivo.delete();
        }      
    }
    
    public Grafo cargaTXTAutomatica() throws IOException{
        if(new File("GrafoSimulacion.txt").exists() && new File("GrafoSimulacion.txt").isFile()){
            File fichero = new File("GrafoSimulacion.txt");
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
    
    public boolean esArchivoTxt(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        return archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt");
    }
}
