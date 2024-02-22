/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Ciudad;
import edd.ListaSimple;


public class Historial {
   private ListaSimple<HistorialHormiga> historialHormigas;
   private ListaSimple<Ciudad> caminoOptimo;
   private double distanciaOptima;

    public Historial(ListaSimple<HistorialHormiga> hitorialHormigas, ListaSimple<Ciudad> caminoOptimo, double distanciaOptima) {
        this.historialHormigas = hitorialHormigas;
        this.caminoOptimo = new ListaSimple();
        this.distanciaOptima = distanciaOptima;
    }

    public ListaSimple<HistorialHormiga> getHistorialHormigas() {
        return historialHormigas;
    }

    public void setHistorialHormigas(ListaSimple<HistorialHormiga> hitorialHormigas) {
        this.historialHormigas = hitorialHormigas;
    }

    public ListaSimple<Ciudad> getCaminoOptimo() {
        return caminoOptimo;
    }

    public void setCaminoOptimo(ListaSimple<Ciudad> caminoOptimo) {
        this.caminoOptimo = caminoOptimo;
    }

    public double getDistanciaOptima() {
        return distanciaOptima;
    }

    public void setDistanciaOptima(double distanciaOptima) {
        this.distanciaOptima = distanciaOptima;
    }
   
   
   
}
