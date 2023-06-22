class Solution {
    public boolean isSubsequence(String s, String t) {
        /**
        Complexity:
            Time  - O(n)
            Space - O(1)
        ----------------------------------------------------------------------
        Psedocode:
            Validate both string(s & t) length are not zero
                initiate two pointer (i & j) incremental loop to travel through the length
                    validate if jth char of s equals ith char of t
                        validate j is at last char of s
                            then return true
                        else validate i is less than t length by one and jth char of s is not equals i+1'th char of t
                            then increment j by one
                return false
            validate if both s length is zero 
                return true
         */
        if(s.length() != 0 & t.length() != 0){
            for(int i=0, j=0; i<t.length(); i++){
                if(s.charAt(j) == t.charAt(i)){
                    if(j == s.length()-1) return true;
                    else if(i<t.length()-1 && s.charAt(j) != t.charAt(i+1)) j++;
                }
            }
        }
        else if(s.length() == 0) return true;      
        return false;
    }
}