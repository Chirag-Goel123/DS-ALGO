class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int row=mat.length;
        int col=mat[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                int idx=i-j;
                if(map.containsKey(idx))
                {
                    map.get(idx).add(mat[i][j]);
                }
                else
                {
                    List<Integer> list=new ArrayList<>();
                    list.add(mat[i][j]);
                    map.put(idx,list);
                }
            }
        }
        map.forEach((key,value)->{
            Collections.sort(value);
        });

        for(int i=row-1;i>=0;i--)
        {
            for(int j=col-1;j>=0;j--)
            {
                int idx=i-j;
                List<Integer> list=map.get(idx);
                mat[i][j]=list.get(list.size()-1);
                list.remove(list.size()-1);
            }
        }
        return mat;
    }
}