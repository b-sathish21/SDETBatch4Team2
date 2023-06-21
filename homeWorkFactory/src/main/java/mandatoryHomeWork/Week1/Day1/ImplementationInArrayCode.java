package mandatoryHomeWork.week1.day1;

import java.util.Arrays;

import org.junit.Test;

public class ImplementationInArrayCode {

	/**
	   Implement below methods using array
			a. add to the specific index
			b. print the array value as string
			c. contains
			d. remove a value
			e. trim to the given length
	 */
	
	@Test
	public void ex1() throws Exception {
		int[] m1 = {1,2,4,5};
		int k = 3;
		System.out.println("First example output is " + Arrays.toString(addToSpecificIndex(m1, k)));
		System.out.println("\nFirst example2 output is ");
		printinString(m1);
		System.out.println("\nFirst example3 output is ");
		containsTarget(m1, 4);
		System.out.println("\nFirst example4 output is " + Arrays.toString(removeTarget(m1, 2)));
		System.out.println("\nFirst example5 output is " + Arrays.toString(trimtoGivenLength(m1, 2)));
	}
	

	@Test
	public void ex2() throws Exception {
		int[] m1 = {1,4,5};
		int k = 3;
		System.out.println("Second example output is " + Arrays.toString(addToSpecificIndex(m1, k)));
	}
	
	@Test
	public void ex3() throws Exception {
		int[] m1 = {};
		int k = 3;
		System.out.println("Third example output is " + Arrays.toString(addToSpecificIndex(m1, k)));
	}
	
	@Test
	public void ex4() throws Exception {
		int[] m1 = {7,1,3,9};
		int k = 5;
		// this example creates infinity loop need help
		System.out.println("Fourth example output is " + Arrays.toString(addToSpecificIndex(m1, k)));
	}
	
	private int[] addToSpecificIndex(int[] m1, int k) throws Exception {
		// TODO Auto-generated method stub
		int[] m = new int[m1.length+1];
		int tlft=0;
		int trt=0;
		int lft = 0;
		int rt = (m1.length-1);
		int flag=0;
		while(lft <= rt) {
			if(tlft==1 && trt==1) throw new Exception("More than one index found - Created Infinity Loop");
			if(m1[lft]<=k) {
				m[lft] = m1[lft];
				lft++;
			}
			else {
				m[lft] = k;
				flag=1;
				tlft = 1;
			}
			if(m1[rt]>=k) {
				m[rt+1] = m1[rt];
				rt--;
			}
			else {
				m[rt+1] = k;
				flag=1;
				trt = 1;
			}
		}
		if (flag==0) m[(m1.length/2)]=k;
		return m;
	}
	
	private void printinString(int[] m1) {
		// TODO Auto-generated method stub
		System.out.print("[");
		for(int i=0; i<m1.length; i++) {
			if(i==(m1.length-1)) System.out.print(m1[i] + "]");
			else System.out.print(m1[i] + ", ");
		}
	}

	private void containsTarget(int[] m1, int k) {
		// TODO Auto-generated method stub
		boolean f = false;
		int lft = 0;
		int rt = (m1.length-1);
		while(lft <= rt) {
			if(m1[lft]!=k) lft++;
			else {
				f = true;
				break;
			}
			if(m1[rt]!=k) rt--;
			else {
				f = true;
				break;
			}
		}
		if (f==true) System.out.println("Target is available in the array");
		else System.out.println("Target is not available in the array");
	}

	private int[] removeTarget(int[] m1, int k) throws Exception {
		// TODO Auto-generated method stub
		int[] m = new int[m1.length-1];
		int lft = 0;
		int rt = (m1.length-1);
		int flag=0;
		while(lft < rt) {
			if(m1[lft]!=k) {
				m[lft] = m1[lft];
				lft++;
			}
			else flag=1;
			if(m1[rt]!=k) {
				m[rt-1] = m1[rt];
				rt--;
			}
			else flag=1;
		}
		if (flag==0) throw new Exception("Target is not available in the array");;
		return m;
	}

	private int[] trimtoGivenLength(int[] m1, int i) {
		// TODO Auto-generated method stub
		int[] m = new int[i];
		for(int j=0;j<i;j++) m[j]=m1[j];
		return m;
	}

}
