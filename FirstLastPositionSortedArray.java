/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

34. Find First and Last Position of Element in Sorted Array
Medium

3312

144

Add to List

Share
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
class Solution {
    //find the first instance of target in nums- in mid index 
    public int[] searchRange(int[] nums, int target) {
        //for null check
        if(nums.length==0) return  new int[]{-1,-1};
        
        int low=0;
        int high=nums.length-1;
        
        int mid=low+(high-low)/2;
        while(low<=high){
            
             mid=low+(high-low)/2;
            
            if(nums[mid]==target){
                break;  //break if the first instance is found
            }
                
            else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        if(high<low) return new int[]{-1,-1}; //target not found in the array after full iteration
        
        int firstPos=binarySearchFirstPos(low,mid,nums,target); //mid is fixed as target
        int lastPos=binarySearchLastPos(mid,high,nums,target); //mid is fixed as target
        
        return new int[]{firstPos,lastPos};
    }
    
    public int binarySearchFirstPos(int low, int high, int[] nums, int target){
                
        while(low<high){//notice since we are not doing high=mid+1
            
             int mid=low+(high-low)/2;
            
            if(nums[mid]==target){
                high=mid; //notice 
            }
            
            else if(target>nums[mid]){
                low=mid+1;
            }
        
        }
        
        return high;//since we know high is target
    }
    
    public int binarySearchLastPos(int low, int high, int[] nums, int target ){
        
        
        while(low<high){//notice
            
             int mid=low+(high-low +1)/2;//since this return lower value of double we need to move farther right to find the last pos so we do (high-low+1)
            
            if(nums[mid]==target){
                low=mid;//notice
            }
                
            else if(target<nums[mid]){
             high=mid-1;
            }
        
        }
        
        return low;// since we know low is target
    }
}
