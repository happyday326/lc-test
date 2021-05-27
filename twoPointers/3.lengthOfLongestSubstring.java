class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right=0; right<s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                left = Math.max(left, map.get(rightChar)+1);
            }
            map.put(rightChar, right);
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}