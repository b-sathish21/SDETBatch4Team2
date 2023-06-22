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
    public ListNode swapPairs(ListNode head) {
        /*
        Complexity: Time - O(n) & Space - O(1)
        */
        if(head == null || head.next == null) return head;
        //Assign tripple node
        ListNode prev = head, cur = head.next, nxt = cur.next;
        //interchange the first two node and keep the second node as head
        prev.next = nxt;
        cur.next = prev;
        //validate there is third node and assign to nxt var node
        if(prev.next == null) return cur;
        nxt = prev.next;
        while(nxt != null && nxt.next != null){
            //prev is one node prev to swap node nxt
            //point the next node of prev to second next node of prev thus sepearating middle node
            prev.next = prev.next.next;
            //shift prev node by one step
            prev = prev.next;
            //repoint next node of nxt to next node of prev
            nxt.next = prev.next;
            //point the next node of prev to nxt node
            prev.next = nxt;
            //shift prev & nxt by one step
            prev = prev.next;
            nxt = prev.next;
        }
        return cur;
    }
}