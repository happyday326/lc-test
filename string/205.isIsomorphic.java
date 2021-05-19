class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i=0; i<n; i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
            }
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            }
        }
        String newWord1 = new String();
        String newWord2 = new String();
        for (int j=0; j<n; j++) {
            newWord1 += String.valueOf(map1.get(s.charAt(j)));
            newWord2 += String.valueOf(map2.get(t.charAt(j)));
        }
        return t.equals(newWord1) && s.equals(newWord2);
    }
}