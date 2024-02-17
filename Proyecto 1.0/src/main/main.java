/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import GUI.Bienvenido;
import edd.Grafo;
import funciones.Validaciones;

/**
 *
 * @author vickysaldivia
 */
public class main {
    public Grafo newGrafo = new Grafo();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Bienvenido interfaz = new Bienvenido();
        interfaz.setResizable(false);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);  
    }
    
}
