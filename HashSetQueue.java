/**
 * A generic Hash Set Queue
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class HashSetQueue<E> {
    private QueueNode<E> front;
    private int size;
    
    public HashSetQueue() {
        clear();
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean add(E value) {
        QueueNode<E> current = front;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new QueueNode<E>(value);
        size++;
        return true;
    }
    
    public QueueNode<E> remove() {
        QueueNode<E> first = front.next;
        front.next = first.next;
        size--;
        return first;
    }
    
    public void clear() {
        this.front = new QueueNode<E>(null);
        size = 0;
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
