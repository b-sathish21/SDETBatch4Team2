package weekWorkOuts;

import java.util.Arrays;

import org.junit.Test;

public class rgtPascalTriangle {

	@Test
	public void ex1() {
		int k = 5;
		System.out.println("Example 1 \n Num of rows is " + k);
		rightPascalTriangle(k);
	}

	@Test
	public void ex2() {
		int k = 2;
		System.out.println("\n Example 2 \n Num of rows is " + k);
		rightPascalTriangle(k);
	}

	@Test
	public void ex3() {
		int k = 1;
		System.out.println("\n Example 3 \n Num of rows is " + k);
		rightPascalTriangle(k);
	}

	@Test
	public void ex4() {
		int k = 0;
		System.out.println("\n Example 4 \n Num of rows is " + k);
	}

	private void rightPascalTriangle(int k) {
		// TODO Auto-generated method stub
		int line = k + (k-1);
		int up = 1;
		int dwn = k-1;
		for(int i=0; i<line; i++) {
			System.out.println("");
			if(up<=k) {
				for(int x = 0; x<up; x++) System.out.print("*");
				up++;
			}
			else {
				int y=dwn;
				for(; y>0; y--) System.out.print("*");
				dwn--;
			}
		}
	}

}
