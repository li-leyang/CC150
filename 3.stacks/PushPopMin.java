/*CTCI 3.2: push pop and min are within O(1).
 * 
 * */

/*basic idea: add min attribute of each node and compare the min with pushed value.
 * time:O(1). space:O(n).
 * */
class Node{
	private int value;
	private int minValue;
	public Node(int value,int minValue){
		this.value=value;
		this.minValue=minValue;
	}
	public int getValue(){
		return value;
	}
	public int getMinValue(){
		return minValue;
	}
	public void setValue(int v){
		value=v;
	}
	public void setMin(int min){
		minValue=min;
	}
	
}
class Stack{
	Node p;
	int size;
	int capacity;
	Node[] stack;
	public Stack(){
		size=-1;
		capacity=10;
		stack=new Node[capacity];
		
	}
	public void push(int n) throws Exception{
		if(size>=capacity-1){
			throw new Exception("out of capacity");
		}
		int newMin;
		if(size>=0)
			newMin=Math.min(n, findMin());
		else
			newMin=n;
		stack[++size]=new Node(n,newMin);
	}
	public Node pop() throws Exception{
		if(size<0)
			throw new Exception("the stack is empty");
		Node result=stack[size--];
		return result;
		
	}
	public Node peek() throws Exception{
		if(size<0)
			throw new Exception("The stack is empty");
		return stack[size];
	}
	public int findMin() throws Exception{
		return this.peek().getMinValue();
	}
	
	
}
public class PushPopMin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack stack=new Stack();
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
		printStack(stack);
	}
	public static void printStack(Stack stack) throws Exception{
		for(int i=0;i<=stack.size;i++){
			System.out.print(stack.stack[i].getValue()+"&"+stack.stack[i].getMinValue()+" ");
			
		}
		System.out.println(stack.findMin());
	}
}
