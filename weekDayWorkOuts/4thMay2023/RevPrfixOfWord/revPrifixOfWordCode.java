class Solution {
    public String reversePrefix(String s, char ch) {
        //Time Complexity  --> O(n)
        //Space Complexity --> O(1)
        int i=0, c=0;
        for(;i<s.length(); i++){
            if(s.charAt(i)==ch){
                c++;
                break;
            }
        }
        if(c>0){
            for(int j=0; j<=i; j++, i--){
                if(j==0 && j!=i){
                    s=s.substring(i,i+1) + s.substring(j+1,i) + s.substring(j,j+1) + s.substring(i+1);        
                }
                else if (j==i){
                    s=s;
                }
                else{
                    s=s.substring(0,j) + s.substring(i,i+1) + s.substring(j+1,i) + s.substring(j,j+1) + s.substring(i+1);
                }    
            }
        }
        return s;
    }
}