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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode prev = head;        
        if(prev != null && prev.next != null){
            while(prev != null && prev.val == val) {
                System.out.println("prev Val make null: " + prev.val);
                prev = prev.next;
            }
            if(prev == null) return null;
            ListNode curr = prev.next;
            System.out.println("--Prev val: " + prev.val);
            System.out.println("--Current val: " + curr.val);
            while(curr != null){
                if(curr.val == val){
                    prev.next = curr.next;
                }
                prev = curr;
                System.out.println("Prev val: " + prev.val);
                curr = curr.next;
                if(curr != null) System.out.println("Current val: " + curr.val);
            }
        }
        return head;
    }
}