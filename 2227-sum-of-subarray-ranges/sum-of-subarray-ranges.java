class Solution 
{
    public long subArrayRanges(int[] nums) 
    {
        return sumOfSubarrayMaximums(nums) - sumOfSubarrayminimums(nums);
    }

    public long sumOfSubarrayMaximums(int[] nums) 
    {
        int n = nums.length;

        int[] nbe = findNBE(nums, n);
        int[] pbee = findPBEE(nums, n);

        long s = 0;

        for(int i = 0; i < n; i++)
        {
            long left = i - pbee[i];
            long right = nbe[i] - i;

            long len = left * right;

            s += len * nums[i];
        }

        return s;
    }

    public long sumOfSubarrayminimums(int[] nums) 
    {
        int n = nums.length;

        int[] nse = findNSE(nums, n);
        int[] psee = findPSEE(nums, n);

        long s = 0;

        for(int i = 0; i < n; i++)
        {
            long left = i - psee[i];
            long right = nse[i] - i;

            long len = left * right;

            s += len * nums[i];
        }

        return s;
    }

    public int[] findNSE(int[] arr, int n) // Next Smaller Element
    {
        int[] nse = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = n - 1; i >= 0; i--)
        {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();

            if(s.isEmpty())
                nse[i] = n;
            else
                nse[i] = s.peek();

            s.push(i);
        }

        return nse;
    }

    public int[] findPSEE(int[] arr, int n) // Previous Smaller or Equal Element
    {
        int[] psee = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            while(!s.isEmpty() && arr[s.peek()] > arr[i])
                s.pop();

            if(s.isEmpty())
                psee[i] = -1;
            else
                psee[i] = s.peek();

            s.push(i);
        }

        return psee;
    }

    public int[] findNBE(int[] arr, int n) // Next Bigger Element
    {
        int[] nbe = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = n - 1; i >= 0; i--)
        {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i])
                s.pop();

            if(s.isEmpty())
                nbe[i] = n;
            else
                nbe[i] = s.peek();

            s.push(i);
        }

        return nbe;
    }

    public int[] findPBEE(int[] arr, int n) // Previous Bigger or Equal Element
    {
        int[] pbee = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            while(!s.isEmpty() && arr[s.peek()] < arr[i])
                s.pop();

            if(s.isEmpty())
                pbee[i] = -1;
            else
                pbee[i] = s.peek();

            s.push(i);
        }

        return pbee;
    }
}