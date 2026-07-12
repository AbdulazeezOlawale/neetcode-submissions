class Solution {
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < str.length()) {
            int hashPosition = str.indexOf("#", index);

            int length = Integer.parseInt(str.substring(index, hashPosition));

            int wordStart = hashPosition + 1;

            int wordEnd = wordStart + length;
            String extractedWord = str.substring(wordStart, wordEnd);

            result.add(extractedWord);

            index = wordEnd;
        }

        return result;
    }
}
