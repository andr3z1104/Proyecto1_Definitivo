/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
/**
 *
 * @author Luis
 */
public class GraficarGrafo {
    private GRAFO grafo;
    private Lista ListaUsuarios;


    public GraficarGrafo(Lista ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }
    
    

    public Graph returnGraph(Lista ListaUsuarios){
        Graph g = new SingleGraph("hp");
        Nodo pAux=  ListaUsuarios.getHead();
        Nodo pAux2 = ListaUsuarios.getHead();
        
        while (pAux!=null){
            Usuario u = (Usuario) pAux.getElement();
            g.addNode(u.getName());
            pAux = pAux.getNext();
        }
        
        while (pAux2!=null){
            Usuario u = (Usuario) pAux2.getElement();
            Lista listaRelaciones = u.getRelaciones();
            Nodo pAux3 = listaRelaciones.getHead();
//            System.out.println((String) pAux3.getElement());
            while (pAux3!=null){
                System.out.println((String) pAux3.getElement());
                g.addEdge( "HOLA", u.getName(), (String) pAux3.getElement());
                pAux3=pAux3.getNext();
            }
            pAux2 = pAux2.getNext();
        }
        return g;
    } 
    
    public void mostrar(){
        Graph g = returnGraph(ListaUsuarios);
        g.display();
}
            
            
    /**
     * @return the grafo
     */
    public GRAFO getGrafo() {
        return grafo;
    }

    /**
     * @param grafo the grafo to set
     */
    public void setGrafo(GRAFO grafo) {
        this.grafo = grafo;
    }

    /**
     * @return the ListaUsuarios
     */
    public Lista getListaUsuarios() {
        return ListaUsuarios;
    }

    /**
     * @param ListaUsuarios the ListaUsuarios to set
     */
    public void setListaUsuarios(Lista ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }
    
    
    
}
