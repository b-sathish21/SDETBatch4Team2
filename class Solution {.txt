class Solution {
    public boolean isLongPressedName(String name, String typed) {
		/*
		* Complexity:
		*	Time  - O(n)
		*	Space - O(1)		
		*/
        if(name.length() > typed.length()) return false;
        int i=0, j=0;
        for(; j<typed.length(); j++){
            System.out.println("Loop: " + j + " ==> " + name.charAt(i) + " -- " + typed.charAt(j));         
            if(name.charAt(i)!=typed.charAt(j)){
                System.out.println("First if " + name.charAt(i) + " -/- " + typed.charAt(j));
                if(i==0 && j==0) return false;
                if(i == name.length()-1){
                    if(j == typed.length() -1 || name.charAt(i)!=typed.charAt(j + 1)) return false;
                }
                if(name.charAt(++i)!=typed.charAt(j)){
                    System.out.println("Second if " + name.charAt(i) + " -/- " + typed.charAt(j));
                    return false;
                }
                j--;
            }
            else if(i<name.length()-1){
                if( name.charAt(i) == name.charAt(i+1)){
                    System.out.println("First if " + name.charAt(i) + " == " + name.charAt(i+1));
                    if(typed.charAt(j) == typed.charAt(j+1)){
                        System.out.println("First if " + typed.charAt(j) + " == " + typed.charAt(j+1));
                        i++;
                    }
                }
            } 
        }
        System.out.println(i + " -- " + j);
        if(i<name.length()-1 && j==typed.length()) return false;
        return true;
    }
}