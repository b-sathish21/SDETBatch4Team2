class Solution {
    public int[] sortArrayByParity(int[] n) {
        //Time Complexity  --> O(n)
        //Space Complexity --> O(1)
        int l=0, r=n.length-1;
        while(l<r){
            if(n[l]%2 == 0 || n[l] == 0) l++;
            else if(n[l]%2 != 0 || n[l] != 0){
                if(n[r] % 2 == 0 || n[r] == 0){
                    int t = n[r];
                    n[r--] = n[l];
                    n[l++] = t;
                }
                else r--;
            }
        }
        return n;
    }
}