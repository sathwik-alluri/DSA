/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root == null)
            return "";
        StringBuilder st=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr!=null)
            {
                st.append(curr.val + " ");
                q.add(curr.left);
                q.add(curr.right);
            }
            else
                st.append("# ");
        }
        return st.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data == "")
            return null;
        String values[]=data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++)
        {
            TreeNode curr=q.poll();

            if(!values[i].equals("#"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                curr.left=left;
                q.add(left);
            }

            i=i+1;
            if(i < values.length && !values[i].equals("#"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                curr.right=right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));