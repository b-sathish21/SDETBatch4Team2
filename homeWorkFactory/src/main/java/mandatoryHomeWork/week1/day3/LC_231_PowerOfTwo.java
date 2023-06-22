package weekWorkOuts;

import org.junit.Test;

public class powerOfTwoLeetCode {


	@Test
	public void ex1() {
		int k = -8;
		System.out.println("Example 1 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex2() {
		int k = 8;
		System.out.println("Example 2 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex3() {
		int k = -1;
		System.out.println("Example 3 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex4() {
		int k = 1;
		System.out.println("Example 4 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex5() {
		int k = 0;
		System.out.println("Example 5 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex6() {
		int k = 2;
		System.out.println("Example 6 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex7() {
		int k = 128;
		System.out.println("Example 7 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex8() {
		int k = -128;
		System.out.println("Example 8 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex9() {
		int k = 120;
		System.out.println("Example 9 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}
	
	@Test
	public void ex10() {
		int k = -120;
		System.out.println("Example 10 \n Input is " + k);
		System.out.println(powerOfTwo(k));
	}

	private boolean powerOfTwo(int k) {
		// TODO Auto-generated method stub
		if(k==1 || k==-1) return true;
		if(k==0) return false;
		int hlf = k/2;
		int r=0;
		if(k>1) {
			r=2;
			for(int i=1; i<hlf;i++) {
				r = r * 2;
				if (r==k) return true;
			}
		}
		else if(k<-1) {
			r=-2;
			for(int i=-1; i>hlf;i--) {
				r = r * 2;
				if (r==k) return true;
			}
		}
		
		if (r==k) return true;
		return false;
	}
}
