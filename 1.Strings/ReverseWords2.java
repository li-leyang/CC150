import java.util.*;
/*problem: reverse the string
 * method: improved version
 * overview: reverse the whole string and reverse the word individually.
 * trick: In java, you can use split method of string and print the words in reverse order
 * */
public class ReverseWords2 {


	public static void main(String[] args){
		String str="I am a good student, majoring in mechanical engineering.";
		
		String newStr;
		newStr=reverseWords(str);
		System.out.println(newStr);
	}
	public static String reverseWords(String str){
		char[] strArray=str.toCharArray();
		int start=0,end=0;
		int length=str.length();
		reverseOrder(strArray,start,length-1);
		while(end<length){
			if(strArray[end]!=' '){
				start=end;
				while(end<length && strArray[end]!=' '){
					end++;
				}
				end--;
				reverseOrder(strArray,start,end);
			}
			//else{
			end++;
			
		}
		return String.valueOf(strArray);
	}
	public static void reverseOrder(char[] str,int start,int end){
		while(start<end){
			char temp=str[start];
			str[start]=str[end];
			str[end]=temp;
			start++;end--;
		}
	}
	
}
