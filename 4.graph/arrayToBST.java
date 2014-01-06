/*4.3 given a sorted array, create a bst with minimal height
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

class arrayToBST{
	public static void main(String[] args){
		int[] array={1,2,3,4,5};		
		Node Tree=createBST(array,0,array.length-1);
	
		
	}
	public static Node createBST(int[] array,int start,int end){
		int mid=(start+end)/2;
		if(start>end)
			return null;
		Node treeNode=new Node(array[mid]);
		treeNode.leftChild=createBST(array,start,mid-1);
		treeNode.rightChild=createBST(array,mid+1,end);
		System.out.println(treeNode.key);
		return treeNode;
	}
}