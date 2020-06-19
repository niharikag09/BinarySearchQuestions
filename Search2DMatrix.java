/* https://leetcode.com/problems/search-a-2d-matrix/
74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row=matrix.length;
        if(row==0) return false;
        int col=matrix[0].length;
        if(col==0) return false;
        
        int rowToFind=-1;
        for(int i=0;i<row;i++){
            if(target>=matrix[i][0] && target<=matrix[i][col-1]) {
                rowToFind=i;
                break;
            }
        }
        
        if(rowToFind==-1) return false;
        
        int low=0;
        int high=col-1;
        
        while(low<=high){
            
            int mid=low+(high-low)/2;
            
            if(matrix[rowToFind][mid]==target){
                return true;
            }
            else if(target>matrix[rowToFind][mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return false;
    }
}
