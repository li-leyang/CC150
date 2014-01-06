/*CTCI 2.6: find the first element of the loop in ll
 * */
import java.util.*;
class Node{
	public int value;
	public Node next;
	public Node prev;
	Node(int d){
		value=d;
		next=null;
		prev=null;
	}
	public void append(Node v){
		Node d=this;
		//jump to the tail,append to tail
		while(d.next!=null){
			d=d.next;
		}
		d.next=v;
	}
	public Node remove(Node head,int d){
		Node n=head;
		//remove head
		if(n.value==d)
			return head.next;
		while(n.next!=null){
			if(n.next.value==d){
				n.next=n.next.next;
			}
			//step forwards
			n=n.next;
		}
		return head;	
	}

}

public class checkPanlidrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node d1=new Node(7);
		d1.append(new Node(1));
		d1.append(new Node(3));
		d1.append(new Node(4));
		d1.append(new Node(10));
		d1.append(new Node(4));
		d1.append(new Node(3));
		d1.append(new Node(1));
		d1.append(new Node(7));

		boolean bool=isPanlidrome(d1);
		System.out.println(bool);
	}
	
/*method1: we used java.util in this problem (stack) to store the list and pop in the reverse order .
 * To save time, we only check half of the stack.
 * time:O(n). space:O(n)stack
 * */

	public static boolean isPanlidrome(Node head){
		Stack<Node> stack=new Stack<Node>();
		if(head==null)
			return false;
		
		Node current=head;
		//push the list to stack
		while(current!=null){
			stack.push(current);
			current=current.next;
		}
		//pop element from stack to check
		current=head;
		int size=stack.size();
		while(stack.size()>size/2){
			if(stack.peek().value!=current.value)
				return false;
			stack.pop();
			current=current.next;
		}
		return true;
	}


	public static int length(Node d){
		int count=0;
		Node current=d;
		while(current!=null){
			count++;
			current=current.next;
		}
		return count;
	}


	public static void printList(Node d){
		while(d!=null){
			System.out.print(d.value+"->");
			d=d.next;
		}
		System.out.println("null");
	}

}
