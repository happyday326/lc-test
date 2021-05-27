//该题的解法为O(logn)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n > 0) {
            return powHelper(x, n);
        } else {
            return powHelper(1/x, n);
        }
    }

    private double powHelper(double x, int n) {
        if (n == 0) return 1.0;
        Double a = powHelper(x, n/2);
        if (n%2 == 0) {
            return a*a;
        } else {
            return x*a*a;
        }
    }
}





//Input: x = 2.10000, n = 3
//Output: 9.26100