class Solution {
    public int minimumRecolors(String s, int k) {
        /*
        Algorithm: Sliding Window + Two Pointer (Opp Direction)
        Big O Notation
            Time  - O(n * m)
            Space - O(1)
        */
        int c = 0, min = s.length();
        //Sliding Window
        for(int i = 0; i <= (s.length() - k); i++){
            //Two Pointer
            for(int l=i, r=(i+(k-1)); l<=r; l++, r--){
                if(l==r){
                    if(s.charAt(l) == 'W') c++;
                }
                else{
                    if(s.charAt(l) == 'W') c++;
                    if(s.charAt(r) == 'W') c++;
                }                
            }
            //compare and store minimum iteration
            if(c < min) min = c;
            //resetting count to zero
            c = 0;
        }
        return min;
    }
}