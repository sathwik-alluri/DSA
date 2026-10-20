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
    public int countNodes(TreeNode root)    //TC : O(logn) * O(logn) == O(logn ^2) -- We are traversing the height of tree will is logn and for each of that node we will becalculating height which is again logn
    {
        if(root==null)
            return 0;
        
        int lh=leftHeight(root);;
        int rh=rightHeight(root);

        if(lh==rh)
            return (int)Math.pow(2, lh + 1) - 1;    //Why lh+1 - We need to calculate the levels rather than height. Including the root node we have lh+1 nodes. lh will be calculated based on edges, but w ewanted based on nodes.
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int leftHeight(TreeNode root)
    {
        int c=0;
        while(root.left!=null)
        {
            root=root.left;
            c++;
        }
        return c;
    }

    public int rightHeight(TreeNode root)
    {
        int c=0;
        while(root.right!=null)
        {
            root=root.right;
            c++;
        }
        return c;
    }
}