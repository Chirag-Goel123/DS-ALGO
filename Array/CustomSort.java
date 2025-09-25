class MyComparator implements Comparator<Integer>
{
    public int compare(int a,int b)
    {
        // int = -ve -> a comes first than b
        // int = +ve -> b comes first than a
        // int = 0 -> equal
        return a-b;
    }
}

// Example : Sort: x ascending, if x same then sort as y descending
// [[3,1],[1,3],[1,1]]
// OutPut : [[1 3] [1 1] [3 1]]

 Arrays.sort(points , (a,b)->
{
    if(a[0]==b[0])
    {
        return b[1]-a[1];
    }
    return a[0]-b[0];
});