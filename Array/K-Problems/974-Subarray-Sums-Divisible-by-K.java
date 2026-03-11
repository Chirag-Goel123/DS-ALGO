class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int result=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0)
            {
                rem+=k;
            }
            if(map.containsKey(rem))
            {
                result+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }
            else
            {
                map.put(rem,1);
            }
        }
        return result;

    }
}