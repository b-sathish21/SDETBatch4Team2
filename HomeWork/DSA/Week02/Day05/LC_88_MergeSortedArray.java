class Solution {
    public void merge(int[] n1, int m, int[] n2, int n) {        
        //Time Complexity  --> O(n^2)
        //Space Complexity --> O(1)
        if(n!=0) {
            for(int i = 0;m<n1.length; i++, m++) n1[m] = n2[i];
            for(int i=0; i<n1.length; i++){
                for(int j=i+1; j<n1.length; j++){
                    if(n1[i]>n1[j]){
                        int t = n1[i];
                        n1[i] = n1[j];
                        n1[j] = t;
                    }
                }
            }
            }
        }
    }