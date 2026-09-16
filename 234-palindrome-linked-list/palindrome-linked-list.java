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
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null || head.next==null)
            return true;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode revhead=reverseList(slow);
        
        while(head!=null && revhead!=null)
        {
            if(head.val != revhead.val)
                return false;
            head=head.next;
            revhead=revhead.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) 
    {
        if(head==null || head.next==null)
            return head;
        
        //ListNode curr = head;
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