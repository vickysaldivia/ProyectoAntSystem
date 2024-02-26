/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Ciudad;
import edd.ListaSimple;

/**
 * Clase que representa el historial de una colonia de hormigas.
 *
 * @author jonathansarli
 */
public class Historial {
   private ListaSimple<HistorialHormiga> historialHormigas;
   private ListaSimple<Ciudad> caminoOptimo;
   private double distanciaOptima;

   /**
    * Constructor de la clase Historial.
    *
    * @param historialHormigas Lista simple del historial de las hormigas.
    * @param caminoOptimo El camino óptimo encontrado por las hormigas.
    * @param distanciaOptima La distancia óptima encontrada por las hormigas.
    */
    public Historial(ListaSimple<HistorialHormiga> historialHormigas, ListaSimple<Ciudad> caminoOptimo, double distanciaOptima) {
        this.historialHormigas = historialHormigas;
        this.caminoOptimo = new ListaSimple();
        this.distanciaOptima = distanciaOptima;
    }

    /**
    * Obtiene la lista d historial de las hormigas.
    *
    * @return Lista del historial de las hormigas.
    */
    public ListaSimple<HistorialHormiga> getHistorialHormigas() {
        return historialHormigas;
    }

    /**
    * Establece la lista del historial de las hormigas.
    *
    * @param historialHormigas Lista del historial de las hormigas.
    */
    public void setHistorialHormigas(ListaSimple<HistorialHormiga> historialHormigas) {
        this.historialHormigas = historialHormigas;
    }

    /**
    * Obtiene el camino óptimo encontrado por las hormigas.
    *
    * @return El camino óptimo encontrado por las hormigas.
    */
    public ListaSimple<Ciudad> getCaminoOptimo() {
        return caminoOptimo;
    }

    /**
    * Establece el camino óptimo encontrado por las hormigas.
    *
    * @param caminoOptimo El camino óptimo encontrado por las hormigas.
    */
    public void setCaminoOptimo(ListaSimple<Ciudad> caminoOptimo) {
        this.caminoOptimo = caminoOptimo;
    }

    /**
    * Obtiene la distancia óptima encontrada por las hormigas.
    *
    * @return La distancia óptima encontrada por las hormigas.
    */
    public double getDistanciaOptima() {
        return distanciaOptima;
    }

    /**
    * Establece la distancia óptima encontrada por las hormigas.
    *
    * @param distanciaOptima La distancia óptima encontrada por las hormigas.
    */

    public void setDistanciaOptima(double distanciaOptima) {
        this.distanciaOptima = distanciaOptima;
    }
   
   
   
}
