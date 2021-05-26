import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {return 0;}
        Arrays.sort(nums);
        int current = 1;
        int longest = 1;
        for (int i=0; i<n-1; i++) {
            if (nums[i] != nums[i+1]) {
                if (nums[i]+1 == nums[i+1]) {
                    current++;
                    if (current >= longest) {
                        longest = current;
                    }
                } else {
                    current = 1;
                }
            }
        }
        return longest;
    }
}


//[1,2,0,1]
//[0,1,1,2]