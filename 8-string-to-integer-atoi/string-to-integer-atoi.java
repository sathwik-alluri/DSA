class Solution {
    public int myAtoi(String s) 
    {
        int n=s.length();
        boolean neg=false;
        boolean encounteredCharacter=false;
        int num = 0;
        for(int i=0;i<n;i++)
        {
            if(encounteredCharacter==false && Character.isWhitespace(s.charAt(i)))
                continue;
            else if(encounteredCharacter==false && s.charAt(i) == '+')
            {
                encounteredCharacter=true;
                continue;
            }
            else if(encounteredCharacter==false && s.charAt(i) == '-')
            {
                neg=true;
                encounteredCharacter=true;
                continue;
            }

            if(Character.isDigit(s.charAt(i)))
            {
                encounteredCharacter=true;
                int digit=s.charAt(i) - '0';
                if(num > (Integer.MAX_VALUE-digit)/10)  //To check num*10+digit > INT_MAX
                {
                    if(neg)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                num = num * 10 + digit;
            }
            else
                break;
        }

        if(neg == true)
        {
            return -num;
        }
        return num;
    }
}