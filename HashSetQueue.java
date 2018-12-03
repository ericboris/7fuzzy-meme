import java.util.HashSet;

/**
 * A generic Hash Set Queue
 *
 * @author Eric Boris
 * @version 12/1/2018
 */
public class HashSetQueue<E> {
    /** first                   the first node in the queue */
    private QueueNode<E> first;
    /** size                    the number of nodes in the queue */
    private int size;   
    /** hashSet                 a hash set of the queue */
    private HashSet<E> hashSet;
    
    /**
     * create a new queue
     */
    public HashSetQueue() {
        hashSet = new HashSet<E>();
        clear();
    }
    
    /**
     * get the size of the queue
     * 
     * @return                  the number of elements in the queue
     */
    public int size() {
        return size;
    }
    
    
    /**
     * is the boolean empty
     * 
     * @return                  true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * add a new value to the queue
     * 
     * @param   value           the data to add to the queue
     * @return                  true if data could be added, false otherwise
     */
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
    
    /** 
     * remove the next value from the queue
     * 
     * @return                  the next value in the queue
     */
    public E remove() {
        QueueNode<E> current = first.next;
        first.next = current.next;
        hashSet.remove(current.data);
        size--;
        return current.data;
    }
    
    /**
     * clear the queue
     */
    public void clear() {
        first = new QueueNode<E>(null);
        hashSet.clear();
        size = 0;
    }
    
    /**
     * peek at the next value without removing
     * 
     * @return                  the next value in the queue
     */
    public QueueNode<E> peek() {
        return first.next;
    }
    
    /**
     * create a new queue node
     */
    private class QueueNode<E> {
        /** the data to store in the node */
        public E data;
        /** the next node in the queue */
        public QueueNode<E> next;
        
        /**
         * create a new node
         * 
         * @param   data        the data to store in the node
         */
        public QueueNode(E data) {
            this(data, null);
        }
        
        /**
         * create a new node
         * 
         * @param   data        the data to store in the node
         * @param   next        the next node in the queue
         */
        public QueueNode(E data, QueueNode<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
