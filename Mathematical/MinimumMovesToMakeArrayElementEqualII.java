public class MinimumMovesToMakeArrayElementEqualII {
    public int approach1(int[] nums) {
        int ans =0;
        int ansEven=0;
        Arrays.sort(nums);
        int n1=0,n2=-1;
        if(nums.length%2 ==0){
            n1= nums.length/2;
            n2=(nums.length-1)/2;
        }else{
            n1= nums.length/2;
        }
        for(int i=0;i<nums.length;i++){
            if(n2==-1){
                ans+= Math.abs(nums[i]-nums[n1]);
            }else{
                ans+= Math.abs(nums[i]-nums[n1]);
                ansEven += Math.abs(nums[i]-nums[n2]);
            }
        }
        if(n2!=-1){
            ans = Math.min(ans, ansEven);
        }
        return ans;
    }
    public int approach2(int[] nums) {
        int count=0;
        int start=0,end = nums.length-1;
        Arrays.sort(nums);
        while(start<end){
            count+=nums[end]-nums[start];
            start++;
            end--;
        }
        return count;
    }
}