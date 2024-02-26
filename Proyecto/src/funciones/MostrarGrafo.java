/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import edd.Arista;
import edd.Ciudad;
import edd.Grafo;
import edd.ListaSimple;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


/**
 * Clase que representa un grafo de ciudades y sus conexiones a través de
 * la librería GraphStream.
 *
 * @author vickysaldivia
 */
public class MostrarGrafo {

    private ListaSimple<Ciudad> Nodes = new ListaSimple();
    private ListaSimple<Edge> Edges = new ListaSimple();
    Graph graph = new SingleGraph("Grafo de la Simulación");
    
    
    /**
     * Método que visualiza el grafo utilizando la biblioteca GraphStream.
     *
     * @param grafo Grafo que se va a visualizar.
     * @param caminoOptimo Camino óptimo del grafo.
     */
    public void GrafoMostrar(Grafo grafo, ListaSimple<Ciudad> caminoOptimo){
        System.setProperty("org.graphstream.ui", "swing");
        ListaSimple<Double> EdgesDistance = new ListaSimple();
        
       
        
        for (int i = 0; i < grafo.getCiudades().getSize(); i++) {
            this.Nodes.Append(grafo.getCiudades().GetData(i));
            graph.addNode(String.valueOf(grafo.getCiudades().GetData(i).getValue()));
            
            Node node = graph.getNode(String.valueOf(grafo.getCiudades().GetData(i).getValue()));
            node.setAttribute("ui.label", node.getId());
            this.setNodeStyle(node, "30px", "#AD8249");
            
        }
        
        for (int i = 0; i < this.Nodes.getSize(); i++) {
            Ciudad ciudad = this.Nodes.GetData(i);
            
            for (int j = 0; j < ciudad.getAristas().getSize(); j++) {
                Arista arista = ciudad.getAristas().GetData(j);
                
                if(!EdgesDistance.Search(arista.getDistancia())){
                    if(arista.getDestino().getValue() < arista.getOrigen().getValue()){
                        EdgesDistance.Append(arista.getDistancia());
                        String conexion = String.valueOf(arista.getOrigen().getValue()) + String.valueOf(arista.getDestino().getValue());
                        
                        String c1 = String.valueOf(arista.getOrigen().getValue());
                        String c2 = String.valueOf(arista.getDestino().getValue());
                        
                        graph.addEdge(conexion, c1, c2);
                       
                        Edge edge = graph.getEdge(conexion);
                        edge.setAttribute("ui.label", String.valueOf(arista.getDistancia()));
                        this.setEdgeStyle(edge, "2px", "#4974AD");
                        
                        this.Edges.Append(edge);
                    }
                }
                
            }
            
            
        }
        
        graph.setAttribute("ui.stylesheet", "graph {fill-color: white; } node { size: 30px; fill-mode: dyn-plain; fill-color: #AD8249; text-size: 30; } edge {fill-color: #4974AD; stroke-width: 4px; text-background-mode: plain; text-background-color: white; text-size: 20px;}");

        if(!caminoOptimo.isEmpty()){
            this.displayCamino(caminoOptimo);
        }
        
        Viewer viewer = graph.display();
        
        viewer.enableAutoLayout();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
    
    
    /**
     * Establece el estilo de un nodo en el grafo.
     *
     * @param node Nodo del grafo.
     * @param size Tamaño del nodo.
     * @param fillColor Color de relleno del nodo.
     */
    public void setNodeStyle(Node node, String size, String fillColor){
        node.setAttribute("ui.style", "size: " + size + "; fill-mode: dyn-plain; fill-color: " + fillColor + ";");
    }
    
    
    /**
     * Establece el estilo de una arista en el grafo.
     *
     * @param edge Arista del grafo.
     * @param thickness Grosor de la arista.
     * @param color Color de la arista.
     */

    public void setEdgeStyle(Edge edge, String thickness, String color) {
        edge.setAttribute("ui.style", "size: " + thickness + "; fill-color: " + color + ";");
    }
    
    
    /**
     * Método que modifica el color de las aristas del grafo si estos pertenecen
     * al camino más optimo del sistema.
     * @param caminoOptimo 
     */
    public void displayCamino (ListaSimple<Ciudad> caminoOptimo){
        for (int i = 0; i < caminoOptimo.getSize()-1; i++) {
            String Node1 = String.valueOf(caminoOptimo.GetData(i).getValue());
            String Node2 = String.valueOf(caminoOptimo.GetData(i+1).getValue());

            Edge edgeMarked = this.findEdgeBetweenNodes(Node1, Node2);
            this.setEdgeStyle(edgeMarked, "4px", "#FF0000");

            
        }
    }
    
    /**
     * Método que busca una arista entre dos nodos en el grafo.
     *
     * @param Node1 Identificador del primer nodo.
     * @param Node2 Identificador del segundo nodo.
     * @return Arista entre los dos nodos, si existe.
     */
    public Edge findEdgeBetweenNodes(String Node1, String Node2){
        String edgeId1 = Node1 + Node2;
        String edgeId2 = Node2 + Node1;
        
        for (int i = 0; i < this.Edges.getSize(); i++) {
            if(this.Edges.GetData(i).getId().equals(edgeId1)){
                return graph.getEdge(edgeId1);
            }
            else if(this.Edges.GetData(i).getId().equals(edgeId2)){
                return graph.getEdge(edgeId2);
            }
            
        }
        return null;
    }
    
    
    
    
}
