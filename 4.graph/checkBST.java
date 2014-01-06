/*4.5 implement a function to check whether a binary tree is bst
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

class checkBST{
	public static void main(String[] args){
		Tree tree=new Tree();
		tree.root=new Node(6);
		tree.root.leftChild=new Node(4);
		tree.root.rightChild=new Node(8);
		tree.root.leftChild.leftChild=new Node(3);
		tree.root.leftChild.rightChild=new Node(5);

		//boolean bool=isBST(tree.root);
		boolean bool=isBST2(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println(bool);	
	}
	/*in method1, we used in order traversal. if the subsequent element is smaller than previous one, return false
	 * time: O(n), space:O(1)
	 * */
	public static int lastValue=Integer.MIN_VALUE;
	public static boolean isBST(Node root){	
		if(root==null)
			return true;
		
		//check left child 
		if(!isBST(root.leftChild)){
			return false;
		}
		
		//check current
		if(root.key<lastValue)
			return false;
		lastValue=root.key;
		
		//check right child
		if(!isBST(root.rightChild))
			return false;
		return true;
	}
	/*method2: the root(middle) element is the max limit for left subtree and min limit for right subtree.
	 * use recursive approach to traverse the left and right subtree.
	 * time:O(n),space:O(logn)(because it is the depth of bst)
	 * */
	public static boolean isBST2(Node root,int min,int max){
		//base case
		if(root==null)
			return true;
		
		if(root.key<min||root.key>max)
			return false;
		if(!isBST2(root.leftChild,min,root.key)||!isBST2(root.rightChild,root.key,max)){
			return false;
		}
		return true;
		
	}

}