class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (!hashMap.containsKey(sortedString)) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                hashMap.put(sortedString, anagrams);
            } else {
                List<String> updatedStrings = hashMap.get(sortedString);
                updatedStrings.add(strs[i]);
                hashMap.put(sortedString, updatedStrings);
            }
        }

        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
