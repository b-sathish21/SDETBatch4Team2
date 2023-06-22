package weekWorkOuts;

import java.util.Arrays;

import org.junit.Test;

public class removeElement {

@Test
public void ex1() throws Exception {
	int[] n = {2,3};
	int k = 1;
	System.out.println("\nExample 1 - ");
	System.out.println("Input is " + Arrays.toString(n));
	System.out.println("Target is " + k);
	callProcess(n, k);
}

@Test
public void ex2() throws Exception {
	int[] n = {3,1};
	int k = 1;
	System.out.println("\nExample 2 - ");
	System.out.println("Input is " + Arrays.toString(n));
	System.out.println("Target is " + k);
	callProcess(n, k);
}

@Test
public void ex3() throws Exception {
	int[] n = {1,2,3,1};
	int k = 1;
	System.out.println("\nExample 3 - ");
	System.out.println("Input is " + Arrays.toString(n));
	System.out.println("Target is " + k);
	callProcess(n, k);
}

@Test
public void ex4() throws Exception {
	int[] n = {1,1};
	int k = 1;
	System.out.println("\nExample 4 - ");
	System.out.println("Input is " + Arrays.toString(n));
	System.out.println("Target is " + k);
	callProcess(n, k);
}

@Test
public void ex5() throws Exception {
	int[] n = {1,2,1,3,1};
	int k = 1;
	System.out.println("\nExample 5 - ");
	System.out.println("Input is " + Arrays.toString(n));
	System.out.println("Target is " + k);
	callProcess(n, k);
}

private void callProcess(int[] n, int k) throws Exception {
	/**
	 * Big 'O' Notation - 
	 * 		Time  - O(n)
	 * 		Space - O(1)
	 * ***************************************************************************************
	 * initiate slow pointer to given array length minus one
	 * and fast pointer to zero
	 * validate fast pointer is less or equal to slow pointer
	 * 		validate slow pointer val index of given array val equals target val
	 * 			decrement the slow pointer val by one
	 * 		else validate fast pointer val index of given array val equals target val
	 * 			 and slow pointer val index of given array val not equals target val
	 * 					assign slow pointer val index of given array val to fast pointer val 
	 * 				  index of given array.
	 * 					assign fast pointer val index of given array val equals target val
	 * 					increase fast pointer by one and decrease slow pointer by one
	 * 		else validate fast pointer val index of given array val not equals target val
	 * 					increase fast pointer by one
	 * return fast pointer 
	 * */
	/******************************************************************************************/
	int l =0, r = n.length-1;
	while(l<=r) {
		if(n[r]==k) r--;
		else if(n[l]==k && n[r]!=k) {
			n[l++]=n[r];
			n[r--]=k;
		}
		else if(n[l]!=k) l++;
	}
	System.out.println("refactored input - " + Arrays.toString(n));
	System.out.println("The number of elements not equal to val is " + l);
}

}
