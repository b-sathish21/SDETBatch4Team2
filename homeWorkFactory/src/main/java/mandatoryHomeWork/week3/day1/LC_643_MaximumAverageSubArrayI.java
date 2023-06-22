class Solution {
    public double findMaxAverage(int[] n, int k) {
        /*
        Big O Notation
            Time  - O(n)
            Space - O(1)
        Algorithm: Sliding Window
        Steps:
            > initiate s = 0, a = 0, m = 0, i = 0.
            > initiate an inc loop to add the no. till i < k
                - add and store s + n[i] to s
            > validate n.length equals k then return s
            > else 
                - assign s to m and initiate j = 0.
                - initiate loop to validate i < s.length
                    > s = s + n[i++] - n[j++]
                    > a = s/k
                    > validate a is greater than m then assign a to m
                return m
        */
        int s=0, i=0;
        double a = 0, m = 0;
        for(; i < k; i++) s += n[i];
        a = (double)s/k;
        m = a;
        if (n.length != k) {
            m = a;
            for(int j = 0; i < n.length; i++, j++){
                s = s + n[i] - n[j];
                a = (double)s/k;
                if(a>m) m = a;
            }
        }
        return m;
    }
}