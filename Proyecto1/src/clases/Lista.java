
package clases;



/**
 *
 * @author andre
 */
public class Lista implements iLista{
    
    private Nodo head;
    private int length;
    
    public Lista(){
        this.head = null;
        this.length = 0; 
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    @Override
    public boolean isEmpty(){
        return getHead() == null;
    }
    
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
    
    public void print(){
        Nodo pointer = getHead();
        while(pointer != null){
            System.out.print(" [ " +  pointer.getElement() + " ] ");
            pointer = pointer.getNext();
        }
    }
    
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
    
    public Object returnIndexData(int index){
        Nodo returnedNodo=this.searchByIndex(index);
        if (returnedNodo!=null){
            return returnedNodo.getElement();
        }else{
            return null;
        }
    }
    
}
