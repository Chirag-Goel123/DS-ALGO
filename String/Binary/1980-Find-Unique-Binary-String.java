// Brute Force : TC : O(n*2^n)

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        // O(n)
        List<String> inputString=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            inputString.add(nums[i]);
        }
        // O(n·2^n)
        List<String> allBinaryString=generateAllBinaryStringOfNLen(nums[0].length());
        for(String s : allBinaryString) // O(n*2^n)
        {
            if(!inputString.contains(s))
            {
                return s;
            }
        }
        return "";

    }

    // Total number of binary String = 2^n. Each String has len n.
    // TC of generatingAllBinaryString = O(2^n)*n
    public List<String> generateAllBinaryStringOfNLen(int n)
    {
        if(n==1)
        {
            List<String> baseCase=new ArrayList<>();
            baseCase.add("0");
            baseCase.add("1");
            return baseCase;
        }
        List<String> res=new ArrayList<>();
        List<String> nMinusOneList=generateAllBinaryStringOfNLen(n-1);
        for(String s : nMinusOneList)
        {
            res.add(s+"0");
            res.add(s+"1");
        }

        return res;
    }
}

// Approach 1 :
Step 1  : Convert the string into Binary Value.
Step 2  : Add each binary value to set. // Integer.parseInt(nums[i],2)
Step 3  : Max Value of n length of binary String is : (2^n)-1.
                        String -> Decimal Value
            EX : n=2 -> 00     -> 0
                        01     -> 1
                        10     -> 2
                        11     -> 3   (2^2)-1 = 3

Step 4 : for(int i=0; i< maxDecimalValue;i++) 
Step 5 : if that value is not present in set -> return (DecimalValue to n-Len string).
        Code ->    if(!set.contains(i))
            {
                result=Integer.toBinaryString(i);
                while(result.length() <n)
                {
                    result="0"+result;
                }

                return result;
            }


Code : 

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            set.add(Integer.parseInt(nums[i],2));
        }

        int n=nums.length;

        String result="";
        int max=(int)(Math.pow(2,n))-1;
        for(int i=0;i<=max;i++)
        {
            if(!set.contains(i))
            {
                result=Integer.toBinaryString(i);
                while(result.length() <n)
                {
                    result="0"+result;
                }

                return result;
            }
        }
        return "";
    }
}

// Approach 2 : O(n)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        String result="";

        for(int i=0;i<nums.length;i++)
        {
            String s=nums[i];
            char ch=s.charAt(i);
            if(ch=='0')
            {
                result+='1';
            }
            else
            {
                result+='0';
            }
        }

        return result;
    }
}