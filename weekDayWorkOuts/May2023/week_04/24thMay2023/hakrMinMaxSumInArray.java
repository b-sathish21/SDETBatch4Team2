public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    /*
    initiate sum of long datatype
    add all the val in the array by running an loop and store in sum
    initiate long data type variable min and max
    run loop till array length
        initiate check variable to store sum minus current index val
        validate min is greater than check
            assign check to min
        validate max is less than check
            assign check to max
    print min space max
    -----------------------------------------------------------
    Complexity: Time - O(n) | Space - O(1)
    */
    long sum = 0;
    for(int i=0; i<arr.size(); i++) sum = sum + arr.get(i);
    long min = sum, max = 0;
    for(int i=0; i<arr.size(); i++){
        long check = sum - arr.get(i);
        if(min > check) min = check;
        if(max < check) max = check;
    }
    System.out.println(min + " " + max);
    }