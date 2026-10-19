/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        List<Integer> ans=new ArrayList<>();

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        findParents(root, parent);

        HashMap<TreeNode, Integer> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.add(target);
        vis.put(target, 1);
        int level=0;

        while(!q.isEmpty())
        {
            int size=q.size();

            if(level == k)
            {
                size=q.size();
                for(int i=0;i<size;i++)
                {  
                    ans.add(q.poll().val);
                }
                return ans;
            }

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
                level++;
            }
        }
        return ans;
    }

    public void findParents(TreeNode root, HashMap<TreeNode, TreeNode> parent)
    {
        parent.put(root, null);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                
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
    }
}