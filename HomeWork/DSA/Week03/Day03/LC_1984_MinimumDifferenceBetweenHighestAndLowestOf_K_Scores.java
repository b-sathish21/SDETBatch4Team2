class Solution {
    public int minimumDifference(int[] n, int k) {
			/*
			Algorith: Sliding Window
			Big O Notation:
				Time  - O(n)
				Space - O(1)
			Pseducode:
				- Initiate minimum value variable(m) and assign length of the array
				- Initiate arithmetic operation result variable(a) and assign zero
				- Validate length of the array equals one
					> assign zero to 'm'
				- Else
						> initiate loop to travel given array length minus one
							and initiate loop variables(i & j) and assign (0 & 1)
							And run the loop till 'i' is less than given array length minus one
									-> validate i'th index val of array is greater than
															j'th index val of array
											==> i'th index val of array minus j'th index val of array
														and assign the value to 'a'
									-> Else validate i'th index val of array is lesser than
															j'th index val of array
											==> j'th index val of array minus i'th index val of array
														and assign the value to 'a'
									-> validate 'm' is greater than 'a'
											==> assign 'a' to 'm'
									-> validate 'j' equals given array length minus one
											==> increment 'i' by one and assign to 'j'
				return 'm'									
			*/
        		int m = Integer.MAX_VALUE, a = 0;
			if (n.length == 1) m=0;
			else{
				for(int i=0, j=1; i<n.length-2; j++) {
					if(n[i]>n[j]) a = n[i] - (n[j]);
					else a = n[j] - (n[i]);
					if(m>a)	m = a;
					if(j==n.length-1) {
						i++; j=i;
						}
					}
				}        
			return m;
    }
}