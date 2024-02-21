/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class HistorialHormiga {

    private int hormiga;
    private String caminoRecorrido;
    private double distanciaRecorrida;

    public HistorialHormiga(int hormiga, String caminoRecorrido, double distanciaRecorrida) {
        this.hormiga = hormiga;
        this.caminoRecorrido = caminoRecorrido;
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public int getHormiga() {
        return hormiga;
    }

    public void setHormiga(int hormiga) {
        this.hormiga = hormiga;
    }

    public String getCaminoRecorrido() {
        return caminoRecorrido;
    }

    public void setCaminoRecorrido(String caminoRecorrido) {
        this.caminoRecorrido = caminoRecorrido;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

}
