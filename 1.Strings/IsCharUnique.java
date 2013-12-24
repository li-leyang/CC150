import java.util.*;
/*problem: check whether the string contains only unique characters
 * Method: use a int array to represent the asc2 character,
 * if the repeated multiple times, increment the element and return false
 * */
public class IsCharUnique {


	public static void main(String[] args){

		String str="Iameci.";
		boolean bool=isCharUnique(str);
		System.out.println(bool);
	}
	//	public static final int MAX_INT=10;
	public static boolean isCharUnique(String str){
		char[] strArray=str.toCharArray();
		int[] intArray=new int[128];
		for(int i=0;i<str.length();i++){
			intArray[strArray[i]]++;//null pointer excepiton
			if(intArray[strArray[i]]>1)
				return false;
		}
			return true;
		
	}
}
