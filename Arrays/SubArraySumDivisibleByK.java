import java.util.HashMap;

public class SubArraySumDivisibleByK {
    public int brute(int[] nums, int k) {
    int count=0;
    for (int i=0;i< nums.length;i++){
        int sum=0;
        for (int j=i;j< nums.length;j++){
            sum+=nums[j];
            if(sum%k==0) count++;
        }
    }
    return count;
    }
    public int optimal(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,1);
        int result =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder = sum%k;
            if(remainder<0){
                remainder+=k;
            }
            if(map.containsKey(remainder)){
                result+=map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder,0)+1);
        }
        return result;
    }
}
