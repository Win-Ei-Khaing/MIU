package prog9_2_startup;

import java.util.Arrays;

public class MyCharStack {
	private char[] arr = new char[10];
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int pop() {
		if(isEmpty()) throw new IllegalStateException("Stack is empty!");
		int deletedValue=arr[--size];
		arr[size]=0;
		return deletedValue;
	}

	public char peek() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		return arr[size-1];
	}

	public void push(char i) {
		if(size==arr.length) resize();
		arr[size++]=i;
	}

	//queue size, not array size
	public int size() {
		return size;
	}

	public void resize() {
		char[] newAry=new char[arr.length*2];
		System.arraycopy(arr, 0, newAry, 0, size());
		arr=newAry;
	}

	public static void main(String[] args) {
		MyCharStack c = new MyCharStack();
		c.push('A');
		c.push('B');
		c.push('C');
		c.push('D');
		c.push('E');

		System.out.println(Arrays.toString(c.arr));
		System.out.println("Size is : "+c.size());
		System.out.println("Peek is : "+c.peek());

		c.pop();
		System.out.println(Arrays.toString(c.arr));
		System.out.println("Size is : "+c.size());
		System.out.println("Peek is : "+c.peek());
		c.pop();
		System.out.println(Arrays.toString(c.arr));
		System.out.println("Size is : "+c.size());
		System.out.println("Peek is : "+c.peek());
	}
}

