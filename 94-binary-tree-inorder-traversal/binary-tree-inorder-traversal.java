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

        // TreeNode node=root;                        //TC:O(n)
        //                                             //SC: O(n) Stack space
        // List<Integer> ans=new ArrayList<>();
        // Stack<TreeNode> st=new Stack<>();
        // while(true)
        // {
        //     if(node != null)
        //     {
        //         st.push(node);
        //         node=node.left;
        //     }
        //     else
        //     {
        //         if(st.isEmpty())
        //             break;

        //         node=st.pop();
        //         ans.add(node.val);
        //         node=node.right;
        //     }
        // }
        // return ans;


        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {

            // 1. Go as far left as possible
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            // 2. Process the node
            curr = st.pop();
            ans.add(curr.val);

            // 3. Move to the right subtree
            curr = curr.right;
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