package weekWorkOuts;

import org.junit.Test;

public class missingNumber {
	
	@Test
	public void ex1() throws Exception {
		int[] n = {0};
		System.out.println("Example 1 - ");
		missedNumber(n);
	}
	
	@Test
	public void ex2() throws Exception {
		int[] n = {3,1,0};
		System.out.println("Example 2 - ");
		missedNumber(n);
	}

	private void missedNumber(int[] n) throws Exception {
		
		//Negative case handle
		// Verify input array is not equal to zero
		if (n.length==0) throw new Exception("No data is available");
		
		//Positive Case handle
		// initiate count var to count the no of occurrence of indexth val in input array
		
		for(int i=0;i<=n.length;i++) {
			int c=0;
			for(int j=0;j<n.length;j++) {
				if(i==n[j]) {
					c++;
					break;
				}
			}
			if(c==0) {
				System.out.println("The missing number is " + i);
				break;
			}
		}
		
		//Sol - 2
		int s1=0, s2=0;
		for(int i=0; i<=n.length; i++) {
			s1=s1+i;
			if(i<n.length) s2=s2+n[i];
		}
		System.out.println("The missing number is " + (s1-s2));
	}
}
