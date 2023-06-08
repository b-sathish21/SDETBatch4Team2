class Solution {
    public int numSpecial(int[][] mat) {
        //Complexity: Time - O(n * m * k) & Space - O(1)
        int cnt = 0;
         for(int i=0; i<mat.length; i++){
             int f = 0;
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 1) {
                    f++;
                    for(int k=0; k<mat.length; k++){
                        if(k != i){
                            if(mat[k][j] == 1) f++;
                        }
                    }
                }
            }
            if(f==1) cnt++;
        }
        return cnt;
    }
}

/*
First Solution
--------------
Complexity: Time - O(n * m) & space - O(n)
int[] rw = new int[mat.length], clm = new int[mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 1) {
                    rw[i]++;
                    clm[j]++;
                }
                System.out.println("--> Row("+i+"): " + rw[i] + " Column("+j+"): " + clm[j]);
            }
        }
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 1 && rw[i] == 1 && clm[j] == 1) {
                    cnt++;
                }
            }
        }
        */