App 1 : Collections.sort(); nlogn
App2 : Count zero, one , two and add in the array.. TC : O(n+n)
App3 : 

class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int j=0;
        int k=nums.length-1;
        while(j<=k)
        {
            int val=nums[j];
            if(val==2)
            {
                swap(nums,j,k);
                k--;
            }
            else if(val==1)
            {
                j++;
            }
            else
            {
                swap(nums,i,j);
                i++;
                j++;
            }
        }
        return ;
    }

    public void swap(int[] nums,int fi,int se)
    {
        int temp=nums[fi];
        nums[fi]=nums[se];
        nums[se]=temp;
    }
}