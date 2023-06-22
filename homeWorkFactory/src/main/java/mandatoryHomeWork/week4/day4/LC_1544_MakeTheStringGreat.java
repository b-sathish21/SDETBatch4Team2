class Solution {
    public String makeGood(String s) {
        /**
        find the char is small or caps

         */
        int i=0;
        for(; i<s.length()-1; i++){
            int f = 0, a = 0, b = 0;
            System.out.println(s.charAt(i) + " -- " + s.charAt(i+1) + " ==> " + s.length());

            if(s.charAt(i)>96 && s.charAt(i+1)<96) {
                a = s.charAt(i);
                b = s.charAt(i+1);
                f = 1;
            }
            else if(s.charAt(i)<96 && s.charAt(i+1)>96) {
                b = s.charAt(i);
                a = s.charAt(i+1);
                f = 1;
            }
            System.out.println(f + "---> ");
            if(f==1){
                System.out.println(a + " == " + b);
                a = a-96;
                b = b-64;
                System.out.println(a + " == " + b);
                if(a == b){                    
                    if(i == 0){
                        System.out.println("i == 0");
                        if(s.length()>2) s = s.substring(2);
                        else s = "";
                    } 
                    else if(i==s.length()-2) s = s.substring(0,i);
                    else s = s.substring(0,i)+s.substring(i+2);
                    i=-1;
                }
            }
            System.out.println(s + " --> " + i + " ==> " + s.length());
        }
        System.out.println(s + " --> " + i + " ==> " + s.length());
        return s;
    }
}