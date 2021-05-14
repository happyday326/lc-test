class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l = 0;
        int index = 0;
        if (strs.length == 0) {return "";}
        if (strs.length == 1) {return strs[0];}
        else {
            //获得最小单词长度
            l = strs[0].length();
            for (int k=0; k<strs.length; k++) {
              if (strs[k].length() < l) {
                  l = strs[k].length();
                  index = k;
              }
            }
        }
        for (int i=0; i<l; i++) {
            //strs内部遍历
            for (int j=0; j<strs.length-1; j++) {
                if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    if (i == 0) {
                        return "";
                    } else {
                        return strs[0].substring(0, i);
                    }
                }
            }
        }
        return strs[0].substring(0, l);
    }
}


Input: strs = ["flower","flow","flight"]
        Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""

特殊情况['a'] ["ab", "a"]