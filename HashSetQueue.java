import java.util.HashSet;

/**
 * A generic Hash Set Queue
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class HashSetQueue<E> {
    private QueueNode<E> first;
    private int size;
    private HashSet<E> hashSet;
    
    public HashSetQueue() {
        hashSet = new HashSet<E>();
        clear();
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean add(E value) {
        if (hashSet.add(value)) {
            QueueNode<E> current = first;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new QueueNode<E>(value);
            size++;
            return true;
        } else {
            return false;
        }
    }
    
    public E remove() {
        QueueNode<E> current = first.next;
        first.next = current.next;
        hashSet.remove(current.data);
        size--;
        return current.data;
    }
    
    public void clear() {
        first = new QueueNode<E>(null);
        hashSet.clear();
        size = 0;
    }
    
    public QueueNode<E> peek() {
        return first.next;
    }
    
    private class QueueNode<E> {
        public E data;
        public QueueNode<E> next;
        
        public QueueNode(E data) {
            this(data, null);
        }
        
        public QueueNode(E data, QueueNode<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
