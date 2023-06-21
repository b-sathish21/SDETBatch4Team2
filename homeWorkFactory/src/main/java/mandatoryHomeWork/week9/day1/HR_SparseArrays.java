class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    // Write your code here
    List<Integer> op = new ArrayList<>();
    
    for(int i=0; i<queries.size(); i++){
        int cnt=0;
        for(int j=0; j<stringList.size(); j++){
            if(queries.get(i).equals(stringList.get(j))) cnt++;
        }
        op.add(cnt);
    }
    
    return op;
    }

}