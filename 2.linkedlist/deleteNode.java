/*CTCI 2.3: delete a node in a ll given only access to that node.
 * boolean delete(Node n) or void delete(Node n)
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
public class deleteNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node d=new Node(3);
		Node n=new Node(4);
		d.append(new Node(2));
		d.append(new Node(22));
		d.append(new Node(1));
		d.append(new Node(3));
		d.append(new Node(10));
		d.append(new Node(21));
		d.append(new Node(21));
		d.append(n);
		d.append(new Node(2));
		printList(d);
		deleteNode(n);
		printList(d);

	}

	/*method: let the next node value of delete node copied to delete, set the delete next field to
	 * the delete.next.next
	 * special care: if the delete node is tail or the delete node is null
	 * No head or any node access.
	 * time: O(1)
	 * */
	public static void deleteNode(Node delete){
		if(delete==null||delete.next==null)
			return;
		int deleteValue=delete.next.value;
		delete.value=deleteValue;
		delete.next=delete.next.next;
		
	}

	public static void printList(Node d){
		while(d!=null){
			System.out.print(d.value+"->");
			d=d.next;
		}
		System.out.println("null");
	}

}
