
package clases;



/**
 *
 * @author andre
 */
public class Lista implements iLista{
    
    private Nodo head;
    private int length;
    
    /**
     *Constructor de la lista enlazada
     * 
     */
    public Lista(){
        this.head = null;
        this.length = 0; 
    }

    /**
     *Obtiene la cabeza de la lista enlazada
     * 
     * @return la cabeza de la lista enlazada
     */
    public Nodo getHead() {
        return head;
    }

    /**
     *Setea la cabeza de la lista enlazada
     * 
     * @param head la cabeza de la lista enlazada
     */
    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
     *Obtiene la longitud de la lista enlazada
     * 
     * @return la longitud de la lista enlazada
     */
    public int getLength() {
        return length;
    }

    /**
     *Setea la longitud de la lista enlazada
     * 
     * @param length la longitud de la lista enlazada
     */
    public void setLength(int length) {
        this.length = length;
    }
    
    /**
     *Checkea si la lista enlazada esta vacia
     * 
     * @return true si la lista esta vacia, falso de lo contrario
     */
    @Override
    public boolean isEmpty(){
        return getHead() == null;
    }
    
    /**
     *Inserta un elemento al prinicpio de la lista enlazada
     * 
     * @param element el elemento a insertar
     */
    @Override
    public void insertBegin(Object element){
        Nodo nodo = new Nodo(element);
        
        if(isEmpty()){
            setHead(nodo);
        }
        else{
            nodo.setNext(getHead());
            setHead(nodo);
        }
        length++;
    }
    
    /**
     *Inserta un elemento al final de la lista enlazada
     * 
     * @param element el elemento a insertar
     */
    @Override
    public void insertFinale(Object element){
        Nodo nodo = new Nodo(element);
        
        if(isEmpty()){
            setHead(nodo);
        }
        else{
            Nodo pointer = getHead();
            while(pointer.getNext() != null){
                pointer = pointer.getNext();
            }
            pointer.setNext(nodo);
        }
        length++;
    }
    
    /**
     *Insertar un elemento al indice espicificado de la lista enlazada
     * 
     * @param element el elemento a insertar
     * @param index el indice al cual se insertar el elemento
     */
    @Override
    public void insertAtIndex(Object element, int index){
        Nodo nodo = new Nodo(element);
        
        if(isEmpty() || index == 0){
            insertBegin(element);
        }
        else{
            if (index < getLength()) {
                Nodo pointer = getHead();
                
                int count = 0;
                
                while(count < index-1){
                    pointer = pointer.getNext();
                    count++;
                }
                
                Nodo temp = pointer.getNext();
                
                nodo.setNext(temp);
                pointer.setNext(nodo);
                length++;
            }
            else if (index == getLength()) {
                insertFinale(element);
            }
            else{
                System.out.println("Index not valid");
            }
        }
        
    }
    
    /**
     *Borra el primer elemento de la lista enlazada, es decir, la cabeza
     * 
     * @return pointer
     */
    @Override
    public Nodo deleteBegin(){
    
        if(isEmpty()){
            System.out.println("La Lista esta vacia");
            return null;
        }
        else{
            Nodo pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            length--;
            return pointer;
        }
    
    }
    
    /**
     *Borra el ultimo elemento de la lista enlazada
     * 
     * @return temp
     */
    @Override
    public Nodo deleteFinale(){
        
        if(isEmpty()){
            System.out.println("La Lista esta vacia");
            return null;
        }
        else{
            Nodo pointer = getHead();
            while(pointer.getNext().getNext() != null){
                pointer = pointer.getNext();
            }
            Nodo temp = pointer.getNext();
            pointer.setNext(null);
            length--;
            return temp;
        }
    }
    
    /**
     *Borra un elemento al indice espicificado de la lista enlazada
     * 
     * @param index el indice del elemento 
     * @return temp
     */
    @Override
    public Nodo deleteAtIndex(int index){
        
        if(isEmpty() || index == 0){
            return deleteBegin();
        }
        else{
            if (index < getLength()) {
                Nodo pointer = getHead();
                
                int count = 0;
                
                while(count < index-1){
                    pointer = pointer.getNext();
                    count++;
                }
                
                Nodo temp = pointer.getNext();
                
                pointer.setNext(temp.getNext());
                temp.setNext(null);
                length--;
                return temp;
            }
            else if (index == getLength()) {
                return deleteFinale();
            }
            else{
                System.out.println("Index not valid");
                return null;
            }
        }
        
    }
    
    /**
     *Printea la lista enlazada
     * 
     */
    public void print(){
        Nodo pointer = getHead();
        while(pointer != null){
            System.out.print(" [ " +  pointer.getElement() + " ] ");
            pointer = pointer.getNext();
        }
    }
    
    /**
     *Busca un elemento por su indice
     * 
     * @param index el indice del elemento 
     * @return pAux
     */
    public Nodo searchByIndex(int index){
        Nodo pAux=this.head;
        int count = 0;
        
        while (pAux!=null && count!=index){
            pAux=pAux.getNext();
            count++;
        }
        if (pAux!=null){
            return pAux;
        }else{
            return null;
        }
        
    }
    
    /**
     *Retorna el elemento del nodo
     * 
     * @see searchByIndex
     * @param index el indice del elemento
     * @return
     */
    public Object returnIndexData(int index){
        Nodo returnedNodo=this.searchByIndex(index);
        if (returnedNodo!=null){
            return returnedNodo.getElement();
        }else{
            return null;
        }
    }
    
}
