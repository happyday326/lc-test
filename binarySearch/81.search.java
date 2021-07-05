class Solution {
    public boolean search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if (target==nums[mid]) {
                return true;
            }
            if (nums[l]==nums[mid] && nums[mid]==nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target<nums[mid]) {
                    r = mid -1;
                } else {
                    l = mid +1;
                }
            } else {
                if (target<=nums[r] && target>nums[mid]) {
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
        }
        return false;
    }
}