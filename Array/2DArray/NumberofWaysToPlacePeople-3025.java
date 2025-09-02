// My Approach
class Solution {
    public int numberOfPairs(int[][] points) {

        int count=0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<points.length;i++)
        {
            if(map.containsKey(points[i][0]))
            {
                map.get(points[i][0]).add(points[i][1]);
            }
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(points[i][1]);
                map.put(points[i][0],list);
            }
        }

        // Pairing :

        for(int i=0;i<points.length;i++)
        {
            for(int j=0;j<points.length;j++)
            {
                if(j==i)
                {
                    continue;
                }
                int Bx=points[i][0];
                int By=points[i][1];
                int Ax=points[j][0];
                int Ay=points[j][1];

                if(upperLeft(Ax,Ay,Bx,By))
                {
                    if(checkRectangleOrLine(Ax,Ay,Bx,By,map))
                    {
                        System.out.println("True ");
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean upperLeft(int Ax,int Ay,int Bx,int By)
    {
        System.out.println("Upper Left "+ Ax + " "+Ay +" "+ Bx+" "+By);
        return Ax<=Bx && Ay>=By;
    }

    public boolean checkRectangleOrLine(int Ax,int Ay,int Bx,int By,HashMap<Integer,List<Integer>> map)
    {
        // Line
        if(Ax==Bx)
        {
            System.out.println("Line X");
            int strtvalue=Math.min(Ay,By);
            int endvalue=Math.max(Ay,By);
            for(int i=strtvalue+1; i<endvalue ; i++)
            {
                if(map.get(Ax).contains(i))
                {
                    return false;
                }
            }
            return true;
        }
        else if(Ay==By)
        {
            System.out.println("Line Y");
            int strtvalue=Math.min(Ax,Bx);
            int endvalue=Math.max(Ax,Bx);
            for(int i=strtvalue+1; i<endvalue ; i++)
            {
                if(map.containsKey(i) && map.get(i).contains(Ay))
                {
                    return false;
                }
            }
            return true;
        }

        else
        {
            // Rectangle
             System.out.println("Rectangle"+ Ax + " "+Ay +" "+ Bx+" "+By);
            int xDiff=Math.abs(Bx-Ax);
            int xStart=Math.max(Bx,Ax)-xDiff;

            for(int i=xStart;i<=Math.max(Bx,Ax);i++)
            {
                // Y Range
                for(int j=By;j<=Ay;j++)
                {
                    if((i==Ax && j==Ay) || (i==Bx && j==By))
                    {
                        continue;
                    }
                    List<Integer> checkY=map.getOrDefault(i,new ArrayList<>());
                    if(checkY.contains(j))
                    {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}