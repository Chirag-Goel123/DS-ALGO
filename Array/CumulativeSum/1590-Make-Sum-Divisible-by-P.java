class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0;

        for(int num : nums)
        {
            sum=(sum+num)%p;
        }
        int target=sum%p;

        if(target==0)
        {
            return 0;
        }

        HashMap<Integer,Integer> map=new HashMap();
        map.put(0,-1);
        int cur=0;
        int result=n;
        for(int j=0;j<nums.length;j++)
        {
            cur=(cur+nums[j])%p;

            int rem=(cur-target+p)%p;
            if(map.containsKey(rem))
            {
                result=Math.min(result,j-map.get(rem));
            }
            map.put(cur,j);
        }
        return result==n?-1:result;
    }
}