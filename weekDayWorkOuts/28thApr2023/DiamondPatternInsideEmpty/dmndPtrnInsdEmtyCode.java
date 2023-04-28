package weekWorkOuts;

import org.junit.Test;

public class dimndPtrnInsideEmpty {
	
	@Test
	public void ex1() throws Exception {
		char c = 'A';
		System.out.println("\nExample 1 - ");
		callProcess(c);
	}
	
	@Test
	public void ex2() throws Exception {
		char c = 'B';
		System.out.println("\nExample 2 - ");
		callProcess(c);
	}
	
	@Test
	public void ex3() throws Exception {
		char c = 'C';
		System.out.println("\nExample 3 - ");
		callProcess(c);
	}
	
	@Test
	public void ex4() throws Exception {
		char c = 'F';
		System.out.println("\nExample 4 - ");
		callProcess(c);
	}

	private void callProcess(char c) throws Exception {
		//--------------------------------//
		//Identify number of rows
		/**
		 * 1st Sol by Ascii val
		 * 2nd Sol by iterating char directly
		 * */
		//By Ascii Val
		int a = 65; //ASCII val of 'A' is 65
		int count=1;
		for(;a!=90;count++, a++) {
			if((char)a==c) break;
		}
		
		//By iterating char directly
		char A = 'A';
		int Count=1;
		for(;A!='Z';A++, Count++) {
			if(A==c) break;
		}
		
		//-----------------------------------------//
		/**
		 * calculate the total line of the diamond pattern
		 * formula: (row X 2) -1
		 * */
		int line = (count*2)-1;
		int ot_spc=0, cns=0;
		a = 64; //re-initiating the char variable a
		//iterate till total line
		for(int i=1;i<=line;i++) {
			System.out.println("");
			/**
			 * identify the total space to be printed before printing character
			 * Two part of calculation
			 * first half decrement and second half increment 
			 * */
			if(i<=count) { //First half decrement space to be print out
				ot_spc = count - i;
				cns=i;
				a++;
			}
			else if(i>count) {//Second half increment space to be print out
				ot_spc=i-count;
				cns=count-ot_spc;
				a--;
			}
			//loop to print the space before printing character
			for(int j=0;j<ot_spc;j++) System.out.print(" ");
			/**
			 * print char min is one and max is two
			 * min char print is at initial and end of the line
			 * max char print is inbetween initial and end of the line
			 * when max char is to print then as per loop size print space inbetween
			 * */
			//printing 'A' when line is first or last
			if(i==1 || i==line) System.out.print('A');
			else {
				for(int k=0; k<cns; k++) {
					if(k==0 || k==(cns-1)) System.out.print((char)a + " ");
					else System.out.print("  ");
				}
			}
		}
	}
}
