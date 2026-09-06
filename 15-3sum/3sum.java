import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        // int n=nums.length;
        // Set<List<Integer>> ans=new HashSet<>();
        // for(int i=0;i<n;i++)
        // {
        //     HashSet<Integer> h=new HashSet<>();
        //     for(int j=i+1;j<n;j++)
        //     {
        //         int third=-(nums[i]+nums[j]);
        //         if(h.contains(third))
        //         {
        //             List<Integer> a=Arrays.asList(nums[i], nums[j], third);
        //             Collections.sort(a);
        //             ans.add(a);
        //         }
        //         h.add(nums[j]);
        //     }
        // }3
        // return new ArrayList<>(ans);


        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int l=i+1;
            int r=n-1;
            while(l<r)
            {
                if(nums[l] + nums[r] + nums[i] == 0)
                {
                    List<Integer> a=Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(a);
                    l++;
                    r--;

                    while (l<r && nums[l] == nums[l-1]) 
                        l++;
        
                    while (l<r && nums[r] == nums[r+1]) 
                        r--;
                }
                else if(nums[l] + nums[r] + nums[i] < 0)
                    l++;
                else
                    r--;
            }            
        }
        // return new ArrayList<>(ans);
        return ans;
    }
}