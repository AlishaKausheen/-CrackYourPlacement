public class MaximumProductOfThreeNumbers {
    public int brute(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[0]*nums[1]*nums[n-1]);
    }
    public int optimal(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        for (int n : nums) {
            if(n>max1){
                max3=max2;
                max2=max1;
                max1=n;
            }else if(n>max2){
                max3=max2;
                max2=n;
            }else if(n>max3){
                max3=n;
            }
            if(n<min1){

                min2=min1;
                min1=n;
            }else if(n<min2){

                min2=n;
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}