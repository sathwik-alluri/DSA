/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BSTIterator
{
    Stack<TreeNode> st=new Stack<>();
    boolean isReverse=true;

    //isReverse == true -> Before (Large)
    //isReverse == false -> Next (Smaller)

    BSTIterator(TreeNode root, boolean reverse)
    {
        isReverse = reverse;
        pushAll(root);
    }

    public void pushAll(TreeNode root)
    {
        TreeNode curr=root;
        while(curr!=null)
        {
            st.push(curr);
            if(isReverse == false)
                curr=curr.left;
            else
                curr=curr.right;
        }  
    }
    
    public int next()
    {
        TreeNode node=st.pop();
        if(isReverse == false)
            pushAll(node.right);
        else
          pushAll(node.left);  
        return node.val;
    }

    public boolean hasNext()
    {
        return !st.isEmpty();
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) 
    {
        if(root == null)
            return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r=new BSTIterator(root, true);

        int i=l.next();
        int j=r.next();
        while(i<j)
        {
            if(i+j == k)
                return true;
            else if(i+j > k)
                j=r.next();
            else
                i=l.next();
        }
        return false;
    }
}