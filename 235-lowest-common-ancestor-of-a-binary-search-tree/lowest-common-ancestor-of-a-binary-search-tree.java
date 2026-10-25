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
        //Normal LCA approach used for BTs
        // if(root == null)
        //     return null;
        
        // if(root == p || root == q)
        //     return root;
        
        // TreeNode lh=lowestCommonAncestor(root.left, p, q);
        // TreeNode rh=lowestCommonAncestor(root.right, p, q);
        // if(lh==null)
        //     return rh;
        // if(rh==null)
        //     return lh;
        // return root;

        if(root == null)
            return null;
        
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.val==p.val || curr.val==q.val || (p.val < curr.val && q.val > curr.val) ||
            (p.val > curr.val && q.val < curr.val))
                return curr;
            
            else if(curr.val > p.val && curr.val > q.val)
                curr=curr.left;
            
            else
                curr=curr.right;
        }
        return null;
    }
}