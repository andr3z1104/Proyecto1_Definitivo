
package clases;

/**
 *
 * @author andre
 */
public interface iLista {
    
    /**
     *Inserta un elemento al principio de la lista
     * 
     * @param element el elemento a insertar
     */
    public void insertBegin(Object element);

    /**
     *Inserta un elemento al principio de la lista
     * 
     * @param element el elemento a insertar
     */
    public void insertFinale(Object element);

    /**
     *Inserta un elemento a un indice especificado
     * 
     * @param element el elemento a insertar
     * @param index el indice al cual se insertar el elemento
     */
    public void insertAtIndex(Object element, int index);
    
    /**
     *Borra el primer elemento de la lista
     * 
     * @return el elemento borrado
     */
    public Object deleteBegin();

    /**
     *Borra el ultimo elemento de la lista
     * 
     * @return el elemento borrado
     */
    public Object deleteFinale();

    /**
     *Borra un elemento en un indice especificado
     * 
     * @param index el indice del elemento a borrar
     * @return el elemento borrado
     */
    public Object deleteAtIndex(int index);
    
    /**
     *Checkea si una lista esta vacia
     * 
     * @return true si esta vacia, falso de lo contrario
     */
    public boolean isEmpty();
    
}
