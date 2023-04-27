package weekWorkOuts;

import org.junit.Test;

public class sandGlassPatern {
	
	@Test
	public void ex1() throws Exception {
		int k = -1;
		System.out.println("\nExample 1 - ");
		sndGlsPtrn(k);
	}
	
	@Test
	public void ex2() throws Exception {
		int k = 0;
		System.out.println("\nExample 2 - ");
		sndGlsPtrn(k);
	}
	
	@Test
	public void ex3() throws Exception {
		int k = 1;
		System.out.println("\nExample 3 - ");
		sndGlsPtrn(k);
	}
	
	@Test
	public void ex4() throws Exception {
		int k = 2;
		System.out.println("\nExample 4 - ");
		sndGlsPtrn(k);
	}
	
	@Test
	public void ex5() throws Exception {
		int k = 3;
		System.out.println("\nExample 5 - ");
		sndGlsPtrn(k);
	}
	
	@Test
	public void ex6() throws Exception {
		int k = 4;
		System.out.println("\nExample 6 - ");
		sndGlsPtrn(k);
	}
	
	@Test
	public void ex7() throws Exception {
		int k = 13;
		System.out.println("\nExample 7 - ");
		sndGlsPtrn(k);
	}

	private void sndGlsPtrn(int k) throws Exception {
		
		//Negative case handle
		// verify negative integers
		if (k < 0) throw new Exception("Negative integers not accepted");
		
		//Positive Case handle
		int i=0, spc = 0, str = 0;
		for(; i < (k*2); i++) {
			System.out.println("");
			if(i < k) {
				spc=i;
				str=k-i;
			}
			else {
				spc = ((k*2) - (i+1));
				str = ((i+1) - k);
			}
			for(int x=0; x<spc; x++) System.out.print(" ");
			for(int y=0; y<str; y++) System.out.print("* ");
		}
	}
}
