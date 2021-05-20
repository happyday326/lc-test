class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+"); //匹配一个或多个空格
        StringBuilder result = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            result.append(words[i] + " ");
        }
        return result.toString().trim();
    }
}