class Solution {
    public int smallestSubstring(String s) {
        int[] count = new int[3]; // for '0', '1', '2'
        int left = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - '0']++;

            // check if window contains all 3 chars
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                minLen = Math.min(minLen, right - left + 1);

                // shrink window
                count[s.charAt(left) - '0']--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}