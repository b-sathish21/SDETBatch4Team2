class Result {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    // Write your code here
    int count = 0, tc1 = 0, tc2 = 0, s1 = 0, s2 = 0, i = 0, j = 0;
    
    for(; i<a.size(); i++){
        s1 += a.get(i);
        if(s1 <= maxSum) tc1++;
        else{
            s1 -= a.get(i--);
            break;
        }
    }
    System.out.println("First Stack valid count: " + tc1);
    System.out.println("Sum: " + s1);
    for(; j<b.size(); j++){
        s2 += b.get(j);
        if(s2 <= maxSum) tc2++;
        else{
            s2 -= b.get(j--);
            break;
        }
    }
    System.out.println("Second Stack valid count: " + tc2);
    System.out.println("Sum: " + s2);
    if(tc1 <= tc2) {
        //play with stack 2 as constant
        for(int k=0; k<tc1; ){
            while(s2 <= maxSum && k<tc1){
                s2 += a.get(k++);
                if(s2 > maxSum){
                    if(count < tc2) count = tc2;
                }
                tc2++;
            }
            if(k == tc1 && s2 <= maxSum){
                if(count < tc2) count = tc2;
            }
            if(j == b.size()) j--;
            if(j < 0) break;
            s2 -= b.get(j--);
            tc2--;
        }
    }
    else {
        //play with stack 1 as constant
        for(int k=0; k<tc2; ){
            while(s1 <= maxSum && k<tc2){
                s1 += b.get(k++);
                if(s1 > maxSum){
                    if(count < tc1) count = tc1;
                }                
                tc1++;
                if(k == tc2 && s1 < maxSum && count < tc1){
                    count = tc1;
                    break;
                }
            }
            if(k == tc2 && s1 <= maxSum){
                if(count < tc1) count = tc1;
            }
            if(i == a.size()) i--;
            if(i < 0) break;
            s1 -= a.get(i--);
            tc1--;
        }
    }
    System.out.println("After juggling, count: " + count);
    /*---Parrallel Count---*/
    int x=0, y=0, s3 = 0, tc = 0, flgA = 0, flgB = 0;
    while(x<a.size() && y<b.size()){
        if(a.get(x) <= maxSum && flgA < 1) {
            s3 += a.get(x);
            if(s3 <= maxSum && flgA < 1) {
                tc++;
                x++;
            }
            else {
                s3 -= a.get(x);
                flgA++;
            }
        }
        else flgA++;
        if(b.get(y) <= maxSum && flgB < 1) {
            s3 += b.get(y);
            if(s3 <= maxSum && flgB < 1) {
                tc++;
                y++;
            }
            else {
                s3 -= b.get(y);       
                flgB++;
            }
        }
        else flgB++;
        if(flgA > 0 && flgB > 0) break;
    }
    while(x < a.size() && flgA < 1){
        if(a.get(x) <= maxSum) s3 += a.get(x);
        if(s3 <= maxSum) {
            tc++;
            x++;
        }
        else break;
    }    
    while(y < b.size() && flgB < 1){
        if(b.get(y) <= maxSum) s3 += b.get(y);
        if(s3 <= maxSum) {
            tc++;
            y++;
        }
        else break;
    }
    System.out.println("parallel count: " + tc);
    
    if(count <= tc) count = tc;
    
    return count;
    }
}