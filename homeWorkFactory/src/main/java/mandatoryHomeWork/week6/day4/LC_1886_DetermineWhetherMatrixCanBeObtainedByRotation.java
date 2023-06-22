class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        //complexity: Time - O(n^2) & Space - O(1)
        int f=0;

        //reading original position
        for(int i=0; i<mat.length; i++){
            for(int k=0; k<mat[i].length; k++){
                if(mat[i][k] != target[i][k]) {
                    f++;
                    System.out.println("broke - Origin");
                    break;
                }
            }
            if(f>0) break;
        }
        if(f==0) return true;
        f=0;

        //reading upside down
        for(int i=0, j=mat.length-1; i<mat.length; i++, j--){
            for(int k=0; k<mat[i].length; k++){
                if(mat[i][k] != target[j][k]) {
                    f++;
                    System.out.println("broke - upside down");
                    break;
                }
            }
            if(f>0) break;
        }
        if(f==0) return true;
        f=0;

        //reading from left bottom        
        for(int i=0, j=mat.length-1; i<mat.length; i++, j--){
            for(int k=0, l=mat.length-1; k<mat[i].length; k++,l--){
                if(mat[l][i] != target[i][k]) {
                    f++;
                    System.out.println("broke - left bottom");
                    break;
                }
            }
            if(f>0) break;
        }
        if(f==0) return true;
        f=0;

        //reading from right bottom        
        for(int i=0, j=mat.length-1; i<mat.length; i++, j--){
            for(int k=0, l=mat.length-1; k<mat[i].length; k++,l--){
                if(mat[j][l] != target[i][k]) {
                    f++;
                    System.out.println("broke - right bottom");
                    break;
                }
            }
            if(f>0) break;
        }
        if(f==0) return true;
        f=0;

        //reading from right top        
        for(int i=0, j=mat.length-1; i<mat.length; i++, j--){
            for(int k=0; k<mat[i].length; k++){
                if(mat[k][j] != target[i][k]) {
                    f++;
                    System.out.println("broke - right top");
                    break;
                }
            }
            if(f>2) break;
        }
        if(f==0) return true;

        return false;
    }
}