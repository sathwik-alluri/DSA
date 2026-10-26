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
class BSTIterator {

    Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) 
    {
        pushLeft(root);
    }
    
    public int next() 
    {
        TreeNode topNode = st.pop();
        pushLeft(topNode.right);
        return topNode.val;
    }
    
    public boolean hasNext() 
    {
        return !st.isEmpty();
    }

    public void pushLeft(TreeNode root)
    {
        TreeNode curr=root;
        while(curr!=null)
        {
            st.push(curr);
            curr=curr.left;
        }     
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */