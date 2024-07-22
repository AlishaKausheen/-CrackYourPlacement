import java.util.HashMap;
import java.util.Map;

public class MajorityElementNby2 {
    public int brute(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]) count++;
            }
            if(count>nums.length/2) return nums[i];
        }
        return -1;
    }
    public int better(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (nums.length / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }
    public int optimal(int[] nums) {
        int count=0,el=-1;
        for(int i=0;i<nums.length;i++){
            if(count ==0) {
                count=1;
                el=nums[i];
            }else if(nums[i]==el) count++;
            else count--;
        }
        int countcheck=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==el) countcheck++;
        }
        if(countcheck>nums.length/2) return el;
        return -1;
    }
}
