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


    public GraficarGrafo(Lista ListaUsuarios, GRAFO grafo) {
        this.ListaUsuarios = ListaUsuarios;
        this.grafo=grafo;
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
    
    

    public Graph returnGraph(Lista ListaUsuarios){
        Graph g = new SingleGraph("hp");
        Nodo pAux=  ListaUsuarios.getHead();
        Nodo pAux2 = ListaUsuarios.getHead();
        int n = 0;
        
        while (pAux!=null){
            Usuario u = (Usuario) pAux.getElement();
            g.addNode(u.getName());
            pAux = pAux.getNext();
        }

        for (int i=0;i< getGrafo().getMatrixAdy().length;i++){
            for (int j=0;j< getGrafo().getMatrixAdy().length;j++){
                System.out.print(getGrafo().getMatrixAdy()[i][j]);
                System.out.print(getGrafo().getMatrixAdy().length);
                if(getGrafo().getMatrixAdy()[i][j]==1){
                    g.addEdge(Integer.toString(i)+Integer.toString(j), ((Usuario)ListaUsuarios.returnIndexData(i)).getName(), ((Usuario) ListaUsuarios.returnIndexData(j)).getName(), true);
                }
            }
        }
        return g;
    } 
    
    public void mostrar(){
        Graph g = returnGraph(ListaUsuarios);
        g.setAttribute("ui.stylesheet", "node { text-alignment: under; }");
        
        for (Node node : g) {
            node.setAttribute("ui.label", node.getId());
        }
         
        for (Node node : g) {
            node.setAttribute("ui.style", "text-size: 20;");
        }
        
        g.display();
    }
      
    public void printSubgraph(){}
        
    
    
}
