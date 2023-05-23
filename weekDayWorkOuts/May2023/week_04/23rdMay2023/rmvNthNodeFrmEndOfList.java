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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
        - get the size
        - if size is 0 or 1 return null
        - calculate loop run i.e. size -n
        - assign head to an node
        - assign head.next to head
        - run loop till caluculated times
            - assign head to node next
            - assign node next to node
            - assign head.next to head
        - if head next is not null
            - if head.next.next is not null
                assign head next's next to node next
                assign node next to node
        return node
        ---------------------------------------------------
        Complexity:
            Time  -O(n)
            Space -O(n)
         */
        int size=0, i=0;
        ListNode c = head, a = null, b = null;
        while(c != null){
            size++;
            c = c.next;
        }
        if(size == 0 || size == 1) return null;
        else{
            /**
            run = size - n = 5 - 2 = 3
            run = size - n = 5 - 5 = 0
            run = size - n = 2 - 1 = 1
            run = size - n = 2 - 2 = 0
             */
            int run = size - n;
            if(run == 0){
                head = head.next;
                return head;
            }
            else{
                if(a==null){
                    b = a = head;
                    head = head.next;
                }
                System.out.println(head.val);
                while(head != null){
                    i++;
                    if(i < run){
                        a = a.next = head;
                    }
                    else if(head.next != null) {
                        a = a.next = head.next;
                    }
                    else a = a.next = null; 
                    head = head.next;                   
                } 
                return b;
            }
        }               
    }
}