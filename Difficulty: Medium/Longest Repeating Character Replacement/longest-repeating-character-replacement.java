class Solution {
    public int longestSubstr(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // track max frequency in current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // if replacements needed > k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update answer
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}