public class TreeNode<T> implements TreeNodeInterface {
    protected T data;

    public TreeNode() {
        data = null;
    }
    public TreeNode(T data) {
        this.data = data;
    }


    @Override
    public boolean setObject(Object object) {
        try{
            this.data = (T) object;
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object getObject() {
        return this.data;
    }

    @Override
    public boolean isEquals(Object object) {
        return false;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
