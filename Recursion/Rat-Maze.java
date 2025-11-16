class Solution {
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        int[][] visited=new int[maze.length][maze[0].length];
        ArrayList<String> res=new ArrayList<>();
        findPath(maze,0,0,visited,res,"");
        return res;
    }
    
    public void findPath(int[][] maze,int i,int j,int[][] visited, ArrayList<String> res,String path)
    {
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || visited[i][j]==-1 || maze[i][j]==0)
        {
            return ;
        }
        if(i==maze.length-1 && j==maze[0].length-1)
        {
            res.add(path);
            return ;
        }
        visited[i][j]=-1;
        findPath(maze,i+1,j,visited,res,path+"D");
        findPath(maze,i,j-1,visited,res,path+"L");
         findPath(maze,i,j+1,visited,res,path+"R");
        findPath(maze,i-1,j,visited,res,path+"U");
        
        
        visited[i][j]=0;
    }
}

// Tc : 
// Each cell has 4 options : Up, Down , Bottom , Right and total cell =N*N.
// TC -> O(4^(n*n))

// SC : Depth of Recursive Tree .O(N*N)..
//     In worst case tree visit all the cells. That's why.