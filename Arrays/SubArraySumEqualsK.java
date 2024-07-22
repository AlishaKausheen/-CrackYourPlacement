import java.util.HashMap;

public class SubArraySumEqualsK {
    public int brute(int[] nums, int k) {
        int count =0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for(int l=i;l<=j;l++){
                    sum=sum+nums[l];

                }
                if(sum==k) count++;
            }
        }
        return count;
    }
    public int better(int[] nums, int k) {
        int count =0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];


                if(sum==k) count++;
            }
        }
        return count;
    }
    public int optimal(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count =0;
        int preSum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int remove = preSum-k;
            count+= map.getOrDefault(remove,0);
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
