import java.util.ArrayList;
import java.util.LinkedList;

/*4.9 find all the path that sums up to a specific value
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

class pathSum{
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
		int sum=10;
		findSum(t2.root,sum);

	}
	//if the node start from root
	public static void findSum(Node root,int sum){
		if(root==null)
			return;
		int depth=findDepth(root);
		int[] path=new int[depth];//length=depth;
		findSum(root,path,sum,0);
	}
	// from bottom to top,sum up, if the sum is achieved, then print
	//complexity: time: O(nlogn) n nodes, each node find the path(log(n) times).
	//space: O(logn) path[n] proportional to depth of tree. proportional to recursive times.
	public static void findSum(Node root,int[] path,int sum,int level){
		if(root==null)
			return;
		path[level]=root.key;
		int t=0;
		for(int i=level;i>=0;i--){
			t+=path[i];
			if(t==sum&&i==0)
				print(path,i,level);
		}
		//root leftchild load into path array,since level above has been loaded then recursively sum up.
		findSum(root.leftChild,path,sum,level+1);
		findSum(root.rightChild,path,sum,level+1);
		path[level]=Integer.MIN_VALUE;
	}
	public static void print(int[] path,int start,int end){
		for(int j=start;j<=end;j++){
			System.out.print(path[j]+" ");
		}
		System.out.println();
	}
	
	public static int findDepth(Node root){
		if(root==null)
			return 0;
		else
			return 1+Math.max(findDepth(root.rightChild),findDepth( root.leftChild));
	}

}