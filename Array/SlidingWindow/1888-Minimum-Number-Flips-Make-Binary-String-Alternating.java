// My Approach : But gives TLE.

class Solution {
    public int minFlips(String s) {
        int n=s.length();
        // 010101....
        String strtWithZeros=alterNativeStartsWithZeros(n);

        // 1010101....
        String strtWithOnes=alterNativeStartsWithOnes(n);

        int min=Integer.MAX_VALUE;
        int val1=compareString(s,strtWithZeros);
        int val2=compareString(s,strtWithOnes);

        int tillMin=Math.min(min,Math.min(val1,val2));
        String copyString=new String(s);
        // For Rotating the char 1 by 1 and checking it with the strtWithZeros and strtWithOnes
        // stirngs.
        for(int i=0;i<n-1;i++)
        {
            char c=copyString.charAt(0);
            copyString=copyString.substring(1)+c;
            System.out.println("Rotate "+ copyString);
            int rotateMin1=compareString(copyString,strtWithZeros);
            int rotateMin2=compareString(copyString,strtWithOnes);
            tillMin=Math.min(tillMin,Math.min(rotateMin1,rotateMin2));
        }
        return tillMin;
    }

    public String alterNativeStartsWithZeros(int n)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                sb.append("0");
            }
            else
            {
                sb.append("1");
            }
        }

        return sb.toString();
    }

     public String alterNativeStartsWithOnes(int n)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                sb.append("1");
            }
            else
            {
                sb.append("0");
            }
        }

        return sb.toString();
    }
    // Compare the 2 strings and give the count of number of places where char is different.
    public int compareString(String s, String s1)
    {
        int n=s.length();
        int flipCount=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=s1.charAt(i))
            {
                flipCount++;
            }
        }

        return flipCount++;
    }
}

// Approach : Accepted
class Solution {
    public int minFlips(String s) {
        int n=s.length();
        String s1=alterNativeStartsWithZeros(n+n);
        String s2=alterNativeStartsWithOnes(n+n);
        s=s+s;
        int min=Integer.MAX_VALUE;
        int flip1=0;
        int flip2=0;
        int i=0;
        int j=0;
        while(j<2*n)
        {
            if(s.charAt(j)!=s1.charAt(j))
            {
                flip1++;
            }

            if(s.charAt(j)!=s2.charAt(j))
            {
                flip2++;
            }

            if(j-i+1>n)
            {
                if(s.charAt(i)!=s1.charAt(i))
                {
                    flip1--;
                }

                if(s.charAt(i)!=s2.charAt(i))
                {
                    flip2--;
                }

                i++;
            }
            if(j-i+1==n)
            {
                min=Math.min(min,Math.min(flip1,flip2));
            }
            j++;

        }
        return min;
    }

    public String alterNativeStartsWithZeros(int n)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                sb.append("0");
            }
            else
            {
                sb.append("1");
            }
        }

        return sb.toString();
    }

     public String alterNativeStartsWithOnes(int n)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                sb.append("1");
            }
            else
            {
                sb.append("0");
            }
        }

        return sb.toString();
    }
}