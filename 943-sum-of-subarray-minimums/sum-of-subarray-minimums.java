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
}