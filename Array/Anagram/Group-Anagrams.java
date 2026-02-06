// With Sorting
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> res=new ArrayList<>();

        // O(n)
        for(int i=0;i<strs.length;i++)
        {
            String s=strs[i];
            char[] arr=s.toCharArray();
            Arrays.sort(arr);   // K is the ma length of string..(k * logk) for sorting

            String sorted=new String(arr);

            if(map.containsKey(sorted))
            {
                map.get(sorted).add(s);
            }
            else
            {
                List<String> li=new ArrayList<>();
                li.add(s);
                map.put(sorted,li);
            }
        }

        map.forEach((key,value)->{
            res.add(value);
        });

        return res;
    }
}

Tc : O(n*(klogk));

// Without Sorting : 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        int n=strs.length;
        List<List<String>> res=new ArrayList<>();
        // O(n)
        for(int i=0;i<n;i++)
        {
            String word=strs[i];
            String new_word=generateWord(word); // Max length of string k. (k+26)
            if(map.containsKey(new_word))
            {
                map.get(new_word).add(word);
            }
            else
            {
                List<String> li=new ArrayList<>();
                li.add(word);
                map.put(new_word,li);
            }
        }

        map.forEach((key,value)->{
            res.add(value);
        });

        return res;
    }

    public String generateWord(String word)
    {
        int[] arr=new int[26];
        for(char c:word.toCharArray())
        {
            arr[c-'a']++;
        }

        String new_word="";

        for(int i=0;i<26;i++)
        {
            int freq=arr[i];
            while(freq>0)
            {
                new_word+='a'+i;
                freq--;
            }
        }
        return new_word;
    }
}

// TC : O(n*(k+26))