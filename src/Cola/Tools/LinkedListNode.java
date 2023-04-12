package Cola.Tools;

public class LinkedListNode<T> implements Node<T> {

    T data;
    LinkedListNode<T> next;

    public LinkedListNode() {
        this.data = null;
        this.next = null;
    }

    public LinkedListNode(T object) {
        this.data = object;
        this.next = null;
    }

    public LinkedListNode(T object, LinkedListNode next) {
        this.data = object;
        this.next = next;
    }
  
    @Override
    public boolean setObject(T object) { //Validar que el objeto puede ser almacenado en la LinkedList   
        this.data = object;
        return true;
    }

    @Override
    public T getObject() { 
        return this.data;
    }

    @Override
    public boolean isEquals(T object) { 
        return this.data.toString().equals(object.toString());
        
    }

    @Override
    public String toString() {
        return "LinkedListNode{" + "object=" + data + ", next=" + next + '}';
    }
    
}
