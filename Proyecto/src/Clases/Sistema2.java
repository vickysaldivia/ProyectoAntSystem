/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Arista;
import edd.Ciudad;
import edd.Grafo;
import edd.ListaSimple;
import java.text.DecimalFormat;
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
    private double factorExploracion;
    
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
        this.factorExploracion = 0.8;
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
            this.historialtemp.DeleteList();
            for (int j = 0; j < this.hormigas.getSize(); j++) {
                recorridoCompleto(hormigas.GetData(j), this.factorExploracion);
                this.historialtemp.Append(this.llenarHistorialHormiga(hormigas.GetData(j), (j+1)));
                
            }

            this.evaporarFeromonas();
            if(this.factorExploracion > 0 && (this.factorExploracion - 0.2) > 0){
                this.factorExploracion = this.factorExploracion - 0.2;
                
            }
            
            Historial newHistorial = new Historial(historialtemp, caminoOptimo, distanciaOptima);
            this.historial.Append(newHistorial); 
            
        }
    }
    
    /**
     * Llena y devuelve un nuevo objeto {@link HistorialHormiga} con la
     * información de la instancia de {@link Hormiga} dada.
     *
     * Este método construye una cadena que representa el camino recorrido por
     * las ciudades visitadas, y calcula la distancia total recorrida por la
     * hormiga.
     *
     * @param hormiga La instancia de {@link Hormiga} de la que se extraerá la
     * información.
     * @param hormigaValor El valor asociado con la hormiga dada.
     * @return Un nuevo objeto {@link HistorialHormiga} llenado con la
     * información de la hormiga.
     */
    public HistorialHormiga llenarHistorialHormiga(Hormiga hormiga, int hormigaValor){
        String caminoRecorrido = "CIUDADES RECORRIDAS: ";
        for (int i = 0; i < hormiga.getCiudadesRecorridas().getSize()-1; i++) {
            Ciudad ciudadRecorrida = hormiga.getCiudadesRecorridas().GetData(i);
            caminoRecorrido+= String.valueOf(ciudadRecorrida.getValue()) + "-";
        }
        Ciudad ciudadRecorrida = hormiga.getCiudadesRecorridas().GetData(hormiga.getCiudadesRecorridas().getSize()-1);
        caminoRecorrido += String.valueOf(ciudadRecorrida.getValue());  
        double distanciaRecorrida = hormiga.getDistanciaRecorrida();
        
        return new HistorialHormiga(hormigaValor,caminoRecorrido,distanciaRecorrida);
    }
    
    /**
     * Realiza un recorrido completo con la hormiga dada, actualizando el camino
     * óptimo y la distancia óptima del sistema si es necesario.
     *
     * @param hormiga La hormiga a utilizar en el recorrido completo.
     * @param factorExploracion
     */

    public void recorridoCompleto(Hormiga hormiga, Double factorExploracion) {
        for (int i = 0; i < this.grafo.getCiudades().getSize(); i++) {
            if (hormiga.getCiudadActual().getValue() != this.ciudadFinal.getValue()) {
                ListaSimple<Arista> ciudadesCandidatas = ciudadesCandidatas(hormiga);
                if (ciudadesCandidatas.getpFirst() != null) {
                    ListaSimple<Double> probs = probabilidades(ciudadesCandidatas);
                    Arista arista = decidirCiudad(probs, ciudadesCandidatas, factorExploracion);
                    hormiga.visitarCiudad(arista.getDestino(), arista.getDistancia());
                }
            }
        }

        if (this.distanciaOptima == 0) {
            this.setDistanciaOptima(hormiga.getDistanciaRecorrida());
            this.setCaminoOptimo(hormiga.getCiudadesRecorridas());
        } else {
            if (hormiga.getDistanciaRecorrida() < this.distanciaOptima) {
                if(hormiga.getCiudadActual().getValue() == this.ciudadFinal.getValue()){
                this.setCaminoOptimo(hormiga.getCiudadesRecorridas());
                this.setDistanciaOptima(hormiga.getDistanciaRecorrida());
                }
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
     * @param factorExploracion
     * @return La arista seleccionada.
     */
    
    
    public Arista decidirCiudad(ListaSimple<Double> probabilidades, ListaSimple<Arista> ciudadesCandidatas, Double factorExploracion) {
        ListaSimple<Integer> index = new ListaSimple();
        double probMayor = 0;
        int posicion = -1;
        
        for (int i = 0; i < probabilidades.getSize(); i++) {
            double probActual = (double) probabilidades.GetData(i);
            if (probActual >= probMayor) {
                if(probActual > probMayor){
                    posicion = i;
                }
                probMayor = probActual;
                index.Append(i);
               
            }
        }
        Random randomNumbers = new Random();
        
        if(randomNumbers.nextDouble(1) < factorExploracion){
            int indexArista = randomNumbers.nextInt(index.getSize());
            return ciudadesCandidatas.GetData(indexArista);
        }
        else{
            return ciudadesCandidatas.GetData(posicion);
        }
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
    
    /**
     * Genera y devuelve una cadena con los resultados de la simulación.
     *
     * Este método construye una cadena que contiene el resumen de toda la simulación.
     *
     * @return Una cadena con los resultados de la simulación.
     */
    public String finSimulacion(){
        String finSimulacion = "RESULTADOS DE LA SIMULACIÓN" + "\n\nCICLOS TOTALES: "+ String.valueOf(this.ciclos)+"\nHORMIGAS EN EL SISTEMA: " + String.valueOf(this.hormigas.getSize()) + "\n\n";
        String caminoOpt = "";
        for (int i = 0; i < caminoOptimo.getSize()-1; i++) {
            caminoOpt += String.valueOf(caminoOptimo.GetData(i).getValue()) + "-";
        }
        caminoOpt += String.valueOf(caminoOptimo.GetData(caminoOptimo.getSize()-1).getValue());
        
        finSimulacion += "CAMINO ÓPTIMO: " + caminoOpt + "\nDISTANCIA ÓPTIMA: " + String.valueOf(this.distanciaOptima) + "\n";
        
        for (int i = 0; i < this.historial.getSize(); i++) {
            Historial historialCiclo = this.historial.GetData(i);
            finSimulacion += "\nCICLO (" + (i+1) + ")\n";
            for (int j = 0; j < historialCiclo.getHistorialHormigas().getSize(); j++) {
                HistorialHormiga historialHor = historialCiclo.getHistorialHormigas().GetData(j);
                finSimulacion += "HORMIGA (" + String.valueOf(historialHor.getHormiga()) + ") -- CAMINO RECORRIDO: " + historialHor.getCaminoRecorrido() + " -- DISTANCIA RECORRIDA: " + String.valueOf(historialHor.getDistanciaRecorrida()) + "\n";
            }
            
        }
        finSimulacion += this.feromonasFinales();
        return finSimulacion;
    }
    
    /**
     * Genera una cadena de texto que representa las feromonas finales en cada
     * arista del grafo.
     *
     * @return Una cadena de texto que contiene las feromonas en cada arista con
     * el formato: 
*         FEROMONAS POR CAMINO:
     *         CAMINO X-Y: Z
     * Donde X e Y son los valores de los vértices de la arista y Z es el
     * valor de las feromonas en esa arista.
     */
    public String feromonasFinales(){

        String feromonas = "\n\nFEROMONAS POR CAMINO:\n";
        for (int i = 0; i < this.grafo.getCiudades().getSize(); i++) {
            Ciudad ciudad = this.grafo.getCiudades().GetData(i);
            for (int j = 0; j < ciudad.getAristas().getSize(); j++) {
                Arista arista = ciudad.getAristas().GetData(j);
                if (arista.getOrigen().getValue() > arista.getDestino().getValue()) {
                    DecimalFormat formato = new DecimalFormat("#.##");
                    String fer = formato.format(arista.getFeromonas());
                    feromonas += "CAMINO " + String.valueOf(arista.getOrigen().getValue()) + "-" +String.valueOf(arista.getDestino().getValue()) + ": " + fer + "\n";
                }
            }
            
        }
        return feromonas;
    }
}
