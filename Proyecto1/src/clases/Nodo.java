
package clases;

/**
 *
 * @author andre
 */
public class Nodo {
    
    private Object element;
    private Nodo next;
    
    /**
     *Constructor del nodo
     * 
     * @param element el elemento para ser guardado en el nodo
     */
    public Nodo(Object element){
        this.element = element;
        this.next = null;
    }

    /**
     *Obtiene el elemento guardado en el nodo
     * 
     * @return el elemento guardado en el nodo
     */
    public Object getElement() {
        return element;
    }

    /**
     *Setea el elemento para ser guardado en el nodo
     * 
     * @param element el elemento a ser guardado en el nodo
     */
    public void setElement(Object element) {
        this.element = element;
    }

    /**
     *Obtiene el siguiente nodo en la lista enlazada
     * 
     * @return el siguiente nodo
     */
    public Nodo getNext() {
        return next;
    }

    /**
     *Setea el siguiente nodo en la lista enlazada
     * 
     * @param next el siguiente nodo
     */
    public void setNext(Nodo next) {
        this.next = next;
    }
    
    
    
}
