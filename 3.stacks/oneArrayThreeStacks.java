/*CTCI 3.1: use a single array to implement 3 stacks
 * fixed size stack[0~n/3),[n/3,2n/3),[2n/3,n);
 * 
 * */

// time: O(1). space:O(n).
//weakness: if three stacks are unbalanced. Some stacks are operated more frequently than others. 
class Stack{
	int stackSize=10;
	int[] buffer=new int[3*stackSize];
	int[] stackPointer={-1,-1,-1};
	
	//stackNum=-1,0 and 1. stackNum is
	public void push(int stackNum,int value) throws Exception{
		if(stackPointer[stackNum]+1>=stackSize)
			throw new Exception("out of space");
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)]=value;
	}
	
	public int pop(int stackNum) throws Exception{
		if(stackPointer[stackNum]==-1){
			throw new Exception("stack is already empty");
		}
		int value=buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)]=0;
		stackPointer[stackNum]--;//pop need decrement.
		return value;
	}
	
	public int peek(int stackNum){
		int index=absTopOfStack(stackNum);
		return buffer[index];
		
	}
	public int absTopOfStack(int stackNum){
		return stackSize*stackNum+stackPointer[stackNum];
	}
	
}
public class oneArrayThreeStacks {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack stack=new Stack();
		stack.push(0, 2);
		stack.push(1, 21);
		stack.push(2, 23);
		stack.push(2, 12);
		stack.push(0, 22);
		for(int i=0;i<stack.buffer.length;i++){
			System.out.println(stack.buffer[i]);
		}
	}
	
}
