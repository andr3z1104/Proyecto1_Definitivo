
package clases;

/**
 *
 * @author andre
 */
public interface iStack {
    
    /**
     *Agrega un elemento al tope de la pila
     * 
     * @param element el elemento a agregar
     */
    public void push(int element);

    /**
     *Borra el primer elemento de la pila
     * 
     * @return el elemento borrado
     */
    public NodoStack pop();

    /**
     *Checkea si la pila esta vacia
     * 
     * @return true si la pila esta vacia, falso de lo contrario
     */
    public boolean isEmpty();
    
}
