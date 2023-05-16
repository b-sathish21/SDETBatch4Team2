class Solution {
    public String reverseWords(String s) {        
        //Time Complexity  --> O(n X m)
        //Space Complexity --> O(n)
        StringBuilder S = new StringBuilder(s);
        int i=0, j=0, k=0, f=0;
        char spc = ' ';
        for(; i<s.length(); i++){
            if(s.charAt(i) == spc){
                k = i-1;
                f = 1;
            }
            else if(i==S.length()-1){
                k = i;
                f = 1;
            }
            if(f==1){
                for(; j < k; j++, k--){
                    char a = s.charAt(j), b = s.charAt(k);
                    S.setCharAt(j, b);
                    S.setCharAt(k, a);
                }
                j = i + 1;
                f = 0;
            }
        }        
        return S.toString();
    }
}