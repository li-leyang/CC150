import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*CTCI 3.3: design a data structure of once the new stack exceeds the threshold, create a new stack.
 * Then write popAt(int index)
 * use array to represent stack
 * */

/*The tower is like this:
 *         **    stack bottom
 *        ****
 *       ******  stack top(peek)
 * */
class Tower{
	private Stack<Integer> disk;
	private int index;
	public Tower(int i){
		index=i;
		disk=new Stack<Integer>();
	}

	public int index(){
		return index;
		
	}
	
	public void add(int d){

		if(!disk.isEmpty() && disk.peek()<=d){
			System.out.println("error placing plate: "+ d);			
		}
		else{

	
			disk.push(d);

		}
	}
	
	public void moveDisk(int n,Tower dest,Tower buffer){
		if(n>0){
			moveDisk(n-1,buffer,dest);
			moveTop(dest);
			buffer.moveDisk(n-1, dest, this);
			
		}
	}
	public void moveTop(Tower t){
		int top=disk.pop();//stack top is the disk number
		t.add(top);// t is dest tower number, index() is start(current) tower number
		System.out.println("Move disk "+ top+"from"+index()+"to"+t.index());
		
	}

	

}
class Hanoi{
	public static void main(String[] args) throws Exception{
		int n=3;
		Tower[] towers=new Tower[n];
		for(int i=0;i<n;i++){
			towers[i]=new Tower(i);
		}
		//from bottom to top add plate from big to small/
		for(int i=n-1;i>=0;i--){
			towers[0].add(i);
		}
		//dest and buffer in order
		towers[0].moveDisk(n,towers[2],towers[1]);
		
	}
}


