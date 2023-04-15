import java.util.LinkedList;

public interface TreeInterface<T> {
    LinkedList<T> preOrder();
    LinkedList<T> inOrder();
    LinkedList<T> postOrder();
    LinkedList<T> widthOrder();
    boolean search(int key);
    T extract();
    int size();
    int nodeCount();
    boolean isEmpty();
    int height();
    boolean insert(T object, int key);
    boolean remove(int key);
    boolean isFull();
    boolean isComplete();

}
