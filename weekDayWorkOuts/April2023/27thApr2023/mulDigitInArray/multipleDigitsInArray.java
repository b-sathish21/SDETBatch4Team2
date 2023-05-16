package weekWorkOuts;

import org.junit.Test;

public class multipleDigitsInArray {
	
	@Test
	public void ex1() throws Exception {
		int[] n = {1,2,3,4};
		System.out.println("Example 1 - ");
		mulNoInArray(n);
	}
	
	@Test
	public void ex2() throws Exception {
		int[] n = {12, 0 ,3,4};
		System.out.println("\nExample 2 - ");
		mulNoInArray(n);
	}
	
	@Test
	public void ex3() throws Exception {
		int[] n = {1,1,11,0};
		System.out.println("\nExample 3 - ");
		mulNoInArray(n);
	}
	
	@Test
	public void ex4() throws Exception {
		int[] n = {0};
		System.out.println("\nExample 4 - ");
		mulNoInArray(n);
	}

	private void mulNoInArray(int[] n) throws Exception {
		
		//Negative case handle
		// Verify input array is not equal to zero
		if (n.length==0) throw new Exception("No data is available");
		
		//Positive Case handle
		int[] m = new int[n.length];
		for(int i=0; i<n.length; i++) {
			int mul = 1;
			for(int j=0; j<n.length; j++) {
				if(i!=j) mul = mul * n[j];
			}
			System.out.print(" " + mul + " ");
			m[i] = mul;
		}
		
		//sol 2 - Not working if zero is part of the input
		System.out.println("\n----------Sol 2----------");
		int a = 1;
		for(int x=0; x<n.length; x++) {
			a = a*n[x];
		}
		for(int y=0; y<n.length; y++) {
			System.out.print(" " + (a/n[y]) + " ");
		}
	}
}
