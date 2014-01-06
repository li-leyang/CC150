import java.util.ArrayList;
import java.util.LinkedList;

/*CTCI 3.3: design a data structure of once the new stack exceeds the threshold, create a new stack.
 * Then write popAt(int index)
 * use array to represent stack
 * */
class Stack{
	int value;
	int size;
	int capacity;
	int top,bottom;
	int[] stack;
	public Stack(){
		size=0;
		capacity=10;
		stack=new int[capacity];
		
	}
	public void push(int n) throws Exception {
	
		if(size>=capacity){
			throw new Exception("the stack is full");
		}
		stack[size]=n;
		size++;
		
	}
	public int pop() throws Exception{
		if(size==0)
			throw new Exception("the stack is empty");
		int result=stack[size-1];
		size--;
		return result;
	}
	
	public int peek() throws Exception{
		if(size==0)
			throw new Exception("The stack is empty");
		return stack[size-1];
	}
	public  int[] shiftArray(){
		int length=size;
		for(int i=0;i<length-1;i++){
			stack[i]=stack[i+1];
			
		}
		//size--;
		return stack;
	}

}
class setOfStacks{
	ArrayList<Stack> stacks=new ArrayList<Stack>();
	
	public void push(int value) throws Exception{
		//System.out.println("s");
		
		if(getLastStack()!=null && getLastStack().size!=getLastStack().capacity){
			stacks.get(stacks.size()-1).push(value);


		}
		else{
			Stack stack=new Stack();
			stack.push(value);
			stacks.add(stack);
		}
	}
	public int pop() throws Exception{
		int result=getLastStack().pop();
		if(getLastStack().size==0)
			stacks.remove(stacks.size()-1);
		return result;
	}
	public Stack getLastStack(){
		if(stacks.size()>0)
			return stacks.get(stacks.size()-1);
		return null;
	}
	
	// pop the  arraylist index i and perform pop operation on sub-stack
	public int popAt(int index) throws Exception{
		if(index>stacks.size()-1)
			throw new Exception("index out of bound");
		Stack stack=stacks.get(index);//index of stack list
		int result=stack.pop();
		//if not the last substack
		if(index!=stacks.size()-1)
			stack.push(move(index+1));//push the bottom of the next stack
		
		return result;
	}
	public int move(int index) throws Exception{
		System.out.println("s");
		Stack stack=stacks.get(index);
		int value=stack.stack[0];//bottom of the stack
		stack.shiftArray();//array shift
		stack.size--;
		if(index!=stacks.size()-1){//if not the last stack
			stack.push(move(index+1));//push the next stack
		}
		else{
			if(stack.size==0)//stack is empty, then remove from the arraylist
				stacks.remove(stack);
		}
		
		return value;
	}

}
class setOfStacks{
	public static void main(String[] args) throws Exception{
		SetOfStacks stack=new SetOfStacks();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		stack.push(15);
		stack.push(16);
		stack.push(17);
		stack.push(18);
		stack.push(19);
		stack.push(20);
		stack.push(21);
		stack.push(22);
		stack.push(23);
		stack.push(24);
		stack.push(25);
		stack.push(26);
		stack.push(27);
		stack.push(28);
		stack.push(29);
		stack.push(30);
		stack.push(31);
		stack.pop();
		stack.popAt(1);
		for(int i=0;i<stack.stacks.size();i++){
			System.out.print("\nstack"+i+" ");
			for(int j=0;j<stack.stacks.get(i).size;j++)
				System.out.print(stack.stacks.get(i).stack[j]+" ");
		}
	}
}


