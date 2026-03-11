class Solution {
    public int smallestRepunitDivByK(int k) {
        int n=1;
        int len=1;
        boolean flag=false;
        int itr=0;
        while(itr<k)
        {
            System.out.println(n);
            int rem=n%k;
            if(rem==0)
            {
                flag=true;
                break;
            }
            n=rem*10+1;
            len++;
            itr++;
        }
        return flag?len:-1;
    }
}

// Points : 
// 1
// 11
// 111
// 1111 
// Instead of taking that large number -> num = (prevRem*10)+1;
// Max 0 to k-1 remainder hi aa skte hai.