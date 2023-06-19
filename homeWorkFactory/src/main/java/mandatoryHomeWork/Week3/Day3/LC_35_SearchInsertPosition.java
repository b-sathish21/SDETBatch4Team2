class Solution {
    public int searchInsert(int[] n, int k) {
        /*
        Algorithm: Divide N Conquer        
        Big O Notation:
				Time  - O(log n)
				Space - O(1)
		Pseducode:
            initiate loop with var(i=0, j=array length -1, m=(i+j)/2)
            run loop till i <= j
                validate array val of index m > k && i < k then assign j = m
                else validate array val of index m < k && j > k then assign i = m
                validate array val of index 0 > k then return 0
                else validate array val of index array length -1 then return length of array
                else validate array val of index m == k return m
                validate j-i == 1 return j
                assign (i+j)/2 to m
            return zero
        */
        for(int i= 0, j = n.length-1, m=(i+j)/2; i<=j;){
            if(n[m]>k && n[i]<k) j = m;
            else if(n[m]<k && n[j]>k) i = m;
            if(n[0]>=k) return 0;
            else if(n[n.length-1]<k) return n.length;
            else if(n[n.length-1]==k) return n.length-1;
            else if(n[m]==k) return m;
            if((j-i)==1) return j;
            m = (i+j)/2;
        }
        return 0;
    }
}