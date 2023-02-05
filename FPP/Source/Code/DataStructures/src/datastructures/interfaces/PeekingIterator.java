/**
 * Interfaces for my data structures to implement
 */
package datastructures.interfaces;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This defines a PeekingIterator, an enhanced Iterator
 * that includes the peek method.
 * @author obi
 * @since 2021-06-16
 */
public interface PeekingIterator<E> extends Iterator<E> {
	
	/**
     * Retrieves and returns the next element 
     * of this iterator, without advancing the cursor
     * or throws a NoSuchElementException if no next element exists.
     *
     * @return the next element of the iterator
	 * @throws NoSuchElementException if no next element exists
	 */
	public abstract E peek();
	
}
