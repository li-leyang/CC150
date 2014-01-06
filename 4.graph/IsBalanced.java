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
class IsBalanced{
	public static void main(String[] args){
		Tree tree=new Tree();
		tree.root=new Node(2);
		tree.root.leftChild=new Node(4);
		tree.root.rightChild=new Node(3);
		
		tree.root.leftChild.leftChild=new Node(23);
		tree.root.leftChild.rightChild=new Node(5);
		tree.root.leftChild.leftChild.leftChild=new Node(3);

		tree.root.rightChild.rightChild=new Node(21);
		tree.root.rightChild.leftChild=new Node(4);
		
		boolean bool=checkBalanced(tree.root);
		System.out.println(bool);
	}
	/*calculate the height of tree using recursive approach
	 * */
	public static int height(Node root){
		if(root==null)
			return 0;
		return 1+Math.max(height(root.leftChild),height(root.rightChild));
	}
	/*using recursive approach to check the subtree.
	 * */
	public static boolean checkBalanced(Node root){
		if(root==null){
			
			return true;
		}
		
		int heightDiff=Math.abs(height(root.leftChild)-height(root.rightChild));
		System.out.println(heightDiff);
		if(heightDiff>1)
			return false;
		else
			return checkBalanced(root.leftChild)&&checkBalanced(root.rightChild);	
	}	
}