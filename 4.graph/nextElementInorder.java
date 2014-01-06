import java.util.ArrayList;
import java.util.LinkedList;

/*4.6 find the next element of in order traversal
 * */
class Node{
	int key;
	Node leftChild;
	Node rightChild;
	Node parent;
	public Node(int key ){
		this.key=key;
	}

}
class Tree{
	Node root=null;
	//insert the node to the tree.
	
	//idea: if the target is less, go left to find the proper tail to the tree and link to it.
	public void insert(int key){
		Node newNode=new Node(key);
		if(root==null)
			root=newNode;
		else{
			Node current=root;
			Node parent=null;
			while(true){
				parent=current;
				if(newNode.key<current.key){
					current=current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						newNode.parent=parent;
						return;
					}
				}
				else{
					current=current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						newNode.parent=parent;
						return;
					}
				}
			}
		}
			
		
	}
}

class nextElementInorder{
	public static void main(String[] args){
		Tree tree=new Tree();
		tree.root=new Node(6);
		tree.insert(4);
		tree.insert(8);
		tree.insert(10);
		Node n=new Node(1);
		tree.insert(n.key);
		tree.insert(23);
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		tree.insert(9);
		ArrayList<LinkedList<Node>> list= createLinkedList(tree.root);
//		for(LinkedList<Node> l:list){
//			for(Node d:l){
//				System.out.print(d.key+" ");
//			}
//			System.out.println();
//		}
		Node d=nextInOrder(tree.root.rightChild);
		System.out.println(d);

	}
	public static Node nextInOrder(Node node){
		if(node==null)
			return null;
		//if node has right child, the next would be the leftmost element of the node's right subtree
		if(node.rightChild!=null)
			return leftMost(node.rightChild);
		// if node don't has right child, then two cases. 
		// 1. if the node is the right branch of its parent, then go 
		// the way up until find the parent which is the left branch of the parent.if you cannot find, it must be the 
		// second case: the tail of in order traversal
		//2. if the node is not the right child of parent, then return its parent.
		else{
			while(node.parent!=null && node.parent.leftChild!=node){
				node=node.parent;
			}
			return node.parent;
		}
	}
	public static Node leftMost(Node node){
		if(node==null)
			return null;
		if(node.leftChild==null)
			return node;
		while(node.leftChild!=null)
			node=node.leftChild;
		return node;
			
	}
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

}