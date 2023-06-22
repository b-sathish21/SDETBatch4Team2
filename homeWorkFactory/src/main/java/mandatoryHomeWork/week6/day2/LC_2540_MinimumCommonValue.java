class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        /*
        Complexity: Time - O(n) & Space - O(1)
        */
        int min = -1, i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]!=nums2[j]){
                if(nums1[i]<nums2[j]) i++;
                else j++;
            }
            else{
                min = nums1[i];
                break;
            }
        }
        return min;
    }
}