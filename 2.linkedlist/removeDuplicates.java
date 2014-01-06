/*CTCI 2.1:  delete or check the duplicate element in ll
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
public class removeDuplicates {

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
		removeDuplicates2(d);
		printList(d);

	}

	/*use hash set to store key values(buffer).
	 * use additional ptr to record the pre node.
	 * time: O(n) ,space:o(n)
	 * */
	public static void removeDuplicates(Node d){
		HashSet<Integer> hash=new HashSet<Integer>();
		Node pre=null;//second ptr
		while(d!=null){
			if(hash.contains(d.value)){
				pre.next=d.next;
			}
			else{
				hash.add(d.value);
				pre=d;
			}
			d=d.next;
		}
	}
	/*still use hashset to store key values(buffer)
	 * use only one ptr to implement removal
	 * time:O(n),space:O(n)
	 * */
	public static void removeDuplicates2(Node d){
		HashSet<Integer> hash=new HashSet<Integer>();
		hash.add(d.value);
		while(d.next!=null){
			if(hash.contains(d.next.value))
				d.next=d.next.next;
			else{
				hash.add(d.next.value);
				d=d.next;
			}

		}
	}	
	/*no additional buffer allowed. 
	 * use runner trick. The current is traversed from head to tail, the runner will check the subsequent node. 
	 * time:O(n^2), space:O(1)
	 * */
	public static void removeDuplicates3(Node d){
		if(d==null)
			return;
		Node current=d;
		while(current!=null){
			Node runner=current;
			while(runner.next!=null){
				if(runner.next.value==current.value)
					runner.next=runner.next.next;
				else
					runner=runner.next;
			}
			current=current.next;
		}
	}
	public static void printList(Node d){
		while(d!=null){
			System.out.print(d.value+"->");
			d=d.next;
		}
		System.out.println("null");
	}

}
