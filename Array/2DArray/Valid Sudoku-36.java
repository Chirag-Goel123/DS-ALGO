
// Approach1 : Baisc Approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Row Check
        for(int i=0;i<9;i++)
        {
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++)
            {
                char c=board[i][j];
                if(c!='.')
                {
                    if(set.contains(c))
                    {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        // Col Check

        for(int j=0;j<9;j++)
        {
            Set<Character> set=new HashSet<>();
            for(int i=0;i<9;i++)
            {
                char c=board[i][j];
                if(c!='.')
                {
                    if(set.contains(c))
                    {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        // Sub-Box Check
        for(int i=0;i<9;i+=3)
        {
            int er=i+2;
            for(int j=0;j<9;j+=3)
            {
                int ec=j+2;
                if(!isValidSubBox(i,er,j,ec,board))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSubBox(int sr,int er,int sc,int ec,char[][] board)
    {
        Set<Character> set=new HashSet<>();
        for(int i=sr;i<=er;i++)
        {
            for(int j=sc;j<=ec;j++)
            {
                char c=board[i][j];
                if(c!='.')
                {
                    if(set.contains(c))
                    {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        return true;
    }
}

// Approach 2 : SubBox mein i/3 and j/3 same hai.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char c=board[i][j];
                if(c!='.')
                {
                    String row=c+"_ROW_"+i;
                    String col=c+"_COL_"+j;
                    String subBox=c+"_SUB_"+(i/3)+(j/3);
                    if(set.contains(row) || set.contains(col) || set.contains(subBox))
                    {
                        return false;
                    }
                    set.add(row);
                    set.add(col);
                    set.add(subBox);
                }
            }
        }

        return true;
    }
}