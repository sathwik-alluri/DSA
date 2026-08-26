class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int n=s.length();
        int l=0;
        int r=0;
        int arr[]=new int[256];
        int maxLen=0;
        while(r<n)
        {
            if(arr[s.charAt(r)] == 0)
            {
                arr[s.charAt(r)] += 1;
                maxLen=Math.max(maxLen, r-l+1);
                r++;
            }
            else
            {
                while(l<r && s.charAt(l) != s.charAt(r))
                {
                    arr[s.charAt(l)] -= 1;
                     l++;
                }
                arr[s.charAt(l)] -= 1;
                l++;
                
                arr[s.charAt(r)] += 1;
                r++;
            }
        }
        return maxLen;
    }
}