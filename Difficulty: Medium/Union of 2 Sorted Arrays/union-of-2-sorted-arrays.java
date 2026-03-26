class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        int n = a.length, m = b.length;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                if (res.size() == 0 || res.get(res.size()-1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
            } 
            else if (a[i] > b[j]) {
                if (res.size() == 0 || res.get(res.size()-1) != b[j]) {
                    res.add(b[j]);
                }
                j++;
            } 
            else {
                if (res.size() == 0 || res.get(res.size()-1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
                j++;
            }
        }

        // remaining elements
        while (i < n) {
            if (res.get(res.size()-1) != a[i]) {
                res.add(a[i]);
            }
            i++;
        }

        while (j < m) {
            if (res.get(res.size()-1) != b[j]) {
                res.add(b[j]);
            }
            j++;
        }

        return res;
    }
}