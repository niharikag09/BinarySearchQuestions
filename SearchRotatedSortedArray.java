/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length==0) return -1;
        
        //find pivot
        
        int low=0;
        int high=nums.length-1;
        
        while(low < high){
            int mid=low+(high-low)/2;
            
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        
        //decide which half should contain target
        int pivot=low;
        low=0;
        high=nums.length-1;
        
        if(target>=nums[pivot] && target<=nums[high]) low=pivot;
        else high=pivot;
        
        //now we have a sorted array in which we can binary search the target
        while(low<=high){
            
            int mid=low+(high-low)/2;
            
            if(nums[mid]==target) return mid;
            
            if(target<nums[mid]) high=mid-1;
            
            else low=mid+1;
        }
        
        return -1;
        
    }
}
