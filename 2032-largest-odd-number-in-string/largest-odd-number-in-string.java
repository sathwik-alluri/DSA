class Solution {
    public String largestOddNumber(String num) 
    {
        int n=num.length();
        StringBuilder odd=new StringBuilder();
        int i=n-1;

        while(i>=0)
        {
            if((num.charAt(i) - '0') % 2 != 0)
            {
                return num.substring(0, i+1);
            }
            else
                i--;
        }
        return "";
    }
}