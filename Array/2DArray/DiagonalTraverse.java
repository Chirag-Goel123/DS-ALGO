class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                int key=i+j;
                if(map.containsKey(key))
                {
                    map.get(key).add(mat[i][j]);
                }
                else
                {
                    List<Integer> list=new ArrayList<>();
                    list.add(mat[i][j]);
                    map.put(key,list);
                }
            }
        }

        boolean flip=true;
        List<Integer> result=new ArrayList<>();
        for(int d=0;d<m+n-1;d++)
        {
            List<Integer> li=map.get(d);
            if(flip)
            {
                Collections.reverse(li);
            }
            result.addAll(li);

            flip=!flip;
        }

        int[] ans=new int[result.size()];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=result.get(i);
        }
        return ans;
    }
}