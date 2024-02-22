/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import edd.Arista;
import edd.Ciudad;
import edd.Grafo;
import edd.ListaSimple;
import funciones.funcionesSistema;
import javax.swing.JOptionPane;

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
    private ListaSimple<HistorialHormiga> historialtemp;

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
        
        for (int i = 0; i < grafo.getCiudades().getSize(); i++) {
            System.out.println(hormiga.getCiudadActual().getValue());
            if(hormiga.getCiudadActual().getValue() != ciudadFinal.getValue()){
                ListaSimple ciudadesCandidatas = ciudadesCandidatas(hormiga);
                if (ciudadesCandidatas.getSize() != 0) {
                    Arista arista = decidirProximaCiudad(this.obtenerProbabilidades(ciudadesCandidatas(hormiga)), this.ciudadesCandidatas(hormiga));
                    
                    hormiga.visitarCiudad(arista.getDestino(), arista.getDistancia());
                }
                break;
            }
            break;
            
        }
        
        
        
        
    }
    
    public ListaSimple<Arista> ciudadesCandidatas(Hormiga hormiga){
        Ciudad ciudadActual = hormiga.getCiudadActual();
        ListaSimple<Arista> ciudadesCandidatas = new ListaSimple();
        
        if(grafo.getCiudad(ciudadActual.getValue()) != null){
            ListaSimple<Arista> ListAdy = grafo.getCiudad(ciudadActual.getValue()).getAristas();
            for (int i = 0; i < ListAdy.getSize(); i++) {
                if(!hormiga.getCiudadesRecorridas().Search(ListAdy.GetData(i).getDestino())){
                    ciudadesCandidatas.Append(ListAdy.GetData(i));
                }
            }
            ciudadesCandidatas.Show();
            return ciudadesCandidatas;
        }else{
            return null;
        }      
    }
    
    public ListaSimple obtenerProbabilidades(ListaSimple<Arista> ciudadesCandidatas){
        ListaSimple<Double> ciudadesProbabilidades = new ListaSimple();
        double sumatoria = 0;
        
        for (int i = 0; i < ciudadesCandidatas.getSize(); i++) {
            Arista arista = ciudadesCandidatas.GetData(i);
            double probabilidad = Math.pow(arista.getFeromonas(),alfa)*Math.pow(1/arista.getDistancia(), beta);
            ciudadesProbabilidades.Append(probabilidad);
            sumatoria += probabilidad;
        }
        
        for (int i = 0; i < ciudadesProbabilidades.getSize(); i++) {
            double probabilidadCiudad = ciudadesProbabilidades.GetData(i)/sumatoria;
            ciudadesProbabilidades.EditByPosition(i, probabilidadCiudad);
            
        }
        

      return ciudadesProbabilidades;  
    }
    
    public Arista decidirProximaCiudad(ListaSimple probabilidades, ListaSimple ciudadesCandidatas){
        int posicion = -1;
        double probMayor = 0;
        for (int i = 0; i < probabilidades.getSize(); i++) {
            double probActual = (double) probabilidades.GetData(i);
            if(probActual > probMayor){
                probMayor = probActual;
                posicion = i;
            }
        }
        Arista aristaElegida = (Arista) ciudadesCandidatas.GetData(posicion);
        return aristaElegida;
    }
   
    
    //SOLO SE LLAMA AL FINAL DEL CICLO!!!!!!!
    public void evaporarFeromonas(){
       // arista verificar si destino > origen
        for (int i = 0; i < grafo.getCiudades().getSize(); i++) {
            Ciudad ciudadActual = (Ciudad) grafo.getCiudades().GetData(i);
            for (int j = 0; j < ciudadActual.getAristas().getSize(); j++) {
                Arista aristaActual = (Arista) ciudadActual.getAristas().GetData(j);
                if(ciudadActual.getValue() < aristaActual.getDestino().getValue()){
                    double newFeromonas = aristaActual.getFeromonas() * (1- this.getRho());
                    aristaActual.setFeromonas(newFeromonas);  
                }
            }
        }
    }
    
    public void incrementarFeromonas(){
        for (int i = 0; i < hormigas.getSize(); i++) {
            Hormiga hormiga = hormigas.GetData(i);
            
            for (int j = 0; j < hormiga.getCiudadesRecorridas().getSize()-1; j++) {
                Ciudad ciudad = hormiga.getCiudadesRecorridas().GetData(j);
                Ciudad ciudadSiguiente = hormiga.getCiudadesRecorridas().GetData(j+1);
                
                for (int k = 0; k < ciudad.getAristas().getSize(); k++) {
                    Arista arista = (Arista) ciudad.getAristas().GetData(k);
                    if(arista.getDestino() == ciudadSiguiente){
                        arista.setFeromonas(arista.getFeromonas()+1/hormiga.getDistanciaRecorrida());
                    }
                }
            }
        }
    }
    
    public HistorialHormiga llenarHistorialHormiga(int hormigaValor, Hormiga hormiga){
        String caminoRecorrido = "CIUDADES RECORRIDAS: ";
        for (int i = 0; i < hormiga.getCiudadesRecorridas().getSize()-1; i++) {
            Ciudad ciudadRecorrida = hormiga.getCiudadesRecorridas().GetData(i);
            caminoRecorrido += String.valueOf(ciudadRecorrida.getValue()) + ",";  
        }
        Ciudad ciudadRecorrida = hormiga.getCiudadesRecorridas().GetData(hormiga.getCiudadesRecorridas().getSize()-1);
        caminoRecorrido += String.valueOf(ciudadRecorrida.getValue());  
        
        double distanciaRecorrida = hormiga.getDistanciaRecorrida();
        
        return new HistorialHormiga(hormigaValor,caminoRecorrido,distanciaRecorrida);
    }

    
    public void iniciarCiclo(int i){
        funcionesSistema func = new funcionesSistema();
        JOptionPane.showMessageDialog(null, "INICIO DEL CICLO " + (i+1));
        hormigas = func.inicializarHormigas(hormigas.getSize(), ciudadInico);
        if(i == 0){
            func.inicializarFeromonas(this);
        }
        
        for (int j = 0; j < hormigas.getSize(); j++) {
            this.moverHormiga(hormigas.GetData(j));
            HistorialHormiga historialHormiga = this.llenarHistorialHormiga(j+1, hormigas.GetData(j));
            
            if(historialHormiga.getDistanciaRecorrida() > this.distanciaOptima){
                this.distanciaOptima = historialHormiga.getDistanciaRecorrida();
                this.caminoOptimo = hormigas.GetData(j).getCiudadesRecorridas();
            }
            
            this.historialtemp.Append(historialHormiga);
        }
        
        Historial newHistorial = new Historial(historialtemp, caminoOptimo, distanciaOptima);
        this.historial.Append(newHistorial);
        
        this.evaporarFeromonas();
        this.incrementarFeromonas();
        
    }
    
    public String finalizarCiclo(int i){
        String resultadosSimulacion = "SIMULACIÓN - CICLO" + (i+1) + "\n";
        resultadosSimulacion += "CANTIDAD DE HORMIGAS: " + String.valueOf(this.hormigas.getSize()) + "\nCANTIDAD DE CICLOS: " + String.valueOf(ciclos) + "\n";
        String stringcaminoOptimo = "";
        for (int j = 0; j < this.caminoOptimo.getSize(); j++) {
            Ciudad ciudad = this.caminoOptimo.GetData(j);
            stringcaminoOptimo += String.valueOf(ciudad.getValue());
        }
        resultadosSimulacion += "CAMINO MÁS ÓPTIMO: " + stringcaminoOptimo + "\n" + "DISTANCIA MÁS ÓPTIMA: " + String.valueOf(this.getDistanciaOptima());
        
        return resultadosSimulacion;
    }
       
}
