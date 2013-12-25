import java.util.*;
/*problem: PIE. itoa(int to String)
 * approach: traverse the string from right to left, gain the quotient and remainder.
 * special care: zero and negative value
 * */
public class IntToString {


	public static void main(String[] args){
		int num=-20;
		
		String str;
		str=intToStr(num);
		System.out.println(str);
	}
	public static final int MAX_INT=10;
	public static String intToStr(int num){
		char flag=1;
		int i=0;
		char[] str=new char[MAX_INT+1];
		if(num<0){
			num=-num;
			flag='-';
		}
		StringBuffer buffer=new StringBuffer();
		do{
			int a=num%10;
			str[i++]=(char)(a+'0');
			num/=10;
		}while(num!=0);
		if(flag=='-')
			buffer.append('-');
		while(i>0){	
			buffer.append(str[--i]);
		}
		
		return buffer.toString();
	}

}
