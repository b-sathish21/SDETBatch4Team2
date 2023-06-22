package weekWorkOuts;

import java.util.Arrays;

import org.junit.Test;

public class moveZerosLeetCode {

@Test
public void ex1() throws Exception {
	int[] n = {1,0,2,0,3,0,4};
	System.out.println("\nExample 1 - ");
	callProcess(n);
}

@Test
public void ex2() throws Exception {
	int[] n = {1,0,0,0,0,0,4};
	System.out.println("\nExample 2 - ");
	callProcess(n);
}

@Test
public void ex3() throws Exception {
	int[] n = {0,0,2,0,3,0,0};
	System.out.println("\nExample 3 - ");
	callProcess(n);
}

@Test
public void ex4() throws Exception {
	int[] n = {0,0,0,0,0};
	System.out.println("\nExample 4 - ");
	callProcess(n);
}

private void callProcess(int[] n) throws Exception {
	/**
	 * Algorithm - Two Pointer
	 * Big 'O' Notation - O(n)
	 * initiate an loop to travel through the given array
	 * initiate slow pointer to zero and fast pointer to one
	 * while at loop - validate slow pointer is zero
	 * 			if yes validate fast pointer is also zero
	 * 				if fast pointer is equal to  given array length -1
	 * 					break
	 * 				if yes increase the fast pointer by one and continue the loop
	 * 			if no then swap the data from left to right and increase both pointers
	 * 			If slow pointer is not zero 
	 * 				if fast pointer - slow pointer is one 
	 * 					if fast pointer is equal to given array length -1
	 * 						break
	 * 					increase both pointers
	 * 				if not then increase slow pointer by one 
	 * */
	/*******************************************************************************/
	
	int l=0, r=1;
	while(r<n.length) {
		System.out.println("left - " + l);
		System.out.println("right - " + r);
		int a = n[l], b = n[r];
		System.out.println("a - " + a);
		System.out.println("b - " + b);
		System.out.println("array length: " + n.length);
		if (a==0) {
			if(b==0) {
				if(r==n.length-1) {
					System.out.println(r + " = " + (n.length-1));
					break;
				}
				r++;
			}
			else {
				n[l] = b;
				n[r] = 0;
			}
		}
		else {
			if((r-l) == 1) {
				if(r==n.length-1) {
					System.out.println(r + " = " + (n.length-1));
					break;
				}
				else {
					l++;
					r++;
				}
			}
			else l++;
		}
	}
	System.out.println(Arrays.toString(n));
}

}
