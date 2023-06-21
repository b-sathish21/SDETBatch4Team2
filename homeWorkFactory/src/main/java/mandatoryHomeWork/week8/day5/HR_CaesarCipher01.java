class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
     //ASCII - A==65 | Z==90 | a==97 | z==122
    StringBuilder sb = new StringBuilder();
    while(k >= 27) k = k - 26;
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c>64 && c<91 || c>96 && c<123){            
            int a = c+k;
            if((c>64 && c<91) && (a>90)) sb.append((char)(a-26));
            else if((c>96 && c<123) && (a>122)) sb.append((char)(a-26));
            else sb.append((char)(c+k));
        }
        else sb.append(c);
    }
    return sb.toString();
    }

}