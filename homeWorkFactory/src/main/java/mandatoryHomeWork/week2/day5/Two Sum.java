Two Sum
=======
class Solution {
    public int[] twoSum(int[] n, int k) {
        /*
        inititate i, j, flag
        initiate outer loop to travel through the array length
            initiate inner loop to travel through the array length
                validate outer loop var (i) is not equal to inner loop var (j)
                    add and store sum of val of array at index i & j in var (r)
                    validate target val equals r
                        raise flag and break the loop
            validate flag is raised
                break the loop
        store i & j in an array var (op)
        return op
        Big O Notation
            Time  - O(n^2)
            space - O(n)
        */
        int i=0, j=0, f=0;
        for(; i<n.length; i++){
            for(j=0; j<n.length; j++){
                if(j!=i){
                int r = n[i] + n[j];
                    if(k==r) {
                        f = 1;
                        break;
                    }
                }
            }
            if(f==1) break;
        }
        int[] op = {i,j};
        return op;
    }
}