class Solution {
    public int reverse(int x) {
        //转成string
        if (x == 0) {return x;}
        String xStr = String.valueOf(x);

        //String reverse
        String result = new String();
        for (int i=xStr.length()-1; i>=0; i--) {
            result += xStr.charAt(i);
        }
        //第一位是0的情况
        if (result.substring(0,1).equals("0")) {
            result = result.substring(1);
        }
        //负数情况
        if (result.substring(result.length()-1).equals("-")) {
            result = "-" + result.substring(0, result.length()-1);
        }
        if (Long.valueOf(result) > Integer.MAX_VALUE || Long.valueOf(result) < Integer.MIN_VALUE) return 0;
        return Integer.valueOf(result);
    }
}




class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}