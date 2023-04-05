public interface TreeInterface<T> {
    String preOrderToString();
    String inOrderToString();
    String postOrderToString();
    String widthOrderToString();
    boolean insertWidth(T object);
    boolean insertDeep(T object);
    boolean removeWidth(T object);
    boolean removeDeep(T object);
    int height(BinaryTreeNodez<T> node);
    int size();
}
