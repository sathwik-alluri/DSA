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
class Solution {
    public boolean isBalanced(TreeNode root) 
    {
        // if(root==null)          //TC:O(n) * O(n)
        //     return true;
        
        // int lh=height(root.left);
        // int rh=height(root.right);
        // return Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right); 

        int height=heightwithBalancedCheck(root);
        if(height!=-1)
            return true;
        else
            return false;
    }

    public int heightwithBalancedCheck(TreeNode root) 
    { 
        if(root==null)
            return 0;
        
        int lh=heightwithBalancedCheck(root.left);
        int rh=heightwithBalancedCheck(root.right);

        if(lh == -1) return -1;
        if(rh == -1) return -1;

        if(Math.abs(lh-rh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);
    }

    public int height(TreeNode root) 
    { 
        if(root==null)
            return 0;
        
        int lh=height(root.left);
        int rh=height(root.right);
        return 1 + Math.max(lh, rh);
    }
}