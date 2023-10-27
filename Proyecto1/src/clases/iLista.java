
package clases;

/**
 *
 * @author andre
 */
public interface iLista {
    
    public void insertBegin(Object element);
    public void insertFinale(Object element);
    public void insertAtIndex(Object element, int index);
    
    public Object deleteBegin();
    public Object deleteFinale();
    public Object deleteAtIndex(int index);
    
    public boolean isEmpty();
    
}
