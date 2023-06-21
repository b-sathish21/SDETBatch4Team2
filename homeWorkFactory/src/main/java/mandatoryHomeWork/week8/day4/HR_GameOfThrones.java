class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
    // Write your code here
    /*
    * Validate if an char occurence is single 
    * then there are no other char count with single 
    * or only one char count is in odd
    */
        HashMap<Character, Integer> m = new HashMap<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(m.containsKey(c)) m.put(c, m.get(c) + 1);
            else m.put(c, 1);
        }
        for(Map.Entry<Character,Integer> k : m.entrySet()){
            System.out.println(k.getKey() + " == " + k.getValue());
            ar.add(k.getValue());
        }
        Collections.sort(ar);
        int f = 0;
        for(int i=0; i<ar.size(); i++){
            if(ar.get(i) == 1 && ar.get(i+1) == 1) return "NO";
            else if(ar.get(i) % 2 != 0) f++;
            if(f > 1) return "NO";
        }
        return "YES";
    }

}
