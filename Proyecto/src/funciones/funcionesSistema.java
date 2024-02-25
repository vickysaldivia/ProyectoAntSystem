/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import Clases.Hormiga;
import Clases.Sistema2;
import edd.Arista;
import edd.Ciudad;
import edd.ListaSimple;

/**
* Clase con funciones auxiliares para el sistema de hormigas.
*
* @author vickysaldivia
*/
public class funcionesSistema {
    
    /**
    * Inicializa una lista de hormigas con el número dado de hormigas, cada una en la
    * ciudad inicial dada.
    *
    * @param numHormigas  El número de hormigas a inicializar.
    * @param ciudadInicial La ciudad inicial de cada hormiga.
    * @return Una lista de hormigas inicializadas.
    */
    public ListaSimple<Hormiga> inicializarHormigas(int numHormigas, Ciudad ciudadInicial){
        ListaSimple<Hormiga> listHormigas = new ListaSimple();
        for (int i = 0; i < numHormigas; i++) {
            Hormiga hormiga = new Hormiga(ciudadInicial);
            hormiga.getCiudadesRecorridas().Append(ciudadInicial);
            listHormigas.Append(hormiga);
        }
        
        return listHormigas;
    }
    
    /**
    * Inicializa las feromonas en todas las aristas del grafo con el valor dado.
    *
    * @param sistema El sistema de hormigas con el grafo donde inicializar las feromonas.
    */
    public void inicializarFeromonas(Sistema2 sistema){
        int numCiudades = sistema.getGrafo().getCiudades().getSize();
        for (int i = 0; i < numCiudades; i++) {
            Ciudad ciudadActual = (Ciudad) sistema.getGrafo().getCiudades().GetData(i);
            for (int j = 0; j < ciudadActual.getAristas().getSize(); j++) {
                Arista arista = (Arista) ciudadActual.getAristas().GetData(j);
                arista.setFeromonas(1.0/numCiudades);
            }
        }
    }
}
