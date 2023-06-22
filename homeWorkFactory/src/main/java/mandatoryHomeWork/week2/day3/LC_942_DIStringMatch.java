class Solution {
    public int[] diStringMatch(String s) {
        //Time Complexity  --> O(n)
        //Space Complexity --> O(n)
        int i=0, min=0, max = s.length()+1;
        int[] op = new int[max];
        System.out.print("[");
        for(;i<s.length(); i++){
            if(s.charAt(i)=='I') op[i]=min++;
            else op[i]=--max;
            System.out.print(op[i] + ", ");
        }
        if(s.charAt(i-1)=='I') op[i]=--max;
        else op[i] = min;
        System.out.print(op[i] + "]");
        return op;
    }
}