/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_4.BowlingShopApp;

import java.util.LinkedList;

/**
 * Class to contain the product list and functions for interacting with it
 */
public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    /**
     * Adds an item to the queue
     * 
     * @param item
     */
    public void enqueue(E item) {
        list.addFirst(item);
    } // end enqueue

    /**
     * Removes an item from the queue
     */
    public void dequeue() {
        System.out.println(list.getFirst().toString());
        list.removeFirst();
    } // end dequeue

    /**
     * Returns the size of the list
     * 
     * @return int
     */
    public int size() {
        return list.size();
    } // end size
}
