class Solution {
    public int kthGrammar(int n, int k) {
        return solve(n,k);
    }

    public int solve(int n,int k)
    {
        if(n==1 && k==1)
        {
            return 0;
        }
        int mid=(int)Math.pow(2,n-1)/2;
        if(k<=mid)
        {
            return solve(n-1,k);
        }
        else
        {
            int val=solve(n-1,k-mid);
            if(val==0)
            {
                return 1;
            }
            return 0;
        }
    }
}