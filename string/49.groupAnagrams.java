class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;
        HashMap<String, List<String>> map = new HashMap();
        for (int i=0; i<n; i++) {  // -- O(n)
            char[] a = strs[i].toCharArray();
            //给a排序，使得a作为key
            Arrays.sort(a);
            this.addToMap(map, String.valueOf(a), strs[i]);
        }
        //遍历key set，取出每一个对应value set  -- O(n)
        for (String key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    //判断是否在map里，如果不在先增加key和空数组value，在的话value增加一个
    public void addToMap(HashMap<String, List<String>> map, String key, String value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
}

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Input: strs = [""]
Output: [[""]]

Input: strs = ["a"]
Output: [["a"]]

//        Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

