import Cola.*;

import java.util.concurrent.ExecutionException;

public class BinarySearchTree<T> implements TreeInterface<T> {

    BinarySearchNode<T> root;
    int elements = 0, height = 0;

    public BinarySearchTree() {
        this.root = null;
        this.elements = 0;
    }

    public BinarySearchTree(T object) {
        this.root = new BinarySearchNode<>(object);
        elements = 1;
    }

    //Recorridos
    @Override
    public String preOrderToString() {
        return preOrderToString(root, "");
    }
    private String preOrderToString(BinarySearchNode<T> raiz, String string) {
        try{
            if(raiz != null){
                string += raiz.getObject().toString();
                string = preOrderToString(raiz.left, string);
                string = preOrderToString(raiz.right, string);
                elements++; //??
            }
            return string;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String inOrderToString() {
        return inOrderToString(root, "");
    }
    private String inOrderToString(BinarySearchNode<T> root, String string) {
        try{

            if(root != null){
                string += root.left.getObject().toString();
                string = inOrderToString(root, string);
                string = inOrderToString(root.right, string);
                elements++; //??
            }
            return string;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String postOrderToString() {
        return postOrderToString(root, "");
    }
    private String postOrderToString(BinarySearchNode<T> root, String string) {
        try{
            if(root != null){
                string += root.left.getObject().toString();
                string = postOrderToString(root.right, string);
                string = postOrderToString(root, string);
                elements++; //??
            }
            return string;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String widthOrderToString() {
        return widthOrderToString(root, "");
    }
    private String widthOrderToString(BinarySearchNode<T> root, String string) {

        DinamicQueue<TreeNode<T>> queue = new DinamicQueue<>();
        queue.insert(root);
        height++;

        while(!queue.isEmpty()){
            BinarySearchNode<T> temp = (BinarySearchNode<T>) queue.extract();
            string += temp.getObject().toString();

            if(temp.left != null){
                queue.insert(temp.left);
            }
            if(temp.right != null){
                queue.insert(temp.right);
            }
        }
        return string;
    }

    @Override
    public boolean search(T object) {
        try{
            if(!isEmpty()){
                BinarySearchNode<T> temp = root;
                boolean found = false;

                while(temp.data != object){
                    if((((Comparable) object).compareTo(temp.data) < 0)){
                        temp = temp.left;
                    }else{
                        temp = temp.right;
                    }
                }

                if(object.equals(temp.data)){
                    found = true;
                }
             return found;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public T extract() {

        BinarySearchNode<T> aux = root;
        remove(root.data);

        return aux.data;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public int nodeCount() {
        try{
            return root.cantHijos();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public boolean insert(T object) {
        try{
            BinarySearchNode<T> temp = new BinarySearchNode<>(object);
            Comparable<T> comparable = (Comparable<T>) object;

            //en caso de que el arbol esté vacío
            if(isEmpty()){
                root = temp;
            }else{
                boolean agregado = false;

                //comparar el nuevo elemento comparado con el elemento de la raiz
                while(!agregado){
                    //si el elemento es menor que la raiz
                    if(comparable.compareTo(root.data) < 0){
                        if(root.left == null){
                            root.left = temp;
                            agregado = true;
                        }else{
                            //nos desplazamos hasta el hijo izquierdo de la raiz
                            root = root.left;
                        }
                    }else{
                        //si es mayor, agregar a la derecha
                        if(root.right == null){
                            root.right = temp;
                            agregado = true;
                        }else{
                            root = root.right;
                        }
                    }
                }
                elements++;
                return agregado;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(T object) {
        try{

            boolean found = false;

            if(!isEmpty()){
                //Si no tiene hijos, la funcion de reemplazar retorna nulo
                //Si tiene un hijo, devuelve ese hijo
                //Si tiene dos hijos, devuelveel nodo siguiente al que hay que eliminar
                if((object).equals(root.data)){
                    root = reemplazar(root);
                    elements--;
                }else{
                    BinarySearchNode<T> actual, padre = root;

                    if(((Comparable) object).compareTo(root.data) < 0){
                        actual = root.left;
                    }else{
                        actual = root.right;
                    }

                    while(actual != null && !found){
                        if(object.equals(actual.data)){
                            found = true;
                            elements--;

                            if(actual == padre.left){
                                padre.left = reemplazar(actual);
                            }else{
                                padre.right = reemplazar(actual);
                            }
                        }else{
                            padre = actual;

                            if(((Comparable)object).compareTo(actual.data) < 0){
                                actual = actual.left;
                            }else{
                                actual = actual.right;
                            }
                        }
                    }
                }
            }
            return found;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //Devuelve el nodo que sustituirá al que se va a reemplazar en el medoto remove
   private BinarySearchNode<T> reemplazar(BinarySearchNode<T> nodo){
        try{
            BinarySearchNode<T> resultado;

            if((nodo.left == null) && (nodo.right == null)){
                resultado = null;
            }else if((nodo.left != null) && (nodo.right == null)){
                resultado = nodo.left;
            }else if((nodo.left == null) && (nodo.right != null)){
                resultado = nodo.right;
            }else{

                BinarySearchNode<T> actual = nodo.right;
                BinarySearchNode<T> padre = nodo;

                while(actual.left != null){
                    padre = actual;
                    actual = actual.left;
                }

                if(nodo.right == actual){
                    actual.left = nodo.left;
                }else{
                    padre.left = actual.right;
                    actual.right = nodo.right;
                    actual.left = nodo.left;
                }

                resultado = actual;
            }
            return resultado;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
   }

}
