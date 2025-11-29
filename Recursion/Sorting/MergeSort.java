// Megre Sort Kya Khta Hai? Req : Ek Array ko sort karna hai.
// Mujhe Pura Array Nhi pta kese sort krte hai
// Usko 2 mein split kro or sort krke le aao.
// l=0, r=arr.length-1, mid.   
// Mein bas merge kr dunga

// Snippet :

// void mergeSort(arr,l,r)
// {
//     (l==r) return ;
//     mergeSort(arr,l,mid);
//     mergeSort(arr,mid+1,r);
//     mergeTwoSortedArr(arr,l,mid,r);
// }


// TC : O(n*logn)
// Sc : O(n) 

class Solution {

    void mergeSort(int arr[], int l, int r) {
        if(l==r)
        {
            return ;
        }
        int mid=l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        mergeSortedArray(arr,l,mid,r);
    }
    
    void mergeSortedArray(int[] arr,int l,int mid,int r)
    {
        int[] arr1=new int[mid-l+1];
        int[] arr2=new int[r-mid];
        int pointer=l;
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=arr[pointer];
            pointer++;
        }
        
        for(int i=0;i<arr2.length;i++)
        {
            arr2[i]=arr[pointer];
            pointer++;
        }
        
        int i=0;
        int j=0;
        int k=l;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                arr[k]=arr1[i];
                i++;
            }
            else
            {
                arr[k]=arr2[j];
                j++;
            }
            k++;
        }
        
        while(i<arr1.length)
        {
            arr[k]=arr1[i];
            i++;
            k++;
        }
        
        while(j<arr2.length)
        {
            arr[k]=arr2[j];
            j++;
            k++;
        }
        return ;
    }
}

