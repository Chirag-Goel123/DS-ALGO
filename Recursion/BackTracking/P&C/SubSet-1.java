class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track=new ArrayList<>();
        res=new ArrayList<>();
        call(nums,0,track);
        return res;
    }

    public void call(int[] nums, int i,List<Integer> track)
    {
        if(i==nums.length)
        {
            List<Integer> rootList=new ArrayList<>(track);
            res.add(rootList);
            return ;
        }

        track.add(nums[i]);
        call(nums,i+1,track);

        track.remove(track.size()-1);
        call(nums,i+1,track);
    }
}
// TC : O(2^N).
// Eveery point has 2 options, Yes or No.
// SC: O(2^n *N)
// For storing each value in the list..In worst case, each result value is of length n