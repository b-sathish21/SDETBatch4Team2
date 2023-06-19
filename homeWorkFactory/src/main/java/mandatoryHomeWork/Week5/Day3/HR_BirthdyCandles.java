public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
    /*
    initate max and count as zero
    run through the array to find the maximum val and store in max
    run through the array to find the occurence of max and store in count
    return count
    -----------------------------------------------------------
    Complexity: Time - O(n) | Space - O(1)
    */
    int max = 0, count = 0;
    for(int i=0; i<candles.size(); i++){
        if(max<candles.get(i)) max = candles.get(i);
    }
    for(int i=0; i<candles.size(); i++){
        if(max == candles.get(i)) count++;
    }
    return count;
    }