class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
       if(n==1)
       {
           return 1;
       }
        
        // n-1 rods from -> Aux
       int count=towerOfHanoi(n-1,from,aux,to);
       
       // 1 last rod from -> To
       count++;
       
       // n-1 rod aux -> to
       count+=towerOfHanoi(n-1,aux,to,from);
       
       return count;
    }
}
