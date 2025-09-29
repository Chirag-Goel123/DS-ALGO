// TC : O(n) Travering through the stack
// SC : O(n) Taking the extra Space
class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.size()==0)
        {
            return ;
        }
        int topEle=st.pop();
        reverseStack(st);
        Stack<Integer> heplerStack=new Stack<Integer>();
        while(st.size()>0)
        {
            heplerStack.push(st.pop());
        }
        st.push(topEle);
        while(heplerStack.size()>0)
        {
            st.push(heplerStack.pop());
        }
        return ;
    }
}

// Approch-2 
// TC : O(n*n)
// SC :O(1) -> InsertEle at bottom using recursion

class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.size()==0)
        {
            return ;
        }
        int topEle=st.pop();
        reverseStack(st);
        insertIntoBottom(st,topEle);
        return ;
    }
    
    public static void insertIntoBottom(Stack<Integer> st, int ele)
    {
        if(st.size()==0)
        {
            st.push(ele);
            return ;
        }
        int topEle=st.pop();
        insertIntoBottom(st,ele);
        st.push(topEle);
        return ;
    }
}

