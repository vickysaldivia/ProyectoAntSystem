/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;


/**
* Clase que representa ciudad o vértice en un grafo.
*
* @author vickysaldivia
*/
public class Ciudad {
    private int value;
    private ListaSimple<Arista> aristas; //Contienen las aristas
    
    /**
    * Constructor de la clase Ciudad.
    *
    * @param value valor de la ciudad.
    */
    public Ciudad(int value) {
        this.value = value;
        this.aristas = new ListaSimple();
    }
    
    /**
    * Método que devuelve el valor de la ciudad.
    *
    * @return valor de la ciudad.
    */
    public int getValue() {
        return value;
    }

    /**
    * Método que establece el valor de la ciudad.
    *
    * @param value valor de la ciudad.
    */
    public void setValue(int value) {
        this.value = value;
    }

    /**
    * Método que devuelve la lista de aristas de la ciudad.
    *
    * @return lista de aristas.
    */
    public ListaSimple<Arista> getAristas() {
        return aristas;
    }

    /**
    * Método que establece la lista de aristas de la ciudad.
    *
    * @param aristas lista de aristas.
    */
    public void setAristas(ListaSimple<Arista> aristas) {
        this.aristas = aristas;
    }
    
    
    /**
    * Método que añade una arista a la lista de aristas de la ciudad.
    *
    * @param arista arista a añadir.
    */
    public void agregarArista(Arista arista){
        aristas.Append(arista); 
    }
    
    /**
    * Método que elimina una arista de la lista de aristas de la ciudad.
    *
    * @param arista arista a eliminar.
    */
    public void eliminarArista(Arista arista){
        aristas.DeleteByReference(arista);

    }
    
    /**
    * Método que busca una arista en la lista de aristas de la ciudad.
    *
    * @param numero valor del destino de la arista a buscar.
    * @return arista encontrada o null en caso de no encontrarla.
    */
    public Arista buscarArista (int numero){
        for (int i = 0; i < this.aristas.getSize(); i++) {
            Arista aristaActual = (Arista) this.aristas.GetData(i);
            if(aristaActual.getDestino().getValue() == numero){
                return aristaActual;
            } 
        
        }
        return null;
    
    }

    /**
    * Método que devuelve la representación en cadena de la ciudad.
    *
    * @return representación en cadena de la ciudad.
    */
    @Override
    public String toString() {
        return "Ciudad{" + "value=" + value + ", aristas=" + aristas + '}';
    }
    
    
}

