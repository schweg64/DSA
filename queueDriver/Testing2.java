package queueDriver;
import queue.*;
public class Testing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(12);
		queue.add(12);
		queue.add(10);
		queue.add(0);
		queue.add(4);
		queue.add(6);
		queue.add(8);
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
	}
	
}
