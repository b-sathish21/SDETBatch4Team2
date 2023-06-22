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
    public ListNode middleNode(ListNode head) {
        /*
        Complexity:
            Time  - O(n)
            Space - O(1)
        */
        if(head == null) return head;
        int count=0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        System.out.println("Size of the list is " + count);
        current = head;
        for(int i=0; i<(count/2); i++){
            System.out.println("--> " + current.val);
            current = current.next;
        }
        return current;
    }
}