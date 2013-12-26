/*CTCI 1.6: rotate the matrix pixels
 * layer by layer 
 * */
import java.util.*;
public class Rotate {

	public static final int SIZE=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix=new int[SIZE][SIZE];
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				matrix[i][j]=i*SIZE+j;
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("\n");
		}
		System.out.println(".................");
		rotate(matrix);
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				//matrix[i][j]=i*SIZE+j;
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	
 //method1: suppose the rotation is ccw. 
	//time:O(n^2). Space:O(1)/
	//we used one int to store temp instead of n-length vector
	public static void rotate(int[][] matrix){
		int length=matrix.length;
		int layer;
		for(layer=0;layer<length/2;layer++ ){
			int first=layer;
			int last=length-1-layer;
			for(int i=first;i<last;i++){
				int top=matrix[layer][i];
				matrix[layer][i]=matrix[i][last];
				matrix[i][last]=matrix[last][length-1-i];
				matrix[last][length-1-i]=matrix[length-1-i][layer];
				matrix[length-1-i][layer]=top;
			}
		}	
	}
}
