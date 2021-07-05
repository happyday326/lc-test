public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid = l + (r-l)/2 ;
        while (l<r) {
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = l + (r-l)/2;
        }
        return mid;
    }
}