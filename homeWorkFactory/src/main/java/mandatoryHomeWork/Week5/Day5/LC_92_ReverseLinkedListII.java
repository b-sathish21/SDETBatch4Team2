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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //Complexity: Time - O(n) and Space - O(n)
        int sz=0, i=1, k=right;
        ListNode a = head, bfLft = null, temp = null, cur = null, prev = null;
        while(a != null){
            a = a.next;
            sz++;
        }
        // System.out.println("Size of the node is " + sz);
        if(left == right || head == null || head.next == null) return head;
        if(left != 1){
            bfLft = head;
            cur = bfLft;
            for(; i<left; i++){
                prev = cur;
                cur = cur.next;
            }
            // System.out.println(prev.val + " -- " + cur.val + " -- " + i);
        }
        while(i < k){
            temp = head;
            for(int j = 1; j < right-1; j++){
                // System.out.println("Inner Loop: " + j + " < " + right);
                temp = temp.next;
            }
            System.out.println("prev node of Node to change: " + temp.val);
            ListNode temp2 = temp.next;
            // if(temp2 != null) System.out.println("Node to change: " + temp2.val);
            // else System.out.println("Node to change: null");
            if(temp2 != null && temp2.next != null) temp.next = temp.next.next;
            
            if(bfLft == null){
                if(sz == right) temp.next = null;
                bfLft = temp2;
                prev = bfLft;
                prev.next = head;
                cur = prev.next;
                head = bfLft;
                // System.out.println("after swap bfLft Node val: " + bfLft.val);
                // System.out.println("after swap head Node val: " + head.val);
                // System.out.println("after swap prev Node val: " + prev.val);
                // System.out.println("after swap cur Node val: " + cur.val);
            }
            else{
                // System.out.println("prev Node val: " + prev.val);
                // System.out.println("cur Node val: " + cur.val);
                prev.next = temp2;
                prev = prev.next;
                prev.next=cur;
                // System.out.println("after swap prev Node val: " + prev.val);
                // System.out.println("after swap cur Node val: " + cur.val);
            }            
            k--;
        }
        if(right == sz){
            ListNode b = head;
            for(int c=1; c<sz; c++){
                b = b.next;
                //System.out.println("final Node val: " + b.val);
            }
            b.next = null;
        }        
        //System.out.println("----------Completed----------------");
        return bfLft;
    }
}