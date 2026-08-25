class Solution {
    public String longestPalindrome(String s) 
    {
        int n=s.length();

        int resLen=0;
        String res="";
        
        int mid=0;
        int l=0;
        int r=0;
        for(int i=0;i<n;i++)
        {
            //Odd Length
            mid=i;
            l=mid;
            r=mid;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r))
            {
                if(resLen < (r-l)+1)
                {
                    resLen=(r-l)+1;
                    res=s.substring(l,r+1);
                }
                l--;
                r++;
            }

            //Even length
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r))
            {
                if(resLen < (r-l)+1)
                {
                    resLen=(r-l)+1;
                    res=s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}