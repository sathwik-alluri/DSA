/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int l1=getLength(headA);
        int l2=getLength(headB);

        ListNode s=headA;
        ListNode f=headB;

        if(l1 >= l2)
        {
            int d=l1-l2;
            for(int i=0;i<d;i++)
            {
                s=s.next;
            }
            while(s!=null && f!=null)
            {
                if(s==f)
                    return s;
                else
                {
                    s=s.next;
                    f=f.next;
                }
            }
        }
        else
        {
            int d=l2-l1;
            for(int i=0;i<d;i++)
            {
                f=f.next;
            }
            while(s!=null && f!=null)
            {
                if(s==f)
                    return s;
                else
                {
                    s=s.next;
                    f=f.next;
                }
            }
        }
        return null;
    }

    public int getLength(ListNode head) 
    {
        // code here
        ListNode t=head;
        int c=0;
        while(t!=null)
        {
            c++;
            t=t.next;
        }
        return c;
    }
}