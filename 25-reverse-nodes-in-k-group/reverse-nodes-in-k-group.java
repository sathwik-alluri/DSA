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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(k==1)
            return head;
            
        ListNode s=head;
        ListNode e=head;
        ListNode ep=null;
        ListNode sp=null;
        ListNode ansHead=head;
        ListNode temp=head;

        while(e!=null)
        {
            for(int i=0;i<k;i++)
            {
                ep=e;
                e=e.next;
                if(e==null && i<k-1)
                    return ansHead;
            }
            ListNode revHead=reverse(s, ep);

            if(ansHead == head)
                ansHead=revHead;

            s.next=e;
            if(sp!=null)
            {
                sp.next=ep;
            }
            sp=s;
            s=e;
        }
        return ansHead;
    }

    public ListNode reverse(ListNode start, ListNode end) 
    {
        ListNode stop = end.next;
        ListNode temp = start;
        ListNode prev = null;
        while(temp != stop)
        {
            ListNode next = temp.next;

            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}