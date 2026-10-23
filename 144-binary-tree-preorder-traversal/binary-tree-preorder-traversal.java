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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        // List<Integer> ans = new ArrayList<>();
        // if (root == null)
        //     return ans;

        // Stack<TreeNode> st = new Stack<>();
        // st.push(root);

        // while (!st.isEmpty()) 
        // {
        //     TreeNode node = st.pop();

        //     //Process root
        //     ans.add(node.val);

        //     //Push right first
        //     if (node.right != null)
        //         st.push(node.right);

        //     //Push left second
        //     if (node.left != null)
        //         st.push(node.left);
        // }
        // return ans;


        TreeNode curr=root;
        List<Integer> ans = new ArrayList<>();       //TC:O(n) and SC:O(1)
        while(curr!=null)
        {
            if(curr.left == null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else
            {
                TreeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr)
                {
                    temp=temp.right;
                }
                
                if(temp.right == null)
                {
                    temp.right=curr;
                    ans.add(curr.val);
                    curr=curr.left;
                }
                else
                {
                    temp.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}