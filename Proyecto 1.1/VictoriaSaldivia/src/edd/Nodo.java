/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author vickysaldivia
 */
public class Nodo<T> {
    // Atributos de la clase Nodo
    private T data;
    private Nodo pNext;
    
    // Constructor de Nodo vacío
    public Nodo() {
        this.data = null;
        this.pNext = null;
    }
    
    // Constructor de Nodo tomando por parámetro la información
    public Nodo(T data) {
        this.data = data;
        this.pNext = null;
    }
    
    // Constructor de Nodo completo
    public Nodo(T data, Nodo pNext) {
        this.data = data;
        this.pNext = pNext;
    }
    
    // Getters y Setters para los atributos de la clase Nodo
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
    
    
    
}
