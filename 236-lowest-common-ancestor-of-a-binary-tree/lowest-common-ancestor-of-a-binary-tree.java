/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root==null)        //TC:O(n) and SC:O(n)- Aux space used by recursion
            return null;

        TreeNode l=lowestCommonAncestor(root.left, p, q);
        TreeNode r=lowestCommonAncestor(root.right, p, q);

        if(root == p || root == q)
            return root;

        if(l==null)
            return r;
        if(r==null)
            return l;
        else         //if(l==null && r!=null)
            return root;
    }
}