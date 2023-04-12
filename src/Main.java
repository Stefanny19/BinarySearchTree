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
        System.out.println(resultado);*/

        //Postosrder
        System.out.println("Postorder");
        System.out.println(arbol.postOrderToString());

        //Preorder
        System.out.println("preorder");
        System.out.println(arbol.preOrderToString());

        //remove
        arbol.remove(10);
        System.out.println(arbol.postOrderToString());
        System.out.println(arbol.preOrderToString());

        //search
        System.out.println("Search");
        System.out.println(arbol.search(7));

        //Extract
        System.out.println("Extract");
        System.out.println(arbol.extract());

        System.out.println(arbol.preOrderToString());

        //Size
        System.out.println("Size\n" + arbol.size());

        //Node count
        System.out.println("NodeCount\n" + arbol.nodeCount());

        //Height
        System.out.println("Height\n" + arbol.height());

    }
}