public class PermuteInArray {
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Your code goes here
        Long[] bWrapper = new Long[n];
        for (int i = 0; i < n; i++) {
            bWrapper[i] = b[i];
        }
        Arrays.sort(bWrapper, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            b[i] = bWrapper[i];
        }
        Arrays.sort(a);

        for (int i=0; i<n; i++)
            if ( a[i] + b[i] < k)
                return false;

        return true;




    }
}