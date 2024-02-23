/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import Clases.Hormiga;
import Clases.Sistema;
import Clases.Sistema2;
import edd.Arista;
import edd.Ciudad;
import edd.ListaSimple;


public class funcionesSistema {
    
    //Funcion para inicializar hormigas
    public ListaSimple<Hormiga> inicializarHormigas(int numHormigas, Ciudad ciudadInicial){
        ListaSimple<Hormiga> listHormigas = new ListaSimple();
        for (int i = 0; i < numHormigas; i++) {
            Hormiga hormiga = new Hormiga(ciudadInicial);
            hormiga.getCiudadesRecorridas().Append(ciudadInicial);
            listHormigas.Append(hormiga);
        }
        
        return listHormigas;
    }
    
    //Funcion para inicializar feromonas
    public void inicializarFeromonas(Sistema2 sistema){
        int numCiudades = sistema.getGrafo().getCiudades().getSize();
        
//        System.out.println(numCiudades);
//        System.out.println(1.0/numCiudades);
        for (int i = 0; i < numCiudades; i++) {
            Ciudad ciudadActual = (Ciudad) sistema.getGrafo().getCiudades().GetData(i);
            for (int j = 0; j < ciudadActual.getAristas().getSize(); j++) {
                Arista arista = (Arista) ciudadActual.getAristas().GetData(j);
                arista.setFeromonas(1.0/numCiudades);
            }
        }
    }
}
