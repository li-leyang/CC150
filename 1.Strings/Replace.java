/*CTCI 1.5: implement the compress of the original string, if not smaller, return the original string
 * */
import java.util.*;
public class Replace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aaabbcaasss";
		String result=compress2(str);
		System.out.println(result);
	}
	
	//method1: use two neighbor ptrs to traverse the string/
	//time: O(n). space:buffer.O(n)
	//special care: length==0, newlength>=length.
	public static String compress1(String str){
		int length=str.length();
		int count=1;
		StringBuffer buffer=new StringBuffer();
		if(length==0)
			return null;
		if(length==1){
			return str;
		}
	
		for(int i=0;i<length-1;i++){
			if(str.charAt(i+1)==str.charAt(i)){
				count++;
				//The last character and count(multiple times)
				if(i==length-2){
					buffer.append(str.charAt(i));
					buffer.append(count);
				}
				continue;
			}
			buffer.append(str.charAt(i));
			buffer.append(count);
			count=1;//reset the number.
			// The last character and count(single time)
			if(str.charAt(i+1)!=str.charAt(i)&&i==length-2){
				buffer.append(str.charAt(i+1));
				buffer.append(count);
			}
		}
	
		if(buffer.length()>=length)
			return str;
		return new String(buffer);
	}
	//method2: use stringbuffer to append instead of string. if the char is unchanged, last is not updated.
	//if char changed, updated last and count++; 
	//time:O(n)
	public static String compress2(String str){
		int size=compressCount(str);
		if(size>=str.length()){
			return str;
		}
		char last=str.charAt(0);
		int count=1;
		StringBuffer buffer=new StringBuffer();
		for(int i=1;i<str.length();i++){//notice the char is from index 1 because the count is already 1.
			if(str.charAt(i)==last){
				count++;
			}
			else{
				buffer.append(last);
				buffer.append(count);
				last=str.charAt(i);
				count=1;
			}
		}
		buffer.append(last);
		buffer.append(count);
		return buffer.toString();
	}
	public static int compressCount(String str){
		char c=str.charAt(0);
		int count=1;
		int size=0;
		for(int i=1;i<str.length();i++){
			if(c==str.charAt(i)){
				count++;
			}
			else{
				c=str.charAt(i);
				size+=1+String.valueOf(count).length();
				count=1;
			}
		}
		size+=1+String.valueOf(count).length();
		return size;
	}

}
