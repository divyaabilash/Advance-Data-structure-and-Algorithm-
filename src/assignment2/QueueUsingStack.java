package assignment2;

import java.util.Stack;

class Queue1{
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
		
		public void enqueue(int num1){
		s1.push(num1);	
		}
		
		public int dequeue(){
		int returnData=0;
			if(s2.isEmpty()){
				if(!s1.isEmpty()){
					while(!s1.isEmpty()){
					s2.push(s1.pop());
					}
//					returnData=s2.pop();
				}else{
					System.out.println("The Queue is Empty!! please Refill");
					return -1;
				}
			}
				returnData=s2.pop();	
		
			return returnData;
		}
		
}

public class QueueUsingStack {
	
	
	public static void main(String[] args) {
		Queue1 q=new Queue1();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(7);
		System.out.println(q.dequeue());
		q.enqueue(8);
		q.enqueue(9);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

}
