package Cola;

import Cola.Tools.DoublyLinkedList;
import Cola.Tools.Node;

import java.util.Iterator;

public class DinamicQueue<T> implements QueueInterface<T> {

    DoublyLinkedList<T> queue = new DoublyLinkedList<>();

    @Override
    public void clear() {
        try{

            if(!isEmpty()){
                queue.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            return queue.isEmpty();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public T extract() {
        try {

            if(!isEmpty()){
                T temp = queue.getFirst();
                queue.remove(queue.getFirst());

                return temp;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(T object) {

        try{

            queue.addLast(object);

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int size() {
        try {

            return queue.size();

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean search(T object) {
        try {

            return queue.contains(object);

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void sort() {
        try {

            if(!isEmpty()){
                //Ordenar de forma ascendente
               queue.orderBy('a');
               //Este método solo accede por la cabeza, por lo tanto se puede usar para la cola
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void reverse() {
        try {
            if(!isEmpty()){
                DoublyLinkedList<T> reverse = new DoublyLinkedList<>();
                Iterator i = queue.iterator();

                while(i.hasNext()){
                    Node<T> thing = (Node<T>) i.next();
                    reverse.addFirst(thing.getObject());
                }

                queue = reverse;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toString(){
        try{

            if (isEmpty()) {
                return "";
            }

            StringBuilder string = new StringBuilder();
            Iterator<Node> i = queue.iterator();

            while (i.hasNext()) {

                string.append(i.next().getObject().toString());
                string.append(" ");
            }

            return string.toString();

        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
