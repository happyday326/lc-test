class Solution {
    public int mySqrt(int x) {
        if (x==1 || x==0) {
            return x;
        }
        long min = 1;
        long max = x;
        long answer = 0;
        long mid;
        while (min<=max) {
            mid = min + (max - min)/2;
            if (mid*mid < x) {
                min = mid +1;
                answer = mid;
            }
            if (mid*mid > x) {
                max = mid - 1;
            }
            if (mid*mid == x) {
                return (int)mid;
            }
        }
        return (int)answer;
    }
}