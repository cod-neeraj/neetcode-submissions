class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        if (s2.length() < k) return false;

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        String sortedS1 = new String(s1Array);

        int left = 0;
        int right = k - 1;  

        while (right < s2.length()) {
            String window = s2.substring(left, right + 1);
            char[] windowArray = window.toCharArray();
            Arrays.sort(windowArray);
            String sortedWindow = new String(windowArray);

            if (sortedWindow.equals(sortedS1)) {
                return true;
            }

            left++;
            right++;
        }
        return false;
    }
}