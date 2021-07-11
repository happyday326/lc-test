class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        while (l<r-1) {
            int mid = l + (r-l)/2;
            if (nums[l]==nums[r] && nums[l]==nums[mid]) {
                l++;
                r--;
            }else if (nums[l]<=nums[mid] && nums[mid]<=nums[r]) {
                r = mid;
            } else if (nums[l]<=nums[mid] && nums[mid]>=nums[r]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l]<=nums[r]) {
            return nums[l];
        }
        return nums[r];
    }
}