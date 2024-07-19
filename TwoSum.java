import java.util.HashMap;

public class TwoSum {
    public int[] brute(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return null;
    }
    public int[] better(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            int current =nums[i];
            int required= target-current;
            if(map.containsKey(required)){
                ans[0]=map.get(required);
                ans[1]=i;
                return ans;
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
