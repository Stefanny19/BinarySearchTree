package Cola.Tools;

public class DoublyLinkedListNode<T> implements Node<T>{

     T data;
     DoublyLinkedListNode<T> next, prev;

    public DoublyLinkedListNode() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public DoublyLinkedListNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> next, DoublyLinkedListNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public boolean setObject(T object) {
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
        return "DoublyLinkedListNode{" +
                "data=" + data +
                '}';
    }
}
