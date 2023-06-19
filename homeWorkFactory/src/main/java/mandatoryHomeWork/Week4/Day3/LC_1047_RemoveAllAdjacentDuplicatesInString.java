class Solution {
    public String removeDuplicates(String s) {
        /**
        Time: O(n)
        Space: O(1)
         */
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                if(i==0){
                    if(s.length()>2) s=s.substring(2);
                    else return "";
                } 
                else s = s.substring(0,i) + s.substring(i+2);
                i=-1;
            }
        }
        return s;
    }
}