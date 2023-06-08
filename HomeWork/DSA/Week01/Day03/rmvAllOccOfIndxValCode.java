package weekWorkOuts;

import org.junit.Test;

public class rmvIndxValAllOccrnce {
	
	@Test
	public void ex1() throws Exception {
		int[] n = {1,2,3,1,2,3,1,2,3};
		int k = 2;
		System.out.println("Example 1 - ");
		remvIndxValAllOccrnce(n,k);
	}
	
	@Test
	public void ex2() throws Exception {
		int[] n = {1,2,3,1};
		int k = 5;
		System.out.println("Example 2 - ");
		remvIndxValAllOccrnce(n,k);
	}
	
	@Test
	public void ex3() throws Exception {
		int[] n = {};
		int k = 5;
		System.out.println("Example 3 - ");
		remvIndxValAllOccrnce(n,k);
	}
	
	@Test
	public void ex4() throws Exception {
		int[] n = {1,2,3};
		int k = 0;
		System.out.println("Example 4 - ");
		remvIndxValAllOccrnce(n,k);
	}
	
	@Test
	public void ex5() throws Exception {
		int[] n = {1};
		int k = 0;
		System.out.println("Example 5 - ");
		remvIndxValAllOccrnce(n,k);
	}

	private void remvIndxValAllOccrnce(int[] n, int k) throws Exception {
		
		//Negative case handle
		// Verify input array is not equal to zero
		if (n.length==0) throw new Exception("No data is available");
		// verify out of bound index
		if (n.length<k) throw new Exception("given index is greater than input array length");
		
		//Positive Case handle
		// initiate count var to count the no of occurrence of indexth val in input array
		int c=1;
		int a=0;
		System.out.print("input array length is " + n.length + "\n\n");
		System.out.print("input is \n [");
		// initiating the loop to travel throughout the input array
		for(; a < n.length-1; a++) {
			System.out.print(n[a]+", ");
			// comparing the current index val equals given index val
			if(n[a]==n[k]) c++; // incrementing the count
		}
		System.out.print(n[a]+"] \n\n");		
		System.out.println("Total occurence of val " + n[k] + " is " + c);
		
		//initiating the output array with length of input array length minus count
		int[] m = new int[n.length-c];
		
		System.out.println("output is\n[");
		int i2=0, j=0;
		// initiating the loop to travel throughout the input array
		for(; i2<n.length-1;i2++) {
			// comparing the current index val not equals given index val
			if(n[i2]!=n[k]) {
				m[j++]=n[i2]; // adding ip val to op
				System.out.print(m[j-1] + ", ");
			}			
		}
		System.out.print("]");
		System.out.println("\nThe time comlexity is O(2n) ==> O(n)");
	}
}
