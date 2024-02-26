/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
* Clase que representa un grafo como una lista de ciudades, donde cada
* ciudad tiene una lista de aristas conectadas a otras ciudades.
*
* @author vickysaldivia
*/
public class Grafo {
    private ListaSimple<Ciudad> ciudades;

    /**
    * Constructor por defecto de la clase Grafo. Inicializa la lista de ciudades.
    */
    public Grafo() {
        this.ciudades = new ListaSimple();
    }
    
    /**
    * Devuelve la lista de ciudades del grafo.
    *
    * @return lista de ciudades.
    */
    public ListaSimple<Ciudad> getCiudades() {
        return ciudades;
    }

    /**
    * Establece la lista de ciudades del grafo.
    *
    * @param ciudades lista de ciudades.
    */
    public void setCiudades(ListaSimple<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
    
    /**
     * Añade una ciudad al grafo.
     *
     * @param ciudad ciudad a añadir.
     */
    public void addCiudad(Ciudad ciudad){
        this.ciudades.Append(ciudad);
    }
    
    /**
     * Devuelve una ciudad a partir de su valor.
     *
     * @param numCiudad valor de la ciudad a buscar.
     * @return ciudad encontrada o null en caso de no encontrarla.
     */
    public Ciudad getCiudad(int numCiudad){
        for (int i = 0; i < this.ciudades.getSize(); i++) {
            Ciudad ciudad = (Ciudad) ciudades.GetData(i);
            if(ciudad.getValue() == numCiudad){
                return ciudad;
            }
        }
        return null; 
    }
    
    /**
    * Imprime por pantalla las ciudades y sus aristas.
    */
    public void printCiudades(){
        for (int i = 0; i < this.ciudades.getSize(); i++) {
            Ciudad ciudad = this.ciudades.GetData(i);
            System.out.println("CIUDADES");
            System.out.println(ciudad.getValue());
            for (int j = 0; j < ciudad.getAristas().getSize(); j++) {
                System.out.println("ARISTAS");
                Arista arista = (Arista) ciudad.getAristas().GetData(j);
                System.out.println("Origen: " + arista.getOrigen().getValue());
                System.out.println("\nDestino: " + arista.getDestino().getValue());
                System.out.println("\nDistancia: " + arista.getDistancia());
                
            }
            System.out.println("--------");
            
            }
        }
    
    /**
     * Devuelve una cadena de texto con la información de una ciudad y sus
     * aristas.
     *
     * @param numCiudad valor de la ciudad a buscar.
     * @return cadena de texto con la información de la ciudad y sus aristas.
     */
    public String stringCiudad(int numCiudad){
        String infoCiudad = "";
        Ciudad ciudad = getCiudad(numCiudad);
        infoCiudad += "CIUDAD: "+ String.valueOf(numCiudad);
        infoCiudad += "\n\nCONEXIONES:";
        for (int i = 0; i < ciudad.getAristas().getSize(); i++) {
            Arista arista = (Arista) ciudad.getAristas().GetData(i);
            infoCiudad += "\nOrigen: " + String.valueOf(arista.getOrigen().getValue());
            infoCiudad += "\nDestino: " + String.valueOf(arista.getDestino().getValue());
            infoCiudad += "\nDistancia: " + String.valueOf(arista.getDistancia());
        }
        return infoCiudad;
    }
    
    /**
     * Vacía el grafo, eliminando todas las ciudades y aristas.
     */
    public void emptyGrafo(){
        this.ciudades = new ListaSimple();
    }
    
    /**
     * Añade una arista al grafo, conectando dos ciudades previamente agregadas.
     *
     * @param origen el valor de la ciudad origen de la arista.
     * @param destino el valor de la ciudad destino de la arista.
     * @param distancia la distancia de la arista.
     */
    public void addArista(int origen, int destino, double distancia){
        Ciudad ciudadOrigen = this.getCiudad(origen);
        Ciudad ciudadDestino = this.getCiudad(destino);
        
        if(ciudadOrigen != null && ciudadDestino != null){
            ciudadOrigen.getAristas().Append(new Arista(ciudadOrigen, ciudadDestino, distancia));
            ciudadDestino.getAristas().Append(new Arista(ciudadDestino, ciudadOrigen, distancia)); 
        } 
    }
    
    /**
     * Ordena una lista de aristas en orden ascendente según el valor del
     * destino de la arista.
     *
     * @param Aristas la lista de aristas a ordenar.
     */
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

    
    /**
     * Elimina una ciudad y todas las aristas que la conectan del grafo.
     *
     * @param numCiudad el valor de la ciudad a eliminar.
     */
    public void eliminarCiudad (int numCiudad){
        Ciudad ciudadEliminar = this.getCiudad(numCiudad);
        
        if(ciudadEliminar != null){
            
            for (int i = 0; i < ciudadEliminar.getAristas().getSize(); i++) {
                Arista arista = (Arista) ciudadEliminar.getAristas().GetData(i);
                
                int ciudadDestino = arista.getDestino().getValue();
                this.eliminarArista(numCiudad, ciudadDestino);
            }
            for (int i = 0; i < this.getCiudades().getSize(); i++) {
                if(this.getCiudades().GetData(i).getValue() == numCiudad){
                    ciudades.DeleteByPosition(i);
                }
            }
            

        }
    }
    
    /**
     * Elimina una arista del grafo.
     *
     * @param origen el valor de la ciudad origen de la arista a eliminar.
     * @param destino el valor de la ciudad destino de la arista a eliminar.
     */
    public void eliminarArista(int origen, int destino){
        Ciudad ciudadEliminar = this.getCiudad(origen);
        
        Ciudad ciudadDestino = this.getCiudad(destino);
        
        if(ciudadEliminar != null && ciudadDestino != null){
            
            for (int i = 0; i < ciudadDestino.getAristas().getSize(); i++) {
                Arista arista = ciudadDestino.getAristas().GetData(i);
                if(arista.getDestino() == ciudadEliminar){
                    ciudadDestino.getAristas().DeleteByPosition(i);
                }
                
            }
        }
    }
    
    /**
     * Transforma el grafo en una cadena.
     * @return Cade a del grafo.
     */
    @Override
    public String toString() {
         
        StringBuilder sb = new StringBuilder();
        sb.append("ciudad\n");
        for (int i = 0; i < ciudades.getSize();i++) {
            Ciudad ciudad = (Ciudad) ciudades.GetData(i);
            sb.append(ciudad.getValue()).append("\n");
        }
        sb.append("aristas\n");
        for (int i = 0; i < ciudades.getSize();i++) {
            Ciudad ciudad = (Ciudad) ciudades.GetData(i);
            for (int j = 0; j < ciudad.getAristas().getSize();j++) {
                Arista arista = (Arista) ciudad.getAristas().GetData(j);
                if(ciudad.getValue() > arista.getDestino().getValue()){
                    sb.append(arista.getOrigen().getValue()).append(",").append(arista.getDestino().getValue()).append(",").append(arista.getDistancia()).append("\n");
                }
            }
        }
        return sb.toString();
    }
    
    /**
     * Transforma las ciudades en una cadena mostrada como lista.
     * @return Cadena de. valor de cada ciudad.
     */
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

}

