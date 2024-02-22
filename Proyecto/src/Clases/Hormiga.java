/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Ciudad;
import edd.ListaSimple;
import javax.swing.JOptionPane;

public class Hormiga {

    //Atributos
    private ListaSimple<Ciudad> ciudadesRecorridas;
    private double distanciaRecorrida;
    private Ciudad ciudadActual;

    //Constructor
    public Hormiga() {
        this.ciudadesRecorridas = new ListaSimple();
        this.distanciaRecorrida = 0;
        this.ciudadActual = null;
    }
    
    //Getter and Setter
    public ListaSimple<Ciudad> getCiudadesRecorridas() {
        return ciudadesRecorridas;
    }

    public void setCiudadesRecorridas(ListaSimple<Ciudad> ciudadesRecorridas) {
        this.ciudadesRecorridas = ciudadesRecorridas;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(Ciudad ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
    
    //Primitivas
    public void visitarCiudad(Ciudad destino, double distancia){
        if(!this.visitado(destino)){
            this.setCiudadActual(destino);
            ciudadesRecorridas.Append(destino);
            distanciaRecorrida += distancia;
            JOptionPane.showMessageDialog(null, "La hormiga se ha movido");
        }else{
            JOptionPane.showMessageDialog(null, "Ya se visito la ciudad.");
        }
    }
    
    //Saber si una hormiga ya visito una ciudad
    public boolean visitado(Ciudad ciudad){
        for (int i = 0; i < ciudadesRecorridas.getSize(); i++) {
            if(ciudad.getValue() == ciudadesRecorridas.GetData(i).getValue() ){
                return true;
            }
        }
        return false;
    }
}
