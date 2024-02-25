/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * Representa el historial de una hormiga en el algoritmo de búsqueda de caminos óptimos.
 *
 * @author jonathansarli
 */
public class HistorialHormiga {

    private int hormiga;
    private String caminoRecorrido;
    private double distanciaRecorrida;

    /**
     * Crea un nuevo historial de hormiga con la información proporcionada.
     *
     * @param hormiga El número de la hormiga que recorrió el camino.
     * @param caminoRecorrido El camino recorrido por la hormiga, representado como una cadena de caracteres.
     * @param distanciaRecorrida La distancia recorrida por la hormiga.
     */
    public HistorialHormiga(int hormiga, String caminoRecorrido, double distanciaRecorrida) {
        this.hormiga = hormiga;
        this.caminoRecorrido = caminoRecorrido;
        this.distanciaRecorrida = distanciaRecorrida;
    }

    /**
     * Obtiene el número de la hormiga que recorrió el camino.
     *
     * @return El número de la hormiga que recorrió el camino.
     */
    public int getHormiga() {
        return hormiga;
    }

    /**
     * Establece el número de la hormiga que recorrió el camino.
     *
     * @param hormiga El número de la hormiga que recorrió el camino.
     */
    public void setHormiga(int hormiga) {
        this.hormiga = hormiga;
    }

    /**
     * Obtiene el camino recorrido por la hormiga, representado como una cadena de caracteres.
     *
     * @return El camino recorrido por la hormiga, representado como una cadena de caracteres.
     */
    public String getCaminoRecorrido() {
        return caminoRecorrido;
    }

    /**
     * Establece el camino recorrido por la hormiga, representado como una cadena de caracteres.
     *
     * @param caminoRecorrido El camino recorrido por la hormiga, representado como una cadena de caracteres.
     */
    public void setCaminoRecorrido(String caminoRecorrido) {
        this.caminoRecorrido = caminoRecorrido;
    }

    /**
     * Obtiene la distancia recorrida por la hormiga.
     *
     * @return La distancia recorrida por la hormiga.
     */

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    /**
     * Establece la distancia recorrida por la hormiga.
     *
     * @param distanciaRecorrida La distancia recorrida por la hormiga.
     */

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

}
