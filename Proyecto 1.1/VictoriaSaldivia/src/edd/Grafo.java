/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author vickysaldivia
 */
public class Grafo {
    private ListaSimple<Ciudad> ciudades;

    
    public Grafo() {
        this.ciudades = new ListaSimple();
    }

    public ListaSimple getCiudades() {
        return ciudades;
    }

    public void setCiudades(ListaSimple ciudades) {
        this.ciudades = ciudades;
    }
    
    
    
    public void addCiudad(Ciudad ciudad){
        this.ciudades.Append(ciudad);
    }
    
    public Ciudad getCiudad(int numCiudad){
        for (int i = 0; i < this.ciudades.getSize(); i++) {
            Ciudad ciudad = (Ciudad) ciudades.GetData(i);
            if(ciudad.getValue() == numCiudad){
                return ciudad;
            }
        }
        return null; 
    }
    
    public void printCiudades(){
        for (int i = 0; i < this.ciudades.getSize(); i++) {
            Ciudad ciudad = this.ciudades.GetData(i);
            System.out.println("CIUDADES");
            System.out.println(ciudad.getValue());
            for (int j = 0; j < ciudad.getAristas().getSize(); j++) {
                System.out.println("ARISTAS");
                Arista arista = (Arista) ciudad.getAristas().GetData(j);
                System.out.println("Origen:" + arista.getOrigen().getValue());
                System.out.println("Destino:" + arista.getDestino().getValue());
                System.out.println("Distancia:" + arista.getDistancia());
                
            }
            System.out.println("--------");
            
            }
        }
    
    
    public void emptyGrafo(){
        this.ciudades = new ListaSimple();
    }
    
    public void addArista(int origen, int destino, double distancia){
        Ciudad ciudadOrigen = this.getCiudad(origen);
        Ciudad ciudadDestino = this.getCiudad(destino);
        
        if(ciudadOrigen != null && ciudadDestino != null){
            Arista newArista = new Arista(ciudadOrigen, ciudadDestino, distancia);
            if(!ciudadOrigen.getAristas().Search(newArista)){
                ciudadOrigen.getAristas().Append(newArista);
                ciudadDestino.getAristas().Append(new Arista(ciudadDestino, ciudadOrigen, distancia));
                this.sortAristaBurbuja(ciudadOrigen.getAristas());
                this.sortAristaBurbuja(ciudadDestino.getAristas());
                
                System.out.println(ciudadOrigen.getValue() + "\n");
                ciudadOrigen.getAristas().Show();
                
                System.out.println(ciudadDestino.getValue() + "\n");
                ciudadDestino.getAristas().Show();
            }
        }
        
        
    }
    
    public void sortAristaBurbuja(ListaSimple Aristas) {
        if (Aristas.getpFirst() == null || Aristas.getpFirst().getpNext() == null) {
            // La lista está vacía o tiene un solo elemento, ya está ordenada
            return;
        }
        boolean intercambio = true;

        while (intercambio) {
            intercambio = false;
            Nodo aux = Aristas.getpFirst();
            Nodo auxpNext = Aristas.getpFirst().getpNext();

            while (auxpNext != null) {
                
                Arista auxData = (Arista) aux.getData();
                Arista auxpNextData = (Arista) auxpNext.getData();
                
                if (auxData.getDestino().getValue() > auxpNextData.getDestino().getValue()) {
                    Arista temp = auxData;
                    auxData = auxpNextData;
                    auxpNextData = temp;
                    intercambio = true;
                }
                aux = auxpNext;
                auxpNext = auxpNext.getpNext();
            }
        }
    }

    
    public void eliminarCiudad (int numCiudad){
        Ciudad ciudadEliminar = this.getCiudad(numCiudad);
        if(ciudadEliminar != null){
            ciudades.DeleteByReference(ciudadEliminar);
            
            
        }
    }
    
