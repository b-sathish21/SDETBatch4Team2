package mandatoryHomeWork.week1.day2;

import org.junit.Test;

public class LC_258_AddDigits {
	
	@Test
	public void ex1() {
		int n = 123;
		sum(n);
	}
	
	@Test
	public void ex2() {
		int n = 39875;
		sum(n);
	}
	
	@Test
	public void ex3() {
		int n = 0;
		sum(n);
	}
	
	@Test
	public void ex4() {
		int n=1;
		sum(n);
	}
	
	private void sum(int n) {
		// TODO Auto-generated method stub
		int m = n;
		int s = 0;
		while (n!=0 || s>9) {
			if (n == 0) {
                n = s;
                s = 0;
            }
            s = s + (n % 10);
            n = n / 10;
	       }		
		System.out.println("sum of "+m+" is "+s);
	}

}
