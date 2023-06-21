class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
    // Write your code here
    int count = 0, i=0;
    int bal = s.length() % 3;
    
    for(; i<s.length()-bal; i+=3){
        if(s.charAt(i) != 'S') count++;
        if(s.charAt(i+1) != 'O') count++;
        if(s.charAt(i+2) != 'S') count++;
    }
    if(bal != 0){
        if(s.charAt(i++) != 'S') count++;
        if(i<s.length() && s.charAt(i) != 'O') count++;
    }    
    return count;
    }

}