package prog9_3_startup;

import java.util.Arrays;

public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	private int front = 0;
	private int rear = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int dequeue() {
		if(isEmpty()) throw new IllegalStateException("Queue is empty!");
		int deletedValue=front;
		arr[0]=arr[1];
		front=arr[0];
		int[] newAry=new int[arr.length];
		System.arraycopy(arr, 1, newAry, 0, size());
		arr=newAry;
		size--;
		rear=arr[size-1];
		return deletedValue;
	}
	
	public int peek() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		return front;
	}

	public void enqueue(int i) {
		if(size==arr.length) resize();
		rear=arr[size++]=i;
		if(size==0){//mark front for the very first insertion
			front=arr[0];
			rear=front;//at the very first time insertion, front and rear will be the same
		}
	}

	//queue size, not array size
	public int size() {
		return size;
	}

	public void resize() {
		int[] newAry=new int[arr.length*2];
		System.arraycopy(arr, 0, newAry, 0, size());
		arr=newAry;
	}

	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		//uncomment when ready
		for(int i = 0; i < 15; i ++) {
			q.enqueue(i);
			//System.out.println("Enqueuing "+i +"\n Result is : "+Arrays.toString(q.arr));
		}
		System.out.println(Arrays.toString(q.arr));
		System.out.println("Size is : "+q.size());
		System.out.println("Peek is : "+q.peek());
		System.out.println("Rear or Tail is : "+q.rear);
		for(int i = 0; i < 14; i ++)
			q.dequeue();

		//System.out.println("Dequeing - deleted value is "+q.dequeue()+"\n Result is : "+Arrays.toString(q.arr));
		System.out.println(Arrays.toString(q.arr));
		System.out.println("Size is : "+q.size());
		System.out.println("Peek is : "+q.peek());
		System.out.println("Rear or Tail is : "+q.rear);
	}
}
