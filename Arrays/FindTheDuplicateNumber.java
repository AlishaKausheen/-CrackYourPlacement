import java.util.Arrays;

public class FindTheDuplicateNumber {
    public int brute(int[] nums) {
        Arrays.sort(nums);
        int ans =0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                ans=nums[i];
                break;
            }
        }
        return ans;
    }
    public int better(int[] nums) {
        int[] hash = new int[nums.length];
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(hash[nums[i]]==1){
                ans=nums[i];
                break;
            }else{
                hash[nums[i]]=1;
            }
        }
        return ans;
    }
    public int optimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast= nums[nums[fast]];
        }while(slow!=fast);
        fast =nums[0];
        while(slow!=fast){
            slow =nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
