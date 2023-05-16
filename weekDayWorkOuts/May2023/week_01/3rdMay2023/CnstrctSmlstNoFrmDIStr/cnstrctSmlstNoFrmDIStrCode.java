class Solution {
    public String smallestNumber(String s) {
        //Time Complexity  --> O(n log n)
        //Space Complexity --> O(n)
        String op = "";
        int i = 1;
        for(;i<=s.length()+1;i++) op=op+i;
        int j=0;
        for(;j<s.length();j++){
            System.out.println("output is " + op);
            if(s.charAt(j)=='D'){
                int k=j, c=0;
                for(;k<s.length(); k++){
                    if(s.charAt(k)=='I') break;
                    else c++;
                }
                System.out.println("total 'D' count is " + c + "\n Kth position is " + k);
                String d = op.substring(k,k+1);
                int a = Integer.parseInt(d);
                for(;c>=0;c--) {
                    System.out.println("loop " + c + ":- " + op + " - " + a + " - " + j);
                    op=op.substring(0,j++)+(a)+op.substring(j);
                    a--;
                }
                j--;
            }
        }
        return op;
    }
}