// SOrt
// Remove the duplicates.
// Fixed the n1 and remove the duplicates.

class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        res=new ArrayList<>();
        int n=nums.length;
        if(n<3)
        {
            return res;
        }

        // Sort
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int n1=nums[i];
            int target=-1*n1;

            twoSum(nums,target,i+1,n-1);
        }
        return res;
    }

    public void twoSum(int[] nums,int target,int i,int j)
    {
        while(i<j)
        {
            if(nums[i]+nums[j]>target)
            {
                j--;
            }
            else if(nums[i]+nums[j]<target)
            {
                i++;
            }
            else
            {
                while(i<j && nums[i]==nums[i+1])
                {
                    i++;
                }

                while(i<j && nums[j]==nums[j-1])
                {
                    j--;
                }
                List<Integer> ans=new ArrayList<>();
                ans.add(-target);
                ans.add(nums[i]);
                ans.add(nums[j]);
                res.add(ans);
                i++; j--;
            }
        }
    }
}