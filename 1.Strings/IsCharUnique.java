import java.util.*;
/*problem: CTCI1.1 check whether the string contains only unique characters
 * Method: use a int array to represent the asc2 character,
 * if the repeated multiple times, increment the element and return false
 * use array as the data structure.
 * */
public class IsCharUnique {


	public static void main(String[] args){

		String str=".a";
		boolean bool;
		// bool=isCharUnique(str);
		//bool=isCharUnique2(str);
		bool=isCharUnique3(str);
		System.out.println(bool);
	}

	/*
	 * method1: use boolean array 1*2*128=256
	 * time:O(n), space:O(1)
	 * */
	public static boolean isCharUnique(String str){
		if(str.length()>256)
			return false;
		boolean[] bool=new boolean[256];// change int to boolean
		for(int i=0;i<str.length();i++){
			if(bool[str.charAt(i)]==true)
				return false;
			bool[str.charAt(i)]=true;
		}
			return true;
		
	}
	/*method2: brute-force search
	 * time:O(N^2), space:O(1)
	 * */
	public static boolean isCharUnique2(String str){
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(i)==str.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	//method3: bitmap. can reduce the space by a factor of 8.
	//time:O(n), space:O(1)
	public static boolean isCharUnique3(String str){
		if(str.length()>256){
			return false;
		}
		int checker=0;
		for(int i=0;i<str.length();i++){
			int val=str.charAt(i)-'a';
			if((checker & (1<<val))>0)
				return false;
			checker|=(1<<val);
		}
		return true;
	}
}
