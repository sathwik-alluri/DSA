class Solution {
    public String removeOuterParentheses(String s) 
    {
        // int n=s.length();
        // String ans="";
        // int c=0;
        // for(int i=0;i<n;i++)
        // {
        //     if(s.charAt(i) == '(')
        //         c++;
        //     else
        //         c--;

        //     if(c==0 || (c==1 && s.charAt(i) == '('))
        //         continue;
            
        //     ans+=s.charAt(i);
            
        // }
        // return ans;


        StringBuilder result = new StringBuilder();  
        int level = 0;  
        for (char ch : s.toCharArray()) 
        {
            if (ch == '(') 
            {
                if (level > 0)        //We have to skip the insertion for 1st level
                    result.append(ch);
                level++; 
            } 
            else if (ch == ')') 
            {
                level--;  
                if (level > 0)  // If we're inside a primitive, adding ')' to result
                    result.append(ch);
            }
        }
        return result.toString();
    }
}