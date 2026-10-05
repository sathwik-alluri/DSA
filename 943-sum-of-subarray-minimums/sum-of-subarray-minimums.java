class Solution {
    public int sumSubarrayMins(int[] arr) 
    {
        long sum=0;      //TC: O(2n) + O(2n) + O(n) == O(5n)   //SC:O(5n)
        int n=arr.length;
        long mod=1000000007L;
        int nse[]=nextSmallerElement(arr);
        int pse[]=previousSmallerorEqualElement(arr);

        for(int i=0;i<n;i++)
        {
            long possibleStarts=i-pse[i];
            long possibleEnds=nse[i]-i;
            
            long possibleSunarrays=possibleStarts*possibleEnds;
            sum= (sum + (possibleSunarrays * arr[i])%mod)%mod;
        }
        return (int)sum;
    }


     //We are calculating PSEE because to handle case like [2, 2] where we will consider
     //the subarray [2, 2] two times.
     //Hence we need to exclude that either in NSE or PSE 

    public int[] previousSmallerorEqualElement(int[] arr) 
    {
        int n=arr.length;
        int[] pse=new int[n];
        Arrays.fill(pse, -1);
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(st.isEmpty()==false && arr[st.peek()] > arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
                pse[i]=st.peek();
            st.push(i);
        }
        return pse;
    }

    public int[] nextSmallerElement(int[] arr) 
    {
        int n=arr.length;
        int[] nse=new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            while(st.isEmpty()==false && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
                nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }



    /*
        Take: arr = [3, 1, 2]

Consider:
i = 1
arr[i] = 1

We have:
pse[1] = -1
nse[1] = 3

Therefore:
possibleStarts = 1 - (-1) = 2
possibleEnds   = 3 - 1 = 2

So: possibleSubarrays = 2 × 2 = 4

Which 4 subarrays are these?
Starting positions:
0 or 1

Ending positions:
1 or 2

Combinations:
start 0, end 1 → [3,1]
start 0, end 2 → [3,1,2]

start 1, end 1 → [1]
start 1, end 2 → [1,2]

Minimum of all four is 1.
So 1 contributes:
4 × 1 = 4

6. That's exactly what this line does
long possibleSubarrays = possibleStarts * possibleEnds;

Then:
possibleSubarrays * arr[i]

means:
arr[i] is the minimum in this many subarrays, so add arr[i] once for each of them.
*/
}