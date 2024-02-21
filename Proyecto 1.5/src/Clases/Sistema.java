/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Arista;
import edd.Ciudad;
import edd.Grafo;
import edd.ListaSimple;

public class Sistema {
    
    //Atributos
    private Grafo grafo;
    private ListaSimple<Hormiga> hormigas;
    private int ciclos;
    private Ciudad ciudadInico;
    private Ciudad ciudadFinal;
    private double alfa;
    private double beta;
    private double q; //Aprendizaje
    private ListaSimple<Ciudad> caminoOptimo;
    private double distanciaOptima;
    private ListaSimple<Historial> historial;

    public Sistema(Grafo grafo, ListaSimple<Hormiga> hormigas, int ciclos, Ciudad ciudadInico, Ciudad ciudadFinal, double alfa, double beta, double q) {
        this.grafo = grafo;
        this.hormigas = hormigas;
        this.ciclos = ciclos;
        this.ciudadInico = ciudadInico;
        this.ciudadFinal = ciudadFinal;
        this.alfa = alfa;
        this.beta = beta;
        this.q = q;
        this.caminoOptimo = new ListaSimple();
        this.distanciaOptima = 0;
        this.historial = new ListaSimple();
    }
    
    //Getter and Setter
    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public ListaSimple<Hormiga> getHormigas() {
        return hormigas;
    }

    public void setHormigas(ListaSimple<Hormiga> hormigas) {
        this.hormigas = hormigas;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public Ciudad getCiudadInico() {
        return ciudadInico;
    }

    public void setCiudadInico(Ciudad ciudadInico) {
        this.ciudadInico = ciudadInico;
    }

    public Ciudad getCiudadFinal() {
        return ciudadFinal;
    }

    public void setCiudadFinal(Ciudad ciudadFinal) {
        this.ciudadFinal = ciudadFinal;
    }

    public double getAlfa() {
        return alfa;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getRho() {
        return q;
    }

    public void setRho(double rho) {
        this.q = rho;
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
    
    //Primitivas
    
    public void inicializar(){
        for (int i = 0; i < ciclos; i++) {
            for (int j = 0; j < hormigas.getSize(); j++) {
                this.moverHormiga(hormigas.GetData(j));
            }
        }
        
    }
    
    public void moverHormiga(Hormiga hormiga){
        //Para mover una hormiga primero debes aplicar la funcion de ciudadesCandidtas a la hormiga
        // Luego debes obtener las probabilidades de esas cicudades candidatas
        
        //Luego verificar en que indice de la lista de double generada por la funcion de probabilidad
        //se encuentra la mayor probabilidad, guardar dicho indice
        
        //Buscar la ciudad que se encuentre en el indice en la lista de ciudades candidatas y esa sera la ciudad a la que la hormiga se mover[a
        
        //Aplicar a la hormiga el metodo/funcion visitarCiudad tomando la ciudad anterior junto con su peso
    }
    
    public ListaSimple<Ciudad> ciudadesCandidatas(Hormiga hormiga){
        Ciudad ciudadActual = hormiga.getCiudadActual();
        ListaSimple<Ciudad> ciudadesCandidatas = new ListaSimple();
        
        if(grafo.getCiudad(ciudadActual.getValue()) != null){
            ListaSimple<Arista> ListAdy = grafo.getCiudad(ciudadActual.getValue()).getAristas();
            for (int i = 0; i < ListAdy.getSize(); i++) {
                if(hormiga.getCiudadesRecorridas().Search(ListAdy.GetData(i).getDestino())){
                    ciudadesCandidatas.Append(ListAdy.GetData(i).getDestino());
                }
            }
            return ciudadesCandidatas;
        }else{
            return null;
        }      
    }
    
    public ListaSimple<(double)> obtenerProbabilidades(ListaSimple<Ciudad> ciudadesCandidatas){
        //Revisar la formula en el proyecto
        return null;
    }
    
    public void actualizarFeromonas(){
        //Esto llamará a las funciones evaporar feromonas e incrementar segun sea el caso
    }
    
    public void eveporarFeromonas(){
    
    }
    
    public void incrementarFeromonas(){
    
    }
       
}
