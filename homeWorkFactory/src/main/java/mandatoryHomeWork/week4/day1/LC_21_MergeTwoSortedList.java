package weekWorkOuts;

import java.util.Arrays;

import org.junit.Test;

import inBuiltLibraryReconstructed.doublyLinkedList;
import inBuiltLibraryReconstructed.singlyLinkedList;

public class merge2SortedLists {

	@Test
	public void ex1() throws Exception {
	int[] n1= {1,2,4};
	int[] n2= {1,3,5};
	System.out.println("\nExample 1 - ");
	System.out.println("Input is \n n1 = " + Arrays.toString(n1));
	System.out.println("and \n n2 = " + Arrays.toString(n2));
	callProcess(n1, n2);
	callProcess1(n1, n2);
}
	
	@Test
	public void ex2() throws Exception {
	int[] n1= {1,2};
	int[] n2= {1,3,5};
	System.out.println("\nExample 2 - ");
	System.out.println("Input is \n n1 = " + Arrays.toString(n1));
	System.out.println("and \n n2 = " + Arrays.toString(n2));
	callProcess(n1, n2);
	callProcess1(n1, n2);
}

	@Test
	public void ex3() throws Exception {
	int[] n1= {1,2,4};
	int[] n2= {1,3};
	System.out.println("\nExample 3 - ");
	System.out.println("Input is \n n1 = " + Arrays.toString(n1));
	System.out.println("and \n n2 = " + Arrays.toString(n2));
	callProcess(n1, n2);
	callProcess1(n1, n2);
}

	@Test
	public void ex4() throws Exception {
	int[] n1= {};
	int[] n2= {};
	System.out.println("\nExample 4 - ");
	System.out.println("Input is \n n1 = " + Arrays.toString(n1));
	System.out.println("and \n n2 = " + Arrays.toString(n2));
	callProcess(n1, n2);
	callProcess1(n1, n2);
}
	
private void callProcess(int[] n, int[] m) throws Exception {
		/**
		 * Big O Notation
		 * 	-Time  ==> O(n)
		 * 	-Space ==> O(n)
		 * */
		singlyLinkedList sll1 = new singlyLinkedList();
		for(int i=0; i<n.length; i++) sll1.add(n[i]+"");
	
		singlyLinkedList sll2 = new singlyLinkedList();
		for(int i=0; i<m.length; i++) sll2.add(m[i]+"");
		
		int l1 = sll1.len(), l2 = sll2.len();
		singlyLinkedList sll = new singlyLinkedList();
		
		if(l1<=l2) {
			for(int i=1; i<=l2; i++) {
				int b = Integer.parseInt(sll2.fetchData(i));
				if(i<=l1) {
					int a = Integer.parseInt(sll1.fetchData(i));
					if(a<=b) {
						sll.add(a+"");
						sll.add(b+"");
					}
					else {
						sll.add(b+"");
						sll.add(a+"");
					}
				}
				else sll.add(b+"");
			}
		}
		else {
			for(int i=1; i<=l1; i++) {
				int a = Integer.parseInt(sll1.fetchData(i));
				if(i<=l2) {					
					int b = Integer.parseInt(sll2.fetchData(i));
					if(a<=b) {
						sll.add(a+"");
						sll.add(b+"");
					}
					else {
						sll.add(b+"");
						sll.add(a+"");
					}
				}
				else sll.add(a+"");
			}
		}
		
		System.out.println("Output is " + sll.toStr());
	}

private void callProcess1(int[] n, int[] m) throws Exception {
		/**
		 * Big O Notation
		 * 	-Time  ==> O(n)
		 * 	-Space ==> O(n)
		 * */
		doublyLinkedList dll1 = new doublyLinkedList();
		for(int i=0; i<n.length; i++) dll1.add(n[i]+"");
	
		doublyLinkedList dll2 = new doublyLinkedList();
		for(int i=0; i<m.length; i++) dll2.add(m[i]+"");
		
		int l1 = dll1.len(), l2 = dll2.len();
		doublyLinkedList dll = new doublyLinkedList();
		
		if(l1<=l2) {
			for(int i=1; i<=l2; i++) {
				int b = Integer.parseInt(dll2.fetchData(i));
				if(i<=l1) {
					int a = Integer.parseInt(dll1.fetchData(i));
					if(a<=b) {
						dll.add(a+"");
						dll.add(b+"");
					}
					else {
						dll.add(b+"");
						dll.add(a+"");
					}
				}
				else dll.add(b+"");
			}
		}
		else {
			for(int i=1; i<=l1; i++) {
				int a = Integer.parseInt(dll1.fetchData(i));
				if(i<=l2) {					
					int b = Integer.parseInt(dll2.fetchData(i));
					if(a<=b) {
						dll.add(a+"");
						dll.add(b+"");
					}
					else {
						dll.add(b+"");
						dll.add(a+"");
					}
				}
				else dll.add(a+"");
			}
		}
		
		System.out.println("Output is " + dll.toStr());
	}
}