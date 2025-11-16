
class Solution {
    public Node flattenBST(Node root) {
        // code here
        if(root==null)
        {
            return null;
        }
        Node left=flattenBST(root.left);
        root.left=null;
        if(left!=null)
        {
            // Traverse Left
            Node tempLeft=left;
            while(tempLeft.right!=null)
            {
                tempLeft=tempLeft.right;
            }
            tempLeft.right=root;
        }
        else
        {
            left=root;
        }
        
        Node right=flattenBST(root.right);
        root.right=right;
        
        return left;
    }
}


// TC : O(n) // Traversing all the node
// SC : O(n) // Max depth of recursive tree.