class Solution {
    public int[] sortEvenOdd(int[] n) {
      /*   
      Big 'O' Notation - 
	    	Time  - O(n log n)
	 		Space - O(1)
        */
        if(n.length<3) return n;
    else{    
    	int first=0;
        for(int i=0; i<n.length; i++){
            if(i==0 || i%2 == 0){
                int min = n[i], idx = 0, j=i+2;
                for(; j<n.length; j=j+2){
                    if(min>n[j]) {
                    	min = n[j];
                    	idx = j;
                    }
                }
                n[idx] = n[i];
                n[i] = min;
                if(i==0) first = min;
            }
            else{
                int max = n[i], idx = 0, j = i+2;
                for(; j<n.length; j=j+2){
                    if(max<n[j]) {
                    	max = n[j];
                    	idx = j;
                    }
                }
                n[idx] = n[i];
                n[i] = max;
            }
            n[0] = first;
        }
    }
	return n;
    }
}