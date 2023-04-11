package Cola.Tools;

import java.lang.reflect.Array;
import java.util.Iterator;

public class DoublyLinkedList<T> implements List<T> {

    private DoublyLinkedListNode<T> head, tail, inode;
    private int length = 0;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedList(T object) {
        this.head = tail = new DoublyLinkedListNode(object);
    }

    @Override
    public boolean add(T object) {

        if (object == null) return false;

        try {
            if (isEmpty()) {
                head = tail = new DoublyLinkedListNode<>(object);
            } else {
                DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(object);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            length++;

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean add(Node node, T object) {

        try {
            if (node == null || object == null || isEmpty()) {
                return false;

            } else if (!isEmpty()) {

                DoublyLinkedListNode<T> nextNode = new DoublyLinkedListNode<>(object);
                DoublyLinkedListNode<T> nodeT = (DoublyLinkedListNode<T>) node;

                nextNode.next = nodeT.next;
                nodeT.next = nextNode;
                nextNode.prev = nodeT;
                nextNode.next.prev = nextNode;

                length++;
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean add(Node node, Node next) {

        try {
            if (node == null || next == null || isEmpty()) {
                return false;

            } else if (!isEmpty()) {

                DoublyLinkedListNode<T> thisNode = (DoublyLinkedListNode) node;
                DoublyLinkedListNode<T> nextNode = (DoublyLinkedListNode) next;
                nextNode = new DoublyLinkedListNode<>(nextNode.data);

                if (head == thisNode) {
                    head.next = nextNode;
                    nextNode.prev = head;
                    return true;

                } else if (tail == thisNode) {
                    tail.prev = thisNode;
                    tail = nextNode;
                    return true;
                }

                nextNode.next = thisNode.next;
                thisNode.next = nextNode;
                nextNode.prev = thisNode;

                length++;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(T[] objects) {

        try {

            for (T t : objects) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(t);
                length++;

                if (isEmpty()) {
                    head = node;

                } else {

                    tail.prev = tail;
                    tail.next = node;
                    tail = tail.next;

                }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(Node node, T[] objects) {

        try {

            DoublyLinkedListNode nodeT = (DoublyLinkedListNode) node;
            DoublyLinkedListNode link = head;
            boolean found = false;

            while (link.next != null) {//Comprobar si el nodo se encuentra en la lista

                if (link == nodeT) {
                    found = true;
                    break;

                } else {
                    found = false;
                    link = link.next;
                }
            }

            if (found) {
                for (T t : objects) {

                    DoublyLinkedListNode<T> nodeN = new DoublyLinkedListNode<>(t);

                    nodeN.next = link.next;
                    link.next = nodeN;
                    nodeN.prev = link;
                    link = nodeN;

                    length++;
                }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addFirst(T object) {
        try {

            if(!isEmpty()){

                DoublyLinkedListNode<T> nodeT = new DoublyLinkedListNode<>(object);

                nodeT.next = head;
                head.prev = nodeT;
                head = nodeT;
                head.prev = null;

                length++;

                return true;
            }else{
                head = tail = new DoublyLinkedListNode<>(object);
                length++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addFirst(T[] objects) {
        try {
            DoublyLinkedListNode<T> nodeT;

            for (int i = objects.length - 1; i >= 0; i--) {
                nodeT = new DoublyLinkedListNode<>(objects[i]);

                nodeT.next = head;
                nodeT.prev = null;
                head.prev = nodeT;
                head = nodeT;

                length++;
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addLast(T object) {

        if (object == null) return false;

        try {
            if (isEmpty()) {
                head = tail = new DoublyLinkedListNode<>(object);
                head.prev = null;
                length++;

            } else {
                DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(object);

                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
                length++;
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addLast(T[] objects) {

        if (objects == null) return false;

        try {
            for (T t : objects) {


                if (isEmpty()) {
                    head = tail = new DoublyLinkedListNode<>(t);
                    head.prev = null;
                    length++;

                }else{

                    DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(t);

                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                    tail.next = null;

                    length++;
                }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean clear() {

        try {
            if (!isEmpty()) {
                head = null;
                length = 0;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List clone() {
        try {
            if (!isEmpty()) {

                DoublyLinkedList<T> newList = new DoublyLinkedList<>();
                DoublyLinkedListNode<T> link = head;

                while (link != null) {
                    newList.add(link.data);
                    link = link.next;
                }

                return (List) newList;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean contains(T object) {

        try {
            if (head != null) {
                DoublyLinkedListNode<T> link = head;

                //Llega hasta el último elemento
                while (link != null) {
                    if (link.data == object) {

                        return true;
                    } else {
                        link = link.next;
                    }
                }
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean contains(T[] objects) {
        try{

            if(!isEmpty()){

                boolean[] contains = new boolean[objects.length];
                int i = 0;

                for (T t : objects) {
                    if(contains(t)){
                        contains[i] = true;
                        i++;
                    }else{
                        contains[i] = false;
                        i++;
                    }
                }

                for (boolean x: contains) {
                    if(!x){
                        return false;
                    }
                }
                return  true;
            }
            return  false;

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Node nodeOf(T object) {

        try{
            DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(object);
            DoublyLinkedListNode<T> link = head;

            while(link.next != null){

                if(link.data == node.data){
                    return link;
                }
                link = link.next;
            }

            return null;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T get() {
        if(!isEmpty()){
            return tail.data;
        }
        return null;
    }

    @Override
    public T get(Node node) {

        try {
            if (node == null) {
                System.out.println("El nodo que insertaste es nulo");
                return null;

            } else {

                DoublyLinkedListNode<T> link = head;
                DoublyLinkedListNode<T> nodeT;
                nodeT = (DoublyLinkedListNode<T>) node;

                while (link.next != null) {

                    if (link.data == nodeT.data) {
                        node = link;
                        return link.data;
                    } else {
                        link = link.next;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T getPrevious(Node node) {
        try {
            if(!isEmpty() && (node != null)){

                DoublyLinkedListNode<T> link = head;
                DoublyLinkedListNode<T> nodeT = (DoublyLinkedListNode<T>) node;

                while(link.next != nodeT && link.next != null){

                    if(link.data == nodeT.data){
                        return link.prev.data;

                    }else{
                        link = link.next;
                    }
                }
            }
            return null;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T getNext(Node node) {
        try{
            if(node == null){
                System.out.println("El nodo que insertaste es nulo");
                return null;

            }else{

                DoublyLinkedListNode<T> link = head;
                DoublyLinkedListNode<T> next;
                DoublyLinkedListNode<T> nodeT = (DoublyLinkedListNode<T>) node;

                while(link.next != nodeT && link.next != null){
                    if(link.data == nodeT.data){
                        next = link.next;
                        return next.data;

                    }else{
                        link = link.next;
                    }
                }
            }
            return  null;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T getFirst() {

        if(!isEmpty()){
            return head.data;
        }
        return null;
    }

    @Override
    public T[] getFirst(int n) {
        try{
            if(!isEmpty()){

                if (n <= 0 || head == null) {
                    return null;
                }

                T[] arrayTs = (T[]) Array.newInstance(head.data.getClass(), n);
                DoublyLinkedListNode<T> link = head;
                int i = 0;

                while(i < arrayTs.length && link.next != null){
                    arrayTs[i] = link.data;
                    link = link.next;
                    i++;
                }

                return arrayTs;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T getLast() {
        if(!isEmpty()){
            return tail.data;
        }
        return null;
    }

    @Override
    public T[] getLast(int n) {
        try{
            if(n > size()){
                throw new IllegalArgumentException("n es mayor que el tamaño de la lista");
            }

            if(!isEmpty()){

                T[] arrayTs = (T[]) Array.newInstance(head.data.getClass(), n);
                DoublyLinkedListNode<T> link = head;

                for (int i = 0; i < size() - n; i++) {
                    link = link.next;
                }

                for (int i = n - 1; i >= 0; i--) {
                    arrayTs[i] = link.data;
                    link = link.next;
                }
                return arrayTs;
            }
            return null;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T pop() {
        try{
            if(head != null){

                DoublyLinkedListNode<T> temp;

                if(head.next == null){ //Comprobar si es el único elemento
                    temp = head;
                    head = null;

                }else{

                    temp = tail;
                    tail = tail.prev;
                    tail.next = null; //Cuando el bucle termine, estará ubicado en el penúltimo enlace

                    length--;          //Así que se eliminará el siguiente

                    return  temp.data;
                }
            }
        } catch(Exception e) {
            System.out.println("La lista esta vacia");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(T object) {

        if(head != null){

            DoublyLinkedListNode<T> link = new DoublyLinkedListNode<>();
            DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(object);
            DoublyLinkedListNode<T> temp;
            link = head;

            if(contains(object)){
                if(head.data == node.data){

                    temp = head;
                    head = link.next;
                    head.prev = null;
                    temp = null;
                    length--;

                    return true;
                }
                else if (tail.data == node.data) {
                    temp = tail;
                    tail = tail.prev;
                    temp = null;
                    length--;

                    return true;
                }

                while(link.next != null){

                    if(link.next.data == node.data){

                        temp = link.next;
                        link.next = link.next.next;
                        link = null;

                        length--;
                        return true;

                    }else{
                        link = link.next;
                    }
                }
            }else{
                System.out.println("Objeto no encontrado");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Node node) {
        try{

            if(!isEmpty()){

                DoublyLinkedListNode<T> nodeT;
                DoublyLinkedListNode<T> link = head;
                DoublyLinkedListNode<T> temp;
                nodeT = (DoublyLinkedListNode<T>) node;

                if(head == nodeT){
                    temp = head;
                    head = link.next;
                    head.prev = null;
                    temp = null;
                    length --;

                    return true;
                }

                while(link.next != null){

                    if(link.next.data == nodeT.data){

                        temp = link.next;
                        link.next = link.next.next;
                        link = null;

                        length--;
                        return true;

                    }else{
                        link = link.next;
                    }
                }
            }
            return false;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeAll(T[] objects) {

        try {

            if(isEmpty() || objects == null){
                return false;
            }

            for (T t : objects) {
                remove(t);
            }

            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean retainAll(T[] objects) {
        return false;
    }

    @Override
    public boolean set(Node node, T object) {
        try {

            if(!isEmpty()){

                DoublyLinkedListNode<T> link = head;
                DoublyLinkedListNode<T> nodeT;
                nodeT = (DoublyLinkedListNode<T>) node;

                nodeT.data = object;

                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public List subList(Node from, Node to) {

        try{
            List subList = new DoublyLinkedList<>();
            DoublyLinkedListNode<T> link = (DoublyLinkedListNode<T>) from;
            DoublyLinkedListNode<T> fin = (DoublyLinkedListNode<T>) to;

            while(link != fin.next){
                subList.add(link.data);
                link = link.next;
            }
            return subList;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T[] toArray() {
        try{
            int size = size();
            T[] array = (T[]) Array.newInstance(head.data.getClass(), size);
            DoublyLinkedListNode<T> link = head;
            int i = 0;

            while (link != null) {
                array[i++] = link.data;
                link = link.next;
            }
            return array;

        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public boolean orderBy(char c) {
        try{

            if (c == 'a') { // ordenar en orden ascendente
                DoublyLinkedListNode<T> link = head;

                while (link != null) {
                    DoublyLinkedListNode<T> nodeT = link.next;

                    while (nodeT != null) {
                        if (((Comparable)link.data).compareTo(nodeT.data) > 0) {

                            T temp = link.data;
                            link.data = nodeT.data;
                            nodeT.data = temp;
                        }
                        nodeT = nodeT.next;
                    }
                    link = link.next;
                }
                return true;
            } else if (c == 'd') { // ordenar en orden descendente
                DoublyLinkedListNode<T> link = tail;

                while (link != null) {
                    DoublyLinkedListNode<T> nodeT = link.prev;

                    while (nodeT != null) {
                        if (((Comparable)link.data).compareTo(nodeT.data) < 0) {

                            T temp = link.data;
                            link.data = nodeT.data;
                            nodeT.data = temp;
                        }
                        nodeT = nodeT.prev;
                    }
                    link = link.prev;
                }
                return true;
            } else {
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    return  false;
    }

    @Override
    public void print() {
        try{
            DoublyLinkedListNode<T> link = head;

            while(link != null){
                System.out.print(link.data + " ");
                link = link.next;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<Node> iterator() {
        inode = head;
        return new Iterator<>(){

            public boolean hasNext(){
                return inode != null;
            }

            public Node next(){
                Node tmp = inode;
                inode = inode.next;
                return tmp;
            }
        };
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
