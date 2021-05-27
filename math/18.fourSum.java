//此题利用了three的解法，同时利用了set的不重复性，时间复杂度O(n^3), 空间复杂度O(n)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i=0; i<nums.length-3; i++) {
            for (int j=i+1; j<nums.length-2; j++) {
                int low = j+1, high = nums.length-1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++; high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
