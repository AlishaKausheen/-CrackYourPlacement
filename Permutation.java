import java.util.ArrayList;

public class Permutation {
    public ArrayList<ArrayList<Integer>> approach1(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds =new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recursion(nums,ds,ans, freq);
        return ans;
    }
    private void recursion(int[] nums, ArrayList<Integer> ds , ArrayList<ArrayList<Integer>> ans, boolean[] freq){
        if(ds.size()== nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i] =true;
                ds.add(nums[i]);
                recursion(nums,ds, ans,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> optimal(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        recursion(0,nums,ans);
        return ans;
    }
    private void recursion(int index, int[] nums, ArrayList<ArrayList<Integer>> ans){
        if(index== nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recursion(index+1,nums, ans);
            swap(i,index,nums);
        }
    }
    private void swap(int i, int j ,int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] =temp;
    }
}
