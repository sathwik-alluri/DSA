class Solution {
    public int beautySum(String s) 
    {
        int n=s.length();      //O(n * n) * O(26) - To find min and max the loop will run for at most the length of 26.
        int beautySum=0;
        for(int i=0;i<n;i++)
        {
            HashMap<Character, Integer> hm=new HashMap<>();
            for(int j=i;j<n;j++)
            {
                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);

                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                for(int val: hm.values())
                {
                    min=Math.min(min, val);
                    max=Math.max(max, val);
                }
                beautySum+=(max-min);
            }
        }
        return beautySum;
    }

}