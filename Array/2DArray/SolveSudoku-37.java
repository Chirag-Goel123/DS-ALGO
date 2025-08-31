class Solution {
    public void solveSudoku(char[][] board) {
       solveFx(board);
       return;
    }

    public boolean solveFx(char[][] board)
    {
       for(int i=0;i<board.length;i++)  // O(9)
       {
            for(int j=0;j<board[0].length;j++) // O(9)
            {
                char c=board[i][j];
                if(c=='.')
                {
                    for(char d='1';d<='9';d++) // O(9)
                    {
                        if(checkRow(i,board,d) && checkCol(j,board,d) && checkBox(i,j,board,d))
                        {
                            board[i][j]=d;
                            if(solveFx(board)==true)
                            {
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
       }
       return true;
    }

    public boolean checkRow(int row,char[][] board,char val)
    {
        for(int j=0;j<board[0].length;j++)
        {
            if(board[row][j]==val)
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int col,char[][] board,char val)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col]==val)
            {
                return false;
            }
        }
        return true;
    }

    public boolean checkBox(int r,int c,char[][] board, char val)
    {
        int sr=(r/3)*3;
        int sc=(c/3)*3;
        char cVal=(char) val;
        for(int row=sr;row<sr+3;row++)
        {
            for(int col=sc;col<sc+3;col++)
            {
                if(board[row][col]==val)
                {
                    return false;
                }
            }
        }
        return true;
    }
}

// TC : Constant : 9 ^ 81