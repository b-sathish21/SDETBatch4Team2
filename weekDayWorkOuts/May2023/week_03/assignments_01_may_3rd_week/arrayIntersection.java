package assignments_01_may_3rd_week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

public class arrayIntersection {

	@Test
	public void ex1() throws Exception {
		int[] n = {1,2,6};
		int[] m = {4,5,6};
		System.out.println("\nExample 1 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		System.out.println("m = " + Arrays.toString(m));
		callProcess(n, m);
	}

	@Test
	public void ex2() throws Exception {
		int[] n = {1,2,6};
		int[] m = {1,5,6};
		System.out.println("\nExample 2 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		System.out.println("m = " + Arrays.toString(m));
		callProcess(n, m);
	}

	@Test
	public void ex3() throws Exception {
		int[] n = {};
		int[] m = {4,5,6};
		System.out.println("\nExample 3 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		System.out.println("m = " + Arrays.toString(m));
		callProcess(n, m);
	}

	@Test
	public void ex4() throws Exception {
		int[] n = {};
		int[] m = {};
		System.out.println("\nExample 4 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		System.out.println("m = " + Arrays.toString(m));
		callProcess(n, m);
	}
	
	private void callProcess(int[] n, int[] m) throws Exception {
		/**
		 * -------------------------------------------------------------------------------------
		 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
		 * Each element in the result must be unique and you may return the result in any order.
		 * -------------------------------------------------------------------------------------
		 * Algorithm: two pointer (Equi)
		 * Big O Notation
		 * 	-Time  ==> O(n X m)
		 * 	-Space ==> O(n)
		 * -------------------------------------------------------------------------------------
		 * >Initiate an map to store the intersects values
		 * > Initiate an outer loop to travel through one array
		 * 	> Initiate an inner loop to travel through other array
		 * 		> Validate outer loop current index value equals inner loop current index value
		 * 			> add the value as key to the map and value as zero
		 * > get the keys of the map and return as array.
		 * -------------------------------------------------------------------------------------
		 * */
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < n.length; i++) {
			for(int j=0; j < m.length; j++) {
				if (n[i] == m[j]) map.put(n[i], 0);
			}
		}
		Set<Integer> a = map.keySet();
		int b = 0, l = a.size();
		if(l>0) {
			System.out.print("[");
			for(int k: a) {
				b++;
				if(b<l) System.out.print(k + " ,");
				else System.out.print(k + "]");
			}
		}		
	}
}
