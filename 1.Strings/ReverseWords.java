import java.util.*;
/*problem: PIE.reverse the string
 * method: general solution.
 * overview: pointer move backwards and forwards back and forth.
 * trick: In java, you can use split method of string and print the words in reverse order
 * */
public class ReverseWords {


	public static void main(String[] args){
		String str="I am a good student, majoring in mechanical engineering.";
		
		String newStr;
		newStr=reverseWords(str);
		System.out.println(newStr);
	}
	public static String reverseWords(String str){
		char[] strArray=str.toCharArray();
		char[] newStrArray=str.toCharArray();// new copy of array.
		int length=strArray.length;
		int readPos=length-1,writePos=0,wordEnd=0,wordStart=0;
		while(readPos>=0){
			//if space direct copy
			if(strArray[readPos]==' '){
				newStrArray[writePos++]=strArray[readPos--];
			}
			// else, backwards moving until encountering space
			// move forwards when copy to new string
			else{
				wordEnd=readPos;
				while(readPos>=0&& strArray[readPos]!=' ')
					readPos--;
				wordStart=readPos+1;
				while(readPos<wordEnd){
					newStrArray[writePos++]=strArray[++readPos];
				}
				readPos-=(wordEnd-wordStart+1);
			}
		}
		return new String(newStrArray,0,length);
	}
	
}
