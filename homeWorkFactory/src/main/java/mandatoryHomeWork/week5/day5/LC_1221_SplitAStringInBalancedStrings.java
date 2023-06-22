class Solution {
    public int balancedStringSplit(String s) {
        /*
        Complexity: Time - O(n) & Space - O(1)
        */
        int count = 0, Rcount = 0, Lcount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R') Rcount++;
            else if(s.charAt(i) == 'L') Lcount++;
            if(Rcount == Lcount){
                count++;
                Rcount = 0;
                Lcount = 0;
            }
        }        
        return count;
    }
}