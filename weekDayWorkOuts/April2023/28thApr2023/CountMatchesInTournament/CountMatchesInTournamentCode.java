package weekWorkOuts;

import org.junit.Test;

public class countOfMatchesInTournament {
	
	@Test
	public void ex1() throws Exception {
		int n = 0;
		System.out.println("\nExample 1 - ");
		callProcess(n);
	}
	
	@Test
	public void ex2() throws Exception {
		int n = 1;
		System.out.println("\nExample 2 - ");
		callProcess(n);
	}
	
	@Test
	public void ex3() throws Exception {
		int n = 2;
		System.out.println("\nExample 3 - ");
		callProcess(n);
	}
	
	@Test
	public void ex4() throws Exception {
		int n = 6;
		System.out.println("\nExample 4 - ");
		callProcess(n);
	}
	
	@Test
	public void ex5() throws Exception {
		int n = 7;
		System.out.println("\nExample 5 - ");
		callProcess(n);
	}
	
	@Test
	public void ex6() throws Exception {
		int n = 14;
		System.out.println("\nExample 6 - ");
		callProcess(n);
	}

	private void callProcess(int n) throws Exception {
		int m = n;
		//Negative case handle
		// Verify input is not equal to zero
		if (n<=1) throw new Exception("Team Size can't be less than one");
		
		//Positive Case handle
		/**
		 * iterate loop half the team size
		 * identify the team is equal or odd
		 * if team size is equal then total matches & team advanced will be half of the team size
		 * else total matches will be half the team size and team advanced will be half the team size + 1
		 * */
		int match=0;
		if(n==2) match=1;
		else {
			for(int i=0; i<(n/2);i++) {
				if((n/2)%2 != 0) n=(n/2)+1;
				else n=n/2;
				match = match + n;
			}
		}
		
		System.out.println("Total Match: " + match);
	}

}
