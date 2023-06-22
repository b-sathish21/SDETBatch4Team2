class Solution {
    public boolean checkXMatrix(int[][] grid) {
        //Complexity: Time - O(n * m) & Space - O(1)
        for(int i=0, j=grid.length-1; i<grid.length; i++, j--){
            if(grid[i][i] !=0 && grid[i][j] !=0){
                for(int k=0; k<grid.length; k++){
                    if(k!=i && k!=j){
                        if(grid[i][k] != 0) return false;
                    }
                }
            }
            else return false;
        }
        return true;
    }
}