public static int simpleArraySum(List<Integer> ar) {
    // Write your code here
    /*
    initate sum to zero
    run loop till list length
        add the current index val to sum
    return sum
    -----------------------------------------------------------
    Complexity: Time - O(n) | Space - O(1)
    */
    int sum=0;
    for(int i=0; i<ar.size(); i++) sum = sum + ar.get(i);
    return sum;
    }