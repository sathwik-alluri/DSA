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
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode oddHead=null;
        ListNode odd=null;
        ListNode evenHead=null;
        ListNode even=null;
        ListNode temp=head;

        int c=0;
        while(temp!=null)
        {
            // ListNode next = temp.next;  // Save next node
            // temp.next = null;           // Disconnect current node

            c+=1;
            if(c%2 != 0)
            {
                if(oddHead==null)
                {
                    oddHead=temp;
                    odd=oddHead;
                }
                else
                {
                    odd.next=temp;
                    odd=temp;
                }
            }
            else
            {
                if(evenHead==null)
                {
                    evenHead=temp;
                    even=evenHead;
                }
                else
                {
                    even.next=temp;
                    even=temp;
                }
            }
            // temp=next;
            temp=temp.next;
        }
        odd.next=evenHead;

        even.next=null;

        return oddHead;
    }
}