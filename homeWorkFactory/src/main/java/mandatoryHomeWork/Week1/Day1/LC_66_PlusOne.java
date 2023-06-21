package mandatoryHomeWork.week1.day1;

import java.util.Arrays;

import org.junit.Test;

public class LC_66_PlusOne {
	

	@Test
	public void ex1() throws Exception {
		int[] m1 = {4,2};
		System.out.println("First example output is " + Arrays.toString(process(m1)));
	}
	
	@Test
	public void ex2() throws Exception {
		int[] m1 = {9};
		System.out.println("Second example output is " + Arrays.toString(process(m1)));
	}
	
	@Test
	public void ex3() throws Exception {
		int[] m1 = {9,9};
		System.out.println("Third example output is " + Arrays.toString(process(m1)));
	}
	
	@Test
	public void ex4() throws Exception {
		int[] m1 = {9,8,9};
		System.out.println("Fourth example output is " + Arrays.toString(process(m1)));
	}
	
	@Test
	public void ex5() throws Exception {
		int[] m1 = {};
		System.out.println("Fifth example output is " + Arrays.toString(process(m1)));
	}

	public static int[] process(int[] n) throws Exception {
		// TODO Auto-generated method stub
		int t = 0;
		if (n.length == 0) {
			throw new Exception("Input array can't be empty");
		}
		if(n.length==1 && n[0]==9) {
			int[] m = new int[n.length + 1];
			m[0] = 1;
			return m;
		}		
		else if(n[n.length-1]<9) {
			n[n.length-1] = n[n.length-1] + 1;
			return n;
			}
		else {
			n[n.length-1] = 0;
			t = 1;
			for(int i=n.length-1; i>0; i--) {
				if((i-1)==0 && t == 1) {
					int[] m = new int[n.length + 1];
					m[i-1] = t;
					return m;
					}
				if(n[i-1]==9 && t==1) {
						n[i-1] = 0;
						t = 1;
					}
				else if (n[i-1]!=9 && t == 1) {
					n[i-1] = n[i-1] + t;
					t = 0;
					}
			}
			return n;
		}	
	}

}
