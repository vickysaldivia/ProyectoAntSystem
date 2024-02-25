/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
* Clase genérica ListaSimple que representa una lista simplemente enlazada.
*
* @param <T> Tipo genérico de los datos almacenados en la lista.
*
* @author vickysaldivia
*/
public class ListaSimple<T> {
    // Nodo apuntador al primero de la lista
    private Nodo pFirst;
    private int size;

    /**
    * Crea una nueva instancia de ListaSimple.
    * Inicializa el puntero al primer nodo en null y el tamaño en 0.
    */
    public ListaSimple() {
        this.pFirst = null;
        this.size = 0;
    }
    
    /**
    * Devuelve el primer nodo de la lista.
    *
    * @return el primer nodo de la lista.
    */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
    * Establece el primer nodo de la lista.
    *
    * @param pFirst el nuevo primer nodo de la lista.
    */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }
    
    /**
    * Devuelve el tamaño de la lista.
    *
    * @return el tamaño de la lista.
    */
    public int getSize() {
        return size;
    }
    
    /**
    * Establece el tamaño de la lista.
    *
    * @param size el nuevo tamaño de la lista.
    */
    public void setSize(int size) {
        this.size = size;
    }
    
    // Primitivas
    
    /**
    * Destructor de la lista.
    * Elimina todos los nodos de la lista y establece el puntero al primer nodo en null y el tamaño en 0.
    */
    public void DeleteList(){
        this.pFirst = null;
        this.size = 0;
    }
    
    /**
    * Verifica si la lista está vacía.
    *
    * @return true si la lista está vacía, false en caso contrario.
    */
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    /**
    * Inserta un nuevo dato al final de la lista.
    *
    * @param data el dato a insertar.
    */
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
    
    /**
    * Inserta un nuevo dato al inicio de la lista.
    *
    * @param data el dato a insertar.
    * @return el nuevo nodo creado.
    */
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
    
    /**
    * Inserta un nuevo dato en una posición específica de la lista.
    *
    * @param pos la posición donde se insertará el dato.
    * @param data el dato a insertar.
    * @throws IndexOutOfBoundsException si la posición es menor a 0 o mayor al tamaño de la lista.
    */
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
    
    /**
    * Busca un elemento de la lista por referencia.
    *
    * @param referencia el elemento a buscar.
    * @return true si el elemento fue encontrado, false en caso contrario.
    */
    public boolean Search(T referencia){
        Nodo aux = this.pFirst;
        boolean found = false;
        while(aux != null && found == false){
            if(referencia == aux.getData()){
                found = true;
                return true;
            }
            else{
                aux = aux.getpNext();
            }
        }
        return false;
    }
    
    /**
    * Inserta un nodo por referencia.
    *
    * @param referencia la referencia del nodo anterior al que se insertará el nuevo nodo.
    * @param data el dato a almacenar en el nuevo nodo.
    */
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
    
    /**
     * Permite transformar una lista en un String.
     * 
     * @return String de la lista.
     */
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
    
    /**
     * Permite imprimir por pantalla los elementos de una lista.
     */
    public void Show(){
        if(!isEmpty()){
            String list = "";
            Nodo aux = this.pFirst;
            for (int i = 0; i < this.size; i++) {
                String info = aux.getData().toString();
                list += info + ", ";  
                aux = aux.getpNext();
            }
            System.out.println(list);
        }
    }
    
    /**
    * Elimina un nodo por referencia.
    *
    * @param referencia la referencia del nodo a eliminar.
    */
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
    
    /**
    * Elimina un nodo en la posición especificada.
    *
    * @param pos la posición del nodo a eliminar.
    * @throws IndexOutOfBoundsException si la posición está fuera de rango.
    */
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
    
    /**
     * Edita la información de un nodo mediante su referencia.
     *
     * @param referencia la referencia del nodo a editar.
     * @param data la nueva información del nodo.
     */
    public void EditByReference(T referencia, T data){
        if(this.Search(referencia)){
            Nodo aux = this.pFirst;
            while(aux.getData() != referencia){
                aux = aux.getpNext();
            }
            aux.setData(data);
        }
    }
    
    /**
     * Edita la información de un nodo mediante su posición.
     *
     * @param pos la posición del nodo a editar.
     * @param data la nueva información del nodo.
     * @throws IndexOutOfBoundsException si la posición está fuera de rango.
     */
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
    
    /**
    * Obtiene el dato en la posición especificada.
    *
    * @param pos la posición del nodo a obtener.
    * @return el dato en la posición especificada.
    * @throws IndexOutOfBoundsException si la posición está fuera de rango.
    */
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
    
    /**
    * Obtiene el nodo en la posición especificada.
    *
    * @param pos la posición del nodo a obtener.
    * @return el nodo en la posición especificada.
    * @throws IndexOutOfBoundsException si la posición está fuera de rango.
    */
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
    
    /**
     * Obtiene el índice de un nodo en la lista.
     *
     * @param node el nodo a buscar.
     * @return el índice del nodo en la lista, -1 en caso de no encontrarlo.
     */
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
    
    /**
     * Obtiene la posición de un elemento en la lista.
     *
     * @param referencia el elemento a buscar.
     * @return la posición del elemento en la lista, -1 en caso de no
     * encontrarlo.
     */
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
