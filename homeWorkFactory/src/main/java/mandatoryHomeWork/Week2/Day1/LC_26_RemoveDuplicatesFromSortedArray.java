package weekWorkOuts;

import java.util.Arrays;

import org.junit.Test;

public class rmvDupFrmSrtdArr {

@Test
public void ex1() throws Exception {
	int[] n = {};
	System.out.println("\nExample 1 - ");
	System.out.println("Input is " + Arrays.toString(n));
	callProcess(n);
}

@Test
public void ex2() throws Exception {
	int[] n = {0};
	System.out.println("\nExample 2 - ");
	System.out.println("Input is " + Arrays.toString(n));
	callProcess(n);
}

@Test
public void ex3() throws Exception {
	int[] n = {0,0};
	System.out.println("\nExample 3 - ");
	System.out.println("Input is " + Arrays.toString(n));
	callProcess(n);
}

@Test
public void ex4() throws Exception {
	int[] n = {0,0,1};
	System.out.println("\nExample 4 - ");
	System.out.println("Input is " + Arrays.toString(n));
	callProcess(n);
}

@Test
public void ex5() throws Exception {
	int[] n = {0,0,1,1,2,2,3,4,4,5};
	System.out.println("\nExample 5 - ");
	System.out.println("Input is " + Arrays.toString(n));
	callProcess(n);
}

@Test
public void ex6() throws Exception {
	int[] n = {0,0,1,1,1,2,3,4,4,5};
	System.out.println("\nExample 6 - ");
	System.out.println("Input is " + Arrays.toString(n));
	callProcess(n);
}

private void callProcess(int[] n) throws Exception {
	/**
	 * Algorithm - Two Pointer
	 * Big 'O' Notation - O(n)
	 * ***************************************************************************************
	 * initiate loop to travel through the given array
	 * initiate slow pointer as zero and fast pointer as one
	 * initiate an flag to zero
	 * while in loop - 
	 * 		validate slow pointer val is equal to fast pointer val
	 * 			if yes then increase fast pointer by one
	 * 			if no then 
	 * 				validate slow pointer val is less than fast pointer val
	 * 					if yes then
	 * 						increase slow pointer by one
	 * 						assign fast pointer val to slow pointer val
	 * 						increase fast pointer
	 * 		return left and array 	
	 * ****************************************************************************************				
	 * initiate output array with length of left plus one
	 * initiate loop to travel through given array but to the length of output array
	 * while in loop - 
	 * 	assign given array val of current index to output array's current index
	 * ****************************************************************************************
	 * Assert -
	 * validate left plus one equals output array length
	 * initiate loop to run till left plus one
	 * while in loop - 
	 * 		validate given array val of current index equals output array's current index val
	 * */
	/******************************************************************************************/
	if(n.length<1) throw new Exception("given array can't be empty");
	int l=0, r=1;
	if(n.length>1) {
		while(r<n.length) {
			int a = n[l], b = n[r];
			if (a==b) {
				r++;
			}
			else {
				if(a<b) {
					l++;
					n[l] = n[r];
					r++;
				}
			}
		}
	}
	System.out.println("total unique numbers: " + (l+1));
	
	//creating expected output array for asserting with custom judge
	int[] m = new int[l+1];
	for(int i=0; i<m.length; i++) {
		m[i] = n[i];
	}
	System.out.println("output is " +Arrays.toString(m));
	//custom Judge
	assert (l+1)==m.length;
	for(int k=0; k<(l+1); k++) {
		assert n[k] == m[k];
	}
}

}
