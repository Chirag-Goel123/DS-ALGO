class Solution {
    
    public int numSub(String s) {
        long result=0;
        long count=0;


        for(char c:s.toCharArray())
        {
            if(c=='1')
            {
                count++;
            }
            else
            {
                result+=(count*(count+1)/2)%(Math.pow(10,9)+7);
                count=0;
            }
        }
        result+=(count*(count+1)/2)%(Math.pow(10,9)+7);
        return (int)result;
    }
}

// Total no of Substirng : n*(n+1)/2