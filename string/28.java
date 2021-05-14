class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals(haystack)) {return 0;}
        if (needle == "" && haystack != "") {return -1;}
        for (int i=0; i<haystack.length()-needle.length(); i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}


//Input: haystack = "hello", needle = "ll"
//        Output: 2

//特殊情况：1. 两个""
//        2. needle为""

//注意：1. 两个字符串相比用equals，和实际字符串相比，如"abc"可以用==
//     2. 注意边界情况