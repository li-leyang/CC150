import java.util.*;
/*problem: PIE. given a string and remove string, find the resulting string removing 
 * specified characters
 * Using lookup array.
 * */
public class RemoveSpecifiedChars {


	public static void main(String[] args){
		String str="I am a good student majoring mechanical engineering";
		String remove="aeiou";
		String newStr;
		newStr=removeSpecifiedChar(str,remove);
		System.out.println(newStr);
	}
	public static String removeSpecifiedChar(String str,String remove){
		char[] removeArray=remove.toCharArray();
		char[] strArray=str.toCharArray();
		boolean[] bool=new boolean[128];//asc2 limit is 128 characters
		int src=0,des=0;
		//set the element in remove sets to be true
		for(int i=0;i<removeArray.length;i++){
			//set the corresponding asc2 code to true if in remove array.
			// here we used array approach instead of hash table.
			/*if the length of str is short but have many possibilities,we used lookup hashtable
			 * if long but few possibilites, used lookup array to minimize memory usage.*/
			bool[removeArray[i]]=true;
		
		}//O(m)

		//we traversed the string. if not in remove, des++,else des remains the same.
		//we overwrite the preceding characters in the string.
		for(src=0;src<strArray.length;src++){
			if(bool[strArray[src]]==false){
				strArray[des]=strArray[src];
				des++;
			}
		}//O(n)
		
		//overall running time is O(M+N).
		return new String(strArray,0,des);
	}
	
}
