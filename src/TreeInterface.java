import java.util.LinkedList;

public interface TreeInterface<T> {
    LinkedList<T> preOrderToString();
    LinkedList<T> inOrderToString();
    LinkedList<T> postOrderToString();
    LinkedList<T> widthOrderToString();
    boolean search(int key);
    T extract();
    int size();
    int nodeCount();
    boolean isEmpty();
    int height();
    boolean insert(T object, int key);
    boolean remove(int key);

}
