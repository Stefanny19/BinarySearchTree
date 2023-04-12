import Cola.*;

import java.util.LinkedList;

public class BinarySearchTree<T> implements TreeInterface<T> {

    private BinarySearchNode<T> root;
    private int elements = 0, height = 0;

    public BinarySearchTree() {
        this.root = null;
        this.elements = 0;
    }

    public BinarySearchTree(T object, int key) {
        this.root = new BinarySearchNode<>(object, key);
        elements = 1;
    }

    //Recorridos
    @Override
    public String preOrderToString(){
        LinkedList<T> lista = new LinkedList<>();
        return preOrderToString(root, lista);
    }
    private String preOrderToString(BinarySearchNode<T> raiz, LinkedList<T> lista) {
        try{
            if(raiz != null){
                lista.add((T) raiz.getObject());
                preOrderToString(raiz.left, lista);
                preOrderToString(raiz.right, lista);
            }
            return lista.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String inOrderToString() {
        LinkedList<T> lista = new LinkedList<>();
        return inOrderToString(this.root, lista);
    }
    private String inOrderToString(BinarySearchNode<T> root, LinkedList<T> lista) {
        try{

            if(root != null){
                inOrderToString(root.left, lista);
                lista.add((T) root.data);
                inOrderToString(root.right, lista);
            }
            return lista.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String postOrderToString() {
        LinkedList<T> lista = new LinkedList<>();
        return postOrderToString(this.root, lista);
    }
    private String postOrderToString(BinarySearchNode<T> root, LinkedList<T> lista) {
        try{
            if(root != null){
                postOrderToString(root.left, lista);
                postOrderToString(root.right, lista);
                lista.add((T) root.data);
            }
            return lista.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String widthOrderToString() {
        LinkedList<T> lista = new LinkedList<>();
        return widthOrderToString(root, lista);
    }
    private String widthOrderToString(BinarySearchNode<T> root, LinkedList<T> lista) {

        DinamicQueue<BinarySearchNode<T>> queue = new DinamicQueue<>();
        queue.insert(root);

        while(!queue.isEmpty()){
            BinarySearchNode<T> temp = queue.extract();

            if(temp != null){
                lista.add((T) temp.data);

                if(temp.left != null){
                    queue.insert(temp.left);
                }
                if(temp.right != null){
                    queue.insert(temp.right);
                }
            }
        }
        return lista.toString();
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
    public boolean insert(T object, int key){
        try{
            insert(root, object, key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private BinarySearchNode<T> insert(BinarySearchNode<T> raiz, T object, int key) {
        try{

            //en caso de que el arbol esté vacío
            if(isEmpty()){
                root = new BinarySearchNode<>(object,key);
                elements++;
                return root;

            }else{
                //comparar el nuevo elemento con el elemento de la raiz
                //si el elemento es menor que la raiz
                if(key < raiz.key){

                    if(raiz.left == null){
                        raiz.left = new BinarySearchNode<>(object, key);
                        elements++;
                        return raiz;

                    }else{
                        //nos desplazamos hasta el hijo izquierdo de la raiz
                        raiz = raiz.left;
                        return insert(raiz,object, key);
                    }
                }else{
                    //si es mayor, agregar a la derecha
                    if(raiz.right == null){
                        raiz.right = new BinarySearchNode<>(object, key);
                        elements++;
                        return raiz;

                    }else{
                        raiz = raiz.right;
                        return insert(raiz, object, key);
                    }
                    }
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
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
