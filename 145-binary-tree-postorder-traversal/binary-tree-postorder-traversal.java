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
    int state;
    Pair(TreeNode n, int s)
    {
        node=n;
        state=s;
    }
} 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> preOrder=new ArrayList<>();
        List<Integer> inOrder=new ArrayList<>();
        List<Integer> postOrder=new ArrayList<>();

        Stack<Pair> st=new Stack<>();

        if(root == null)
            return postOrder;
        
        st.push(new Pair(root, 1));

        while(st.isEmpty() == false)
        {
            Pair curr=st.pop();
            TreeNode currNode=curr.node;
            int currState=curr.state;

            if(currState == 1)
            {
                preOrder.add(currNode.val);
                st.push(new Pair(currNode, currState + 1));
                if(currNode.left!=null)
                {
                    st.push(new Pair(currNode.left, 1));
                }
            }
            else if(currState == 2)
            {
                inOrder.add(currNode.val);
                st.push(new Pair(currNode, currState + 1));
                if(currNode.right!=null)
                {
                    st.push(new Pair(currNode.right, 1));
                }
            }
            else if(currState == 3)
            {
                postOrder.add(currNode.val);
            }
        }
        return postOrder;

        // List<Integer> ans = new ArrayList<>();

        // if (root == null)
        //     return ans;

        // Stack<TreeNode> st1 = new Stack<>();
        // Stack<TreeNode> st2 = new Stack<>();

        // st1.push(root);

        // while (!st1.isEmpty()) 
        // {
        //     TreeNode node = st1.pop();
        //     st2.push(node);

        //     if (node.left != null)
        //         st1.push(node.left);

        //     if (node.right != null)
        //         st1.push(node.right);
        // }

        // while (!st2.isEmpty()) {
        //     ans.add(st2.pop().val);
        // }

        // return ans; 
    }
}