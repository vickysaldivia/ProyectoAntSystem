/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import Clases.Hormiga;
import Clases.Sistema;
import edd.Arista;
import edd.Ciudad;
import edd.ListaSimple;


public class funcionesSistema {
    
    //Funcion para inicializar hormigas
    public ListaSimple<Hormiga> inicializarHormigas(int numHormigas, Ciudad ciudadInicial){
        ListaSimple<Hormiga> listHormigas = new ListaSimple();
        for (int i = 0; i < numHormigas; i++) {
            Hormiga hormiga = new Hormiga();
            hormiga.setCiudadActual(ciudadInicial);
            hormiga.getCiudadesRecorridas().Append(ciudadInicial);
            listHormigas.Append(hormiga);
        }
        
        return listHormigas;
    }
    
    //Funcion para inicializar feromonas
    public void inicializarFeromonas(Sistema sistema){
        double feromonaInicial = 1/sistema.getGrafo().getCiudades().getSize();
        for (int i = 0; i < sistema.getGrafo().getCiudades().getSize(); i++) {
            Ciudad ciudadActual = (Ciudad) sistema.getGrafo().getCiudades().GetData(i);
            for (int j = 0; j < ciudadActual.getAristas().getSize(); j++) {
                Arista arista = (Arista) ciudadActual.getAristas().GetData(j);
                arista.setFeromonas(feromonaInicial);
            }
        }
    }
}
