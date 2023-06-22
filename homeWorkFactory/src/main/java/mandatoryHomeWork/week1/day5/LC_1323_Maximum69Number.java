package weekWorkOuts;

import org.junit.Test;

public class Maximum69Number {
	
	@Test
	public void ex1() throws Exception {
		int n = 0;
		System.out.println("\nExample 1 - ");
		callProcess(n);
	}
	
	@Test
	public void ex2() throws Exception {
		int n = 960;
		System.out.println("\nExample 2 - ");
		callProcess(n);
	}
	
	@Test
	public void ex3() throws Exception {
		int n = 69;
		System.out.println("\nExample 3 - ");
		callProcess(n);
	}
	
	@Test
	public void ex4() throws Exception {
		int n = 9669;
		System.out.println("\nExample 4 - ");
		callProcess(n);
	}
	
	@Test
	public void ex5() throws Exception {
		int n = 669;
		System.out.println("\nExample 5 - ");
		callProcess(n);
	}
	
	@Test
	public void ex6() throws Exception {
		int n = 9666;
		System.out.println("\nExample 6 - ");
		callProcess(n);
	}
	
	@Test
	public void ex7() throws Exception {
		int n = 99;
		System.out.println("\nExample 7 - ");
		callProcess(n);
	}
	
	@Test
	public void ex8() throws Exception {
		int n = 66;
		System.out.println("\nExample 8 - ");
		callProcess(n);
	}

	private void callProcess(int n) throws Exception {
		if(n<9) throw new Exception("digits other than 6 & 9 should not be used");
		int count=0;
		int c = n, max = n;
		//O(n)
		while(n!=0) {
			n=n/10;
			count++;
		}
		int[] m = new int[count];
		//O(n)
		for(int i = count-1; i>=0 ; i--) {
			m[i] = c%10;
			if(m[i]==9 || m[i]==6) System.out.print("-");
			else throw new Exception("digits other than 6 & 9 should not be used");
			c=c/10;
		}
		//O(n)
		for(int j=0; j<count; j++) {
			if(m[j]==6) {
				int f = 0;
				//O(n)
				for(int k=0; k<count; k++) {
					if(m[k]==6 && f==0) {
						c = 9 + (c*10);
						f=1;
					}
					else c = m[k] + (c * 10);
				}
				if(c>max) max = c;
				c=0;
			}
		}
		System.out.println(max);
		
		//O(n^2)
	}

}