    public void eliminarArista(int origen, int destino){
        Ciudad ciudadOrigen = this.getCiudad(origen);
        Ciudad ciudadDestino = this.getCiudad(destino);
        if(ciudadOrigen != null && ciudadDestino != null){
            //COMO LA LISTA DEBERIA ESTAR ORDENADA
            Arista newArista = (Arista) ciudadOrigen.getAristas().GetData(destino-1);
            if(newArista.getDestino() == ciudadDestino){
                ciudadOrigen.getAristas().DeleteByPosition(destino-1);
                ciudadDestino.getAristas().DeleteByPosition(origen-1);
            }  
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
         
        StringBuilder sb = new StringBuilder();
        sb.append("ciudades:\n");
        for (int i = 0; i < ciudades.getSize();i++) {
            Ciudad ciudad = (Ciudad) ciudades.GetData(i);
            sb.append(ciudad.getValue()).append("\n");
        }
        sb.append("aristas:\n");
        for (int i = 0; i < ciudades.getSize();i++) {
            Ciudad ciudad = (Ciudad) ciudades.GetData(i);
            for (int j = 0; j < ciudad.getAristas().getSize();j++) {
                Arista arista = (Arista) ciudad.getAristas().GetData(j);
                sb.append(arista.getOrigen().getValue()).append(" ,").append(arista.getDestino().getValue()).append(" ,").append(arista.getDistancia()).append("\n");
            }
        }
        return sb.toString();
    }
    
public String CiudadesToLista() {
     String NumeroCiudades = "";
     if (!this.ciudades.isEmpty()) {
         Nodo aux = this.ciudades.getpFirst();
         while(aux != null){
             Ciudad ciudad = (Ciudad) aux.getData();
             NumeroCiudades += String.valueOf(ciudad.getValue()) + ",";
             aux = aux.getpNext(); 
         }
         return NumeroCiudades;
     }
     return null;
}

    
    //DFS, DFS RECURSIVO, DIJKSTRA
    public ListaSimple dfs(int numeroCiudad) {
        Ciudad ciudadInicio = getCiudad(numeroCiudad);
        ListaSimple recorrido = new ListaSimple();
        boolean[] visitados = new boolean[ciudades.getSize()];

        if (ciudadInicio != null) {
            dfsRecursivo(ciudadInicio, visitados, recorrido);
        }

        return recorrido;
    }
    
    private void dfsRecursivo(Ciudad ciudad, boolean[] visitados, ListaSimple recorrido) {
        visitados[ciudad.getValue()] = true;
        recorrido.Append(ciudad.getValue());

        for (int i=0; i< ciudad.getAristas().getSize();i++) {
            Arista arista = (Arista) ciudad.getAristas().GetData(i);
            Ciudad adyacente = arista.getDestino();
            if (!visitados[adyacente.getValue()]) {
                dfsRecursivo(adyacente, visitados, recorrido);
            }
        }
    }
    
    public int[] dijkstra(int inicio) {
        int[] distancias = new int[ciudades.getSize()];
        boolean[] visitados = new boolean[ciudades.getSize()];

        for (int i = 0; i < ciudades.getSize(); i++) {
            distancias[i] = Integer.MAX_VALUE;
        }

        distancias[inicio] = 0;

        for (int i = 0; i < ciudades.getSize() - 1; i++) {
            int ciudadActual = obtenerCiudadConMenorDistancia(distancias, visitados);
            visitados[ciudadActual] = true;
            Ciudad c = (Ciudad) ciudades.GetData(ciudadActual);
            for (int j = 0; j < c.getAristas().getSize(); j++) {
                Arista arista = (Arista) c.getAristas().GetData(j);
                int ciudadDestino = arista.getDestino().getValue();
                if (!visitados[ciudadDestino] && distancias[ciudadActual] != Integer.MAX_VALUE &&
                        distancias[ciudadActual] + arista.getDistancia() < distancias[ciudadDestino]) {
                    distancias[ciudadDestino] = distancias[ciudadActual] + (int)arista.getDistancia();
                }
                
            }
        }

        return distancias;
    }
    
    private int obtenerCiudadConMenorDistancia(int[] distancias, boolean[] visitados) {
        int minDistancia = Integer.MAX_VALUE;
        int minIndice = -1;
        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] <= minDistancia) {
                minDistancia = distancias[i];
                minIndice = i;
            }
        }
        return minIndice;
    }
}

