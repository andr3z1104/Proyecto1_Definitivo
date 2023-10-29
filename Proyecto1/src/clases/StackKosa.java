
package clases;

/**
 *
 * @author andre
 */
public class StackKosa implements iStack{
    
    private NodoStack peak;
    private int length;

    /**
     *Construye una Pila vacia
     * 
     */
    public StackKosa() {
        this.peak = null;
        this.length = 0;
    }

    /**
     *Retorna el NodoStack en el tope de la pila
     * 
     * @return el NodoStack en el tope de la pila
     */
    public NodoStack getPeak() {
        return peak;
    }

    /**
     *Setea el NodoStack al tope de la pila
     * 
     * @param peak el NodoStack en el tope de la pila
     */
    public void setPeak(NodoStack peak) {
        this.peak = peak;
    }

    /**
     *Retorna el numero de elementos en la pila
     * 
     * @return numero de elementos en la pila
     */
    public int getLength() {
        return length;
    }

    /**
     *Setea el numero de elementos en la pila
     * 
     * @param length el numero de elementos en la pila
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     *Remueve y retorna el NodoStack al tope de la pila
     * 
     * @return el NodoStack al tope de la pila, o null si esta vacia la pila
     */
    @Override
    public NodoStack pop() {
        if (isEmpty()) {
            System.out.println("La lista se encuentra vacia");
            return null;
        } else {
            NodoStack pointer = getPeak();
            setPeak(pointer.getNext());
            pointer.setNext(null);
            length--;
            return pointer;
        }
    }

    /**
     *Checkea si la pila esta vacia
     * 
     * @return true si esta vacia, falso de lo contrario
     */
    @Override
    public boolean isEmpty() {
        return getPeak() == null;
    }
    
    /**
     *Printea los elementos de la pila
     * 
     */
    public void print(){
        NodoStack pointer = getPeak();
        while (pointer != null) {
            System.out.println("[ " + pointer.getElement() + " ]");
            pointer = pointer.getNext();
        } 
    }

    /**
     *Agrega elementos al tope de la pila
     * 
     * @param element el elemento a agregar a la pila
     */
    @Override
    public void push(int element) {
        NodoStack nodo = new NodoStack(element);
        if (isEmpty()) {
            setPeak(nodo);
        } else {
            nodo.setNext(getPeak());
            setPeak(nodo);
        }
        length++;
    }
    
    
}
