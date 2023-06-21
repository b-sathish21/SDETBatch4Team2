class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    // Write your code here
    int count = 0;
    
    int lft = 0, rt = s.length()-1;
    for(; lft < rt; lft++){
        String s1 = "";
        
        for(int i=lft; i<rt; i++){
            // System.out.println("Loop: " + i);
            s1 += s.charAt(i);
            
            HashMap<Character, Integer> map = new HashMap<>();
            for(int x=0; x<s1.length(); x++){
                if(map.containsKey(s1.charAt(x))) map.put(s1.charAt(x), map.get(s1.charAt(x)) + 1);
                else map.put(s1.charAt(x), 1);
            }
            
            // for(Character c : map.keySet()) System.out.println(c + " == " + map.get(c));
            // System.out.println("<----->");
            
            String s2 = "";
            int j=0, k=lft+1, flag=0;
            for(; j<s1.length(); j++, k++) s2 += s.charAt(k);
            
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int a=0; a<s2.length(); a++){
                if(map2.containsKey(s2.charAt(a))) map2.put(s2.charAt(a), map2.get(s2.charAt(a)) + 1);
                else map2.put(s2.charAt(a), 1);
            }
            
            for(Character c : map2.keySet()) {
                // System.out.println(c + " == " + map2.get(c));
                if(map.containsKey(c)) {
                    // System.out.println(map.get(c) + " == " + map2.get(c));
                    if(map.get(c) == map2.get(c)) flag++;
                }
            }
            if(flag == map2.size()) count++;
            flag=0;
            
            while(k < s.length()){
                s2 += s.charAt(k++);
                s2 = s2.substring(1);
                map2 = new HashMap<>();
                for(int a=0; a<s2.length(); a++){
                    if(map2.containsKey(s2.charAt(a))) map2.put(s2.charAt(a), map2.get(s2.charAt(a)) + 1);
                    else map2.put(s2.charAt(a), 1);
                }
                for(Character c : map2.keySet()) {
                    // System.out.println(c + " == " + map2.get(c));
                    if(map.containsKey(c)) {
                        // System.out.println(map.get(c) + " == " + map2.get(c));
                        if(map.get(c) == map2.get(c)) flag++;
                    }
                }
                if(flag == map2.size()) count++;
                flag=0;
                // System.out.println("<====----Count----====>" + count);
            }
        }
    }
    
    // System.out.println("----------------");
    return count;
    }

}