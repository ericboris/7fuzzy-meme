import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HashSetQueueTest.
 *
 * @author  Eric Boris
 * @version 12/3/2018
 */
public class HashSetQueueTest {
    /** hashSetQueue                store a reference to test object */
    private HashSetQueue<Integer> hashSetQueue;
    
    /**
     * Default constructor for test class HashSetQueueTest
     */
    public HashSetQueueTest() {
        hashSetQueue = new HashSetQueue<Integer>();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
    
    /**
     * test the constructor
     */
    @Test
    public void testConstructor() {
        assertTrue(hashSetQueue instanceof HashSetQueue);
    }
    
    /**
     * test that size and add work
     */
    @Test
    public void testSizeAndAdd() {
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, hashSetQueue.size());
            hashSetQueue.add(i);
        }
    }
    
    /**
     * test that remove works
     */
    @Test
    public void testRemove() {
        for (int i = 0; i < 1000; i++) {
            hashSetQueue.add(i);
        }
        
        for (int j = 0; j < 1000; j++) {
            assertEquals((Integer) j, (Integer) hashSetQueue.remove());
        }
    }
    
    /**
     * test that is empty returns true when empty and false otherwise
     */
    @Test
    public void testIsEmpty() {
        assertEquals(true, hashSetQueue.isEmpty());
        hashSetQueue.add(1);
        assertEquals(false, hashSetQueue.isEmpty());
    }
    
    /**
     * test that clear clears a queue
     */
    @Test
    public void testClear() {
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, hashSetQueue.size());
            hashSetQueue.add(i);
        }
        hashSetQueue.clear();
        assertEquals(0, hashSetQueue.size());
    }
    
    /**
     * test that peek returns the expected data
     */
    @Test
    public void testPeek() {
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, hashSetQueue.size());
            hashSetQueue.add(i);
        }
        
        for (int j = 0; j < 1000; j++) {
            assertEquals((Integer) j, (Integer) hashSetQueue.peek());
            hashSetQueue.remove();
        }
    }
    
    /**
     * test that nullpointerexception is thrown when removing from empty queue
     */
    @Test (expected = NullPointerException.class)
    public void removeFromEmptyQueue() {
        hashSetQueue.remove();
    }
}
