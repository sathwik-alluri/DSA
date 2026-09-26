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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        /*
        Bruteforce:
        Put all the elements into the array
        Sort the array
        Create new Linked list using the sorted array

        TC: O(n*m) + O(n*m logn*m) + O(n*m)
        SC: O(2 * n*m) -- For array to store elements and then to create new LL
        */


        //Optimal:
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0);
    }

    public ListNode helper(ListNode[] lists, int i) 
    {
        // base case: last list, nothing after it to merge
        if (i == lists.length - 1) 
            return lists[i];

        ListNode mergedRest = helper(lists, i + 1);   // merge everything after i first
        return merge2Lists(lists[i], mergedRest);     // merge current list with the rest
    }

    public ListNode merge2Lists(ListNode head1, ListNode head2)
    {
        ListNode dummy=new ListNode(-1);
        ListNode dum=dummy;

        ListNode temp1=head1;
        ListNode temp2=head2;

        while(temp1!=null && temp2!=null)
        {
            if(temp1.val <= temp2.val)
            {
                dum.next=temp1;
                dum=temp1;
                temp1=temp1.next;
            }
            else
            {
                dum.next=temp2;
                dum=temp2;
                temp2=temp2.next;
            }
        }

        if(temp1!=null)
        {
            dum.next=temp1;
        }
        if(temp2!=null)
        {
            dum.next=temp2;
        }
        return dummy.next;
    }
}