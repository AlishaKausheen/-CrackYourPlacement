public class CeilingInASortedArray {
    static int ceilSearch(int arr[], int low, int high,
                          int x) {
        if (x==0) return -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]==x) return mid;
            else if (arr[mid]<x) low =mid+1;
            else high = mid-1;
        }
        return low;
    }

}