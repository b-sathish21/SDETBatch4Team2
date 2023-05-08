Remove Element
==============
class Solution {
    public int removeElement(int[] n, int k) {
			/*
			initiate slow pointer (l) as o and fast pointer (r) as array length minus one
			validate l <= r
				validate r indexth of array equals target
					decrement r by one
				else validate l indexth of array equals target and r indexth of array not equals target
					swap val of l and r
					increment l by one and decrement r by one
				else validate l indexth of array not equals target
					increment l by one
			return l
			Big O Notation
				Time  - O(n)
				Space - O(1)
			*/
        int l =0, r = n.length-1;
				while(l<=r) {
					if(n[r]==k) r--;
					else if(n[l]==k && n[r]!=k) {
						n[l++]=n[r];
						n[r--]=k;
					}
					else if(n[l]!=k) l++;
				}
		System.out.println("refactored input - " + Arrays.toString(n));
		System.out.println("The number of elements not equal to val is " + l);
    return l;
    }
}