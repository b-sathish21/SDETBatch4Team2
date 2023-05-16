//Solution - 1
class Solution {
    public int maxProduct(int[] n) {
        //Time Complexity - O(n^2)
        //Space Complexity - O(1)
        int m = 0;
        for(int i = 0; i<n.length; i++){
            for(int j = 0; j<n.length; j++){
                if(j!=i){
                    if(((n[i]-1)*(n[j]-1))>m) m = ((n[i]-1)*(n[j]-1));
                }
            }
        }
        return m;
    }
}

//Solution - 2
class Solution {
    public int maxProduct(int[] n) {
        //Time Complexity - O(n)
        //Space Complexity - O(1)
        int l = 0, r = n.length-1, m1 = 0, m2 = 0;
        for(;l<=r; l++, r--){
            if(n[l]<n[r]) {
                if(n[r]==m1) m2 = m1;
                else{
                    if(n[r]>=m1) m1 = n[r];
                    if(n[l]>=m2) m2 = n[l];
                }                
            }
            else {
                if(n[l]==m1) m2 = m1;
                else{
                    if(n[l]>=m1) m1 = n[l];
                    if(n[r]>=m2) m2 = n[r];
                }
            }
            
        }
        return ((m1-1) * (m2-1));
    }
}