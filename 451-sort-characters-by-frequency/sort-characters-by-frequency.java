// class Pair
// {
//     char ch;
//     int freq;
//     Pair(char c, int f)
//     {
//         ch=c;
//         freq=f;
//     }
// }

class Pair
{
    int freq;
    char ch;
    Pair(int f, char c)
    {
        freq=f;
        ch=c;
    }
}

class Solution {
    public String frequencySort(String s) 
    {
        // HashMap<Character, Integer> h=new HashMap<>();
        // int n=s.length();
        // for(int i=0;i<n;i++)
        // {
        //     h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0)+1);
        // }

        // PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) ->
        // Integer.compare(b.freq, a.freq));

        // for(Map.Entry<Character, Integer> val: h.entrySet())
        // {
        //     pq.add(new Pair(val.getKey(), val.getValue()));
        // }
        
        // StringBuffer ans=new StringBuffer();
        // while(pq.isEmpty() == false)
        // {
        //     Pair top=pq.poll();
        //     char c=top.ch;
        //     int f=top.freq;

        //     for(int i = 0; i < f; i++)
        //     {
        //         ans.append(c);
        //     }
        // }
        // return ans.toString();



        Pair arr[]=new Pair[256];
        for(int i=0;i<256;i++)
        {
             arr[i] = new Pair(0, (char)(i));
        }

        for(int i=0;i<s.length();i++)
        {
            Pair p=arr[s.charAt(i)];
            int f=p.freq;
            char c=p.ch;
            arr[s.charAt(i)] = new Pair(f+1, s.charAt(i));
        }

        Arrays.sort(arr, (a,b) ->
        {
            if(a.freq == b.freq)
                return Character.compare(a.ch, b.ch);      //Characters in ascending order
            return Integer.compare(b.freq, a.freq);        //Decending order
        });        
        
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<256;i++)
        {
            Pair p=arr[i];
            int f=p.freq;
            char c=p.ch;

            if(f==0)
                break;

            for(int j=0; j<f; j++)
            {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}