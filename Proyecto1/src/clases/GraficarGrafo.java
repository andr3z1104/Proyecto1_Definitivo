/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
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
        
        while (pAux!=null){
            Usuario u = (Usuario) pAux.getElement();
            g.addNode(u.getName());
            pAux = pAux.getNext();
        }

        for (int i=0;i< getGrafo().getMatrixAdy().length;i++){
            for (int j=0;j< getGrafo().getMatrixAdy().length;j++){
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
        
        Viewer viewer = g.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
      
    public Graph ChangeColorOfEdge(Lista lista,Graph g, int x,int y,int z){
        for (int i=0;i<getGrafo().getMatrixAdy().length;i++){
            for (int j=0;j<getGrafo().getMatrixAdy().length;j++){
                Nodo pAux = lista.getHead();
                while(pAux!=null){
                    if ((int) pAux.getElement()==i){
                        Nodo pAux2=lista.getHead();
                        while (pAux2!=null){
                            if (getGrafo().getMatrixAdy()[i][j]==1 && (int) pAux2.getElement()==j){
                                Edge edge = g.getEdge(Integer.toString(i)+Integer.toString(j));
                                edge.setAttribute("ui.style", "fill-color: rgb("+Integer.toString(x)+","+Integer.toString(y)+","+Integer.toString(z)+");");
                            }
                            pAux2=pAux2.getNext();
                        }
                    } 
                    pAux=pAux.getNext();
                }
            }
        }
        return g;
    }
    
    public void printSubGraph(){
        Nodo pAux= getGrafo().kosaraju().getHead();
        Graph g=returnGraph(ListaUsuarios);
        
        while (pAux!=null){
               int x = (int) (Math.random() * 256);
               int y = (int) (Math.random() * 256);
               int z = (int) (Math.random() * 256);
            g=ChangeColorOfEdge((Lista) pAux.getElement(),g,x,y,z);
            pAux=pAux.getNext();
        }
        g.setAttribute("ui.stylesheet", "node { text-alignment: under; }");
        
        for (Node node : g) {
            node.setAttribute("ui.label", node.getId());
        }
         
        for (Node node : g) {
            node.setAttribute("ui.style", "text-size: 20;");
        }
        Viewer viewer = g.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        
    }
        
    
    
}
