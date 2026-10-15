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
    public int maxPathSum(TreeNode root) 
    {
        int[] maxSum=new int[1];
        maxSum[0]=-99;
        maxDepth(root, maxSum);

        return maxSum[0];
        
    }
    public int maxDepth(TreeNode root, int[] maxSum) 
    {        
        if(root==null)
            return 0;
        
        int ls=maxDepth(root.left, maxSum);
        int rs=maxDepth(root.right, maxSum);

        if(ls<0)
            ls=0;
        if(rs<0)
            rs=0;

        maxSum[0] = Math.max(maxSum[0], root.val + ls + rs);

        return root.val + Math.max(ls, rs);
    }
}