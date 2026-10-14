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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
    //    List<Integer> ans=new ArrayList<>();
    //    inOrder(root, ans); 
    //    return ans;

        TreeNode node=root;
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        while(true)
        {
            if(node != null)
            {
                st.push(node);
                node=node.left;
            }
            else
            {
                if(st.isEmpty())
                    break;

                node=st.pop();
                ans.add(node.val);
                node=node.right;
            }
        }
        return ans;
    }

    public void inOrder(TreeNode root, List<Integer> ans)
    {
        if(root==null)
            return;
        
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
}