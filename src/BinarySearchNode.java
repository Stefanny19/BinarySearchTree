public class BinarySearchNode<T> extends TreeNode<T>{
    BinarySearchNode<T> left, right;

        public BinarySearchNode() {
            left = right = null;
        }

        public BinarySearchNode(T data) {
            super(data);
            left = right = null;
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

}
