class Solution {
    
    int solve(Node root){
        if(root == null)
            return 0;
        
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        
        int oldVal = root.data;
        
        root.data = leftSum + rightSum;
        
        return oldVal + root.data;
    }
    
    public void toSumTree(Node root) {
        solve(root);
    }
}