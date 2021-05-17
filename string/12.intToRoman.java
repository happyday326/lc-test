class Solution {
    public String intToRoman(int num) {
        int[] keys = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] vals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String result = "";

        for (int i=keys.length-1; i>=0; i--) {
            int k = keys[i];
            String v = vals[i];
            int reps = num/k;
            result += v.repeat(reps);
            num %= k;
        }
        return result;
    }
}