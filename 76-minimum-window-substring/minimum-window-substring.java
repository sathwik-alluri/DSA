class Solution {
    public String minWindow(String s, String t) 
    {
        // int n=s.length();
        // int m=t.length();
        // int minLen=n+1;
        // int startInd=0;
        // for(int i=0;i<n;i++)
        // {
        //     HashMap<Character, Integer> hm=new HashMap<>();
        //     int c=0;
        //     for(int j=0;j<m;j++)
        //     {
        //         hm.put(t.charAt(j), hm.getOrDefault(t.charAt(j), 0)+1);
        //     }

        //     for(int j=i;j<n;j++)
        //     {
        //         if(hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j)) > 0)
        //             c=c+1;
                
        //         hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)-1);
                
        //         if(c == t.length())
        //         {
        //             if(j-i+1 < minLen)
        //             {
        //                 startInd = i;
        //                 minLen=j-i+1;
        //             }   
        //             break;    
        //         }
        //     }
        // }
        // if(minLen == n + 1)
        //     return "";
        // return s.substring(startInd, startInd + minLen);


        int n=s.length();
        int m=t.length();                     //TC: O(m) + O(2n)   //SC: O(256)
        int minLen=Integer.MAX_VALUE;
        int startInd=0;
        int l=0;
        int r=0;
        int c=0;
        HashMap<Character, Integer> hm=new HashMap<>();
        for(int j=0;j<m;j++)
        {
            hm.put(t.charAt(j), hm.getOrDefault(t.charAt(j), 0)+1);
        }
        while(r<n)
        {
            if(hm.containsKey(s.charAt(r)) && hm.get(s.charAt(r)) > 0)
                c+=1;

            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) - 1);
            
            while(l<n && c==t.length())
            {
                if(c==t.length())
                {
                    if(r-l+1 < minLen)
                    {
                        startInd = l;
                        minLen = r-l+1;
                    }
                }

                hm.put(s.charAt(l), hm.getOrDefault(s.charAt(l), 0) + 1);

                if(hm.containsKey(s.charAt(l)) && hm.get(s.charAt(l)) > 0)
                    c-=1;

                l++;
            }
            r++;
        }
        if(minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(startInd, startInd + minLen);
    }
}