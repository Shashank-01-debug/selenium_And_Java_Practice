package javaBasedQuestions;

import java.util.Arrays;

public class JPMorgan_CodingQue {

	public static void main(String[] args) {
		
		int[] input = {1,3,0,5,7,0,9,8,0};
		//output={1,3,5,7.8,9,0,0}
		int index =0;
		
		for(int i:input) {
			if(i!=0) {
				input[index]=i;
				index++;
			}
		}
		
		for(int i=index;i<input.length-1;i++) {
			input[i]=0;
		}
		
		Arrays.sort(input, 0, index );
		System.out.println(Arrays.toString(input));
		
		

	}

}
