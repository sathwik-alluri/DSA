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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            hm.put(inorder[i], i);
        }

        TreeNode root=build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hm);
        return root;
    }

    public TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, HashMap<Integer, Integer> hm)
    {
        if(prestart > preend || instart > inend)
            return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot=hm.get(root.val);
        int numsLeft= inroot - instart;

        root.left = build(preorder, prestart+1, prestart + numsLeft, inorder, instart, inroot-1, hm);
        
        root.right = build(preorder, prestart + numsLeft + 1, preend, inorder, inroot + 1, inend, hm);

        return root;
    }
}