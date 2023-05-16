Find the Index of the First Occurrence in a String
==================================================
class Solution {
    public int strStr(String s, String k) {
        /*
        initiate index var r
        validate if target is available in given string
            initiate loop to travel through the given string
                initiate in the loop start var (i) to get index char val of target
                    validate target char of current index (i) equals string current index char (j)
                        increment i and r
                        validate i equals target length
                            assign j - (r-1) to r
                            break the loop
                    else reassign l and r to zero
            return r
        else return r as -1
        Big O Notation
            Time  - O(n)
            space - O(1)
        */
        int r = 0;        
        for(int l=0, j=0; j<s.length(); j++){
            System.out.println(k.charAt(l)+ " == " + s.charAt(j));
            if(k.charAt(l)==s.charAt(j)) {
                l++;
                r++;
                if(l==k.length()) {
                    System.out.println(j + " - " + r);
                    r = j-(r-1);
                    return r;
                }
            }
            else {
                System.out.println(j + " - " + r);
                j=j-r; l = 0; r = 0; 
                System.out.println("Reset " + j);
            }
        }

        return -1;
    }
}