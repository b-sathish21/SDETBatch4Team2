class Solution {
    public int romanToInt(String s) {
        //Complexity: Time - O(n) & O(1)
        /*
        travel through the length of the string on backwards
        [since numbers are read from one's ten's,... format]
            validate the current index char is 'V'
                the val is one    
            validate the current index char is 'V' or 'X'
                then val is 'V' - 5 & 'X' - 10
                validate there is one more char previous to it and the char of it is 'I'
                    then reduce the val by one
            validate the current index char is 'L' or 'C'
                then val is 'L' - 50 & 'C' - 100
                validate there is one more char previous to it and the char of it is 'X'
                    then reduce the val by ten
            validate the current index char is 'D' or 'M'
                then val is 'D' - 500 & 'M' - 1000
                validate there is one more char previous to it and the char of it is 'C'
                    then reduce the val by hundred
            then add the sum plus val and store back to sum
        return sum
        */
        int temp = 0, sum = 0;
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == 'I') temp = 1;
            else if(c == 'V') {
                temp = 5;
                if(i-1 >= 0 && s.charAt(i-1) == 'I') {
                    temp--;
                    i--;
                }
            }
            else if(c == 'X') {
                temp = 10;
                if(i-1 >= 0 && s.charAt(i-1) == 'I') {
                    temp--;
                    i--;
                }
            }
            else if(c == 'L') {
                temp = 50;
                if(i-1 >= 0 && s.charAt(i-1) == 'X') {
                    temp -= 10;
                    i--;
                }
            }
            else if(c == 'C') {
                temp = 100;
                if(i-1 >= 0 && s.charAt(i-1) == 'X') {
                    temp -= 10;
                    i--;
                }
            }
            else if(c == 'D') {
                temp = 500;
                if(i-1 >= 0 && s.charAt(i-1) == 'C') {
                    temp -= 100;
                    i--;
                }
            }
            else if(c == 'M') {
                temp = 1000;
                if(i-1 >= 0 && s.charAt(i-1) == 'C') {
                    temp -= 100;
                    i--;
                }
            }
            sum += temp;
        }
        return sum;
    }
}