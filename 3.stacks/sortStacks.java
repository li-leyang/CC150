import java.util.Stack;

/*3.6 implement sort the stack in ascending order using one additional stack
 * we roughly sort the helper stack in ascending order and compare the top element with temp
 * like insertion sort
 * 
 * 
 * */

class sort{

	public Stack<Integer> stack,helper;
	public sort(){
		stack=new Stack<Integer>();
		helper=new Stack<Integer>();
	}
	public Stack sortStack(){
		if(stack.size()<2)
			return null;

		while(!stack.isEmpty()){
			int tmp=stack.pop();
			while(!helper.isEmpty()&&helper.peek()>tmp){
				stack.push(helper.pop());  

			}
			helper.push(tmp);

		}	
		return helper;
	}
} 
public class sortStacks{
	public static void main(String[] args){
		sort s=new sort();
		s.stack.push(1);
		s.stack.push(9);
		s.stack.push(2);
		s.stack.push(4);
		s.stack.push(6);
		s.stack.push(8);
		s.stack.push(7);
		Stack ss=s.sortStack();
		for(int i=0;i<ss.size();i++){

			System.out.println(ss.get(i));
		}
	}
}