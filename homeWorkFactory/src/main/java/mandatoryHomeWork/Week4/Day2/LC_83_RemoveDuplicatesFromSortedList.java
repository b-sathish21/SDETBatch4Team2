package weekWorkOuts;

import java.util.Arrays;

import org.junit.Test;

import inBuiltLibraryReconstructed.singlyLinkedList;

public class removeDuplicatesFromSortedList {

	@Test
	public void ex1() throws Exception {
		int[] n = {1,2,2,3};
		System.out.println("\nExample 1 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		callProcess(n);
	}

	@Test
	public void ex2() throws Exception {
		int[] n = {1,2,3};
		System.out.println("\nExample 2 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		callProcess(n);
	}

	@Test
	public void ex3() throws Exception {
		int[] n = {1,1,1,1,2,2,2,3,3,5,7,7,9};
		System.out.println("\nExample 3 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		callProcess(n);
	}

	@Test
	public void ex4() throws Exception {
		int[] n = {};
		System.out.println("\nExample 4 - ");
		System.out.println("Input is \n n = " + Arrays.toString(n));
		callProcess(n);
	}
	
	private void callProcess(int[] n) throws Exception {
		/**
		 * Big O Notation
		 * 	-Time  ==> O(n)
		 * 	-Space ==> O(n)
		 * */
		singlyLinkedList sll1 = new singlyLinkedList();
		for(int i=0; i<n.length; i++) sll1.add(n[i]+"");
		
		for(int i=1; i<=sll1.len(); i++) {
			int a = sll1.duplicateOccurrence(sll1.fetchData(i));
			System.out.println(sll1.fetchData(i) + " --> " + a);
			if(a>1) {
				int lst_indx = sll1.lastIndexOf(sll1.fetchData(i));
				System.out.println("last Index: " + lst_indx);
				for(int j=1; j<a; j++) {
					sll1.removeData(lst_indx);
					System.out.println("left Over: " + sll1.duplicateOccurrence(sll1.fetchData(i)));
					lst_indx = sll1.lastIndexOf(sll1.fetchData(i));
					}
				}
				System.out.println(sll1.toStr());
			}
		System.out.println("Final Output is " + sll1.toStr());
		}
}
