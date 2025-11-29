class Solution {

    private HashSet<List<Integer>> set;
    public List<List<Integer>> permuteUnique(int[] nums) {
        set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        boolean[] track=new boolean[nums.length];
        call(nums,track,list,res);
        return res;
    }


    public void call(int[] nums, boolean[] track, List<Integer> list, List<List<Integer>> res)
    {
        if(list.size()==nums.length)
        {
            if(!set.contains(list))
            {
                List<Integer> finalList=new ArrayList<>(list);
                res.add(finalList);
                set.add(finalList);
            }
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(track[i]==false)
            {
                track[i]=true;
                list.add(nums[i]);
                call(nums,track,list,res);
                track[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}

Tc: For generating all permutation : n! and in base case checking the hashet -> O(n) + Copying the list -> O(n).
O(n!*2n)

SC : O(n×n!)