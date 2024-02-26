/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 * Clase que representa el Nodo de una lista simplemente enlazada
 * 
 * @param <T> Define el tipo de dato almacenado en el Nodo
 * 
 * @author vickysaldivia
 */
public class Nodo<T> {
    private T data;
    private Nodo pNext;
    
    /**
     * Constructor de la clase Nodo. Permite crear un Nodo vacío.
     */
    public Nodo() {
        this.data = null;
        this.pNext = null;
    }
    
    /**
     * Constructor de la clase Nodo. Permite crear un Nodo con información.
     * 
     * @param data Define el dato almacenado en el Nodo.
     */
    public Nodo(T data) {
        this.data = data;
        this.pNext = null;
    }
    /**
     * Constructor de la clase Nodo. Permite crear un Nodo con información y el siguiente Nodo.
     * 
     * @param data Define el dato almacenado en el Nodo
     * @param pNext Define el siguiente Nodo de la lista
     */
    public Nodo(T data, Nodo pNext) {
        this.data = data;
        this.pNext = pNext;
    }
    
    /**
     * Obtiene el dato guardado en el Nodo.
     * 
     * @return el dato.
     */
    public T getData() {
        return data;
    }
    
    /**
     * Establece el dato guardado en el Nodo.
     * @param data Define el nuevo dato del Nodo a establecer.
     */

    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * Obtiene el siguiente Nodo de la lista.
     * 
     * @return siguiente Nodo.
     */
    public Nodo getpNext() {
        return pNext;
    }
    
    /**
     * Establece el siguiente Nodo de la lista.
     * @param pNext siguiente Nodo de la lista.
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
    
    
    
}
