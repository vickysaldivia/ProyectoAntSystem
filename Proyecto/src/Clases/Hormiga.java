/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Ciudad;
import edd.ListaSimple;
import javax.swing.JOptionPane;

/**
 * Clase que representa una hormiga que se mueve entre ciudades en un recorrido.
 * La hormiga lleva un registro de las ciudades que ha visitado y la distancia
 * total recorrida.
 */

public class Hormiga {

    private ListaSimple<Ciudad> ciudadesRecorridas;
    private double distanciaRecorrida;
    private Ciudad ciudadActual;

    //Constructor
    /**
     * Crea una nueva instancia de la clase Hormiga en la ciudad dada.
     *
     * @param ciudad Ciudad donde se encuentra la hormiga al inicio.
     */
    public Hormiga(Ciudad ciudad) {
        this.ciudadesRecorridas = new ListaSimple();
        this.distanciaRecorrida = 0;
        this.ciudadActual = ciudad;
    }
    
    /**
     * Obtiene la lista de ciudades recorridas por la hormiga.
     *
     * @return Lista de ciudades recorridas.
     */
    public ListaSimple<Ciudad> getCiudadesRecorridas() {
        return ciudadesRecorridas;
    }

    /**
     * Establece la lista de ciudades recorridas por la hormiga.
     *
     * @param ciudadesRecorridas Lista de ciudades recorridas.
     */
    public void setCiudadesRecorridas(ListaSimple<Ciudad> ciudadesRecorridas) {
        this.ciudadesRecorridas = ciudadesRecorridas;
    }

    /**
     * Obtiene la distancia total recorrida por la hormiga.
     *
     * @return Distancia total recorrida.
     */
    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    /**
     * Establece la distancia total recorrida por la hormiga.
     *
     * @param distanciaRecorrida Distancia total recorrida.
     */
    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }
    
    /**
     * Obtiene la ciudad en la que se encuentra la hormiga.
     * @return Ciudad en la que se encuentra la hormiga.
     */
    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    /**
     * Establece la ciudad en la que se encuentra la hormiga al moverse.
     *
     * @param ciudadActual ciudad en la que se encuentra la hormiga.
     */
    public void setCiudadActual(Ciudad ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
    
    /**
     * Mueve la hormiga a la ciudad destino y actualiza la distancia total
     * recorrida. Si la hormiga ya ha visitado la ciudad destino, muestra un
     * mensaje.
     *
     * @param destino La ciudad destino.
     * @param distancia La distancia entre la ciudad actual y la ciudad destino.
     */
    public void visitarCiudad(Ciudad destino, double distancia){
        if(!this.visitado(destino)){
            this.setCiudadActual(destino);
            ciudadesRecorridas.Append(destino);
            distanciaRecorrida += distancia;
        }
    }
    
    /**
     * Verifica si la hormiga ha visitado una ciudad.
     *
     * @param ciudad La ciudad a verificar.
     * @return `true` si la hormiga ha visitado la ciudad, `false` en caso
     * contrario.
     */

    public boolean visitado(Ciudad ciudad){
        for (int i = 0; i < ciudadesRecorridas.getSize(); i++) {
            if(ciudad.getValue() == ciudadesRecorridas.GetData(i).getValue() ){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca una ciudad con el valor `numCiudad` en la lista de ciudades
     * recorridas.
     *
     * @param numCiudad El valor de la ciudad a buscar.
     * @return `true` si se encuentra la ciudad en la lista, `false` en caso
     * contrario.
     */
    public boolean Search(int numCiudad){
        for (int i = 0; i < this.ciudadesRecorridas.getSize(); i++) {
           if(this.ciudadesRecorridas.GetData(i).getValue() == numCiudad){
               return true;
           }
        }
        return false;
    
    }

    /**
     * Devuelve una representación en forma de cadena de la hormiga.
     *
     * @return Una cadena que incluye el tamaño de la lista de ciudades
     * recorridas, la distancia total recorrida y el valor de la ciudad actual.
     */
    @Override
    public String toString() {
        return "Hormiga{" + "ciudadesRecorridas=" + ciudadesRecorridas.getSize() + ", distanciaRecorrida=" + distanciaRecorrida + ", ciudadActual=" + ciudadActual.getValue() + '}';
    }

    
    
}
