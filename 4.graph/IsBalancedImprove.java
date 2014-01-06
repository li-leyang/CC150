/*4.1 implement isBalanced to check the balance of binary tree.
 *imporve approach: not calculate height of each root node.
 *time:O(n) space: O(logn)
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
	Node root;
}
class IsBalancedImprove{
	public static void main(String[] args){
		Tree tree=new Tree();
		tree.root=new Node(2);
		tree.root.leftChild=new Node(4);
		//tree.root.rightChild=new Node(3);
		
		tree.root.leftChild.leftChild=new Node(23);
		tree.root.leftChild.rightChild=new Node(5);
		tree.root.leftChild.leftChild.leftChild=new Node(3);

		//tree.root.rightChild.rightChild=new Node(21);
		//tree.root.rightChild.leftChild=new Node(4);
		
		boolean bool=checkBalanced(tree.root);
		System.out.println(bool);
	}
	/*calculate the height of tree using recursive approach
	 * */
	public static int height(Node root){
		if(root==null)
			return 0;
		if(height(root.leftChild)==-1)
			return -1;
		if(height(root.rightChild)==-1)
			return -1;
		int a=Math.abs(height(root.leftChild)-height(root.rightChild));
		if(a>1)
			return -1;
		else
			return Math.max(height(root.leftChild),height(root.rightChild))+1;
		
	}
	/*using recursive approach to check the subtree. O(n^2)
	 * */
	public static boolean checkBalanced(Node root){
		//bigger than 1
		if(height(root)==-1)
			return false;
		else
			return true;
		
	}	
}