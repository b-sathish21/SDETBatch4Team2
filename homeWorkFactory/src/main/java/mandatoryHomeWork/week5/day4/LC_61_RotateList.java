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
    public ListNode rotateRight(ListNode head, int k) {
        /**
        get the size of the listnode and sore in size
        validate size is less than two return head
        assign head to new node a
        run the loop till the size - 1 to stand in the last place before null
        assign the last place next position to head to make it circular node
        run the loop till size - k to stand in the place of kth node
        assign kth next node to head and make null to kth next node
        return head
        ---------------------------------------------------------------------
        Complexity: Time - O(n) | Space - O(n)
        */
        if(head != null && head.next != null){
            int size = 0;
            ListNode a = head;
            while(a != null){
                size++;
                a = a.next;
            }
            while(size < k) k = k-size; // if size is less assign k as k - size
            a = head;
            for(int i=1; i<size; i++) a = a.next;
            a.next = head;
            for(int i=0; i<size-k; i++) a = a.next;
            head = a.next;
            a.next = null;
        }
        return head;
    }
}