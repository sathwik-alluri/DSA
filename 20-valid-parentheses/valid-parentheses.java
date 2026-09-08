class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> st=new Stack<>();
        HashMap<Character, Character> h=new HashMap<>();
        h.put(')', '(');
        h.put('}', '{');
        h.put(']', '[');
        int n=s.length();
        int i=0;
        while(i<n)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(st.size() == 0)
                    return false;

                else if(st.size()>0 && st.peek() != h.get(s.charAt(i)))
                    return false;

                st.pop();
            }
            i++;
        }
        if(st.size() != 0)
            return false;
        return true;
    }
}