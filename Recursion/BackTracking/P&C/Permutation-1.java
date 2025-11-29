class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        boolean[] track=new boolean[n];
        for(int i=0;i<n;i++)
        {
            track[i]=false;
        }
        List<List<Integer>> res=new ArrayList<>();
        call(nums,list,res,track);
        return res;
    }


    public void call(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] track)
    {
        if(list.size()==nums.length)
        {
            // Base Case
            List<Integer> bcase=new ArrayList<>();
            for(int val:list)
            {
                bcase.add(val);
            }
            res.add(bcase);
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(track[i]==false)
            {
                track[i]=true;
                list.add(nums[i]);
                call(nums,list,res,track);
                track[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}

TC : 
 _ , _ , _ ->   No of possibility of adding first ele ->  3.
                No of possibility of adding second ele -> 2.
                No of possibility of adding third ele ->  1.
                                                        n*n-1*n-2 = n!

Base case mein : O(n) // For copying
TC : O(n*n!)
SC : 