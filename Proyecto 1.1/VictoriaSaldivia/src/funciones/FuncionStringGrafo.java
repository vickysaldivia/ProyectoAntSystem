/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import edd.Arista;
import edd.Ciudad;
import edd.Grafo;
import edd.ListaSimple;

/**
 *
 * @author vickysaldivia
 */
public class FuncionStringGrafo {   
    public Grafo convertString(String txt){
        String[] lines = txt.split("\n");
        
        Grafo newGrafo = new Grafo();
        
        ListaSimple Ciudades = new ListaSimple();
        
        boolean isCity = true;
        
        for (String line : lines){
            if(line.equals("aristas")){
                isCity = false;
                continue;
            }
            if(isCity){
                if(!line.equals("ciudad")){
                    int vertice = Integer.parseInt(line);
                    Ciudad newCiudad = new Ciudad(vertice);
                    Ciudades.Append(newCiudad);
                }
            }
            else{
                String parts[] = line.split(",");
                int origen = Integer.parseInt(parts[0]);
                int destino = Integer.parseInt(parts[1]);
                double distancia = Double.parseDouble(parts[2]);
                
                Ciudad ciudadOrigen = searchVertice(origen, Ciudades);
                Ciudad ciudadDestino = searchVertice(destino, Ciudades);
                
                ciudadOrigen.getAristas().Append(new Arista(ciudadOrigen, ciudadDestino, distancia));
                ciudadDestino.getAristas().Append(new Arista(ciudadDestino, ciudadOrigen, distancia));

            }
        }
        
        newGrafo.setCiudades(Ciudades); 
        return newGrafo;
    }
    
    public Ciudad searchVertice(int numCiudad, ListaSimple Ciudades){
        if(!Ciudades.isEmpty()){
            for (int i = 0; i < Ciudades.getSize(); i++) {
                Ciudad ciudad = (Ciudad) Ciudades.GetData(i);
                if(ciudad.getValue() == numCiudad){
                    return ciudad;
                }
                
            }
            return null;
        }
        return null;
    }
    
}
