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
class Solution 
{
    public boolean isValidBST(TreeNode root) 
    {
        // Stack<TreeNode> st = new Stack<>();    //This invidual node check will fail for certail examples like [5,4,6,null,null,3,7] Expected Output - False
        // TreeNode curr = root;
        // while (curr != null || !st.isEmpty()) 
        // {
        //     while (curr != null) 
        //     {
        //         st.push(curr);
        //         curr = curr.left;
        //     }

        //     curr = st.pop();
        //     if(curr.left!=null && curr.val <= curr.left.val)
        //             return false;
        //     if(curr.right!=null && curr.val >= curr.right.val)
        //             return false;

        //     curr = curr.right;
        // }
        // return true;

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long minRange, long maxRange) 
    {
        if(root == null)
            return true;
        
        if(root.val <= minRange || root.val>=maxRange)
            return false;
        
        return helper(root.left, minRange, root.val) && helper(root.right, root.val, maxRange);
    }
}