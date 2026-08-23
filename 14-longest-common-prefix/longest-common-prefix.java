class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        int n=strs.length;
        if(n==1)
            return strs[0];

        String fWord=strs[0];
        char arr[]=fWord.toCharArray();
        int an=arr.length;

        StringBuffer ans=new StringBuffer();
        StringBuffer prefix=new StringBuffer();
        for(int c=0;c<an;c++)
        {
            prefix.append(arr[c]);

            int i=0;
            boolean exists=true;
            for(i=0; i<n; i++)
            {
                if(strs[i].startsWith(prefix.toString()))
                    continue;
                else
                {
                    exists=false;
                    break;
                }
            }
            if(exists == true)
            {
                ans=new StringBuffer(prefix);
            } 
            else    //if(Notexists == true)
            {
                break;
            }
        }
        return ans.toString();
    }
}