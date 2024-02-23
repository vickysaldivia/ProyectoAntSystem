/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;


/**
 *
 * @author vickysaldivia
 */
public class Ciudad {
    private int value;
    private ListaSimple<Arista> aristas; //Contienen las aristas

    public Ciudad(int value) {
        this.value = value;
        this.aristas = new ListaSimple();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListaSimple getAristas() {
        return aristas;
    }

    public void setAristas(ListaSimple aristas) {
        this.aristas = aristas;
    }
    
    public void agregarArista(Arista arista){
        aristas.Append(arista); 
    }
    
    public void eliminarArista(Arista arista){
        aristas.DeleteByReference(arista);

    }
    
    public Arista buscarArista (int numero){
        for (int i = 0; i < this.aristas.getSize(); i++) {
            Arista aristaActual = (Arista) this.aristas.GetData(i);
            if(aristaActual.getDestino().getValue()==numero){
                return aristaActual;
            } 
        
        }
        return null;
    
    }

    @Override
    public String toString() {
        return "Ciudad{" + "value=" + value + ", aristas=" + aristas + '}';
    }
    
    
}

