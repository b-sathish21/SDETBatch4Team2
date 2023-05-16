class Solution {
    public char nextGreatestLetter(char[] l, char t) {
        /*
        Big O Notation:
            Time  - O(n)
            Space - O(1)
        Pseudocode:
            initiate an loop to travel throughout the array
                validate current index char less or equals target char
                and current index plus one char greater than target char
                    return current index plus one val char of the array
            return zero index val char of the array
        */
        for(int i=0; i<l.length-1; i++){
            if(l[i] <= t && l[i+1] > t) return l[i+1];
            }
        return l[0];
    }
}