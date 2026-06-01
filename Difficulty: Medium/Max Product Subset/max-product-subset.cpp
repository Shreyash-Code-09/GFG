class Solution {
  public:
    long long findMaxProduct(vector<int>& arr) {
        const long long MOD = 1000000007;

        int n = arr.size();

        if (n == 1)
            return arr[0];

        int zeroCnt = 0, negCnt = 0;
        int maxNeg = -11;

        for (int x : arr) {
            if (x == 0) zeroCnt++;
            else if (x < 0) {
                negCnt++;
                maxNeg = max(maxNeg, x); // negative closest to 0
            }
        }

        if (zeroCnt == n) return 0;

        if (negCnt == 1 && zeroCnt + negCnt == n)
            return 0;

        long long prod = 1;

        if (negCnt & 1) {
            bool removed = false;

            for (int x : arr) {
                if (x == 0) continue;

                if (!removed && x == maxNeg) {
                    removed = true;
                    continue;
                }

                prod = (prod * x) % MOD;
            }
        } else {
            for (int x : arr) {
                if (x == 0) continue;
                prod = (prod * x) % MOD;
            }
        }

        return prod;
    }
};