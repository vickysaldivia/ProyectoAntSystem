/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import edd.Arista;
import edd.Ciudad;
import edd.Grafo;
import edd.ListaSimple;

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
    
    public Sistema2(Grafo grafo, ListaSimple<Hormiga> hormigas, int ciclos, Ciudad ciudadInico, Ciudad ciudadFinal, double alfa, double beta, double rho) {
        this.grafo = grafo;
        this.hormigas = hormigas;
        this.ciclos = ciclos;
        this.ciudadInico = ciudadInico;
        this.ciudadFinal = ciudadFinal;
        this.alfa = alfa;
        this.beta = beta;
        this.rho = rho;
        this.q = 1;
        this.caminoOptimo = new ListaSimple();
        this.distanciaOptima = 1000;
        this.historial = new ListaSimple();
        this.historialtemp = new ListaSimple();
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
    
    public void simulacion() {
        for (int i = 0; i < this.ciclos; i++) {
            for (int j = 0; j < this.hormigas.getSize(); j++) {
                recorridoCompleto(hormigas.GetData(j));
                hormigas.GetData(j).getCiudadesRecorridas().Show();
                //System.out.println(this.ciudadInico);
            }
            //evaporarFeromonas();
            //this.reiniciarHormigas();
            //this.hormigas.Show();
        }
    }
    
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
        
        //this.incrementarFeromonas(hormiga);
    }
    
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
    
    public Arista decidirCiudad(ListaSimple<Double> probabilidades, ListaSimple<Arista> ciudadesCandidatas) {
        int posicion = -1;
        double probMayor = 0;
        for (int i = 0; i < probabilidades.getSize(); i++) {
            double probActual = (double) probabilidades.GetData(i);
            if (probActual > probMayor) {
                probMayor = probActual;
                posicion = i;
            }
        }
        Arista aristaElegida = ciudadesCandidatas.GetData(posicion);
        return aristaElegida;
    }
    
    public void reiniciarHormigas() {
        for (int i = 0; i < this.hormigas.getSize(); i++) {
            Hormiga hormigaActual = this.hormigas.GetData(i);
            hormigaActual.setCiudadActual(this.ciudadInico);
            hormigaActual.setDistanciaRecorrida(0);
            hormigaActual.getCiudadesRecorridas().DeleteList();
           
        }
    }
    
//    public void evaporarFeromonas() {
//        // arista verificar si destino > origen
//        for (int i = 0; i < grafo.getCiudades().getSize(); i++) {
//            Ciudad ciudadActual = (Ciudad) grafo.getCiudades().GetData(i);
//            for (int j = 0; j < ciudadActual.getAristas().getSize(); j++) {
//                Arista aristaActual = (Arista) ciudadActual.getAristas().GetData(j);
//                if (ciudadActual.getValue() < aristaActual.getDestino().getValue()) {
//                    double newFeromonas = aristaActual.getFeromonas() * (1 - this.getRho());
//                    aristaActual.setFeromonas(newFeromonas);
//                }
//            }
//        }
//    }
//    
//    public void incrementarFeromonas(Hormiga hormiga) {
//        double visibilidad = q / hormiga.getDistanciaRecorrida();
//        
//        for (int i = 0; i < hormiga.getCiudadesRecorridas().getSize(); i++) {
//            Ciudad ciudadActual = hormiga.getCiudadesRecorridas().GetData(i);
//            Ciudad siguienteCiudad = hormiga.getCiudadesRecorridas().GetData(i);
//            
//            double totalFeromonas = visibilidad + ciudadActual.buscarArista(siguienteCiudad.getValue()).getFeromonas();
//            ciudadActual.buscarArista(siguienteCiudad.getValue()).setFeromonas(totalFeromonas);
//        }
//    }
    
}
