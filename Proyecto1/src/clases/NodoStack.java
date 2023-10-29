
package clases;

/**
 *
 * @author andre
 */
public class NodoStack {
    
    private int element;
    private NodoStack next;
    
    /**
     *Constructor del NodoStack
     * 
     * @param element el elemento para ser guardado en el NodoStack
     */
    public NodoStack(int element){
        this.element = element;
        this.next = null;
    }

    /**
     *Obtener el elemento guardado en el NodoStack
     * 
     * @return el elemento guardado en el NodoStack
     */
    public int getElement() {
        return element;
    }

    /**
     *Setea el elemento de para ser guardado en el NodoStack
     * 
     * @param element
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     *Obtener el siguiente NodoStack
     * 
     * @return el siguiente NodoStack
     */
    public NodoStack getNext() {
        return next;
    }

    /**
     *Setea el siguiente elemento NodoStack
     * 
     * @param next
     */
    public void setNext(NodoStack next) {
        this.next = next;
    }
    
}
