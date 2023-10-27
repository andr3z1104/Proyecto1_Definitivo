
package clases;

/**
 *
 * @author andre
 */
public class NodoStack {
    
    private int element;
    private NodoStack next;
    
    public NodoStack(int element){
        this.element = element;
        this.next = null;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public NodoStack getNext() {
        return next;
    }

    public void setNext(NodoStack next) {
        this.next = next;
    }
    
}
