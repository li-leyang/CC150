package sm;
/*4.2 check whether two nodes in the graph are connected.
 * we used queue to implement bfs.
 * time: O(M+N)
 * */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


class Node{
	int key;
	int id;
	boolean isVisited;
	
	public Node(int value,int id){
		key=value;
		this.id=id;
	}
}
class AdjMatrix{
	int[][] matrix;
	int capacity;
	int size;
	HashMap<Integer,Node> map=new HashMap<Integer,Node>();
	public AdjMatrix(){
		capacity=10;
		size=0;
		matrix=new int[capacity][capacity];
	}
	public void addNode(Node d){
		size++;
		map.put(d.id, d);
		
	}
	public void addEdge(Node a,Node b){
		matrix[a.id][b.id]=1;
	}
	
	public ArrayList<Node> getNeighbors(Node a){
		ArrayList<Node> neighbors=new ArrayList<Node>();
		for(int i=0;i<matrix.length;i++){
			if(matrix[a.id][i]==1){
				neighbors.add(map.get(i));
			}
		}
		return neighbors;
	}
}
public class isConnected{
	public static void main(String[] args){
		AdjMatrix matrix=new AdjMatrix();
		Node a=new Node(3,0);
		Node b=new Node(2,1);
		Node c=new Node(23,2);
		Node d=new Node(21,3);
		Node e=new Node(12,4);
		Node f=new Node(34,5);
		Node g=new Node(43,6);
		Node h=new Node(4,7);
		Node i=new Node(10,8);
		Node j=new Node(54,9);
		matrix.addNode(a);
		matrix.addNode(b);
		matrix.addNode(c);
		matrix.addNode(d);
		matrix.addNode(e);
		matrix.addNode(f);
		matrix.addNode(g);
		matrix.addNode(h);
		matrix.addNode(i);
		matrix.addNode(j);
		matrix.addEdge(a, b);
		matrix.addEdge(b, c);
		matrix.addEdge(c, d);
		matrix.addEdge(d, f);
		matrix.addEdge(f, h);
		matrix.addEdge(f, a);
		matrix.addEdge(h, c);
		matrix.addEdge(g, i);
		//System.out.println(matrix.getNeighbors(f).size());
		boolean bool=isConnected(matrix,a,e);

		System.out.println(bool);
	}
	public static boolean isConnected(AdjMatrix matrix,Node a, Node b){
		Queue<Node> queue=new ArrayDeque<Node>();
		// add the first node to queue and set the bool to true;
		a.isVisited=true;
		queue.add(a);
		while(!queue.isEmpty()){
			Node q=queue.remove();
			ArrayList<Node> list=matrix.getNeighbors(q);
			if(!list.isEmpty()){
				for(int i=0;i<list.size();i++){
					if(list.get(i)==b)
						return true;
					//avoid revisit the same node
					if(list.get(i).isVisited)
						continue;
					list.get(i).isVisited=true;	
		
					queue.add(list.get(i));
				}
			}
			else
				return false;	
		}
		return false;
	}
}