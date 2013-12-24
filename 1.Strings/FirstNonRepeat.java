import java.util.*;

public class FirstNonRepeat {

	public static void main(String[] args){
		FirstNonRepeat f=new FirstNonRepeat();
		String str="teester";
		Character c=firstNonRepeated(str);
		System.out.println(c);
	}
	public static Character firstNonRepeated(String str){
		//hash table method
		HashMap<Character,Integer> hashmap=new HashMap<Character,Integer>();
		Character c;
		//traverse the string and compare each individual char
		//setup the hashmap
		for(int i=0;i<str.length();i++){
			c=str.charAt(i);
			//System.out.println(c);
			if(hashmap.containsKey(c)){
				hashmap.put(c, hashmap.get(c)+1);
			}
			else{
				hashmap.put(c, 1);
			}
		}
		// search in the hashmap for the first occurrence of non-repeated character
		for(int i=0;i<str.length();i++){
			c=str.charAt(i);
			if(hashmap.get(c)==1){
				return c;
			}
		}
		return null;
	}
}
