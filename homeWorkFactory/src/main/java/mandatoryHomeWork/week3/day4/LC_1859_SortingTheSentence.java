class Solution {
    public String sortSentence(String s) {        
        /*
        Algorith: Hash Map
        Big O Notation:
            Time  - O(n)
            Space - O(n)
        Pseducode:
            - Initiate array string x and assign s.split based on space
            - Initiate hash map var (map) with key as integer and value as string
            - initiate inc loop to run till loop var (i) is less than x.len
                > initiate int var (a) and assign last char of the word at index i
                > initiate String var (b) and assign all char except last char of the word at index i
                > add a as key and b as value in the map
            - re initiate s to map value of key val equals one
            - initiate inc loop to run till loop var (j=2) less or equals map size
                > add s + map value of key val equals j
            return s
        */
        String[] x = s.split(" ");
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < x.length; i++) {
            int a = x[i].charAt(x[i].length()-1);
            String b = x[i].substring(0, x[i].length()-1);
            map.put(a-48, b);
        }
        s = map.get(1);
        for(int j=2; j<=map.size(); j++) {
            s = s + " " + map.get(j);
        }
        return s;
    }
}