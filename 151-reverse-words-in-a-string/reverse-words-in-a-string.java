class Solution {
    public String reverseWords(String s) 
    {
        // String arr[]=s.trim().split("\\s+");
        // int n=arr.length;
        // int l=0;
        // int r=n-1;
        // while(l<=r)
        // {
        //     String t=arr[l];
        //     arr[l]=arr[r];
        //     arr[r]=t;
        //     l++;
        //     r--;
        // }
        // String Sentence = String.join(" ", arr);
        // return Sentence;

        s=s.trim();
        int n=s.length();
        StringBuilder str=new StringBuilder();
        StringBuilder word=new StringBuilder();
        int i=n-1;
        while(i>=0)
        {
            if(s.charAt(i) !=  ' ')
            {
                word.append(s.charAt(i));
                i--;
            }
            else
            {
                if(str.length() == 0)
                {
                    str.append(word.reverse());
                    word.setLength(0);
                }
                else   
                {
                    str.append(" ");
                    str.append(word.reverse());
                    word.setLength(0);
                }
                while(i>=0 && s.charAt(i) == ' ')
                {
                    i--;
                    continue;
                }
            }
        }
        if(word.length() !=0)
        {
            if(str.length() == 0)
            {
                str.append(word.reverse());
                word.setLength(0);
            }
            else   
            {
                str.append(" ");
                str.append(word.reverse());
            }
        }
        return str.toString();
    }
}