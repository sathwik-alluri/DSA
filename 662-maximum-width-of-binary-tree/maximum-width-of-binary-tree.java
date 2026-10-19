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

class Pair
{
    TreeNode node;
    int index;
    Pair(TreeNode no, int ind)
    {
        node=no;
        index=ind;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) 
    {
        Queue<Pair> q=new LinkedList<>();
        int width=0;
        q.add(new Pair(root, 0));

        while(!q.isEmpty())
        {
            int size=q.size();
            int firstInd=0;
            int lastInd=0;
            for(int i=0;i<size;i++)
            {
                Pair curr=q.poll();
                TreeNode currNode=curr.node;
                int currInd=curr.index;
                if(i==0)
                {
                    firstInd=curr.index;
                }
                if(i==size-1)
                {
                    lastInd=curr.index;
                }

                if(currNode.left!=null)
                {
                    q.add(new Pair(currNode.left, (2 * (currInd - 1)) + 1));
                }
                if(currNode.right!=null)
                {
                    q.add(new Pair(currNode.right, (2 * (currInd - 1)) + 2));
                }
            }
            width=Math.max(width, lastInd - firstInd + 1);
        }
        return width;
    }
}