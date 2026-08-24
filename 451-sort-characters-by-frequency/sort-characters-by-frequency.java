class Pair
{
    char ch;
    int freq;
    Pair(char c, int f)
    {
        ch=c;
        freq=f;
    }
}
class Solution {
    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> h=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) ->
        Integer.compare(b.freq, a.freq));

        for(Map.Entry<Character, Integer> val: h.entrySet())
        {
            pq.add(new Pair(val.getKey(), val.getValue()));
        }
        
        StringBuffer ans=new StringBuffer();
        while(pq.isEmpty() == false)
        {
            Pair top=pq.poll();
            char c=top.ch;
            int f=top.freq;

            for(int i = 0; i < f; i++)
            {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}