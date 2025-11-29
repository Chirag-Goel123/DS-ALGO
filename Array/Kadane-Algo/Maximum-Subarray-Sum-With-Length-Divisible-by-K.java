class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;

        long[] prefixSum=new long[nums.length];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        long result=Long.MIN_VALUE;

        for(int start=0;start<k;start++)
        {
            long curSum=0;
            int i=start;
            while(i<n && i+k-1 <n)
            {
                int j=i+k-1;
                long subSum=prefixSum[j]-(i-1>=0?prefixSum[i-1]:0);
                curSum=Math.max(subSum,curSum+subSum);
                result = Math.max(result, curSum);
                i += k;
            }
        }

        return result;
    }
}