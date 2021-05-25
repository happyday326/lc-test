//这个解法应该可以但是timeout
//class Solution {
//    public int maxArea(int[] height) {
//        int n = height.length;
//        int max = 0;
//        if (n <= 1) {return max;}
//        for (int i=1; i<n; i++) {
//            for (int j=0; j<i; j++) {
//                int volume = (i-j) * Math.min(height[i], height[j]);
//                if(volume > max) {max = volume;}
//            }
//        }
//        return max;
//    }
//}

//采用左右对撞指针解题
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;
        if (height.length <= 1) {return max;}
        while(left <= right) {
            int volume = (right - left) * Math.min(height[left], height[right]);
            if (volume > max) {max = volume;}
            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return max;
    }
}