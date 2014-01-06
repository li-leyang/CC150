/*CTCI 3.2: push pop and min are within O(1).
 * 
 * */

//method2: use additional stack to store the min value instead of each field in the node.
/*time: O(1). more efficient in space.
 * */
class Stack{
	int value;
	int size;
	int capacity;
	int[] stack;
	public Stack(){
		size=-1;
		capacity=10;
		stack=new int[capacity];
		
	}
	public void push(int n) throws Exception {
		if(size>=capacity-1)
			throw new Exception("the stack is full");
		stack[++size]=n;
		
	}
	public int pop() throws Exception{
		if(size<0)
			throw new Exception("the stack is empty");
		int result=stack[size--];
		return result;
		
	}
	public int peek() throws Exception{
		if(size<0)
			throw new Exception("The stack is empty");
		return stack[size];
	}
	public int findMin() throws Exception{
		if(size<0){
			//System.out.println(Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}
		return this.peek();
	}
	
	
}
//stack1 extends generic stack
class Stack2 extends Stack{
	//additional stack2
	Stack s2;
	public Stack2(){
		s2=new Stack();
	}
	
	//overriden stack
	public void push(int n) throws Exception{
		if(size>=capacity-1){
			throw new Exception("out of capacity");
		}

		//if and only if the min value would be stored in stack.
		if(n<s2.findMin()){
			s2.push(n);
		}
		//s1.push
		super.push(n);		
	}
	

	
}
public class PushPopMin2 {

	public static void main(String[] args) throws Exception {

		// additional stack2
		Stack2 stack=new Stack2();
	
		stack.push(3);
		stack.push(5);
		stack.push(6);
		stack.push(2);
		stack.push(51);
		stack.push(12);
		stack.push(1);
		//stack.pop();
		//stack.pop();
		//stack.findMin();
		printStack(stack.s2);
	}
	public static void printStack(Stack stack) throws Exception{
		for(int i=0;i<=stack.size;i++){
			System.out.print(stack.stack[i]+" ");
			
		}
		System.out.println(stack.findMin());
	}
}
