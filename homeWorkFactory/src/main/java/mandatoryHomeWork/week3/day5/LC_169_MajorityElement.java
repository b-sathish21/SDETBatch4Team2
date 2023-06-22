class Solution {
    public int majorityElement(int[] n) {
        /*
        Algorithm: Hashing
        Big O Notation:
            Time  - O(n)
            Space - O(n)
        Pseudocode:
        -----------
            initiate hash map
            initiate loop to travel throughout the array
                validate map contains current index val
                    add current index val as key and get the existing current index val count and add by one to the map
                else
                    add current index val as key and val as one to the map
            initiate set and get keysets of the map
            initiate loop to run till key is available in set
                validate current key's count in the map is greater than array length / 2
                    return key
            return zero
        */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n.length; i++){
            if(map.containsKey(n[i])) map.put(n[i], map.get(n[i])+1);
            else map.put(n[i], 1);
        }
        Set<Integer> se = map.keySet();
        for(Integer q : se) {
            if(map.get(q) > n.length/2) return q;
        }
        return 0;
    }
}