// 算法应该对的，但是timeout
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {return true;}
        if (nums[0] == 0) {return false;}
        for (int i=n-1; i>0; i--) {
            int[] subArray = Arrays.copyOfRange(nums, 0, i);
            if (canJump(subArray) && nums[i-1] >= n-subArray.length) {
                return true;
            }
        }
        return false;
    }
}


class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {return true;}
        //if (nums[0] == 0) {return false;}
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(i, false);
            if (i == 0) {map.put(i, true);}
            else {
                for (int j=i-1; j>=0; j--) {
                    if (map.get(j) && nums[j]>=(i-j)) {
                        map.put(i, true);
                        break;
                    }
                }
            }
        }
        return map.get(n-1);
    }
}

// [2,3,1,1,4]
// [3,0]