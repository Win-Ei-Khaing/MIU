package lists.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import datastructures.interfaces.PeekingIterator;

public class MyArrayListWithIterableAndPeekingIterator<E> implements Iterable<E> {
	private E[] data;
	private static final int INITIAL_LENGTH = 2;
	private int size;
	
	MyArrayListWithIterableAndPeekingIterator() {
		this.data = (E[])new Object[INITIAL_LENGTH];
		this.size = 0;
	}
	
	/**
	 * 
	 * @param e
	 */
	public void add(E e) {
		if(size == data.length)
			resize();
		data[size] = e;
		size = size + 1;
	}
	
	private void resize() {
		E[] newData = (E[])new Object[2 * data.length];
		System.arraycopy(data, 0, newData, 0, data.length);
		this.data = newData;
	}
	
	public void print() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		int i = 0;
		for(; i < size - 1; i++) {
//			s.append((i < size-1) ? (data[i] + ", ") : (data[i]));
			s.append(data[i] + ", ");
		}
		s.append(data[i]);
		s.append("]");
		System.out.println(s.toString());
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for(int i = 0; i < size; i++) {
			sj.add(data[i].toString());
		}
		return sj.toString();
	}
	
	/**
	 * Returns the element at the specified position in the list.
	 * 
	 * @param i index of the position
	 * @return the element at the specified position in the list
	 */
	public E get(int i) {
		if(i < 0 || i >= size)
			throw new IndexOutOfBoundsException("Invalid index, i:" + i);
		return data[i];
	}
	
	// TODO - Try implementing the following operations
	// remove - takes index, i, and removes element at i from list
	// contains - takes value, E, returns boolean (true/false) if any found

	@Override
	public PeekingIterator<E> iterator() {
		return new MyArrayListPeekingIterator<E>();
	}
	
	/**
	 * This implements an Iterator for MyArrayList
	 * here as a member inner class
	 * @author obi
	 * @param <E>
	 */
	class MyArrayListPeekingIterator<E> implements PeekingIterator<E> {
		private int cursor = -1;
		
		MyArrayListPeekingIterator() {
			
		}

		@Override
		public boolean hasNext() {
			return (cursor + 1 != size);
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			return (E)data[++cursor]; //(E)MyArrayListWithIterable.this.data[++cursor];
		}
		
		/**
	     * Retrieves and returns the next element 
	     * of this iterator, without advancing the cursor
	     * or throws a NoSuchElementException if no next element exists.
	     *
	     * @return the next element of the iterator
		 * @throws NoSuchElementException if no next element exists
		 */
		@Override
		public E peek() {
			if(!hasNext())
				throw new NoSuchElementException();
			int nextIndex = cursor + 1;
			return (E)data[nextIndex]; //(E)MyArrayListWithIterable.this.data[cursor];
		}
	}
	
}
