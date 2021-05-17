class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        } else {
            return this.countAddOne(countAndSay(n-1));
        }
    }

    public String countAddOne(String m) {
        String result = "";
        int n = m.length();
        char sign = m.charAt(0);
        int count = 0;
        for (int i=0; i<n; i++) {
            char now = m.charAt(i);
            if (now == sign) {
                count++;
            } else {
                result = result.concat(String.valueOf(count)).concat(String.valueOf(sign));
                count = 1;
                sign = now;
            }
        }
        result = result.concat(String.valueOf(count)).concat(String.valueOf(sign));
        return result;
    }
}