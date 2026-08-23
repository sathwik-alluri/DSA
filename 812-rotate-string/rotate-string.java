class Solution {
    public boolean rotateString(String s, String goal) 
    {
        // String t=goal;                   //This is my approach. But it will not work for the test cases where duplicate caharacters exist. BEcause we are iverriding the position value in the array in later part.
        // if(s.length() != t.length())
        //     return false;

        // int arr[]=new int[26];
        // int n=s.length();

        // char firstEle=s.charAt(0);
        // int firstElePos=0;
        // for(int i=0;i<n;i++)
        // {
        //     arr[goal.charAt(i) - 'a'] = i+1;
        //     if(goal.charAt(i) == firstEle)
        //         firstElePos=i+1;
        // }

        // int diff=firstElePos - (0+1);
        // for(int i=0;i<n;i++)
        // {   
        //     int temp = arr[s.charAt(i) - 'a'] - (i+1);
        //     if(temp < 0)
        //     {
        //         temp = temp + n;
        //     }
        //     if(temp != diff)
        //         return false;
        // }
        // return true;


        //Bruteforce
        // if(s.length() != goal.length())     //TC: O(n * n)
        //     return false;
        // int n=s.length();
        // for(int i=0;i<n;i++)
        // {
        //     String rotated = s.substring(i, n) + s.substring(0,i);

        //     if(rotated.equals(goal))
        //         return true;
        // }
        // return false;



        //Optimal     TC: O(n)
        if(s.length() != goal.length())
            return false;
        String combined = s+s;
        return combined.contains(goal);
    }
}