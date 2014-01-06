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

public class findLoopStart {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node d1=new Node(7);
		Node n=new Node(4);
		d1.append(new Node(1));
		d1.append(new Node(3));
		d1.append(n);
		d1.append(new Node(4));
		d1.append(new Node(10));
		d1.append(new Node(12));
		d1.append(new Node(19));
		d1.append(new Node(14));
		d1.append(new Node(11));
		d1.append(new Node(100));
		d1.append(n);
		Node d=circleLoop(d1);
		System.out.println(d.value);
	}
	
/*method1: first collision is k away from the loop start. Set the p1 to listhead and meet with runner.
 * the second collision point is the loop start
 * Time:O(n),space:O(1)
 * */

	public static Node circleLoop(Node head){
		Node p1=head;
		Node runner=head;
		while(runner.next.next!=null){
			p1=p1.next;
			runner=runner.next.next;
			if(runner==p1){
				p1=head;
				while(p1!=runner){
					p1=p1.next;
					runner=runner.next;
					if(runner==p1)
						return runner;
				}
			}
		}
		return null;
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
