//类似threeSum问题，使用左右指针，时间复杂度为O(n^2), 空间复杂度为O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int distance = Integer.MAX_VALUE;
        int res = target;
        Arrays.sort(nums);
        for (int i=0; i< nums.length-2; i++) {
            int low=i+1, high = nums.length-1;
            while (low<high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target){
                    return target;
                } else if (sum < target) {
                    if (Math.abs(sum-target)<distance){
                        distance = Math.abs(sum-target);
                        res = sum;
                    }
                    low++;
                } else {
                    if (Math.abs(sum-target)<distance){
                        distance = Math.abs(sum-target);
                        res = sum;
                    }
                    high--;
                }
            }
        }
        return res;
    }
}