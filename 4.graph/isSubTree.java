import java.util.ArrayList;
import java.util.LinkedList;

/*4.8 check whether T2 is subtree of T1.
 * method: check whether t2 and t1 has the same root.
 * if the roots are same, then compare the right and left branch
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

class isSubTree{
	public static void main(String[] args){
		Tree t2=new Tree();
		t2.root=new Node(6);
		t2.insert(4);
		t2.insert(8);
		t2.insert(10);
		t2.insert(1);
		t2.insert(23);
		t2.insert(5);
		t2.insert(3);
		t2.insert(7);
		t2.insert(9);
		t2.insert(90);
		
		Tree t1=new Tree();
		t1.root=new Node(6);
		t1.insert(4);
		t1.insert(8);
		t1.insert(10);
		t1.insert(1);
		t1.insert(23);
		t1.insert(5);
		t1.insert(3);
		t1.insert(7);
		t1.insert(9);
//		t1.insert(31);
//		t1.insert(331);
//		t1.insert(91);
		boolean bool=isSubTree(t1.root,t2.root);
		System.out.println(bool);

	}
	public static boolean isSubTree(Node t1,Node t2){
		if(t1==null)
			return false;
		if(t2==null){
			System.out.println(t2.key);
			return true;
		}
		//root equal, then compare the subsequent subtrees
		if(t2.key==t1.key){
			if(treeMatch(t1,t2)){
				return true;
			}
		}
		
		return isSubTree(t1.leftChild,t2)||isSubTree(t1.rightChild,t2);
	}
	public static boolean treeMatch(Node t1,Node t2){
		if(t1==null&&t2==null)
			return true;
		if(t1==null||t2==null)
			return false;
		if(t1.key!=t2.key)
			return false;
		return treeMatch(t1.leftChild,t2.leftChild)&&treeMatch(t1.rightChild,t2.rightChild);
	}
	
//	public static ArrayList<LinkedList<Node>> createLinkedList(Node root){
//		ArrayList<LinkedList<Node>> list=new ArrayList<LinkedList<Node>>();
//		return list;   
//	}
}