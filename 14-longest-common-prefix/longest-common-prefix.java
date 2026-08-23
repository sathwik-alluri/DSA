class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        // int n=strs.length;       //TC: O(n × L²)
        // if(n==1)
        //     return strs[0];

        // String fWord=strs[0];

        // StringBuffer ans=new StringBuffer();
        // StringBuffer prefix=new StringBuffer();

        // for(int c=0;c<fWord.length();c++)
        // {
        //     prefix.append(fWord.charAt(c));

        //     int i=0;
        //     boolean exists=true;
        //     for(i=0; i<n; i++)
        //     {
        //         if(strs[i].startsWith(prefix.toString()))
        //             continue;
        //         else
        //         {
        //             exists=false;
        //             break;
        //         }
        //     }
        //     if(exists == true)
        //     {
        //         ans=new StringBuffer(prefix);     //We cant directly assign ans=prefix. VBecuase as Jave uses String pool concept, both will point to same object.So we might get incorrcet answers.
        //     } 
        //     else    //if(Notexists == true)
        //     {
        //         break;
        //     }
        // }
        // return ans.toString();

        Arrays.sort(strs);
        int n=strs.length;
        String small=strs[0];
        String large=strs[n-1];

        int i=0;
        int j=0;
        int n1=small.length();
        int n2=large.length();
        while(i<n1 && j<n2)
        {
            if(small.charAt(i) == large.charAt(j))
            {
                i++;
                j++;
            }
            else
                break;
        }
        return small.substring(0, i);
    }
}