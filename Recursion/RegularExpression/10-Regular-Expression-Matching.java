// Approach 1: 

class Solution {

    public boolean solve(String s, String p)
    {
        if(p.length()==0)
        {
            if(s.length()==0)
            {
                return true;
            }
            return false;
        }
        boolean first_char_matched=false;
        if(s.length()>0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.'))
        {
            first_char_matched=true;
        }

        if(p.length() >= 2 && p.charAt(1)=='*')
        {
            boolean notTake=solve(s,p.substring(2));
            boolean Take=first_char_matched && solve(s.substring(1),p);
            return notTake || Take;
        }
        return first_char_matched && solve(s.substring(1),p.substring(1));

    }
    public boolean isMatch(String s, String p) {
        return solve(s,p);
    }
}

// Tc: O(2^N) + O(N) for substirng.

// Approach 2 : Instead of substring use i, j pointer and than applied memorzation.
class Solution {
    int[][] dp;
    public boolean solve(int i,int j, String s, String p,int[][] dp)
    {
        if(j==p.length())
        {
            if(i==s.length())
            {
                return true;
            }
            return false;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j]==0?false:true;
        }
        boolean first_char_matched=false;
        if(i<s.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='.'))
        {
            first_char_matched=true;
        }
        boolean ans=false;
        if(j<=p.length()-2 && p.charAt(j+1)=='*')
        {
            boolean notTake=solve(i,j+2,s,p,dp);
            boolean Take=first_char_matched && solve(i+1,j,s,p,dp);
            ans=notTake || Take;
            dp[i][j]=(ans==true)?1:0;
            return ans;
        }
        ans=first_char_matched && solve(i+1,j+1,s,p,dp);
        dp[i][j]=(ans==true)?1:0;
        return ans;

    }
    public boolean isMatch(String s, String p) {
        dp=new int[21][21];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0,0,s,p,dp);
    }
}