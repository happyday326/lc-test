class Solution {
    public int[] plusOne(int[] digits) {
        Boolean addOne = true;
        for (int i=digits.length-1; i>=0; i--) {
            if (addOne) {
                if (digits[i]+1 != 10) {
                    digits[i] += 1;
                    addOne = false;
                } else {
                    digits[i] = 0;
                }
            } else {
                return digits;
            }
        }
        int[] newDigits = new int[digits.length+1];
        if (!addOne) {
            return digits;
        } else {
            newDigits[0] = 1;
            for (int i=1; i<newDigits.length; i++) {
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }
    }
}








