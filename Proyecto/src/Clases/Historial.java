/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.ListaSimple;


public class Historial {
   private ListaSimple<HistorialHormiga> hitorialHormigas;
   private String caminoOptimo;
   private double distanciaOptima;

    public Historial(ListaSimple<HistorialHormiga> hitorialHormigas, String caminoOptimo, double distanciaOptima) {
        this.hitorialHormigas = hitorialHormigas;
        this.caminoOptimo = caminoOptimo;
        this.distanciaOptima = distanciaOptima;
    }

    public ListaSimple<HistorialHormiga> getHitorialHormigas() {
        return hitorialHormigas;
    }

    public void setHitorialHormigas(ListaSimple<HistorialHormiga> hitorialHormigas) {
        this.hitorialHormigas = hitorialHormigas;
    }

    public String getCaminoOptimo() {
        return caminoOptimo;
    }

    public void setCaminoOptimo(String caminoOptimo) {
        this.caminoOptimo = caminoOptimo;
    }

    public double getDistanciaOptima() {
        return distanciaOptima;
    }

    public void setDistanciaOptima(double distanciaOptima) {
        this.distanciaOptima = distanciaOptima;
    }
   
   
   
}
