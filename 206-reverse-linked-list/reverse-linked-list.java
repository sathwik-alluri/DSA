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
    public ListNode reverseList(ListNode head) 
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode ne = head.next;

        while(ne != null)
        {
            head.next = prev;
            prev = head;
            head = ne;
            ne = ne.next;
        }

        head.next = prev;   // Reverse the last node
        return head;        // head is now the new head
    }
}