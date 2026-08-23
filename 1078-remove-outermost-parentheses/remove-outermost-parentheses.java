class Solution {
    public String removeOuterParentheses(String s) 
    {
        int n=s.length();
        String ans="";
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '(')
            {
                c++;
            }
            else
                c--;

            // if(c==1 && s.charAt(i) == '(')
            //     continue;

            if(c==0 || (c==1 && s.charAt(i) == '('))
                continue;

            // else if(c==0 && s.charAt(i) == ')'))
            // {
            //     continue;
            // }
            
            ans+=s.charAt(i);
            
        }
        return ans;
    }
}