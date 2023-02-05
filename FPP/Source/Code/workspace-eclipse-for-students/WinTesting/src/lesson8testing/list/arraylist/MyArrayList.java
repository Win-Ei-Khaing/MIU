package lesson8testing.list.arraylist;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList<E> { //E means Elements, can check in Generic type slides
	private E[] data;
	//private Object[] data; //as everything is under Object, we can use Object instead of Generic E
	private static final int INITIAL_LENGTH=2;
	private int size;
	
	MyArrayList(){
		this.data=(E[])new Object[INITIAL_LENGTH];
	}
	
	/**
	 * Adds a new element, E, into the list
	 * @param e
	 */
	public void add(E e) {
		if(size==data.length){
			resize();
		}
		data[size++]=e;
	}
	
	private void resize() {
		E[] newData=(E[]) new Object[2*data.length];
		System.arraycopy(data, 0, newData, 0, data.length);
		this.data=newData;
	}
	
	/**
	 * Prints the content of the list formatted as, [1,2,3]
	 */
	public void print() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		int i=0;
		for(;i<size-1;i++)
			sb.append(data[i]+", ");
		sb.append(data[i]);
		sb.append("]");
		System.out.println(sb.toString());
		//System.out.println(Arrays.toString(data)); //we should not use this one because null value will be shown as much as they own in array
	}
	
	/**
	 * Returns the string represent content of the list formatted as , [1,2,3]
	 */
	public String toString() {
		StringJoiner sj=new StringJoiner(", ", "[","]");
		for(int i=0;i<size;i++)
			sj.add(data[i].toString());
		
		return sj.toString();
	}
	
	/**
	 * Returns the elements at the specified position i in the list
	 * @param i
	 * @return
	 */
	public E get(int i) {
		if(i<0 || i>=size) throw new IndexOutOfBoundsException("Invalid index , i:"+i);
		return data[i];
	}
	
	//hw is remove, insert and contain
	/**
	 * Remove e from the list
	 * @param e
	 * @return
	 */
	public boolean remove(E e){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(data[i].equals(e)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		E[] temp = (E[]) new Object[data.length];
		System.arraycopy(data,0,temp,0,index);
		System.arraycopy(data,index+1,temp,index,data.length-(index+1));
		data = temp;
		--size;
		return true;
	}

	/**
	 * Insert e at at pos position and move other elements(behind pos) to next +1 position 
	 * @param e
	 * @param pos
	 */
	public void insert(E e, int pos){
		if(pos > size) return;
		if(pos >= data.length||size+1 > data.length) {
			resize();
		}
		E[] temp = (E[]) new Object[data.length+1];
		System.arraycopy(data,0,temp,0,pos);
		temp[pos] = e;
		
		System.arraycopy(data,pos,temp,pos+1, data.length - pos);
		data = temp;
		++size;
		
	}
	
	/**
	 * Check e is contained in the list or not
	 * @param e
	 * @return
	 */
	public boolean contain(E e){
		for(E d : data){
			if(e.equals(d)) return true;
		}
		return false;
	}
}
