import java.util.*;
/*problem: atoi(string to int)
 * approach: traverse the string from left to right, horner's rule.
 * if it is not the rightmost character
 * */
public class StringToInt {


	public static void main(String[] args){
		String str="0";
		
		int newInt;
		newInt=strToInt(str);
		System.out.println(newInt);
	}
	public static int strToInt(String str){
		int length=str.length();
		int num=0,i=0;
		int isNegative=1;
		if(str.charAt(0)=='-'){
			i=1;
			isNegative=-1;
		}
		//O(n)
		for(;i<length;i++){
			num*=10;
			num+=str.charAt(i)-'0';
			
		}
		num=num*isNegative;
		return num;
	}

}
