class Solution {
    public int countPoints(String rings) {
        /**
        [v k , v k , v k] Key == Rod, Value == color concatenate
        [R 0 , G 0 , B 0]
        validate the size of the rings is lesser than 4
            return 0
        initiate count variable to to count number of rods
        initiate an map to store rod as key and color as value (and append the color)
        initiate loop to travel through the string
            validate i is zero or divisible by zero
                validate i+1th char is available in map
                    concatenate the val and store
                else add the val
        initiate loop to travel through the map
            initate another map to store the count of the colors
            initiate loop to travel through the value
                validate current char is in map
                    add value by one
                else add one
            validate color counter map size is 3
                increment count by one
        return the count
        -------------------------------------------------------------------------
        Complexity: Time- O(n * m) | Space- O(n)
         */        
        HashMap<Integer, String> map = new HashMap<>();
        int count = 0;
        if(rings.length()<5) return count;
        for(int i=0; i<rings.length(); i++){
            if(i == 0 || i%2 == 0) {
                int rod = rings.charAt(i+1);
                if(map.containsKey(rod-48)) {
                    map.put(rod-48, (map.get(rod-48) + rings.charAt(i)));
                }
                else map.put(rod-48, rings.charAt(i)+""); 
            }
        }
        for(Map.Entry k : map.entrySet()){ 
            String color = map.get(k.getKey());
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int i=0; i<color.length(); i++){
                if(color.charAt(i) == 'R'){
                    if(map2.containsKey('R')) map2.put('R', map2.get('R') + 1);
                    else map2.put('R', 1);
                }else if(color.charAt(i) == 'G'){
                    if(map2.containsKey('G')) map2.put('G', map2.get('G') + 1);
                    else map2.put('G', 1);
                }else if(color.charAt(i) == 'B'){
                    if(map2.containsKey('B')) map2.put('B', map2.get('B') + 1);
                    else map2.put('B', 1);
                }
            }
            if(map2.size() == 3) count++;
        }
        return count;
    }
}