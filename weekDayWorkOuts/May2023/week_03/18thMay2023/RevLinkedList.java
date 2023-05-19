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
    public ListNode reverseList(ListNode head) {
        if(head != null && head.next != null){            
            // get the size of the listnode
            ListNode curr = head;        
            int count = 0; 
            while(curr != null){
                System.out.println(curr.val + " --Loop: " + count);
                curr = curr.next;
                count++;
            }
            System.out.println("Size of the List is " + count);
            
            ListNode prev = null;
            curr = head;
            
            for(int i=0; i<count; i++){                
                System.out.println("<-- " + curr.val + " -->");
                ListNode a = curr.next; // head
                curr.next = prev;
                prev = curr;
                curr = a;
                System.out.println(prev.val);
            }            
            return prev;
        }
        else return head;        
    }
}