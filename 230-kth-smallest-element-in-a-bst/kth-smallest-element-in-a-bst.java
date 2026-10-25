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
    public int kthSmallest(TreeNode root, int k)
    {
        int[] ans = new int[1];
        int[] count = {k};
        inOrder(root, count, ans);

        return ans[0];

        // //Iterative Approach - O(K) and SC:O(H)
        // Stack<TreeNode> st = new Stack<>();
        // TreeNode curr = root;
        // while (curr != null || !st.isEmpty())
        // {
        //     while (curr != null)
        //     {
        //         st.push(curr);
        //         curr = curr.left;
        //     }
    
        //     curr = st.pop();
        //     k--;
        //     if (k == 0)
        //         return curr.val;

        //     curr = curr.right;
        // }
        // return -1;
    }

    public void inOrder(TreeNode root, int[] count, int[] ans)
    {
        // if (root == null || count[0] <= 0)
        //     return;
        if (root == null)
            return;

        inOrder(root.left, count, ans);

        count[0]--;
        if (count[0] == 0)
        {
            ans[0] = root.val;
            return;
        }

        inOrder(root.right, count, ans);
    }
}
