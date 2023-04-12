package Cola.Tools;

import java.lang.reflect.Array;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    public LinkedListNode<T> head; //Es una referencia, una dirección de memoria
    public LinkedListNode<T> tail;
    public LinkedListNode<T> inode;
    private int length = 0;


    public LinkedList() { //permite iniciar una lista sin que tenga ningún nodo
        this.head = null;
        this.tail = null;
    }

    public LinkedList(T object) { //Permite pasar el primer elemento
        this.head = tail = new LinkedListNode(object);
    }
    
    @Override
    public boolean add(T object) {
        
        boolean ack = false;
        
        try{
            if(object != null){

               if(isEmpty()){

                this.head = this.tail = new LinkedListNode(object); 
                this.tail.next = this.head;

                }else{
                   tail.next = new LinkedListNode(object);
                   tail = tail.next;
               }
               length++;
               ack = true;
            }

        } catch (Exception e){
            e.printStackTrace(); 
        }finally{
            return ack; 
        }
    }

    @Override
    public boolean add(Node node, T object) {
        
        boolean ack = false;

        try{

            if(node == null){
                System.out.println("El nodo que insertaste es nulo");
            }
            else{
                LinkedListNode nodeT = (LinkedListNode)node;
                LinkedListNode nextNode = new LinkedListNode<>(object);

                nextNode.next = (LinkedListNode)nodeT.next;
                nodeT.next = nextNode; 

                ack = true;
                length++;
               return ack; 
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return ack;
        }
    }
        
    @Override
    public boolean add(Node node, Node next) {
        
        boolean ack = false;

        try{
            if(node == null){
                System.out.println("El nodo que insertaste es nulo");

            }else{

                LinkedListNode thisNode = (LinkedListNode)node;
                LinkedListNode nextNode = (LinkedListNode)next;      
                nextNode = new LinkedListNode<>(nextNode.data);         

                nextNode.next = thisNode.next;
                thisNode.next = nextNode;

                ack = true;
                length++;
                return ack;
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return ack;
        }
    }

    @Override
    public boolean add(T[] objects) {
        boolean ack = false;
        
        try{

            for (T t : objects) {
                LinkedListNode node = new LinkedListNode<>(t);
                length++;

                if(isEmpty()){

                head = node;
                ack = true;

            }else{
                LinkedListNode link = head;

                while(link.next != null){
                    link = link.next;
            }
                link.next = node;
                ack = true;
                }        
                }
            return ack;
              
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return ack;
        }
    }

    @Override
    public boolean add(Node node, T[] objects) {

        try{

            LinkedListNode nodeT = (LinkedListNode)node;
            LinkedListNode link = head;
            boolean found = false;

            while(link.next != null){//Comprobar si el nodo se encuentra en la lista

               if(link == nodeT){
                found = true;
                break;

               }else{
                found = false;
                link = link.next;
               } 
               
            }
            
            if(found){
                for (T t : objects) {
                
                LinkedListNode<T> nodeN = new LinkedListNode<>(t);

                nodeN.next = link.next;
                link.next = nodeN;
                link = nodeN;

                length++;      
            }
            return true;
            }
        
            return false;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
    }
}

    @Override
    public boolean addFirst(T object) {

        try{
            LinkedListNode<T> nodeT = new LinkedListNode<>(object);

            nodeT.next = head;
            head = nodeT;
            length++;

            return true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addFirst(T[] objects) {
        try{
            LinkedListNode<T> nodeT;

            for (int i = objects.length - 1; i >= 0; i--) {
                nodeT = new LinkedListNode<>(objects[i]);
                nodeT.next = head;
                head = nodeT;
                length++;
            }     
            return true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addLast(T object) {
        
        try {

            LinkedListNode<T> nodeT = new LinkedListNode<>(object);
            LinkedListNode<T> link = head;

            while(link.next != null){
                link = link.next;
            }

            link.next = nodeT;
            length++;

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addLast(T[] objects) {
        boolean ack = false;
        
        try{

            for (T t : objects) {
                LinkedListNode node = new LinkedListNode<>(t);
                length++;

                if(isEmpty()){

                head = node;
                ack = true;

            }else{
                LinkedListNode link = head;

                while(link.next != null){
                    link = link.next;
            }
                link.next = node;
                ack = true;
                }        
                }
            return ack;
              

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean clear() {

        if(head != null){
            head = null;
            length = 0;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List clone() {

        if(!isEmpty()){

            LinkedList<T> newList = new LinkedList<>();
            LinkedListNode<T> link = head;

            while(link != null){
                newList.add(link.data);
                link = link.next;
            }

            return (List) newList;
        }
        return null;
    }

    @Override
    public  boolean contains(T object) {

        boolean found = false;

        try{
            if(head != null){
                LinkedListNode link = head;           

                //Llega hasta el último elemento
                while(link.next != null){
                    if(link.data == (T)object){
                        found = true;
                        return found;
                    }else{
                        link = link.next;
                    }
                }               
                }
        }catch(Exception e){
            e.printStackTrace();

        }finally{
            return found;
        }
       
    }

    @Override
    public boolean contains(T[] objects) {

        try{

            if(head != null){

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

        LinkedListNode<T> node = null;
        
        try{

            node = new LinkedListNode<>(object);
            LinkedListNode link = head;

            while(link.next != null){
                if(link.data == node.data){
                    node = link;
                    return link;
                }
                link = link.next;
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return node;
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T get() {

        LinkedListNode link = null;

        try {

            if(head != null){
            
                link = head;

                while(link.next != null){
                    link = link.next;
                }

                return (T) link.data;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return (T) link.data;
        }   
    }

    @Override
    public T get(Node node) {

        try {
            if (node == null) {
                System.out.println("El nodo que insertaste es nulo");
                return null;

            } else {

                LinkedListNode<T> link = head;
                LinkedListNode<T> nodeT;
                nodeT = (LinkedListNode<T>) node;

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

        try{

            if(node == null){
                System.out.println("El nodo que insertaste es nulo");
                return null;

            }else{
                LinkedListNode<T> previous;
                LinkedListNode<T> link = head; 
                LinkedListNode<T> nodeT = (LinkedListNode<T>) node;

                link = head;

                while(link.next != nodeT && link.next != null){

                    if(link.next.data == nodeT.data){
                        link.next = link;
                        previous = link;

                        return previous.data;
                    }else{
                      link = link.next;  
                    }    
                } 
                return null;  
            }

        }catch(Exception e){
            e.printStackTrace();       
        }
        return null;
    }

    @Override
    public T getNext(Node node) { //No retorna el objeto

        LinkedListNode next = new LinkedListNode<>();

        try{
            if(node == null){
                System.out.println("El nodo que insertaste es nulo");
                return null;

            }else{
                LinkedListNode<T> link = head; 
                LinkedListNode<T> nodeT = new LinkedListNode<>();

                nodeT = (LinkedListNode<T>)node;

                while(link.next != nodeT && link.next != null){

                    if(link.data == nodeT.data){
                        next = link.next;

                        return (T) next.data;
                    }else{
                      link = link.next;  
                    }    
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return (T) next.data;
        }

    }

    @Override
    public T getFirst() {

        if(!isEmpty()){

            LinkedListNode<T> first = new LinkedListNode<>();
            first = head;

            return first.data;
        }
        return null;
    }

    @Override
    public T[] getFirst(int n) {

        if(!isEmpty()){

            if (n <= 0 || head == null) {
                return null;
            }

            T[] arrayTs = (T[]) Array.newInstance(head.data.getClass(), n);
            LinkedListNode<T> link = head;
            int i = 0;

            while(i < arrayTs.length && link.next != null){
                arrayTs[i] = link.data;
                link = link.next;
                i++;
            }

            return arrayTs;
        }

        return null;
    }

    @Override
    public T getLast() { 

        try{
            if(!isEmpty()){

                LinkedListNode<T> link = head;

                while(link.next != null){
                    link = link.next;
                }

                return link.data;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public T[] getLast(int n) {

        try{
           if(n > size()){
            throw new IllegalArgumentException("n es mayor que el tamano de la lista");  
        }

        if(!isEmpty()){

            T[] arrayTs = (T[]) Array.newInstance(head.data.getClass(), n);
            LinkedListNode<T> link = head;

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

            T temp = tail.data;

            if(head.next == null){ //Comprobar si es el único elemento
                temp = head.data;
                head = null;

                return null;
            }else{
               LinkedListNode<T> link = head;

                while(link.next.next != null){ 
                    link = link.next;
                }
            
                temp = link.next.data; //la cola es link, retorna temp
                link.next = null; //Cuando el bucle termine, estará ubicado en el penúltimo enlace
                length--;          //Así que se eliminará el siguiente

                return temp;
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

            LinkedListNode<T> link = new LinkedListNode<>();
            LinkedListNode<T> node = new LinkedListNode<>(object);
            LinkedListNode<T> temp;
            link = head;

            if(contains(object)){
                
                if(head.data == node.data){
                    temp = head;
                    head = link.next;
                    temp = null;
                    length--;

                    return true;
                }
                
                while(link.next != null){

                if(link.next.data == node.data){
                    temp = link.next;
                    link.next = link.next.next;
                    temp = null;

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
        
        if(!isEmpty()){
            LinkedListNode<T> link = head;
            LinkedListNode<T> nodeT = new LinkedListNode<>(); 
            LinkedListNode temp;

            nodeT = (LinkedListNode<T>) node;
            

            if(head == nodeT){
                temp = head;
                head = link.next;
                temp = null;
                length --;

                return true;
            }

            while(link.next != null){

                if(link.next == nodeT){
                    temp = link.next;
                    link.next = link.next.next;
                    temp = null;

                    length--;
                    return true;

                }else{
                    link = link.next;
                }
            }
        }
        return false;
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
        boolean ack = false;

        try{
            if(!isEmpty()){
                LinkedListNode<T> link = head;
                LinkedListNode<T> nodeT = new LinkedListNode<>(); 

                while(link.next != null){
                    for (int i = 0; i < objects.length; i++) {
                            if(link.data == objects[i]){
                                nodeT = new LinkedListNode<>(objects[i]);
                            }else{
                                link = link.next;
                            }
                        }
                    }
                
                link = nodeT;

                if(link== null){
                    ack = false;
                }else{
                    ack = true;
                }  
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return ack;
        }
    }

    @Override
    public boolean set(Node node, T object) {

        try {

            if(!isEmpty()){

                LinkedListNode<T> link = head;
                LinkedListNode<T> nodeT = new LinkedListNode<>();
                nodeT = (LinkedListNode<T>) node;

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
            List subList = new LinkedList<>();
            LinkedListNode<T> link = (LinkedListNode<T>) from;
            LinkedListNode<T> fin = (LinkedListNode<T>) to;

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
            LinkedListNode<T> link = head;
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

    //??
    @Override
    public boolean orderBy(char c) {
        try{

            if (c == 'a') { // ordenar en orden ascendente
                LinkedListNode<T> link = head;

                while (link != null) {
                    LinkedListNode<T> nodeT = link.next;

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
                LinkedListNode<T> link = head;

                while (link != null) {
                    LinkedListNode<T> nodeT = link.next;

                    while (nodeT != null) {
                        if (((Comparable)link.data).compareTo(nodeT.data) < 0) {
                            T temp = link.data;
                            link.data = nodeT.data;
                            nodeT.data = temp;
                        }
                        nodeT = nodeT.next;
                    }
                    link = link.next;
                }
                return true;
            } else { 
                return false;
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void print() {
        try{
            LinkedListNode<T> link = head;

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
        return "LinkedList{" + "head=" + head + ", tail=" + tail + '}';
    }
  
}
