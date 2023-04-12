import Cola.*;

import java.util.LinkedList;

public class BinarySearchTree<T> implements TreeInterface<T> {

    private BinarySearchNode<T> root;
    private int elements, height;

    public BinarySearchTree() {
        this.root = null;
        this.elements = 0;
        this.height = 0;
    }

    public BinarySearchTree(T object, int key) {
        this.root = new BinarySearchNode<>(object, key);
        this.elements = 1;
        this.height = 1;
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
        return postOrderToString(root, lista);
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
    public boolean search(int key) {
        try{
            if(!isEmpty()){
                BinarySearchNode<T> temp = root;
                boolean found = false;

                while(temp.key != key){
                    if(key < temp.key){
                        temp = temp.left;
                    }else{
                        temp = temp.right;
                    }
                }

                if(key == temp.key){
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
        remove(root.key);

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

    /*
    Referencia para la realizacion del método remove: Estructura de datos con java, diseño de estructuras y algoritmos
    Autrores: John Lewis y Joseph Chase
     */
    @Override
    public boolean remove(int key) {
        try{

            boolean found = false;

            if(!isEmpty()){

                /*verificamos si la clave que deseamos eliminar es la raíz del árbol. Si es así, reemplazamos la raíz
                por un nuevo nodo y decrementamos el contador de elementos.*/

                if(key == root.key){
                    root = reemplazar(root);
                    elements--;

                }else{
                    /*iniciamos un recorrido en el árbol para encontrar el nodo que contiene la clave dada.
                     Comenzamos desde la raíz y comparamos la clave dada con la clave del nodo actual.*/

                    BinarySearchNode<T> actual, padre = root;

                    /*Si la clave dada es menor que la clave del nodo actual, nos movemos al subárbol izquierdo del
                    nodo actual; de lo contrario, nos movemos al subárbol derecho.*/
                    if(key < root.key){
                        actual = root.left;
                    }else{
                        actual = root.right;
                    }

                    /*Si el nodo encontrado es un hijo izquierdo de su padre, reemplazamos el nodo encontrado con su
                    nodo más a la derecha en el subárbol izquierdo. De lo contrario, reemplazamos el nodo encontrado
                    con su nodo más a la derecha en el subárbol derecho.*/
                    while(actual != null && !found){
                        if(key == actual.key){
                            found = true;
                            elements--;

                            if(actual == padre.left){
                                padre.left = reemplazar(actual);
                            }else{
                                padre.right = reemplazar(actual);
                            }

                        }else{
                            padre = actual;

                            if(key < actual.key){
                                actual = actual.left;
                            }else{
                                actual = actual.right;
                            }
                        }
                    }
                }
            }
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //Devuelve el nodo que sustituirá al que se va a reemplazar en el medoto remove

    /*
    Referencia para la realizacion del método reemplazar: Estructura de datos con java, diseño de estructuras y algoritmos
    Autrores: John Lewis y Joseph Chase
     */
   private BinarySearchNode<T> reemplazar(BinarySearchNode<T> nodo){
        try{
            BinarySearchNode<T> resultado;

            //Evaluacion del nodo en tres casos
            //Caso 1: El nodo no tiene ningun hijo
            if((nodo.left == null) && (nodo.right == null)){
                resultado = null;

            //Caso 2: El nodo solo tiene un hijo
            }else if((nodo.left != null) && (nodo.right == null)){
                resultado = nodo.left;
            }else if((nodo.left == null) && (nodo.right != null)){
                resultado = nodo.right;

            //Caso 3: El nodo tiene dos hijos. Evaluar a la derecha
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

                //Devuelve el sucesor del nodo que hay que eliminar
                resultado = actual;
            }
            return resultado;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
   }

}
