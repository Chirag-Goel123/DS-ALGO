class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int sumEven=0;
        int[] res=new int[queries.length];
        int pointer=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==0)
            {
                sumEven+=nums[i];
            }
        }

        for(int q=0;q<queries.length;q++)
        {
            int[] query=queries[q];
            int idx=query[1];
            if(nums[idx]%2==0)
            {
                sumEven-=nums[idx];
            }
            // Apply Operation
            nums[idx]+=query[0];

            if(nums[idx]%2==0)
            {
                sumEven+=nums[idx];
            }
            res[pointer]=sumEven;
            pointer++;
        }

        return res;
    }
}