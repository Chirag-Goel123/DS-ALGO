
// Brute Force : O(n*n)
Required : 1) Kadanes Algo
           2) Rotate Array Left by 1.

Story Point: 
int res=Integer.MIN_VALUE;
for(int i=0;i<n;i++)
{
    int sumSubArray=findMaxSumSubarray(nums);   // O(n)
    rotateLeftByOne(nums);                      // O(n)
    res=Math.max(res,sumSubArray);
}
return res;
===========================================================================
Code :
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int sum=findMaxSumSubaray(nums);
            rotate(nums);
            res=Math.max(sum,res);
        }
        return res;
    }

    public int findMaxSumSubaray(int[] nums)
    {
        int sum=nums[0];
        int maxSum=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int addInSum=sum+nums[i];
            int khudKaBnaLo=nums[i];
            sum=Math.max(addInSum,khudKaBnaLo);
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public void rotate(int[] nums)
    {
        int temp=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            nums[i-1]=nums[i];
        }
        nums[nums.length-1]=temp;
    }
}

Approch 2 : Story Point : 
Find minSum 
Find maxSum
Find circular_sum=sum-minSum
if(maxSum>0) -> return max(maxSum,circular_sum)
return maxSum

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }

        int minSum=kadaneMinSum(nums);
        int maxSum=kadaneMaxSum(nums);

        int circularSum=sum-minSum;

        if(maxSum>0)
        {
            return Math.max(maxSum,circularSum);
        }
        return maxSum;
    }

    public int kadaneMaxSum(int[] nums)
    {
        int sum=nums[0];
        int maxSum=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            sum=Math.max(nums[i],sum+nums[i]);
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;
    }

    public int kadaneMinSum(int[] nums)
    {
        int sum=nums[0];
        int minSum=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            sum=Math.min(nums[i],sum+nums[i]);
            minSum=Math.min(sum,minSum);
        }

        return minSum;
    }
}
