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

// class Pair
// {
//     TreeNode node;
//     int hd;
//     Pair(TreeNode no, int h)
//     {
//         node=no;
//         hd=h;
//     }
// }

class Pair
{
    TreeNode node;
    int vertical;
    int level;
    Pair(TreeNode no, int v, int l)
    {
        node=no;
        vertical=v;
        level=l;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        /*
            This approach will will work if we need elements in the vertical path were in sorted order. 
        */
        // List<List<Integer>> ans=new ArrayList<>();
        // Queue<Pair> q=new LinkedList<>();    
        // q.add(new Pair(root, 0));

        // TreeMap<Integer, PriorityQueue<Integer>> tm=new TreeMap<>();
        // while(!q.isEmpty())
        // {
        //     Pair curr=q.poll();
        //     TreeNode no=curr.node;
        //     int val=no.val;
        //     int hd=curr.hd;

        //     if(tm.containsKey(hd))
        //     {
        //         tm.get(hd).add(val);
        //     }
        //     else
        //     {
        //         PriorityQueue<Integer> a=new PriorityQueue<>();
        //         a.add(val);
        //         tm.put(hd, a);
        //     }

        //     if(no.left!=null)
        //         q.add(new Pair(no.left, hd-1));
        //     if(no.right!=null)
        //         q.add(new Pair(no.right, hd+1));
        // }


        // for(Map.Entry<Integer, PriorityQueue<Integer>> p: tm.entrySet())
        // {
        //     PriorityQueue<Integer> pq=p.getValue();
        //     ArrayList<Integer> al=new ArrayList<>();
        //     while(pq.isEmpty() == false)
        //         al.add(pq.poll());
        //     ans.add(al);
        // }
        // return ans;


        List<List<Integer>> ans=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm=new TreeMap<>();
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            TreeNode no=curr.node;
            int val=no.val;
            int vertical=curr.vertical;
            int level=curr.level;

            if(tm.containsKey(vertical))   //If vertical exists
            {
                if(tm.get(vertical).containsKey(level))
                    tm.get(vertical).get(level).add(val);
                else
                {
                    PriorityQueue<Integer> pq=new PriorityQueue<>();
                    pq.add(val);
                    tm.get(vertical).put(level, pq);
                }
            }
            else     //If vertical not exists - Then we need to inser vertical and also the level Treemap entry
            {
                PriorityQueue<Integer> pq=new PriorityQueue<>();
                pq.add(val);

                TreeMap<Integer, PriorityQueue<Integer>> t=new TreeMap<>();
                t.put(level, pq);
    
                tm.put(vertical, t);
            }

            if(no.left!=null)
                q.add(new Pair(no.left, vertical-1, level+1));
            if(no.right!=null)
                q.add(new Pair(no.right, vertical+1, level+1));
        }


        for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> v: tm.entrySet())
        {
            ArrayList<Integer> al=new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> l=v.getValue();

            for(Map.Entry<Integer, PriorityQueue<Integer>> x: l.entrySet())
            {
                PriorityQueue<Integer> pq=x.getValue();
                while(pq.isEmpty() == false)
                    al.add(pq.poll());
            }
            ans.add(al);
        }
        return ans;
    }
}