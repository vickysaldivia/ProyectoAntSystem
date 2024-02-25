/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 * Clase que representa una arista en un grafo.
 *
 * @author vickysaldivia
 */
public class Arista {
    private Ciudad origen;
    private Ciudad destino;
    private double distancia;
    private double feromonas = 0;
    
    /**
     * Constructor de la clase Arista.
     *
     * @param origen ciudad de origen de la arista.
     * @param destino ciudad de destino de la arista.
     * @param distancia distancia entre las dos ciudades.
     */
    public Arista(Ciudad origen, Ciudad destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
    
    /**
     * Método que devuelve la ciudad de origen de la arista.
     *
     * @return ciudad de origen.
     */
    public Ciudad getOrigen() {
        return origen;
    }

    /**
     * Método que establece la ciudad de origen de la arista.
     *
     * @param origen ciudad de origen.
     */
    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }
    
    /**
     * Método que devuelve la ciudad de destino de la arista.
     *
     * @return ciudad de destino.
     */
    public Ciudad getDestino() {
        return destino;
    }

    /**
     * Método que establece la ciudad de destino de la arista.
     *
     * @param destino ciudad de destino.
     */
    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }
    
    /**
     * Método que devuelve la distancia entre las dos ciudades.
     *
     * @return distancia entre las dos ciudades.
     */
    public double getDistancia() {
        return distancia;
    }
    
    /**
     * Método que establece la distancia entre las dos ciudades.
     *
     * @param distancia distancia entre las dos ciudades.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Método que devuelve las feromonas de la arista.
     *
     * @return feromonas de la arista.
     */
    public double getFeromonas() {
        return feromonas;
    }

    /**
     * Método que establece las feromonas de la arista.
     *
     * @param feromonas feromonas de la arista.
     */
    public void setFeromonas(double feromonas) {
        this.feromonas = feromonas;
    }

    /**
     * Método que devuelve la representación en cadena de la arista.
     *
     * @return representación en cadena de la arista.
     */
    @Override
    public String toString() {
        return "Arista{" + "origen=" + origen.toString()+ ", destino=" + destino .toString()+ ", distancia=" + distancia + ", feromonas=" + feromonas + '}';
    }

    
    
}
