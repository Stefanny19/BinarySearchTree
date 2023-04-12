public interface TreeInterface<T> {
    String preOrderToString();
    String inOrderToString();
    String postOrderToString();
    String widthOrderToString();
    boolean search(int key);
    T extract();
    int size();
    int nodeCount();
    boolean isEmpty();
    int height();
    boolean insert(T object, int key);
    boolean remove(int key);

}
