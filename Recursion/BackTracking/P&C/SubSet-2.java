
class Solution {
    List<List<Integer>> res;
    HashSet<List<Integer>> hashSet;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> track=new ArrayList<>();
        res=new ArrayList<>();
        hashSet=new HashSet<>();
        call(nums,0,track);
        return res;
    }

    public void call(int[] nums, int i,List<Integer> track)
    {
        if(i==nums.length)
        {
            System.out.println("track" +track);
            if(!hashSet.contains(track))
            {
                List<Integer> rootList=new ArrayList<>(track);
                res.add(rootList);
                hashSet.add(track);
            }
            return ;
        }

        track.add(nums[i]);
        call(nums,i+1,track);

        track.remove(track.size()-1);
        call(nums,i+1,track);
    }
}