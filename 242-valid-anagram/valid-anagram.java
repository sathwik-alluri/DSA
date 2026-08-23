class Solution {
    public boolean isAnagram(String s, String t) 
    {
        if(s.length() != t.length())
            return false;

        int arr[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        
        for(int i=0;i<26;i++)
        {
            if(arr[i] != 0)
                return false;
        }
        return true;
    }
}