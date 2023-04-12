public class Main {
    public static void main(String[] args) {
        BinarySearchTree<String> arbol = new BinarySearchTree<>();
        arbol.insert("+", 10);
        arbol.insert("*", 7);
        arbol.insert("/", 13);
        arbol.insert("a", 6);
        arbol.insert("b", 8);
        arbol.insert("c", 12);
        arbol.insert("d", 14);


        //Inorder
        /*System.out.println("inorder");
        String resultado = canasta.inOrderToString();
        System.out.println(resultado);

        //Preorder
        /*System.out.println("preorder");
        System.out.println(canasta.preOrderToString());*/

        //Postosrder
        System.out.println("Postorder");
        System.out.println(arbol.postOrderToString());
    }
}