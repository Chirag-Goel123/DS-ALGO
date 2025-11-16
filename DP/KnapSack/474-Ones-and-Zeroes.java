class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int size=strs.length;
        int[][] count=new int[size][2];
        int[][][] dp=new int[m+1][n+1][size];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        for(int i=0;i<size;i++)
        {
            String s=strs[i];
            int zero=0;
            int one=0;
            for(char ch:s.toCharArray())
            {
                if(ch=='0')
                {
                    zero++;
                }
                else
                {
                    one++;
                }
            }
            count[i][0]=zero;
            count[i][1]=one;
        }

        return solve(count,m,n,0,dp);
    }

    public int solve(int[][] count,int m,int n,int idx,int[][][] dp)
    {
        if(idx==count.length || (m==0 && n==0))
        {
            return 0;
        }
        if(dp[m][n][idx]!=-1)
        {
            return dp[m][n][idx];
        }
        int take=0;
        if(count[idx][0]<=m && count[idx][1]<=n)
        {
            take=1+solve(count,m-count[idx][0],n-count[idx][1],idx+1,dp);
        }

        int exclude=solve(count,m,n,idx+1,dp);

        return dp[m][n][idx]=Math.max(take,exclude);
    }
}