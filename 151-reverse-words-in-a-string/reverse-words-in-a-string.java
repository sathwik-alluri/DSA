class Solution {
    public String reverseWords(String s) 
    {
        String arr[]=s.trim().split("\\s+");

        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l<=r)
        {
            String t=arr[l];
            arr[l]=arr[r];
            arr[r]=t;
            l++;
            r--;
        }
        String Sentence = String.join(" ", arr);
        return Sentence;
    }
}