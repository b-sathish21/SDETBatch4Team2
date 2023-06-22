package mandatoryHomeWork.week1.day2;

import java.util.Arrays;

import org.junit.Test;

public class RemoveFirstNLastOccurenceCode {

	@Test
	public void ex1() {
		int[] n = {1,2,2,3,4,5,2,2,5,2,6};
		int k = 2;
		System.out.println("Example 1");
		removeFirstNLastOccurence(n, k);
	}

	@Test
	public void ex2() {
		int[] n = {1,2,2,3,4,5,2,2,5,2,2};
		int k = 2;
		System.out.println("Example 2");
		removeFirstNLastOccurence(n, k);
	}

	@Test
	public void ex3() {
		int[] n = {1,6};
		int k = 2;
		System.out.println("Example 3");
		removeFirstNLastOccurence(n, k);
	}

	@Test
	public void ex4() {
		int[] n = {};
		int k = 2;
		System.out.println("Example 4");
		removeFirstNLastOccurence(n, k);
	}

	private void removeFirstNLastOccurence(int[] n, int k) {
		// TODO Auto-generated method stub
//		if (n.length==0) throw new Exception("there is no data in input array");
		int lft=0;
		int rt = n.length-1;
		int lf = 0;
		int rf = 0;
		int c=0;
		int op_len=0;
		for(int x=0;x<n.length;x++) {
			if(n[x]==k) c++;
		}
		if(c==0) op_len=n.length;
		else if(c==1) op_len = n.length-1;
		else if(c>=2) op_len = n.length-2;
		int[] m = new int[op_len];
		while(lft <= rt) {
			if(m.length == n.length) {
				m = n;
				break;
			}
			if(n[lft]!=k && lf==0) {
				m[lft] = n[lft];
				lft++;
			}
			else if(n[lft]==k && lf==0) {
				lf=1;
				lft++;
			}
			else {
				m[lft-1] = n[lft];
				lft++;
			}
			if(n[rt]!=k && rf==0) {
				m[rt-2] = n[rt];
				rt--;
			}
			else if(n[rt]==k && rf==0) {
				rf=1;
				rt--;
			}
			else {
				m[rt-1] = n[rt];
				rt--;
			}
		}	
		System.out.println(Arrays.toString(n));
		System.out.println(Arrays.toString(m));		
	}
}
