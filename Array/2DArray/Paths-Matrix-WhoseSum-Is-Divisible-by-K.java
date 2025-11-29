class Solution {
    int res;
    int[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        res=0;
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n][k];
        boolean[][] visited=new boolean[m][n];
        recursiveCall(grid,0,0,m,n,0,k,visited,dp);
        return res%1000000007;
    }

    public void recursiveCall(int[][] grid,int i,int j,int m,int n,int sum,int k,boolean[][] visited,int[][][] dp)
    {
        if(i==m || j==n || visited[i][j]==true)
        {
            return ;
        }
        if(dp[i][j][sum]!=0)
        {
            return ;
        }
        if(i==m-1 && j==n-1)
        {
            if((sum+grid[i][j])%k==0)
            {
                System.out.println(sum+grid[i][j]);
                dp[i][j][sum]=res++;
            }
            return ;
        }
        visited[i][j]=true;
        recursiveCall(grid,i,j+1,m,n,(sum+grid[i][j])%k,k,visited,dp);
        recursiveCall(grid,i+1,j,m,n,(sum+grid[i][j])%k,k,visited,dp);
        visited[i][j]=false;
    }
}