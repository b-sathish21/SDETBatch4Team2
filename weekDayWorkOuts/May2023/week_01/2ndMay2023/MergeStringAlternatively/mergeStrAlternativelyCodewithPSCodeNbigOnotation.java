package weekWorkOuts;

import org.junit.Test;

public class mergeStringsAlternatively {

@Test
public void ex1() throws Exception {
	String w1="", w2="def";
	System.out.println("\nExample 1 - ");
	System.out.println("Input is " + w1 + " & " + w2);
	callProcess(w1, w2);
}

@Test
public void ex2() throws Exception {
	String w1="abc", w2="";
	System.out.println("\nExample 2 - ");
	System.out.println("Input is " + w1 + " & " + w2);
	callProcess(w1, w2);
}

@Test
public void ex3() throws Exception {
	String w1="abc", w2="d";
	System.out.println("\nExample 3 - ");
	System.out.println("Input is " + w1 + " & " + w2);
	callProcess(w1, w2);
}

@Test
public void ex4() throws Exception {
	String w1="a", w2="def";
	System.out.println("\nExample 4 - ");
	System.out.println("Input is " + w1 + " & " + w2);
	callProcess(w1, w2);
}

@Test
public void ex5() throws Exception {
	String w1="abc", w2="def";
	System.out.println("\nExample 5 - ");
	System.out.println("Input is " + w1 + " & " + w2);
	callProcess(w1, w2);
}

private void callProcess(String word1, String word2) throws Exception {
	/**
	 * Big 'O' Notation - 
	 * 		Time  - O(n)
	 * 		Space - O(n)
	 * ***************************************************************************************
	 * initiate output string to empty val
	 * initiate len var to zero
	 * validate first word length is less than second word length
	 * 		validate first word length is less than 1
	 * 			and validate second word length is greater than 1
	 * 				assign word2 to output
	 * 		else assign word1 length to len var
	 * else
	 * 		validate word1 length is less than 1 and word2 length is less than 1
	 * 			throw exception
	 * 		else
	 * 			validate word1 length is greater than 1 and word2 length is less than 1
	 * 				assign word1 to output
	 * 		else assign word2 length to len var
	 * validate len var is not equal to zero
	 * 		initiate loop var to zero
	 * 		initiate an inc loop an validate loop var is less than len var
	 * 			assign output val + word1 current index char + word2 current index char to output
	 * 			increase loop var
	 * 		validate len var val is less than word1 length
	 * 			assign output val + balance char of word1 to output
	 * 		validate len var val is less than word2 length
	 * 			assign output val + balance char of word2 to output
	 * */
	/******************************************************************************************/
	 String op = "";
     int len = 0;
     if(word1.length()<word2.length()) {
         if(word1.length()<1 && word2.length()>1) op = word2;
         else len = word1.length();
     }
     else{
         if(word1.length()<1 && word2.length()<1) throw new Exception("both words are empty");
         else if(word1.length()>1 && word2.length()<1) op = word1;
         else len = word2.length();
     }
     if(len!=0){
         int i=0;
         for (; i<len; i++){
             op=op+word1.charAt(i)+word2.charAt(i);
         }
         if(len<word1.length()) op = op+ word1.substring(i);
         else if(len<word2.length()) op = op+ word2.substring(i);
     }
     System.out.println(op);
}

}
