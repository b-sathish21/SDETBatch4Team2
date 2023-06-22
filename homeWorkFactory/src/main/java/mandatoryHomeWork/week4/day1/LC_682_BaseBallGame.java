package weekWorkOuts;

import java.util.Arrays;

import org.junit.Test;

import inBuiltLibraryReconstructed.stackIntArr;

public class baseBallOperation {

	@Test
	public void ex1() throws Exception {
	String[] s = {"5","2","C","D","+"};
	System.out.println("\nExample 1 - ");
	System.out.println("Input is \n n = " + Arrays.toString(s));
	callProcess(s);
	}

	private void callProcess(String[] s) throws Exception {
		/**
		 * Big O Notation
		 * 	-Time  ==> O(n)
		 * 	-Space ==> O(n)
		 * */
		stackIntArr stck = new stackIntArr();
		for(int i=0; i<s.length; i++) {
			if(s[i] == "+") {
				stck.push(stck.fetchData(stck.size()-1) + stck.fetchData(stck.size()-2));
			}
			else if(s[i] == "D") {
				stck.push(stck.peek()*2);
			}
			else if(s[i] == "C") {
				stck.pop();
			}
			else {
				stck.push(Integer.parseInt(s[i]));
			}
			System.out.println(stck.toStr());
		}
	}
}
