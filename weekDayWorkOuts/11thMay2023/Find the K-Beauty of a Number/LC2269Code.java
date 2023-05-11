class Solution {
    public int divisorSubstrings(int n, int k) {
        /*
        Algorith: Sliding Window
        Big O Notation:
            Time  - O(n)
            Space - O(n)
        Pseducode:
            - Initiate string s and assign n value
            - Initiate integer count (c) and assign zero to it.
            - initiate inc loop to run till loop var (i) is less than s.len - (k-1)
                > initiate j var and assign i + (k-1)
                > initiate string a and assign char of string at i index val
                > initiate inc loop and run till loop var (j = i + 1) is less than k + i
                    - add a + char val of s at j index and assign to a
                > initiate int var (b) and assign a converting to Integer
                > validate b is not equal to zero
                    - validate dividing n by b reminder equals to zero
                        > increase c by one
            return c
        */
        String s = "" + n;
        int c = 0;
        if(s.length() == k) return 1;
        for(int i = 0; i<s.length()-(k-1); i++){
            String a = "" + s.charAt(i);
            if(k!=1){
                for(int j=(i+1); j < (i+k); j++) a = a + s.charAt(j);
            }
            int b = Integer.parseInt(a);
            if(b!=0){
                if(n % b == 0) c++;
            }
        }
        return c;
    }
}