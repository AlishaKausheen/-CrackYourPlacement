public class CountSubArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = nums[0], high= 0;
        //find maximum and summation:
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low<=high){
            int mid = low +(high-low)/2;
            if(countSubArray(nums,mid)>k){
                low=mid+1;
            } else if (countSubArray(nums, mid)<=k) {
                high=mid-1;
            }

        }
        return low;

    }
    public static int countSubArray(int[] nums, int job){
        int subArray=1,count=0;
        for (int i=0;i<nums.length;i++){
            if(count+nums[i]<=job){
                count+=nums[i];
            }else {
                subArray++;
                count=nums[i];
            }
        }
        return subArray;
    }
}