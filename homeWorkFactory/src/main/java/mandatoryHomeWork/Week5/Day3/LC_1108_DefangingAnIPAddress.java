class Solution {
    public String defangIPaddr(String address) {

        /**
        initiate an stringbuilder result
        initiate an loop to travel through address
            Validate current char equals "."
                then add "[.]" to result
            else add the current char to result
        return result
        ---------------------------------------
        Complexity: Time - O(n) | Space - O(n)
         */
        StringBuilder result = new StringBuilder();
        for(int i=0; i<address.length(); i++){
            if(address.charAt(i) == '.') result.append("[.]");
            else result.append(address.charAt(i));
        }
        return result.toString();
    }
}