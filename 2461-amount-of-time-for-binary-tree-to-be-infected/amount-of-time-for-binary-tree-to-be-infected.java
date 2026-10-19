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
    public int amountOfTime(TreeNode root, int start) 
    {
        List<Integer> ans=new ArrayList<>();

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = findParents(root, parent, start);

        HashMap<TreeNode, Integer> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.add(startNode);
        vis.put(startNode, 1);
        int time=0;

        while(!q.isEmpty())
        {
            int size=q.size();
            int flag=0;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();

                if(curr.left!=null && vis.get(curr.left) == null)
                {
                    flag=1;
                    q.add(curr.left);
                    vis.put(curr.left, 1);
                }
                if(curr.right!=null && vis.get(curr.right) == null)
                {
                    flag=1;
                    q.add(curr.right);
                    vis.put(curr.right, 1);
                }
                if(parent.get(curr)!=null && vis.get(parent.get(curr)) == null)
                {
                    flag=1;
                    q.add(parent.get(curr));
                    vis.put(parent.get(curr), 1);
                }
            }

            if(flag==1)
            {
                time++;
            }
        }
        return time;  
    }

    public TreeNode findParents(TreeNode root, HashMap<TreeNode, TreeNode> parent, int start)
    {
        parent.put(root, null);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        TreeNode startNode = root;

        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();

                if(curr.val == start)
                    startNode=curr;
                
                if(curr.left!=null)
                {
                    parent.put(curr.left, curr);
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    parent.put(curr.right, curr);
                    q.add(curr.right);
                }
            }
        }
        return startNode;
    }
}