/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Arista;
import edd.Ciudad;
import edd.Grafo;
import edd.ListaSimple;
import java.util.Random;

/**
 *
 * @author vickysaldivia
 */
public class Sistema2 {
    
    private Grafo grafo;
    private ListaSimple<Hormiga> hormigas;
    private int ciclos;
    private Ciudad ciudadInico;
    private Ciudad ciudadFinal;
    private double alfa;
    private double beta;
    private double rho; //Aprendizaje
    private double q;
    private ListaSimple<Ciudad> caminoOptimo;
    private double distanciaOptima;
    private ListaSimple<Historial> historial;
    private ListaSimple<HistorialHormiga> historialtemp;
    
    /**
     * Constructor de la clase Sistema.
     *
     * @param grafo El grafo del sistema (contiene ciudades y aristas).
     * @param hormigas La lista de hormigas en el sistema.
     * @param ciclos El número de ciclos para ejecutar el algoritmo.
     * @param ciudadInico La ciudad inicial del recorrido.
     * @param ciudadFinal La ciudad final del recorrido.
     * @param alfa El parámetro de grado de importancia de las feromonas.
     * @param beta El parámetro de grado de visibilidad de la ciudad.
     * @param rho El parámetro de aprendizaje de la hormiga.
     */
    public Sistema2(Grafo grafo, ListaSimple<Hormiga> hormigas, int ciclos, Ciudad ciudadInico, Ciudad ciudadFinal, double alfa, double beta, double rho) {
        this.grafo = grafo;
        this.hormigas = hormigas;
        this.ciclos = ciclos;
        this.ciudadInico = ciudadInico;
        this.ciudadFinal = ciudadFinal;
        this.alfa = alfa;
        this.beta = beta;
        this.rho = rho;
        this.q = 1.0;
        this.caminoOptimo = new ListaSimple();
        this.distanciaOptima = 0;
        this.historial = new ListaSimple();
        this.historialtemp = new ListaSimple();
    }

    //Getter and Setter
    /**
    * Obtiene el grafo del sistema.
    *
    * @return El grafo del sistema.
    */
    public Grafo getGrafo() {
        return grafo;
    }
    
    /**
     * Establece el grafo del sistema.
     * @param grafo Grafo del sistema.
     */
    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
      /**
    * Obtiene la lista de hormigas en el sistema.
    *
    * @return La lista de hormigas en el sistema.
    */
    public ListaSimple<Hormiga> getHormigas() {
        return hormigas;
    }
    
    /**
    * Establece la lista de hormigas en el sistema.
    *
    * @param hormigas La lista de hormigas en el sistema.
    */
    public void setHormigas(ListaSimple<Hormiga> hormigas) {
        this.hormigas = hormigas;
    }
    
    /**
    * Obtiene el número de ciclos para ejecutar el algoritmo.
    *
    * @return El número de ciclos para ejecutar el algoritmo.
    */
    public int getCiclos() {
        return ciclos;
    }
    
