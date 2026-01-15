class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);


        int maxConsecutiveHBars=1;
        int maxConsecutiveVBars=1;

        int curConsecutiveHBar=1;
        for(int i=1;i<hBars.length;i++)
        {
            if(hBars[i]-hBars[i-1]==1)
            {
                curConsecutiveHBar++;
            }
            else
            {
                curConsecutiveHBar=1;
            }
            maxConsecutiveHBars=Math.max(maxConsecutiveHBars,curConsecutiveHBar);
        }


        int curConsecutiveVBar=1;
        for(int i=1;i<vBars.length;i++)
        {
            if(vBars[i] - vBars[i-1]==1)
            {
                curConsecutiveVBar++;
            }
            else
            {
                curConsecutiveVBar=1;
            }
            maxConsecutiveVBars=Math.max(maxConsecutiveVBars,curConsecutiveVBar);
        }

        int side=Math.min(maxConsecutiveVBars,maxConsecutiveHBars)+1;
        return side*side;


    }
}