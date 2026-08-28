class Solution {
    public int characterReplacement(String s, int k) 
    {
        int n=s.length();
        int l=0;
        int r=0;
        int maxLen=0;
        int hm[]=new int[26];
        int maxfreq=0;
        while(r<n)
        {
            hm[s.charAt(r) - 'A']++;
            maxfreq=Math.max(maxfreq, hm[s.charAt(r) - 'A']);

            //int changesReq=(r-l+1)-maxFreq;
            while((r-l+1)-maxfreq > k)
            {
                hm[s.charAt(l) - 'A']--;
                l++;
                maxfreq=0;
                for(int i=0;i<26;i++)   //Updating new Max frequency
                {
                    maxfreq=Math.max(maxfreq, hm[i]);
                }
            }

            if((r-l+1)-maxfreq <= k)
            {
                maxLen=Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}