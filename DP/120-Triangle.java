// Ques : 120. Triangle
// Approch 1 : Recursion 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return call(0,0,triangle);
    }

    public int call(int r,int c,List<List<Integer>> list)
    {
        if(r==list.size()-1)
        {
            return list.get(r).get(c);
        }
        if(c>=list.get(r).size())
        {
            return Integer.MAX_VALUE;
        }
        int ithRow=call(r+1,c,list)+(list.get(r).get(c));
        int iPlusOneThRow=call(r+1,c+1,list)+(list.get(r).get(c));

        return Math.min(ithRow,iPlusOneThRow);
    }

}


// Approach 2: Memorization 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int col=triangle.get(row-1).size();
        int[][] dp=new int[row][col];
        return call(0,0,triangle,dp);
    }

    public int call(int r,int c,List<List<Integer>> list,int[][] dp)
    {
        if(r==list.size()-1)
        {
            return dp[r][c]=list.get(r).get(c);
        }
        if(dp[r][c]!=0)
        {
            return dp[r][c];
        }
        if(c>=list.get(r).size())
        {
            return Integer.MAX_VALUE;
        }
        int ithRow=call(r+1,c,list,dp)+(list.get(r).get(c));
        int iPlusOneThRow=call(r+1,c+1,list,dp)+(list.get(r).get(c));

        return dp[r][c]=Math.min(ithRow,iPlusOneThRow);
    }

}

// Approch 3 : Bottom Up

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> gridInteger=triangle;

        int row=gridInteger.size();
        for(int r=row-2;r>=0;r--)
        {
            for(int c=0;c<gridInteger.get(r).size();c++)
            {
                int ithValue=gridInteger.get(r+1).get(c);
                int iPlusOne=gridInteger.get(r+1).get(c+1);
                int value=gridInteger.get(r).get(c)+Math.min(ithValue,iPlusOne);
                // Set Value
                gridInteger.get(r).set(c,value);
            }
        }

        return gridInteger.get(0).get(0);
    }
}