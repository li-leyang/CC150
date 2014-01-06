/*CTCI 2.5: add the list in reverse order and forwards order,like
 * 7->1->6+ 5->9->2= 2->1->9 &&(617+295=912)
 * 6->1->7+ 2->9->5= 9->1->2(617+295=912)
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
class PartialSum{
	public Node sum=null;
	public int carry=0;
}
public class AddListReverseForward {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node d1=new Node(7);
		d1.append(new Node(1));
		d1.append(new Node(6));

		Node d2=new Node(5);
		d2.append(new Node(9));
		d2.append(new Node(2));
		printList(d1);
		printList(d2);
		Node sum=addListReverse(d1,d2);
		printList(sum);

		System.out.println("----------------");
		Node d3=new Node(6);
		d3.append(new Node(1));
		d3.append(new Node(7));

		Node d4=new Node(2);
		d4.append(new Node(9));
		d4.append(new Node(5));
		printList(d3);
		printList(d4);
		Node sum2=addListForward(d3,d4);
		printList(sum2);
	}


	/*
	 * method1: advance two ptrs simultaneously.
	 * time: O(n) space:O(n)
	 * */
	public static Node addListReverse(Node d1,Node d2){
		Node current1=d1;
		Node current2=d2;
		Node sum=null;
		int add=0;
		if(current1==null||current2==null)
			return null;
		while(current1!=null&&current2!=null){
			add+=current1.value+current2.value;//increment the two digits
			if(sum==null)
				sum=new Node(add%10);
			else
				sum.append(new Node(add%10)); // append the remainder node to sum
			add=add/10;//increment carry bit
			current1=current1.next;//advance two pointers
			current2=current2.next;
		}
		while(current1!=null){
			add+=current1.value;
			if(sum==null)
				sum=new Node(add%10);
			else
				sum.append(new Node(add%10));
			add=add/10;//carry bit
			current1=current1.next;
		}
		while(current2!=null){
			add+=current2.value;
			if(sum==null)
				sum=new Node(add%10);
			else
				sum.append(new Node(add%10));
			add=add/10;//carry bit
			current2=current2.next;
		}

		return sum;
		
	}
	
	/*call addlistreverse to do the calculation, then reverse back
	 * */
	public static Node addListForward(Node d1,Node d2){
//		
//		Node sum=addListReverse(reverse(d1),reverse(d2));
//		return reverse(sum);
		int len1=length(d1);
		//System.out.println(len1);
		int len2=length(d2);
		if(len1<len2){
			d1=paddingZero(d1,len2-len1);
		}
		else{
			d2=paddingZero(d2,len1-len2);
		}
		PartialSum sum=addHelper(d1,d2);
		if(sum.carry==0){
		
			return sum.sum;
		}
		else{
			Node result=insertBefore(sum.sum,sum.carry);
			return result;
		}	
	}
	public static Node insertBefore(Node node,int data){
		Node insert=new Node(data);
		if(node!=null){
			insert.next=node;
			node=insert;
		}
		return insert;
	}
	public static PartialSum addHelper(Node d1,Node d2){
		if(d1==null||d2==null){
			PartialSum sum=new PartialSum();
			return sum;
		}
		PartialSum sum=addHelper(d1.next,d2.next);
		int val=sum.carry+d1.value+d2.value;

		Node full=insertBefore(sum.sum,val%10);

		sum.sum=full;
		sum.carry=val/10;
		
		return sum;
		
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
	public static Node paddingZero(Node head,int len){
		for(int i=0;i<len;i++){
			Node n=new Node(0);
			n.next=head;
			head=n;
		}
		return head;
	}
	/*reverse the singly list
	 * */
	private static Node reverse(Node head){
		Node current=head;
		while(current.next!=null){
			Node next=current.next;
			current.next=current.next.next;
			next.next=head;
			head=next;
		}
		return head;
		
	}

	public static void printList(Node d){
		while(d!=null){
			System.out.print(d.value+"->");
			d=d.next;
		}
		System.out.println("null");
	}

}
