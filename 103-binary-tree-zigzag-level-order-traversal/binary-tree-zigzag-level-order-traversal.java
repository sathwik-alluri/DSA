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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        Queue<TreeNode> q=new LinkedList<>();        //TC : O(n) and SC : O(n)
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        q.add(root);
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            ArrayList<Integer> a=new ArrayList<>();
            // if(level%2==0)
            // {
            //     for(int i=0;i<size;i++)
            //     {
            //         TreeNode curr=q.remove();
            //         a.add(curr.val);
            //         if(curr.left!=null)
            //             q.add(curr.left);
            //         if(curr.right!=null)
            //             q.add(curr.right);
            //     }
            // }
            // else
            // {
            //     for(int i=0;i<size;i++)
            //     {
            //         TreeNode curr=q.remove();
            //         a.addFirst(curr.val);
            //         if(curr.left!=null)
            //             q.add(curr.left);
            //         if(curr.right!=null)
            //             q.add(curr.right);
            //     }
            // }

            for(int i=0;i<size;i++)
                {
                    TreeNode curr=q.remove();
                    if(level%2==0)
                        a.add(curr.val);
                    else
                        a.addFirst(curr.val);
                    if(curr.left!=null)
                        q.add(curr.left);
                    if(curr.right!=null)
                        q.add(curr.right);
                }
            ans.add(a);
            level++;
        }
        return ans;
        
    }
}