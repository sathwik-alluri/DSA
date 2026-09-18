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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        if(length(l2) > length(l1))
        {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode prev = null;
        int carry=0;

        while(temp2!=null)
        {
            temp1.val=temp1.val + temp2.val + carry;

            if(temp1.val >= 10)
            {
                int t=temp1.val;
                temp1.val = temp1.val%10;
                carry=t/10;
            }
            else
                carry=0;

            prev=temp1;
            temp2=temp2.next;
            temp1=temp1.next;
        }
        
        if(carry > 0)
        {
            while(temp1!=null)
            {
                temp1.val=temp1.val + carry;

                if(temp1.val < 10)
                {
                    carry=0;
                    break;
                }
                else    // if(temp1.val >= 10)
                {
                    int t=temp1.val;
                    temp1.val = temp1.val%10;
                    carry=t/10;
                }
                prev=temp1;
                temp1=temp1.next;
            }
        }

        if(carry > 0)
        {
            ListNode newNode = new ListNode(1);
            prev.next=newNode;
        }
        return l1;
    }

    public int length(ListNode head)
    {
        int count = 0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
}