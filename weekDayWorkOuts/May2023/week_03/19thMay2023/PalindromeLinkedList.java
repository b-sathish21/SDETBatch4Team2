/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        /**
        Time: O(log n);
        space: O(1)
         */

        //get the size of the list
        ListNode l = head;
        int c = 0;
        while(l != null){
            l = l.next;
            c++;
        }
        System.out.println("Size: " + c);
        //travel till half the size of the list
        l = head;
        for(int i=0, k=c; i<c/2; i++){
            ListNode r = head;
            k--;
            // travel till last and reduce by one
            for(int j=0; j<k; j++) r = r.next;
            System.out.println(l.val + " == " + r.val);
            // validate left == right
            if(l.val != r.val) return false;
            l = l.next;
        }
        return true;
    }
}