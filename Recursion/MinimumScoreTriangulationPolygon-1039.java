class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp=new int[51][51];
        return solve(values,0,values.length-1,dp);
    }

    public int solve(int[] values, int i,int j,int[][] dp)
    {
        if(j-i<=1)
        {
            return dp[i][j]=0;
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++)
        {
            int left=solve(values,i,k,dp);
            int mid=values[i]*values[j]*values[k];
            int right=solve(values,k,j,dp);
            int total=left+right+mid;
            min=Math.min(min,total);
        }
        return dp[i][j]=min;
    }
}

// TC : O(n^3)
// SC : O(n^2)