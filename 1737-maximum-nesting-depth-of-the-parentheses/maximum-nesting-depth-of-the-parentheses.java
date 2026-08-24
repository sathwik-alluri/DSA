class Solution {
    public int maxDepth(String s) 
    {
        int n=s.length();
        int level=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '(')
            {
                level++;
                ans=Math.max(ans, level);
            }
            else if(s.charAt(i) == ')')
            {
                 level--;
            }
        }
        return ans;
    }
}