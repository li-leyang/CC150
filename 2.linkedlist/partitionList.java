/*CTCI 2.4: delete a node in a ll given only access to that node.
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
public class partitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node d=new Node(3);
		d.append(new Node(2));
		d.append(new Node(22));
		d.append(new Node(1));
		d.append(new Node(5));
		d.append(new Node(15));
		d.append(new Node(85));
		d.append(new Node(91));
		d.append(new Node(21));
		d.append(new Node(35));
		d.append(new Node(31));
		d.append(new Node(33));
		d.append(new Node(23));
		d.append(new Node(4));
		d.append(new Node(9));

		d.append(new Node(34));
		d.append(new Node(39));
		printList(d);
		int val=90;
		partitionList(d, val);
		printList(d);

	}


	/*
	 * method1: given head and partition value val, contruct two ll. If smaller than val,put into before
	 * else put into after, then append after after before
	 * time:O(n). Space:O(1)
	 * */
	
	public static void partitionList(Node head,int val){
		Node before=null;
		Node after =null;
		Node current=head;
	
		while(current!=null){
			Node next=current.next;//we need to record this temp node because we are modifying the list
			current.next=null;// *important
			if(current.value>=val){
				if(after==null)
					after=current;
				else
					after.append(current);
			}
			if(current.value<val){
				if(before==null){
					before=current;
				}
				else{
					before.append(current);
				}
			}
			current=next;
		}
		while(before.next!=null){

			before=before.next;
		}
		before.append(after);
		
	}

	public static void printList(Node d){
		while(d!=null){
			System.out.print(d.value+"->");
			d=d.next;
		}
		System.out.println("null");
	}

}
