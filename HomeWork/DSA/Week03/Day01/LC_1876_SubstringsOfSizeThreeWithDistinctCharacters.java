class Solution {
    public int countGoodSubstrings(String s) {
        /*
        Big O Notation
            Time  - O(n * m)
            Space - O(1)
        Algorithm: Sliding Window
        Steps:
            > Validate given string length less than three then return zero.
            > else 
                - initiate count var(c) as zero and flag var(f) as zero
                - initiate outer inc loop to slide one index at an time till given length minus two
                  > reinitiate f to zero
                  > initiate inner inc loop with var(j) val as outer loop var(i) plus one and to run loop till j is less than i+3 (i.e. window of three char)
                    - validate char of i'th index equals char of j'th index then break
                    - else validate j equals i+2
                        > validate char of i+1'th index equals char of j'th index then break
                        > else increase f by one
                    - else increase f by one
                  > validate f equals 2 then increase c by one
                - return c
        */
        if(s.length()<3) return 0;
        else{
            int c = 0, f = 0;
            for(int i = 0; i<(s.length()-2); i++){
                f=0;
                for(int j=i+1; j<(i+3); j++){
                    if(s.charAt(i)==s.charAt(j)) break;
                    else if(j==(i+2)) {
                        if(s.charAt(i+1)==s.charAt(j)) break;
                        else f+=1;
                    }
                    else f+=1;
                }
                if(f==2) c++;
            }
            return c;
        }
    }
}
//aababcabc - aab/ aba/ bab/ abc/ bca/ cab/ abc