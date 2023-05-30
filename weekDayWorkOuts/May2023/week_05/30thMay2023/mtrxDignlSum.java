class Solution {
    public int diagonalSum(int[][] mat) {
        /*
        Complexity: Time - O(n) & Space - O(1)
        */
        int s = 0;
        for(int i=0, k=mat[i].length-1; i<mat.length; i++, k--){
            if(i==k) s = s + mat[i][i];
            else s = s + mat[i][i] + mat[i][k];
        }
        return s;
    }
}