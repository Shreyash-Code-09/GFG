class Solution {
    public long closestPalindrome(long num) {
        String s = String.valueOf(num);
        int n = s.length();

        if (num <= 10) return num;

        long prefix = Long.parseLong(s.substring(0, (n + 1) / 2));

        long[] candidates = new long[5];
        int idx = 0;

        candidates[idx++] = makePalindrome(prefix, n % 2 == 0);
        candidates[idx++] = makePalindrome(prefix - 1, n % 2 == 0);
        candidates[idx++] = makePalindrome(prefix + 1, n % 2 == 0);
        candidates[idx++] = (long)Math.pow(10, n - 1) - 1;
        candidates[idx++] = (long)Math.pow(10, n) + 1;

        long ans = -1;
        long minDiff = Long.MAX_VALUE;

        for (long cand : candidates) {
            long diff = Math.abs(cand - num);

            if (diff < minDiff || (diff == minDiff && cand < ans)) {
                minDiff = diff;
                ans = cand;
            }
        }

        return ans;
    }

    private long makePalindrome(long prefix, boolean evenLength) {
        String left = String.valueOf(prefix);
        String right = new StringBuilder(left).reverse().toString();

        if (!evenLength) {
            right = right.substring(1);
        }

        return Long.parseLong(left + right);
    }
}