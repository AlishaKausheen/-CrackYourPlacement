public class MergeTwoSortedArrays {
    public void brute(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int left=0,right=0, index=0;
        while(left<m && right<n){
            if(nums1[left]<=nums2[right]){
                arr[index]=nums1[left];
                left++;
                index++;
            }else{
                arr[index] =nums2[right];
                right++;
                index++;
            }
        }
        while(left<m){
            arr[index]=nums1[left];
            left++;
            index++;
        }
        while(right<n){
            arr[index] =nums2[right];
            right++;
            index++;
        }
        for(int i=0;i<n+m;i++){
            nums1[i] = arr[i];

        }
    }
    public void optimal(int[] nums1, int m, int[] nums2, int n) {
        int i= m-1, j=n-1, k=m+n-1;
        while(j>=0){
            if(i>=0 && nums1[i]>=nums2[j]){
                nums1[k]= nums1[i];
                k--;
                i--;
            }else{
                nums1[k]=nums2[j];
                k--;
                j--;
            }
        }
    }
}
