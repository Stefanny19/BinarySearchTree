package Cola;

public interface QueueInterface<T> {

    public void clear();
    public boolean isEmpty();
    public T extract();
    public boolean insert(T object);
    public int size();
    public boolean search(T object);
    public void sort();
    public void reverse();
    public String toString();
}
