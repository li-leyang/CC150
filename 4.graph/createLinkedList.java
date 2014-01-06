import java.util.ArrayList;
import java.util.LinkedList;

/*4.4 given a bst, design an algorithm that create a linked list for each depth.
 * */
class Node{
	int key;
	Node leftChild;
	Node rightChild;
	public Node(int key ){
		this.key=key;
	}
	public void displayNode(){
		System.out.print('{');
		System.out.print(key);
		System.out.print('}');
	}
}
class Tree{
	Node root=null;
}

class createLinkedList{
	public static void main(String[] args){
		Tree tree=new Tree();
		tree.root=new Node(6);
		tree.root.leftChild=new Node(4);
		tree.root.rightChild=new Node(8);
		tree.root.leftChild.leftChild=new Node(3);
		tree.root.leftChild.rightChild=new Node(5);
		tree.root.rightChild.rightChild=new Node(15);
		tree.root.rightChild.leftChild=new Node(52);
		ArrayList<LinkedList<Node>> list=createLevelLinkedList(tree.root);
		for(LinkedList<Node> ll:list){
			for(Node n:ll){
				System.out.print(n.key+" ");
			}
			System.out.println();
		}

	}
	// ”√arraylist£¨arraylist¿Ô «linkedList
	//time: O(n), we need to touch each node
	// space: O(n),iterative approach
	public static ArrayList<LinkedList<Node>> createLinkedList(Node root){
		ArrayList<LinkedList<Node>> list=new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current=new LinkedList<Node>();
		//current initial
		if(root!=null)
			current.add(root);
		while(current.size()>0){
			list.add(current);
			LinkedList<Node> parent=current;
			current=new  LinkedList<Node>();
			for(Node n:parent){
				if(n.leftChild!=null)
					current.add(n.leftChild);
				if(n.rightChild!=null)
					current.add(n.rightChild);
			}
		}
		return list;		
	}
	public static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root){
		ArrayList<LinkedList<Node>> list=new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(root,list,0);
		return list;
	}
	public static void createLevelLinkedList(Node root,ArrayList<LinkedList<Node>> lists,int level){
		
		if(root==null)
			return ;
		System.out.println(root.key);
		LinkedList<Node> list=null;
		//first visit level;
		if(lists.size()==level){
			list=new LinkedList<Node>();
			lists.add(list);
		}
		//list already visited
		else{
			list=lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.leftChild,lists,level+1);
		createLevelLinkedList(root.rightChild,lists,level+1);
	}
}