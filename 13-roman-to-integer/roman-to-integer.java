class Solution {
    public int romanToInt(String s) 
    {
        HashMap<Character, Integer> hm=new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        
        int ans=0;
        int n=s.length();
        int i=0;
        for(i=0;i<n-1;)
        {
            if(hm.get(s.charAt(i)) >= hm.get(s.charAt(i+1)))
            {
                ans+=hm.get(s.charAt(i));
                i=i+1;
            }
            
            else    //if(hm.get(s.charAt(i)) < hm.get(s.charAt(i+1)))
            {
                ans+=(hm.get(s.charAt(i+1)) - hm.get(s.charAt(i)));
                i=i+2;
            }
        }
        if(i==n-1)
            ans+=hm.get(s.charAt(i));
        return ans;
    }
}