/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import GUI.Bienvenido;
/**
 *
 * @author vickysaldivia
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Llenar el grafo antes de iniciar el sistema si existe un txt en la carpeta 
        //Test Packges paquete default
        
        Bienvenido interfaz = new Bienvenido();
        interfaz.setResizable(false);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);  
    }
    
}
