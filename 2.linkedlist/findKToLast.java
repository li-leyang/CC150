/*CTCI 2.2: find the k to last elementin ll
 * 
 * */
import java.util.*;
class Node{
	public int value;
	public Node next;
	Node(int d){
		value=d;
		next=null;
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
public class findKToLast {

	public static final int SIZE=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node d=new Node(3);
		d.append(new Node(2));
		d.append(new Node(22));
		d.append(new Node(1));
		d.append(new Node(4));
		d.append(new Node(3));
		d.append(new Node(10));
		d.append(new Node(21));
		d.append(new Node(21));
		d.append(new Node(2));
		printList(d);
		int k=3;
		Node n=findKToLast(d,k);
		System.out.println(n.value);

	}

	/*use runner technique, use two ptrs.
	 * first, advance p2 k elements to make p2 k elements ahead of p1.Then p2 and p1 advance at the same rate.
	 * time:O(n) space:O(1)
	 * */
	public static Node findKToLast(Node head,int k){

		Node p2=head;
		Node p1=null;
		for(int i=0;i<k;i++){
			if(p2.next!=null)
				p2=p2.next;
			else
				return null;
		}
		p1=head;
		while(p2.next!=null){
			p2=p2.next;
			p1=p1.next;
		}
		return p1;
	}

	public static void printList(Node d){
		while(d!=null){
			System.out.print(d.value+"->");
			d=d.next;
		}
		System.out.println("null");
	}

}
