import java.util.Stack;

/*3.5 implement a queue using two stacks
 * 
 * basic idea: enque. push val to stack1.
 * deque: pop from stack1 and push into stack2,after acquire the dequeue value
 * then push back the element in stack2
 * time of enque:O(1)
 * time of deque:O(n)
 * 
 * */
 
 class MyQueue{
	 Stack<Integer> stack1,stack2;
	 public MyQueue(){
		 stack1=new Stack<Integer>();
		 stack2=new Stack<Integer>();
	 }
	 public void enqueue(int a){
		 stack1.push(a); 
	 }
	 public int dequeue(){		 		
		 while(!stack1.isEmpty())
			 stack2.push(stack1.pop());
		 int temp=stack2.pop();
		 while(!stack2.isEmpty())
			 stack1.push(stack2.pop());
		 return temp;
	 }
 }
 public class twoStacksQueue{
	 public static void main(String[] args){
		 MyQueue queue=new MyQueue();
		 queue.enqueue(1);
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
		 queue.enqueue(3);

		 queue.enqueue(4);
		 queue.enqueue(23);
		 queue.enqueue(21);
		 System.out.println(queue.dequeue());
	 }
 }