package assignments_01_may_3rd_week;

import java.util.Arrays;

import org.junit.Test;

public class binaryMatrixImageFlipNInvert {

	@Test
	public void ex4() throws Exception {
		int[][] ip = {{1,0,0},{1,0,1},{0,0,1}};
		System.out.println("\nExample 4 - ");
		callProcess(ip);
	}
	
	private void callProcess(int[][] n) throws Exception {
		/**
		 *-----------------------------------------------------------------------------------------------
		 * Given an n x n binary matrix image, flip the image horizontally, 
		 * then invert it, and return the resulting image.
		 * 
		 * To flip an image horizontally means that each row of the image is reversed.
		 * 
		 * For example, flipping [1,1,0] horizontally results in [0,1,1].
		 * 
		 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
		 * For example, inverting [0,1,1] results in [1,0,0].
		 *-----------------------------------------------------------------------------------------------
		 * Algorithm: 
		 * 		-Flip: two pointer (Opp)
		 * 		-Rev: during flip
		 * Big O Notation
		 * 	-Time  ==> O(n X m)
		 * 	-Space ==> O(1)
		 * ---------------------------------------------------------------------------------------------
		 * > Initiate outer loop to travel through the main array list
		 * 	> Initiate inner loop to travel through the sub array list
		 * 		> run the loop till slow pointer is less or equals to fast pointer
		 * 		> swap pointer values and invert the values till slow pointer is less than fast pointer
		 * 		> invert the value of the slow pointer when slow pointer equals fast pointer
		 * ---------------------------------------------------------------------------------------------
		 * */
		for(int i=0; i<n.length; i++) {
			System.out.println(Arrays.toString(n[i]));
			for(int j=0, k=n[i].length-1; j<=k ; j++, k--) {
				if(j<k) {
					int t = n[i][k];
					n[i][k] = n[i][j];
					n[i][j] = t;
					if(n[i][j] == 0) n[i][j] = 1;
					else n[i][j] = 0;
					if(n[i][k] == 0) n[i][k] = 1;
					else n[i][k] = 0;
				}
				if(j==k) {
					if(n[i][j] == 0) n[i][j] = 1;
					else n[i][j] = 0;
				}
			}
			System.out.println("---> " + Arrays.toString(n[i]));
		}		
	}
}
