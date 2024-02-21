/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author vickysaldivia
 */
public class ListaSimple<T> {
    // Nodo apuntador al primero de la lista
    private Nodo pFirst;
    private int size;

    // Constructor
    public ListaSimple() {
        this.pFirst = null;
        this.size = 0;
    }
    
    // Getters y Setters de los atributos de la lista
    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    // Primitivas
    
    //Destructor
    public void DeleteList(){
        this.pFirst = null;
        this.size = 0;
    }
    
    //Función para verificar si la lista está vacía.
    // True: this.pFirst == null
    // False: this.pFirst != null
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    // Funcion para insertar al final
    public void Append(T data){
        Nodo pNew = new Nodo(data);
        if (isEmpty()){
            this.pFirst = pNew;
        }
        else{
            Nodo aux = this.pFirst;
            while(aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(pNew);
        }
        this.size ++;
    }
    
    //Funcion para insertar al inicio
    public Nodo PreAppend(T data){
        Nodo pNew = new Nodo(data);
        if(isEmpty()){
            this.pFirst = pNew;
        }
        else{
            pNew.setpNext(pFirst);
            pFirst = pNew;
        }
        this.size ++;
        return pNew;
    }
    
    //Funcion para insertar por Posicion //utilizar try catch para evaluar la posicion
    public void InsertPosition(int pos, T data){
        if(pos>=0 && pos<=this.size-1){
            if(pos == 0){
                this.PreAppend(data);
            }
            else if(pos == this.size-1){
                this.Append(data);
            }
            else{
                Nodo pNew = new Nodo(data);
                Nodo aux = new Nodo();
                aux = this.pFirst;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getpNext();
                }
                pNew.setpNext(aux.getpNext());
                aux.setpNext(pNew);
            }
        this.size ++;
        }
    }
    
    //buscar un elemento de la lista por referencia
    public boolean Search(T referencia){
        Nodo aux = this.pFirst;
        boolean found = false;
        while(aux != null && found == false){
            if(referencia == aux.getData()){
                found = true;
            }
            else{
                aux = aux.getpNext();
            }
        }
        return found;
    }
    
    //Inserta un Nodo por referencia
    public void InsertReference(T referencia, T data){
        Nodo pNew = new Nodo(data);
        Nodo aux = this.pFirst;
        if(!isEmpty()){
            if(this.Search(referencia)){
                while(aux.getData()!= referencia){
                    aux = aux.getpNext();
                }
                pNew.setpNext(aux.getpNext());
                aux.setpNext(pNew);
                this.size ++;
            }
        }
    }
    
    //Transforma una lista en una cadena de caracteres
    public String ListToString(){
        if(!isEmpty()){
            Nodo aux = this.pFirst;
            String string = "";
            for (int i = 0; i < this.size; i++) {
                string = aux.getData().toString() + "\n";
                aux = aux.getpNext();
            }
            return string;
        }
        return "Lista vacía";
    }
    
    public void Show(){
        if(!isEmpty()){
            Nodo aux = this.pFirst;
            for (int i = 0; i < this.size; i++) {
                String info = aux.getData().toString();
                System.out.println(info + "\n");
                aux = aux.getpNext();
            }
        }
    }
    
    public void DeleteByReference(T referencia){
        if(Search(referencia)){
            Nodo aux = this.pFirst;
            while(aux.getpNext().getData() != referencia){
                aux = aux.getpNext();
            }
            aux.setpNext(aux.getpNext().getpNext());
        }
        this.size --;
    }
    
    public void DeleteByPosition(int pos){
        if(!isEmpty()){
            if(pos>= 0 && pos< this.size){
                if(pos==0){
                    this.pFirst = this.pFirst.getpNext();
                }
                else{
                    Nodo aux = new Nodo();
                    aux = this.pFirst;
                    for (int i = 0; i < pos-1; i++) {
                        aux = aux.getpNext();
                    }
                    aux.setpNext(aux.getpNext().getpNext());
                }
            this.size --;
            }
        }
    }
    
    // Editar info de un Nodo mediante su referencia
    public void EditByReference(T referencia, T data){
        if(this.Search(referencia)){
            Nodo aux = this.pFirst;
            while(aux.getData() != referencia){
                aux = aux.getpNext();
            }
            aux.setData(data);
        }
    }
    
    // Editar info de un Nodo mediante su posicion
    public void EditByPosition(int pos, T data){
        if(pos>= 0 && pos <=this.size-1){
            if(pos == 0){
                this.pFirst.setData(data);
            }
            else{
                Nodo aux = this.pFirst;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getpNext();  
                }
                aux.setData(data);
            }
        }
    }
    
    public T GetData(int pos){
        if(pos>= 0 && pos < this.size){
            if(pos == 0){
                return (T) this.pFirst.getData();
            }
            else{
                Nodo aux = this.pFirst;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getpNext();
                }
                return (T) aux.getData();
            }
        }
        return null;
    }
    
    public Nodo GetNodo(int pos){
        if(pos>= 0 && pos < this.size){
            if(pos == 0){
                return this.pFirst;
            }
            else{
                Nodo aux = this.pFirst;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getpNext();
                }
                return aux;
            }
        }
        return null;
    }
    
    public int GetIndex(Nodo node){
        if(!isEmpty()){
            int counter = 0;
            Nodo aux = this.pFirst;
            while(aux != null){
                if(node == aux){
                    return counter;
                }
                else{
                    counter ++;
                    aux = aux.getpNext();
                }
            }
            return -1;
        }
        return -1;
    }
    
    public int GetPosition(T referencia){
        if(this.Search(referencia)){
            int counter = 0;
            Nodo aux = this.pFirst;
            while(aux.getData() != referencia){
                counter ++;
                aux = aux.getpNext();
                }
            return -1;
            }
        else{
            return -1;
        }
    }
    
}
