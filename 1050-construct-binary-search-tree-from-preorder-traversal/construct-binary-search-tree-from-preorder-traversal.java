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
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        int[] A=new int[1];
        return build(preorder, Integer.MAX_VALUE, A);
    }
    public TreeNode build(int[] preOrder, int upperBound, int[] i)
    {
        if(i[0] == preOrder.length || preOrder[i[0]] > upperBound)
            return null;
        
        TreeNode root=new TreeNode(preOrder[i[0]]);
        i[0]++;

        root.left=build(preOrder, root.val, i);
        root.right=build(preOrder, upperBound, i);
        return root;
    }
}