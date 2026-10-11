class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        LinkedHashMap<Character, List<Integer>> map =
                new LinkedHashMap<>();

        // Store each character and the string indices
        // where it appears at each position.
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                map.computeIfAbsent(ch, k -> new ArrayList<>())
                   .add(i);
            }
        }

        StringBuilder prefix = new StringBuilder();

        // Check characters position by position.
        for (int pos = 0; pos < strs[0].length(); pos++) {
            char ch = strs[0].charAt(pos);

            boolean valid = true;

            for (int i = 1; i < strs.length; i++) {
                if (pos >= strs[i].length()
                        || strs[i].charAt(pos) != ch) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                break;
            }

            prefix.append(ch);
        }

        return prefix.toString();
    }
}

