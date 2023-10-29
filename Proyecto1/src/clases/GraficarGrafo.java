
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

    /**
     *Crea un objeto GraficarGrafo con una lista de usuarios y un GRAFO
     * 
     * @param ListaUsuarios la lista de usuarios
     * @param grafo el GRAFO
     */
    public GraficarGrafo(Lista ListaUsuarios, GRAFO grafo) {
        this.ListaUsuarios = ListaUsuarios;
        this.grafo=grafo;
    }
    
             
    /**
     * Devuelve el GRAFO
     * 
     * @return el GRAFO
     */
    public GRAFO getGrafo() {
        return grafo;
    }

    /**
     * Setea el GRAFO
     * 
     * @param grafo el GRAFO a establecer
     */
    public void setGrafo(GRAFO grafo) {
        this.grafo = grafo;
    }

    /**
     * Devuelve la lista de usuarios
     * 
     * @return la ListaUsuarios
     */
    public Lista getListaUsuarios() {
        return ListaUsuarios;
    }

    /**
     * Setea la lista de usuarios
     * 
     * @param ListaUsuarios la ListaUsuarios a setear
     */
    public void setListaUsuarios(Lista ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }
    
    /**
     *Crea y devuelve un objeto Graph que representa al GRAFO
     * 
     * @param ListaUsuarios la lista de usuarios
     * @return el objeto Graph que representa al GRAFO
     */
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
    
    /**
     *Muestra el grafo utilizando la libreria GraphStream
     * 
     */
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
      
    /**
     *Cambia el color de las aristas del Graph, tomando en cuenta el RGB
     * 
     * @param lista lista simplemente enlazada de nodos
     * @param g el Graph
     * @param x el valor rojo para llenar el color (R)
     * @param y el valor verde para llenar el color (G)
     * @param z el valor azul para llenar el color (B)
     * @return el Graph modificado con las aristas pintadas
     */
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
    
    /**
     *Printea un subgrafo con las aristas pintadas
     * 
     * Este metodo genera valores aleatorios de RGB para cada subgrafo y llama a la funcion
     * ChangeColorOfEdge para colorear las aristas
     * 
     * @see ChangeColorOfEdge
     */
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
        g.display();
    }
        
    
    
}
