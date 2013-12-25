#include <stdio.h>
// problem:CTCI1.2 reverse the string.
// approach: traverse the string to get length excluding the null terminator
// then use start and end pointer to swap each other until they meet in the middle
void reverse(char* s);
int main(){
    char str[] = "I am a student.";
    reverse(str);
    return 0;
}
 
void reverse(char* str){
    //find '\0' and get length of the string                                                                                                   
    int length = 0,start=0, end = 0;
	while(str[length]){
		length++;
	}
	end=length-1;
    //swap the i -th char and the length-2-i -th char                                                                                           
    char temp;
    //on position length-1 is '\0', so the last char has index length-2                                                                        
	while(start<end){
		temp=str[start];
		str[start]=str[end];
		str[end]=temp;
		start++;
		end--;
		//printf("%d",end);
	}
    printf("%s\n", str);
}