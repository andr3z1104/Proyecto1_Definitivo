
package clases;

/**
 *
 * @author andre
 */
public class GrafoDefinitivo {
    
    private GRAFO grafo;
    private Lista ListaUsuarios;

    /**
     *Construye un objeto GrafoDefinitivo con la lista de usuarios
     * 
     * @param ListaUsuarios la lista de usuarios
     */
    public GrafoDefinitivo(Lista ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }

    /**
     *Retorna el GRAFO asociado con el objeto GrafoDefinitivo
     * 
     * @return GRAFO
     */
    public GRAFO getGrafo() {
        return grafo;
    }

    /**
     *Setea el GRAFO para el objeto GrafoDefinitivo
     * 
     * @param grafo el GRAFO para setear
     */
    public void setGrafo(GRAFO grafo) {
        this.grafo = grafo;
    }

    /**
     *Retorna la lista de usuarios asociado con el objeto GrafoDefinitivo
     * 
     * @return la lista de usuarios
     */
    public Lista getListaUsuarios() {
        return ListaUsuarios;
    }

    /**
     *Setea la lista de usuarios para el objeto GrafoDefinitivo
     * 
     * @param ListaUsuarios la lista de usuarios para setear
     */
    public void setListaUsuarios(Lista ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }
    
    /**
     *Completa el grafo mediante la adicion de los vertices los cuales tienen relaciones
     * 
     */
    public void completarGrafo(){
        
        GRAFO g = new GRAFO(ListaUsuarios.getLength());
        Nodo pointer = ListaUsuarios.getHead();
        int count1 = 0;
        
        while(pointer != null){
            Nodo pointer2 = ((Usuario) pointer.getElement()).getRelaciones().getHead();
            
            while(pointer2 != null){
                Nodo pointer3 =  ListaUsuarios.getHead();
                boolean v = true;
                int count2 = 0;
                
                while(v){
                    if(pointer2.getElement().equals(((Usuario)pointer3.getElement()).getName())){
                        v = false;
                        g.insertArista(count1, count2);
                       
                    }
                    count2++;
                    pointer3 = pointer3.getNext();
                    
                    
                    if(pointer3 == null){
                        v= false;
                    }
                }
                
                pointer2 = pointer2.getNext();
            }
            
            count1++;
            pointer = pointer.getNext();
        }
        
        setGrafo(g);
        
    }
    
    /**
     *Borra el vertice del Grafo
     * 
     * @param Usuario el nombre del vertice a eliminar
     */
    public void deleteVerticeGrafo(String Usuario){
        
        Nodo pointer = ListaUsuarios.getHead();
        int count1 = 0;
        boolean v = true;
        
        while(v){    
            if(((Usuario)pointer.getElement()).getName().equals(Usuario)){
                v = false;
            }
            pointer = pointer.getNext();
            if(v){
                count1++;
            }
        }
        
        getGrafo().deleteVertice(count1);
        getListaUsuarios().deleteAtIndex(count1);
        
        Nodo pointer2 = ListaUsuarios.getHead();
        while(pointer2 != null){
            Nodo pointer3 = ((Usuario) pointer2.getElement()).getRelaciones().getHead();
            int count = 0;
            while(pointer3 != null){
                if(pointer3.getElement().equals(Usuario)){
                   ((Usuario) pointer2.getElement()).getRelaciones().deleteAtIndex(count);
                }
                count++;
                pointer3 = pointer3.getNext();
            }
            pointer2 = pointer2.getNext();
        }
        
        
    }
    
    /**
     *Inserta un nuevo vertice al grafo
     * 
     * @param Usuario el nombre del vertice a insertar
     * @param ListaRelaciones la lista de relaciones asociadas al vertice
     */
    public void insertUsuarioGrafo(String Usuario, Lista ListaRelaciones){
        
        Usuario pointer = new Usuario(Usuario);
        pointer.setRelaciones(ListaRelaciones);
        getGrafo().insertVertice(1);
        getListaUsuarios().insertFinale(pointer);
        completarGrafo();
    }
    
    /**
     *Printea el grafo
     * 
     */
    public void print(){
        Nodo pointer = ListaUsuarios.getHead();
        Nodo pointer2 = ListaUsuarios.getHead();

        System.out.print("  ");
        for (int i = 0; i < getListaUsuarios().getLength(); i++) {
            System.out.print(((Usuario)pointer.getElement()).getName() + " ");
            pointer = pointer.getNext();
        }
        System.out.println("");
        
        for (int i = 0; i < getGrafo().getMatrixAdy().length; i++) {
            System.out.print(((Usuario) pointer2.getElement()).getName() + " ");
            pointer2 = pointer2.getNext();
            for (int j = 0; j < getGrafo().getMatrixAdy()[i].length; j++) {
                System.out.print(getGrafo().getMatrixAdy()[i][j]+ "   ");
            }
            System.out.println();
        }
        
    }
    
    /**
     *Printea la matriz de adjacencia del grafo
     * 
     */
    public void printMA(){
        System.out.println("Vertices: " + getGrafo().getMatrixAdy().length );
        for (int i = 0; i < getGrafo().getMatrixAdy().length; i++) {
            for (int j = 0; j < getGrafo().getMatrixAdy().length; j++) {
                System.out.print(getGrafo().getMatrixAdy()[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    
    
}
