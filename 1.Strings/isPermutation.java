/*CTCI 1.3: check whether the string1 is permutation of the other one/anagrams.
 *  assumption: case insensitive and whitespace omitted
 * */
import java.util.*;
public class isPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="studen!";
		String str2="stnednn";
		boolean bool=permutation4(str1,str2);
		System.out.println(bool);
		//System.out.println((Character.MIN_VALUE+0)+" "+(Character.MAX_VALUE+0));
	}
	
	//method1:construct 2 hashmaps and compare the key and value.
	// time: O(3n)=O(n), space:2 hashmaps O(2n)
	public static boolean permutation(String str1,String str2){
		
		int length1=str1.length();
		int length2=str2.length();
		if(length1!=length2){
			return false;
		}
		HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
		HashMap<Character,Integer> hash2=new HashMap<Character,Integer>();
		for(int i=0;i<length1;i++){
			if(hash.containsKey(str1.charAt(i))){
			
				hash.put(str1.charAt(i), hash.get(str1.charAt(i))+1);
			}
			else{
				
				hash.put(str1.charAt(i), 1);
			}
		}
		for(int i=0;i<length2;i++){
			if(hash2.containsKey(str2.charAt(i))){
				hash2.put(str2.charAt(i), hash2.get(str2.charAt(i))+1);
			}
			else{
				hash2.put(str2.charAt(i), 1);
			}
		}
		for(int i=0;i<length2;i++){
			char c=str2.charAt(i);
			if(!hash.containsKey(c) || (hash.get(c)!=hash2.get(c))){
				return false;
			}
		}
		return true;
	}
	//method: construct only one hashmap, check the second str by decrement the first hashmap
	// time: O(3n)=O(n), space: O(n).
	public static boolean permutation2(String str1,String str2){
		
		int length1=str1.length();
		int length2=str2.length();
		if(length1!=length2){
			return false;
		}
		HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
		//HashMap<Character,Integer> hash2=new HashMap<Character,Integer>();
		for(int i=0;i<length1;i++){
			if(hash.containsKey(str1.charAt(i))){
			
				hash.put(str1.charAt(i), hash.get(str1.charAt(i))+1);
			}
			else{
				
				hash.put(str1.charAt(i), 1);
			}
		}
		for(int i=0;i<length2;i++){
			if(!hash.containsKey(str2.charAt(i))){
				return false;
			}
			else{
				hash.put(str2.charAt(i), hash.get(str2.charAt(i))-1);
			}
		}
		if(!hash.containsValue(0))
			return false;
		
		return true;
	}
	//method3: sort the string using built-in sorting method and check the equality.
	//time: O(n) space: O(1)
	public static boolean permutation3(String str1,String str2){
		if(str1.length()!=str2.length())
			return false;
		return sort(str1).equals(sort(str2));
	}
	public static String sort(String str){
		char[] strArray=str.toCharArray();
		Arrays.sort(strArray);
		
		return new String(strArray);
	}
	
	//method4: using integer bitmap of ascii to record the count of each char
	// time: O(n), space: O(n)
	public static boolean permutation4(String str1,String str2){
		if(str1.length()!=str2.length())
			return false;
		int[] bitmap=new int[256];
		for(int i=0;i<str1.length();i++){
			bitmap[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++){
			bitmap[str2.charAt(i)]--;
		}
		for(int t:bitmap){
			if(t!=0)
				return false;
		}
		return true;
	}

}
