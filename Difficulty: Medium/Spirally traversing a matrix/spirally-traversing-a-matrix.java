import java.util.*;

class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int n = mat.length;
        int m = mat[0].length;
        
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        
        while (top <= bottom && left <= right) {
            
            // left → right
            for (int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }
            top++;
            
            // top → bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;
            
            // right → left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }
            
            // bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        
        return ans;
    }
}
