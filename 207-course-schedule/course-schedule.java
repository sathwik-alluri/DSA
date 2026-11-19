class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=prerequisites.length;

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int V=adj.size();
        int inDegree[]=new int[V];

        for(int i=0;i<V;i++)
        {
            for(int ele: adj.get(i))
            {
                inDegree[ele] += 1;
            }
        }

        Queue<Integer> topo = new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(inDegree[i] == 0)
            {
                topo.add(i);
            }
        }

        ArrayList<Integer> ans=new ArrayList<>();
        while(!topo.isEmpty())
        {
            int curr=topo.poll();
            ans.add(curr);

            for(int ele: adj.get(curr))
            {
                inDegree[ele] -= 1;
                if(inDegree[ele] == 0)
                {
                    topo.add(ele);
                }
            }
        }
                
        return ans.size() == V;
    }
}