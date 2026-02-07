class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;

        if(checkAllZeroAlready(nums))
        {
            return 0;
        }
        for(int i=0;i<queries.length;i++)
        {
            if(checkWithDiffremceArrayTechnique(nums,queries,i)==true)
            {
                return i+1;
            }
        }
        return -1;
    }

    public boolean checkWithDiffremceArrayTechnique(int[] nums, int[][] queries,int k)
    {
        int[] diff=new int[nums.length];


        for(int i=0;i<=k;i++)
        {
            int start=queries[i][0];
            int end=queries[i][1];
            int x=queries[i][2];

            diff[start]+=x;
            if(end+1<nums.length)
            {
                diff[end+1]-=x;
            }
        }

        int cumSum=0;
        for(int i=0;i<diff.length;i++)
        {
            cumSum+=diff[i];
            diff[i]=cumSum;
            if(nums[i]-diff[i]>0)
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkAllZeroAlready(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                return false;
            }
        }

        return true;
    }
}

// TC : O(Q)*(Q+N)

// So, instead of doing the Linear one, use Binary Search.
// TC : O(logQ) * (Q+N).


class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int result=-1;
        if(checkAllZeroAlready(nums))
        {
            return 0;
        }
        int l=0;
        int r=queries.length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(checkWithDiffremceArrayTechnique(nums,queries,mid)==true)
            {
                result=mid+1;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return result;
    }

    public boolean checkWithDiffremceArrayTechnique(int[] nums, int[][] queries,int k)
    {
        int[] diff=new int[nums.length];


        for(int i=0;i<=k;i++)
        {
            int start=queries[i][0];
            int end=queries[i][1];
            int x=queries[i][2];

            diff[start]+=x;
            if(end+1<nums.length)
            {
                diff[end+1]-=x;
            }
        }

        int cumSum=0;
        for(int i=0;i<diff.length;i++)
        {
            cumSum+=diff[i];
            diff[i]=cumSum;
            if(nums[i]-diff[i]>0)
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkAllZeroAlready(int[] nums)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                return false;
            }
        }

        return true;
    }
}