class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] arr=new int[n];
        StringBuilder sb=new StringBuilder();
        for(int[] shift : shifts)
        {
            int L=shift[0];
            int R=shift[1];
            int dir=shift[2];
            int x;
            if(dir==0)
            {
                x=-1;
            }
            else
            {
                x=+1;
            }
            arr[L]+=x;
            if(R+1<n)
            {
                arr[R+1]-=x;
            }
        }
        
        for(int i=1;i<n;i++)
        {
            arr[i]+=arr[i-1];
        }

        for(int i=0;i<n;i++)
        {
            int shift=arr[i]%26;
            if(shift<0)
            {
                shift+=26;
            }
            char c=s.charAt(i);
            int charValue=c-'a';
            char newChar=(char)((charValue+shift)%26);
            sb.append((char)(newChar+'a'));
        }

        return sb.toString();
    }
}