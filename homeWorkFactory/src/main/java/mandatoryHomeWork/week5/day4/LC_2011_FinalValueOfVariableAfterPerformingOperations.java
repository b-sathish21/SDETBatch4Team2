class Solution {
    public int finalValueAfterOperations(String[] operations) {
        /**
        initiate x as zero
        run the loop for the length of operations array
            initiate char variable first and assign current index string's first char
            validate first equals 'X'
                assign current index string's second char to first
            validate first equals '+'
                then increment x by one
            else decrement x by one
        return x
        -----------------------------------------------------------------------
        Complexity: Time - O(n) | Space - O(1)
        */
        int x = 0;
        for(int i=0; i<operations.length; i++){
            char first = operations[i].charAt(0);
            if(first == 'X') first = operations[i].charAt(1);
            if(first == '+') x++;
            else x--;
        }
        return x;
    }
}