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
    private ListaSimple aristas; //Contienen las aristas

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
        aristas.DeleteByReference(arista); // encuentra el objeto de arista en la lista y la elimina
    }
}
