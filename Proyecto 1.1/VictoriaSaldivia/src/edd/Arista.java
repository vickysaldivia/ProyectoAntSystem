/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author vickysaldivia
 */
public class Arista {
    private Ciudad origen;
    private Ciudad destino;
    private double distancia;
    private double feromonas = 0;

    public Arista(Ciudad origen, Ciudad destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getFeromonas() {
        return feromonas;
    }

    public void setFeromonas(double feromonas) {
        this.feromonas = feromonas;
    }

    
    
}
