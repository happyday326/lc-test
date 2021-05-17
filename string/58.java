class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ")+1, s.length()).length();
    }
}


Input: s = "Hello World"
        Output: 5

Input: s = " "
Output: 0

//注意：可以直接用lastIndexOf找到对应位置