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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next==null)
            return head;

        int len=1;
        ListNode tail=head;
        while(tail.next!=null)
        {
            tail=tail.next;
            len++;
        }

        k=k%len;

        if(k == 0)
            return head;

        tail.next=head;
        ListNode temp=head;
        ListNode next=temp.next;
        for(int i=0;i<len-k-1;i++)
        {
            temp=temp.next;
            next=next.next;
        }
        temp.next=null;
        head=next;
        return head;
    }
}