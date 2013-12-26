/*CTCI 1.7: check the zero element, and set the corresponding rows and cols to zero
 * 
 * */
import java.util.*;
public class setToZero {

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
		setToZero(matrix);
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				//matrix[i][j]=i*SIZE+j;
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	
 //method1: use row vector and col vectors. traverse the 2d matrix and find the zero element index.
	//time:O(n^2). Space:O(n)/
	//travers another time, if the bool vector is true, set the whole row and col to zero.
	//time: O(n^2) space:O(n)
	public static void setToZero(int[][] matrix){
		if(matrix.length==0)
			return;
		int length=matrix.length;
		boolean[] row=new boolean[length];
		boolean[] col=new boolean[length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				if(matrix[i][j]==0){
					//1<<i;
					row[i]=true;
					col[j]=true;
				}
					
			}
		}
		for(int i=0;i<length;i++)
			for(int j=0;j<length;j++){
				if(row[i]||col[j])
					matrix[i][j]=0;
			}

	}
}
