class Solution {
    public String reverseVowels(String s) {
        String[] vowels = new String[]{"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};    //apple
        Map<Integer, Character> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        List<Character> values = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (isVowel(vowels, s.charAt(i))) {
                keys.add(i);
                values.add(s.charAt(i));
            }
        }
        //反转数值
        for (int i=0; i<keys.size(); i++) {
            map.put(keys.get(i), values.get(keys.size()-1-i));
        }
        String result = "";
        for (int i=0; i<s.length(); i++) {
            if (!isVowel(vowels, s.charAt(i))) {
                result += String.valueOf(s.charAt(i));
            } else {
                result += String.valueOf(map.get(i));
            }
        }
        return result;
    }

    public boolean isVowel(String[] list, char goal) {
        for (String elem: list) {
            if (String.valueOf(goal).equals(elem)) {return true;}
        }
        return false;
    }
}