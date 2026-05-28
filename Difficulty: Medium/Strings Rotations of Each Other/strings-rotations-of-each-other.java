class Solution {
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        String text = s1 + s1;
        return kmpSearch(text, s2);
    }

    private boolean kmpSearch(String text, String pattern) {
        int n = text.length(), m = pattern.length();

        int[] lps = new int[m];
        computeLPS(pattern, lps);

        int i = 0, j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) return true;

            else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return false;
    }

    private void computeLPS(String pattern, int[] lps) {
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}