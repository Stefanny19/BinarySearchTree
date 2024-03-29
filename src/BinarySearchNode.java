import java.net.BindException;

public class BinarySearchNode<T>  extends TreeNode<T> {
    protected BinarySearchNode<T> left, right;
    protected int key;

    public BinarySearchNode() {
        left = right = null;
    }

    public BinarySearchNode(T data, int key) {
        super(data);
        left = right = null;
        this.key = key;
    }

    public BinarySearchNode(T data, BinarySearchNode<T> left, BinarySearchNode<T> right) {
        super(data);
        this.left = left;
        this.right = right;
    }

    public BinarySearchNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchNode<T> left) {
        this.left = left;
    }

    public BinarySearchNode<T> getRight() {
        return right;
    }

    public void setRight(BinarySearchNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNodez{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    public int cantHijos(){
        try{
            int nodeCant = 0;

            if(left != null)
                nodeCant = 1 + left.cantHijos();
            if(right != null)
                nodeCant = nodeCant + 1 + right.cantHijos();

            return nodeCant;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
