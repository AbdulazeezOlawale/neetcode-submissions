class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashAna = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!hashAna.containsKey(key)) {
                hashAna.put(key, new ArrayList<>());
            }

            hashAna.get(key).add(word);
        }

        return new ArrayList<>(hashAna.values());
    }
}