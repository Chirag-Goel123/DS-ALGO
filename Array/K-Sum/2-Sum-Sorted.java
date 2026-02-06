class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        int[] res=new int[2];
        while(i<j)
        {
            int value=numbers[i]+numbers[j];
            if(value>target)
            {
                j--;
            }
            else if(value<target)
            {
                i++;
            }
            else
            {
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
        }
        return res;
    }
}