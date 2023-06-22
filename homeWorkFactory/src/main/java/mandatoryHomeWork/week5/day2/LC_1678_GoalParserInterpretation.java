class Solution {
    public String interpret(String c) {
        /**
        initiate the output string(s) to empty
        run incremental loop till the length of the given command string(c)
            validate if the i'th char is 'G'
                add s + 'G' to s
            validate i'th char is '(' and i+1'th char is ')'
                add s + 'o' to s
                increment i by one
            validate i'th char is '(' and i+1'th char is 'a'
                add s + "al" to s
                increment i by 3
        return s
        ---------------------------------------------------------------------------
        Complexity:
            Time  - O(n)
            Space - O(n)
         */
        String s = "";
        for(int i=0; i<c.length(); i++){
            if(c.charAt(i) == 'G') s = s + 'G';
            if(c.charAt(i) == '(' && c.charAt(i+1) == ')'){
                s = s + 'o';
                i++;
            }
            if(c.charAt(i) == '(' && c.charAt(i+1) == 'a'){
                s = s + "al";
                i=i+3;
            }
        }
        return s;
    }
}