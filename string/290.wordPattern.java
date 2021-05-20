class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> reverse = new HashMap<>();
        int n = pattern.length();
        String[] words = s.split(" ");

        //注意判断特殊情况：patter = "jquery", s = "jquery"
        if (words.length != n) {return false;}

        for (int i=0; i<n; i++) {
            if(!map.containsKey(String.valueOf(pattern.charAt(i)))) {
                map.put(String.valueOf(pattern.charAt(i)), words[i]);
            }
            if (!reverse.containsKey(words[i])) {
                reverse.put(words[i], String.valueOf(pattern.charAt(i)));
            }
        }
        String newS = new String();
        String newPattern = new String();
        for (int j=0; j<n; j++) {
            newS += map.get(String.valueOf(pattern.charAt(j))) + " ";
            newPattern += reverse.get(words[j]);
        }
        return newS.trim().equals(s) && newPattern.equals(pattern);
    }
}


//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
//
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false