class Solution {
    public String reverseOnlyLetters(String s) {
        /*
        Complexity: Time - O(n) & Space - O(1)
        */
        for(int i=0, j=s.length()-1; i<j; ){
            //A==65 | Z==90 | a==97 | z==122
            int a=0, b=0;
            if((s.charAt(i)>64 && s.charAt(i)<91) || (s.charAt(i)>96 && s.charAt(i)<123)) a=1;
            if((s.charAt(j)>64 && s.charAt(j)<91) || (s.charAt(j)>96 && s.charAt(j)<123)) b=1;
            
            if(a==0 && b==1) i++;
            else if(a==1 && b==0) j--;
            else if(a==1 && b==1){
                if(i==0){
                    if(j==s.length()-1) s = s.substring(j)+s.substring(i+1,j)+s.substring(i,i+1);
                    else s = s.substring(j,j+1)+s.substring(i+1,j)+s.substring(i,i+1)+s.substring(j+1);
                } 
                else if(i != 0 && j==s.length()-1){
                    s = s.substring(0,i) + s.substring(j,j+1) + s.substring(i+1,j) + s.substring(i,i+1);
                }
                else s = s.substring(0,i)+s.substring(j,j+1)+s.substring(i+1,j)+s.substring(i,i+1)+s.substring(j+1);
                i++;
                j--;
            } 
            else if(a==0 && b==0){
                i++; j--;
            }
        }
        return s;
    }
}