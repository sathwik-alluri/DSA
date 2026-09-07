class Solution {
    public int numberOfSubstrings(String s) 
    {
        int n=s.length();        //TC: O(n)
        int l=0;
        int lastseen[]=new int[3];
        lastseen[0]=-1;
        lastseen[1]=-1;
        lastseen[2]=-1;
        int c=0;
        while(l<n)
        {
            lastseen[s.charAt(l) - 'a']=l;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1)
            {
                c = c + 1 + Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
                //Current minimum window is 1 + we can add the characters on left as everyting will be the valid window
            }
            l++;
        }
        return c;
    }
}