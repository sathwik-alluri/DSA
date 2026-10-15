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
    public int maxDepth(TreeNode root) 
    {
        //  //Interative Soln: We are using Queue DS - O(n) in worst case when we have complete BT
        // Queue<TreeNode> q=new LinkedList<>();
        // if(root==null)
        //     return 0;
        // q.add(root);
        // int c=0;
        // while(!q.isEmpty())
        // {
        //     int size=q.size();
        //     ArrayList<Integer> a=new ArrayList<>();
        //     for(int i=0;i<size;i++)
        //     {
        //         TreeNode curr=q.poll();
        //         if(curr.left!=null)
        //             q.add(curr.left);
        //         if(curr.right!=null)
        //             q.add(curr.right);
        //     }
        //     c+=1;
        // }
        // return c;


        //Recursive Soln: We can eliminate the use of queue space. But we still use Auxilary
        // stack space. SC: O(height) in worst case when we have skewed tree
        
        if(root==null)
            return 0;
        
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return 1 + Math.max(lh, rh);
    }
}