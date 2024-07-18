import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

    public int brute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])) set.add(nums[i]);
        }
        int j = 0;
        for (int x: set) {
            nums[j++] = x;
        }


        return set.size();
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
