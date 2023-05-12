class Solution {
    public boolean containsNearbyDuplicate(int[] n, int k) {
        /*
        Algorithm: Sliding Window + Two Pointer
        Big O Notation:
            Time  - O(n)
            Space - O(1)
        Pseudocode:
        -----------
            validate n.len > 1
                initiate i & j var as (0 & 1)
                initiate loop to run till j is less than n.len
                    validate array val of index i equals j
                    and j-i is less or equals k
                        return true
                    increment j by one
                    validate j equals n.len and j-i not equals one
                        increment i by one
                        add i plus one and assign to j
            return false
        */
        // --------------------------------------------------------------
        /*Sol - 1*/
        // --------------------------------------------------------------
        // if(n.length > 1){
        //     int i = 0, j = 1;
        //     System.out.println(i + " -- " + j);
        //     while(j<n.length){
        //         System.out.println("val: " + n[i] + " -- " + n[j]);
        //         if((n[i] == n[j]) && ((j-i) <= k)) return true;
        //         j++;
        //         if(j==n.length && j-i != 1) {
        //             i++; j = i+1;
        //         }
        //         System.out.println(i + " -- " + j);
        //     }
        // }
        // return false;
        //--------------------------------------------------------------
        /*Sol - 2*/
        /*
        Pseudocode:
            initiate map with Integer wrapper as key & val
            initiate loop to travel throughout given array
                validate map contains key as current index val
                    validate current index minus map val is less or equals to k
                        return true
                add current index val as key and index as val in map
            return false
        */
        //--------------------------------------------------------------
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<n.length; i++){
            if(map.containsKey(n[i])){
                if((i- map.get(n[i])) <= k) return true;
                }
            map.put(n[i], i);
            }
        return false;
    }
}