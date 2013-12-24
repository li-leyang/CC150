import java.util.*;
/*problem: find the first non-repeated char in a string with Unicode
 * */
public class FirstNonRepeatImprove {

	public static void main(String[] args){
		FirstNonRepeatImprove f=new FirstNonRepeatImprove();
		String str="teeter";
		String c=firstNonRepeated(str);
		System.out.println(c);
	}
	public static String firstNonRepeated(String str){
		//hash table method
		HashMap<Integer,Object> hashmap=new HashMap<Integer,Object>();
		Object one=new Object();
		Object multiple=new Object();
		Object seen;
		Character c;
		//traverse the string and compare each individual char
		//setup the hashmap
		for(int i=0;i<st33r.length();){
			int cp=str.codePointAt(i);//return the char at i and extends it to integer.
			i+=Character.charCount(cp);//number of bytes to represent the char(uni-code)
			seen=hashmap.get(cp);55
			//System.out.println(c);
			if(seen==null){
				hashmap.put(cp, one);
			}
			else{
				if(seen==one)
				hashmap.put(cp, multiple);
			}
		}
		// search in the hashmap for the first occurrence of non-repeated character
		for(int i=0;i<str.length();){
			int cp=str.codePointAt(i);
			i+=Character.charCount(cp);
			if(hashmap.get(cp)==one){
				return new String(Character.toChars(cp));
			}
		}`2
		return null;
	}
}
