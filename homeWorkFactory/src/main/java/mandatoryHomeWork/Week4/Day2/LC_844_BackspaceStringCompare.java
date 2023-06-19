package weekWorkOuts;

import org.junit.Test;

import inBuiltLibraryReconstructed.stackReconstruct;

public class backspaceStringCompare {

	@Test
	public void ex1() throws Exception {
		String s = "ab#c", t = "ad#c";
		System.out.println("\nExample 1 - ");
		System.out.println("Input is \n s = " + s + " \n t = " + t);
		callProcess(s, t);
	}

	@Test
	public void ex2() throws Exception {
		String s = "ab#cd", t = "ad#c";
		System.out.println("\nExample 2 - ");
		System.out.println("Input is \n s = " + s + " \n t = " + t);
		callProcess(s, t);
	}

	@Test
	public void ex3() throws Exception {
		String s = "c", t = "c";
		System.out.println("\nExample 3 - ");
		System.out.println("Input is \n s = " + s + " \n t = " + t);
		callProcess(s, t);
	}

	@Test
	public void ex4() throws Exception {
		String s = "", t = "";
		System.out.println("\nExample 4 - ");
		System.out.println("Input is \n s = " + s + " \n t = " + t);
		callProcess(s, t);
	}
	
	private void callProcess(String s1, String s2) throws Exception {
		/**
		 * Big O Notation
		 * 	-Time  ==> O(n)
		 * 	-Space ==> O(n)
		 * */
		stackReconstruct stck1 = new stackReconstruct();
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) == '#') {
				stck1.pop();
				i++;
			}
			stck1.push(s1.charAt(i));
			System.out.println("stack 1: " + stck1.toStr());
		}		

		stackReconstruct stck2 = new stackReconstruct();
		for(int i=0; i<s2.length(); i++) {
			if(s2.charAt(i) == '#') {
				stck2.pop();
				i++;
			}
			stck2.push(s2.charAt(i));
			System.out.println("stack 2: " + stck2.toStr());
		}
		System.out.println("---------------------------");
		System.out.println("Stack 01: " + stck1.toStr());
		System.out.println("Stack 02: " + stck2.toStr());
		System.out.println("---------------------------");
		int f = 0;
		for(int i=0; i<stck1.size(); i++) {
			if(stck1.size() != stck2.size()) {
				f = 1;
				break;
			}
			if(stck1.fetchData(i) != stck2.fetchData(i)) {
				f = 1;
				break;
			}
		}
		if(f==0) System.out.println("True --> " + stck1.toStr() + " == " + stck2.toStr());
		else System.out.println("False --> " + stck1.toStr() + " != " + stck2.toStr());
	}
}
