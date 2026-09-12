class Solution {
    public String removeKdigits(String num, int k) 
    {
        int n=num.length();
        Stack<Character> st=new Stack<>();
        if(n == k)
            return "0";
        for(int i=0;i<n;i++)
        {
            while(k>0 && st.isEmpty()==false && st.peek()-'0'>num.charAt(i)-'0')
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0)     //We many encounter case, we are not able to pop any elents. Then we need to remove last k numbers from ans.
        //Ex: 123456
        {
            k--;
            st.pop();
        }

        String ans="";
        while(st.isEmpty() == false)
        {
            ans += st.pop();
        }

        ans=new StringBuilder(ans).reverse().toString();
        
        //ans=ans.replaceFirst("^0+", "");
        int i = 0;
        while(i < ans.length() && ans.charAt(i) == '0')
        {
            i++;
        }
        ans = ans.substring(i);

        if(ans == "")
            return "0";
        return ans;
    }
}