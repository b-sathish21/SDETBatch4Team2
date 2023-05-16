package weekWorkOuts;

import java.util.*;
import org.junit.Test;

public class minAbsDiff {

	@Test
	public void ex1() throws Exception {
	int[] n= {1,2,3,4};
	System.out.println("\nExample 1 - ");
	System.out.println("Input is \n n = " + Arrays.toString(n));
	callProcess(n);
}

	@Test
	public void ex2() throws Exception {
	int[] n= {1,3,6,10,15};
	System.out.println("\nExample 2 - ");
	System.out.println("Input is \n n = " + Arrays.toString(n));
	callProcess(n);
}

	@Test
	public void ex3() throws Exception {
	int[] n= {3,8,-10,23,19,-4,-14,27};
	System.out.println("\nExample 3 - ");
	System.out.println("Input is \n n = " + Arrays.toString(n));
	callProcess(n);
}

	@Test
	public void ex4() throws Exception {
	int[] n= {4,2,1,3};
	System.out.println("\nExample 4 - ");
	System.out.println("Input is \n n = " + Arrays.toString(n));
	callProcess(n);
}

private void callProcess(int[] n) throws Exception {
	/**
	 * Big O Notation
	 * 	-Time  ==> O(n)
	 * 	-Space ==> O(n)
	 * */
	int m = n.length, a = 0;
	String b = "";
	HashMap<Integer, String> map=new HashMap<>();
	for(int i=0, j=1; i<n.length-1; j++) {
		if(n[i]>n[j]) {
			a = n[i] - (n[j]);
			b = "[" + n[j] + "," + n[i] + "]";
		}
		else {
			a = n[j] - (n[i]);
			b = "[" + n[i] + "," + n[j] + "]";
		}		
		if(map.containsKey(a)) b = map.get(a) + ", " + b;
		map.put(a, b);		
		if(j==n.length-1) {
			i++; j=i;
		}
	}
	Set<Integer> se = map.keySet();
	int si = se.size();
	for(Integer q : se) {
		if (m>q) m=q; 
	}
	System.out.println("The minimum difference is " + m + " val is " + map.get(m));
}

}
