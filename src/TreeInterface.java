public interface TreeInterface<T> {
    String preOrderToString();
    String inOrderToString();
    String postOrderToString();
    String widthOrderToString();
    boolean search(T object);
    T extract();
    int size();
    int nodeCount();
    boolean isEmpty();
    int height();
    boolean insert(T object);
    boolean removeWidth(T object);
    boolean removeDeep(T object);

}
