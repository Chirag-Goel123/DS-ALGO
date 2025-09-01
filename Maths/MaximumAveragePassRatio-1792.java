// Approach 1 : Try to add student one bu one in each class and check the delta.

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;

        double[] PR=new double[n];

        for(int i=0;i<n;i++)
        {
            double ratio = (double) classes[i][0] / classes[i][1];
            PR[i]=ratio;
        }

        while(extraStudents-->0)
        {
            // Updated PR 
            double[] updatedPR=new double[n];
            for(int i=0;i<n;i++)
            {
                 double newRatio = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
                updatedPR[i]=newRatio;
            }

            // Delta
            double overAllDelta=0;
            int idx=0;
            for(int i=0;i<n;i++)
            {
                double delta=updatedPR[i]-PR[i];
                if(delta>overAllDelta)
                {
                    overAllDelta=delta;
                    idx=i;
                }
            }

            PR[idx]=updatedPR[idx];
            classes[idx][0]++;
            classes[idx][1]++;
        }

        // Best 
        double result=0.0;
        for(int i=0;i<n;i++)
        {
            result+=PR[i];
        }
        return result/n;
    }
}

// Approach 2 : 

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        int n=classes.length;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));

        for(int i=0;i<n;i++)
        {
            double curPR=(double)classes[i][0]/classes[i][1];
            double updatedPR=(double) (classes[i][0]+1)/(classes[i][1]+1);
            double delta=updatedPR-curPR;
            pq.add(new double[]{delta,i});
        }

        while(extraStudents-- > 0)
        {
            double[] cur=pq.poll();
            int idx=(int)cur[1];

            classes[idx][0]++;
            classes[idx][1]++;

            double curPR=(double)classes[idx][0]/classes[idx][1];
            double updatedPR=(double) (classes[idx][0]+1)/(classes[idx][1]+1);
            double delta=updatedPR-curPR;
            pq.add(new double[]{delta,idx});
        }

        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += (double) classes[i][0] / classes[i][1];
        }

        return result / n;
    }
}
