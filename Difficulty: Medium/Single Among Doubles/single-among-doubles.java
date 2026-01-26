// User function Template for Java

class Sol {
    public static int search(int n, int arr[]) {
        // your code here
        int xxor=0;
        for(int i=0;i<n;i++)
        {
            xxor = xxor^arr[i];
        }
        return xxor;
    }
}