    /**
    * Establece el número de ciclos para ejecutar el algoritmo.
    *
    * @param ciclos El número de ciclos para ejecutar el algoritmo.
    */
    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }
    
    /**
    * Obtiene la ciudad inicial del recorrido.
    *
    * @return La ciudad inicial del recorrido.
    */
    public Ciudad getCiudadInico() {
        return ciudadInico;
    }
    
    /**
    * Establece la ciudad inicial del recorrido.
    *
    * @param ciudadInico La ciudad inicial del recorrido.
    */
    public void setCiudadInico(Ciudad ciudadInico) {
        this.ciudadInico = ciudadInico;
    }
    
    /**
    * Obtiene la ciudad final del recorrido.
    *
    * @return La ciudad final del recorrido.
    */
    public Ciudad getCiudadFinal() {
        return ciudadFinal;
    }
    
    /**
    * Establece la ciudad final del recorrido.
    *
    * @param ciudadFinal La ciudad final del recorrido.
    */

    public void setCiudadFinal(Ciudad ciudadFinal) {
        this.ciudadFinal = ciudadFinal;
    }
    
    /**
    * Obtiene el parámetro de exploración de la hormiga.
    *
    * @return El parámetro de exploración de la hormiga.
    */

    public double getAlfa() {
        return alfa;
    }
    
    /**
    * Establece el parámetro de exploración de la hormiga.
    *
    * @param alfa El parámetro de exploración de la hormiga.
    */
    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }
    
    /**
    * Obtiene el parámetro de explotación de la hormiga.
    *
    * @return El parámetro de explotación de la hormiga.
    */
    public double getBeta() {
        return beta;
    }
    
    /**
    * Establece el parámetro de explotación de la hormiga.
    *
    * @param beta El parámetro de explotación de la hormiga.
    */

    public void setBeta(double beta) {
        this.beta = beta;
    }
    
    /**
    * Obtiene el parámetro de aprendizaje de la hormiga.
    *
    * @return El parámetro de aprendizaje de la hormiga.
    */
    public double getRho() {
        return rho;
    }
    
    /**
    * Establece el parámetro de aprendizaje de la hormiga.
    *
    * @param rho El parámetro de aprendizaje de la hormiga.
    */
    public void setRho(double rho) {
        this.rho = rho;
    }
    
    /**
   * Obtiene la lista de ciudades del camino óptimo.
   *
   * @return La lista de ciudades del camino óptimo.
   */
    public ListaSimple<Ciudad> getCaminoOptimo() {
        return caminoOptimo;
    }
    
    /**
   * Establece la lista de ciudades del camino óptimo.
   *
   * @param caminoOptimo La lista de ciudades del camino óptimo.
   */
    public void setCaminoOptimo(ListaSimple<Ciudad> caminoOptimo) {
        this.caminoOptimo = caminoOptimo;
    }
    
    /**
   * Obtiene la distancia del camino óptimo.
   *
   * @return La distancia del camino óptimo.
   */
    public double getDistanciaOptima() {
        return distanciaOptima;
    }
    
    /**
   * Establece la distancia del camino óptimo.
   *
   * @param distanciaOptima La distancia del camino óptimo.
   */
    public void setDistanciaOptima(double distanciaOptima) {
        this.distanciaOptima = distanciaOptima;
    }
    
    /**
     * Ejecuta la simulación del algoritmo de hormigas. La simulación consiste
     * en un bucle de "ciclos" iteraciones, donde en cada iteración cada hormiga
     * realiza un recorrido completo, se evaporan las feromonas y se reinician
     * las hormigas.
     */
    public void simulacion() {
        for (int i = 0; i < this.ciclos; i++) {
            for (int j = 0; j < this.hormigas.getSize(); j++) {
                recorridoCompleto(hormigas.GetData(j));
                hormigas.GetData(j).getCiudadesRecorridas().Show();
            }
            //System.out.println(this.grafo.toString2());
            //System.out.println("\n");
            this.evaporarFeromonas();
            //this.reiniciarHormigas();
            //this.hormigas.Show();
        }
    }

    
    /**
     * Realiza un recorrido completo con la hormiga dada, actualizando el camino
     * óptimo y la distancia óptima del sistema si es necesario.
     *
     * @param hormiga La hormiga a utilizar en el recorrido completo.
     */

    public void recorridoCompleto(Hormiga hormiga) {
        for (int i = 0; i < this.grafo.getCiudades().getSize(); i++) {
            if (hormiga.getCiudadActual().getValue() != this.ciudadFinal.getValue()) {
                ListaSimple<Arista> ciudadesCandidatas = ciudadesCandidatas(hormiga);
                if (ciudadesCandidatas.getpFirst() != null) {
                    ListaSimple<Double> probs = probabilidades(ciudadesCandidatas);
                    Arista arista = decidirCiudad(probs, ciudadesCandidatas);
                    hormiga.visitarCiudad(arista.getDestino(), arista.getDistancia());
                }
            }
        }

        if (this.distanciaOptima == 0) {
            this.setDistanciaOptima(hormiga.getDistanciaRecorrida());
            this.setCaminoOptimo(hormiga.getCiudadesRecorridas());
        } else {
            if (hormiga.getDistanciaRecorrida() < this.distanciaOptima && hormiga.getCiudadActual().getValue() == this.ciudadFinal.getValue()) {
                this.setCaminoOptimo(hormiga.getCiudadesRecorridas());
                this.setDistanciaOptima(hormiga.getDistanciaRecorrida());
            }

        }

        this.incrementarFeromonas(hormiga);
    }

    /**
     * Obtiene una lista de aristas correspondientes a las ciudades candidatas
     * para la siguiente visita de la hormiga.
     *
     * @param hormiga La hormiga a utilizar en el recorrido completo.
     * @return Una lista de aristas correspondientes a las aristas de las
     * ciudades candidatas.
     */
    public ListaSimple<Arista> ciudadesCandidatas(Hormiga hormiga) {

        ListaSimple<Arista> ciudadesCandidatas = new ListaSimple();

        if (grafo.getCiudad(hormiga.getCiudadActual().getValue()) != null) {
            ListaSimple<Arista> ListAdy = grafo.getCiudad(hormiga.getCiudadActual().getValue()).getAristas();
            for (int i = 0; i < ListAdy.getSize(); i++) {
                if (!hormiga.Search(ListAdy.GetData(i).getDestino().getValue())) {
                    ciudadesCandidatas.Append(ListAdy.GetData(i));
                }
            }
            return ciudadesCandidatas;
        } else {
            return null;
        }
    }

    /**
     * Calcula las probabilidades asociadas a cada arista en la lista de
     * ciudades candidatas. 
     * Permite determinar la probabilidad de elección de un camino u otro.
     *
     * @param ciudadesCandidatas La lista de ciudades candidatas.
     * @return Una lista de probabilidades asociadas a cada arista en la lista
     * de ciudades candidatas.
     */
    public ListaSimple<Double> probabilidades(ListaSimple<Arista> ciudadesCandidatas) {
        ListaSimple<Double> probsindividir = new ListaSimple();

        ListaSimple<Double> ciudadesProbabilidades = new ListaSimple();

        double sumatoria = 0;

        for (int i = 0; i < ciudadesCandidatas.getSize(); i++) {
            Arista arista = ciudadesCandidatas.GetData(i);

            double probabilidad = Math.pow(arista.getFeromonas(), alfa) * Math.pow(1 / arista.getDistancia(), beta);
            probsindividir.Append(probabilidad);
            sumatoria += probabilidad;
        }

        for (int i = 0; i < probsindividir.getSize(); i++) {
            double probabilidadCiudad = ((double) probsindividir.GetData(i)) / sumatoria;
            ciudadesProbabilidades.Append(probabilidadCiudad);
        }

        return ciudadesProbabilidades;
    }

    /**
     * Selecciona una arista de la lista de ciudades candidatas de acuerdo a las
     * probabilidades calculadas.
     *
     * @param probabilidades La lista de probabilidades asociadas a cada arista
     * en la lista de ciudades candidatas.
     * @param ciudadesCandidatas La lista de ciudades candidatas.
     * @return La arista seleccionada.
     */
    public Arista decidirCiudad(ListaSimple<Double> probabilidades, ListaSimple<Arista> ciudadesCandidatas) {
        ListaSimple<Integer> index = new ListaSimple();
        double probMayor = 0;
        
        for (int i = 0; i < probabilidades.getSize(); i++) {
            double probActual = (double) probabilidades.GetData(i);
            if (probActual > probMayor || probActual==probMayor) {
                probMayor = probActual;
                index.Append(i);
            }
        }
        Random randomNumbers = new Random();
        int indexArista = randomNumbers.nextInt(index.getSize());
        Arista aristaFinal = ciudadesCandidatas.GetData(indexArista);
        return aristaFinal;
    }

    /**
     * Reinicia el estado de todas las hormigas al inicio del recorrido.
     */
    public void reiniciarHormigas() {
        for (int i = 0; i < this.hormigas.getSize(); i++) {
            Hormiga hormigaActual = this.hormigas.GetData(i);
            hormigaActual.setCiudadActual(this.ciudadInico);
            hormigaActual.setDistanciaRecorrida(0);
            hormigaActual.getCiudadesRecorridas().DeleteList();

        }
    }

    /**
     * Evapora las feromonas en todas las aristas del grafo.
     */
    public void evaporarFeromonas() {
        // arista verificar si destino > origen
        for (int i = 0; i < grafo.getCiudades().getSize(); i++) {
            Ciudad ciudadActual = (Ciudad) grafo.getCiudades().GetData(i);
            for (int j = 0; j < ciudadActual.getAristas().getSize(); j++) {
                Arista aristaActual = (Arista) ciudadActual.getAristas().GetData(j);
                if (ciudadActual.getValue() < aristaActual.getDestino().getValue()) {
                    double newFeromonas = (1.0 - this.getRho()) * aristaActual.getFeromonas();
                    aristaActual.setFeromonas(newFeromonas);
                }
            }
        }
    }

    /**
     * Incrementa las feromonas en las aristas recorridas por la hormiga.
     *
     * @param hormiga La hormiga a utilizar en el recorrido completo.
     */
    public void incrementarFeromonas(Hormiga hormiga) {
        double visibilidad = q / hormiga.getDistanciaRecorrida();

        for (int i = 0; i < hormiga.getCiudadesRecorridas().getSize() - 1; i++) {
            Ciudad ciudadActual = hormiga.getCiudadesRecorridas().GetData(i);
            Ciudad siguienteCiudad = hormiga.getCiudadesRecorridas().GetData(i + 1);

            double totalFeromonas = visibilidad + ciudadActual.buscarArista(siguienteCiudad.getValue()).getFeromonas();
            ciudadActual.buscarArista(siguienteCiudad.getValue()).setFeromonas(totalFeromonas);
        }
    }
    
}
