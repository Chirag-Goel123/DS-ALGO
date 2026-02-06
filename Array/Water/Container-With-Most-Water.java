// Greedy Approach..
// if we want to increase the area, and we are decreasing the width than height we choose max.

class Solution {
    public int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;

        while(i<j)
        {
            int w=j-i;
            int h=Math.min(height[i],height[j]);
            max=Math.max(max,w*h);
            if(height[i]>height[j])
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return max;
    }
}