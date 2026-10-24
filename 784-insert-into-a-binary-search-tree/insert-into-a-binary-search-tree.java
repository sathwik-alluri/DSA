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
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        TreeNode curr=root;
        if(root == null)
        {
            return new TreeNode(val);
        }

        TreeNode node=new TreeNode(val);
        while(true)
        {
            if(val > curr.val)
            {
                if(curr.right==null)
                {
                    curr.right=node;
                    break;
                }
                curr=curr.right;
            }
            else
            {
                if(curr.left==null)
                {
                    curr.left=node;
                    break;
                }
                curr=curr.left;
            }
        }
        return root;
    }
}